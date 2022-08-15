package bg.softuni.happytravel.model.dto;

public class SearchOfferDTO {
        String countryName;
        Integer minPrice;
        Integer maxPrice;


    public SearchOfferDTO() {
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
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
        return (countryName == null || countryName.isEmpty()) && minPrice == null && maxPrice == null;
    }
}
