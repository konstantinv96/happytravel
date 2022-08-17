package bg.softuni.happytravel.model.dto;

public class SearchOfferDTO {
        String country;
        Integer minPrice;
        Integer maxPrice;


    public SearchOfferDTO() {
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(Integer minPrice) {
        this.minPrice = minPrice;
    }

    public Integer getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(Integer maxPrice) {
        this.maxPrice = maxPrice;
    }

    public boolean isEmpty(){
        return (country == null || country.isEmpty()) && minPrice == null && maxPrice == null;
    }
}
