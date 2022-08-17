package bg.softuni.happytravel.repository;

import bg.softuni.happytravel.model.Offer;
import bg.softuni.happytravel.model.dto.SearchOfferDTO;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class OfferSpecification implements Specification<Offer> {


    private final SearchOfferDTO searchOfferDTO;

    public OfferSpecification(SearchOfferDTO searchOfferDTO) {
        this.searchOfferDTO = searchOfferDTO;
    }

    @Override
    public Predicate toPredicate(Root<Offer> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

        Predicate p = cb.conjunction();

        if(!searchOfferDTO.getCountry().isEmpty()){
            p.getExpressions().add(
                    cb.and(cb.equal(root.get("country"),searchOfferDTO.getCountry()))
            );
        }
        if(searchOfferDTO.getMinPrice() != null){
            p.getExpressions().add(
                    cb.and(cb.greaterThanOrEqualTo(root.get("price"), searchOfferDTO.getMinPrice()))
            );
        }
        if(searchOfferDTO.getMaxPrice() != null){
            p.getExpressions().add(
                    cb.and(cb.lessThanOrEqualTo(root.get("price"),searchOfferDTO.getMaxPrice()))
            );
        }

        return p;
    }
}
