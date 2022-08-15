package bg.softuni.happytravel.web;


import bg.softuni.happytravel.model.dto.AddOfferDTO;
import bg.softuni.happytravel.model.dto.SearchOfferDTO;
import bg.softuni.happytravel.model.views.OfferDetailsView;
import bg.softuni.happytravel.model.views.OfferIndexView;
import bg.softuni.happytravel.service.OfferService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
public class OfferController {

    private OfferService offerService;

    public OfferController(OfferService offerService) {
        this.offerService = offerService;
    }

    @GetMapping("/offers")
    public String getOffers(Model model){

        List<OfferIndexView> offers = offerService.getAllOffers();
        model.addAttribute("offers" , offers);

        return "offers";
    }

    @GetMapping("offers/add")
    public String addOffer(Model model){
        if(!model.containsAttribute("addOfferDTO")){
            model.addAttribute("addOfferDTO", new AddOfferDTO());
        }
        return "offer-add";
    }

    @PostMapping("offers/add")
    public String addOffer(@Valid AddOfferDTO addOfferDTO,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes,
                           @AuthenticationPrincipal UserDetails userDetails) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("addOfferDTO", addOfferDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.addOfferDTO",
                    bindingResult);
            return "redirect:/offers/add";
        }

        offerService.addOffer(addOfferDTO, userDetails);

        return "redirect:/";
    }


    @GetMapping("offers/details/{id}")
    public String getOffer(@PathVariable("id") Long offerId, Model model){

        OfferDetailsView offer = offerService.getOffer(offerId);
        model.addAttribute("offer" , offer);

        return "offer-details";
    }

//    @GetMapping("/offers/search")
//    public String search(){
//
//        return "offers-search";
//    }
    @GetMapping("/offers/search")
    public String searchQuery(@Valid SearchOfferDTO searchOfferDTO,
                              BindingResult bindingResult,
                              RedirectAttributes redirectAttributes , Model model){

        if(bindingResult.hasErrors()){
            redirectAttributes.addAttribute("searchOfferDTO" , searchOfferDTO);
            redirectAttributes.addAttribute("org.springframework.validation.BindingResult.searchOfferDTO",bindingResult);

            return "offer-search";
        }

        if(!model.containsAttribute("searchOfferDTO")){
            model.addAttribute("searchOfferDTO", searchOfferDTO);
        }
        if(!searchOfferDTO.isEmpty()){
            model.addAttribute("offers" , offerService.searchOffer(searchOfferDTO));
        }


        return "offer-search";
    }
}
