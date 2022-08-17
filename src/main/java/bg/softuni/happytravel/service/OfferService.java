package bg.softuni.happytravel.service;

import bg.softuni.happytravel.model.Offer;
import bg.softuni.happytravel.model.Picture;
import bg.softuni.happytravel.model.UserEntity;
import bg.softuni.happytravel.model.dto.AddOfferDTO;
import bg.softuni.happytravel.model.dto.SearchOfferDTO;
import bg.softuni.happytravel.model.enums.UserRoles;
import bg.softuni.happytravel.model.views.OfferDetailsView;
import bg.softuni.happytravel.model.views.OfferIndexView;
import bg.softuni.happytravel.repository.OfferRepository;
import bg.softuni.happytravel.repository.OfferSpecification;
import bg.softuni.happytravel.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OfferService {

    private OfferRepository offerRepository;
    private UserRepository userRepository;

    public OfferService(OfferRepository offerRepository, UserRepository userRepository) {
        this.offerRepository = offerRepository;
        this.userRepository = userRepository;
    }

    public List<OfferIndexView> getAllOffers(){

        return offerRepository.findAll().stream().map(offer -> new OfferIndexView(
                offer.getId(),
                offer.getName(),offer.getOvernightStays(),offer.getCheckInDate(),
                offer.getReturnDate(),offer.getPrice(),offer.getImageUrl(),offer.getCountry(),
                offer.getAgencyName().getFullName())).collect(Collectors.toList());

    }

    public Optional<OfferDetailsView> getOffer(Long id){

        return offerRepository.findById(id).map(offer -> new OfferDetailsView(
                offer.getId(),offer.getCountry(),offer.getCity(),
                offer.getPrice(),offer.getName(),offer.getOvernightStays(),
                offer.getImageUrl(),offer.getTransportType(),
                offer.getCheckInDate(),offer.getReturnDate(),
                offer.getDescription(),offer.getPictures().stream().map(Picture::getUrl).collect(Collectors.toList())));
    }

    public void addOffer(AddOfferDTO addOfferDTO , UserDetails userDetails){

        Offer offer = new Offer(addOfferDTO.getCountry()
                                ,addOfferDTO.getCity()
                                ,addOfferDTO.getPrice(),addOfferDTO.getName(),
                                addOfferDTO.getOvernightStays(),
                                addOfferDTO.getImageUrl(),
                                addOfferDTO.getTransportType(),
                                addOfferDTO.getCheckInDate(),
                                addOfferDTO.getReturnDate(),
                                addOfferDTO.getDescription(),
                                addOfferDTO.getPictureUrls()
                                );

        UserEntity agencyName = userRepository.findByUsername(userDetails.getUsername()).orElseThrow();

        offer.setAgencyName(agencyName);
        offerRepository.save(offer);

    }

    public List<OfferIndexView> searchOffer(SearchOfferDTO searchOfferDTO){
        return this.offerRepository.findAll(new OfferSpecification(searchOfferDTO))
                .stream()
                    .map(offer ->new OfferIndexView(
                            offer.getId(),
                            offer.getName(),
                            offer.getOvernightStays(),
                            offer.getCheckInDate(),
                            offer.getReturnDate(),
                            offer.getPrice(),
                            offer.getImageUrl(),
                            offer.getCountry(),
                            offer.getAgencyName().getFullName())).collect(Collectors.toList());
    }

    public void deleteOfferById(Long offerId){

        offerRepository.deleteById(offerId);


    }

    public boolean isOwner(String userName , Long offerId){
        boolean isOwner =  offerRepository.findById(offerId).filter(o -> o.getAgencyName()
                .getEmail().equals(userName)).isPresent();

        if (isOwner) {
            return true;
        }

        return userRepository.findByUsername(userName).filter(this::isAdmin).isPresent();


    }

    private boolean isAdmin(UserEntity user){

        return user.getRoles().stream().anyMatch(r -> r.getName() == UserRoles.ADMIN);
    }

}
