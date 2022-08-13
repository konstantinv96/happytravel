package bg.softuni.happytravel.model.views;

import bg.softuni.happytravel.model.enums.TransportType;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class OfferDetailsView {

    private Long id;
    private String country;
    private String city;
    private BigDecimal price;
    private String name;
    private Integer overnightStays;
    private String imageUrl;
    private TransportType transportType;
    private LocalDate checkInDate;
    private LocalDate returnDate;
    private String description;
    private List<String> pictureUrls;

    public OfferDetailsView(Long id, String country, String city, BigDecimal price,
                            String name, Integer overnightStays, String imageUrl,
                            TransportType transportType, LocalDate checkInDate,
                            LocalDate returnDate, String description, List<String> pictureUrls) {

        this.id = id;
        this.country = country;
        this.city = city;
        this.price = price;
        this.name = name;
        this.overnightStays = overnightStays;
        this.imageUrl = imageUrl;
        this.transportType = transportType;
        this.checkInDate = checkInDate;
        this.returnDate = returnDate;
        this.description = description;
        this.pictureUrls = pictureUrls;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getOvernightStays() {
        return overnightStays;
    }

    public void setOvernightStays(Integer overnightStays) {
        this.overnightStays = overnightStays;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public TransportType getTransportType() {
        return transportType;
    }

    public void setTransportType(TransportType transportType) {
        this.transportType = transportType;
    }

    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(LocalDate checkInDate) {
        this.checkInDate = checkInDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getPictureUrls() {
        return pictureUrls;
    }

    public void setPictureUrls(List<String> pictureUrls) {
        this.pictureUrls = pictureUrls;
    }
}
