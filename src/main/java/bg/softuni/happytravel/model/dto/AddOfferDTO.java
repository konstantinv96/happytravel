package bg.softuni.happytravel.model.dto;

import bg.softuni.happytravel.model.Picture;
import bg.softuni.happytravel.model.enums.TransportType;

import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class AddOfferDTO {

    @NotBlank
//    @Pattern()
    private String country;

    @NotBlank
    private String city;

    @Positive
    @NotNull
    private BigDecimal price;

    @NotBlank
    private String name;

    @NotNull
    @Positive
    private Integer overnightStays;

    @NotBlank
    private String imageUrl;

    @NotNull
    private TransportType transportType;

    @NotNull
    private LocalDate checkInDate;

    @NotNull
    private LocalDate returnDate;

    @NotBlank
    private String description;

    @NotNull
    private List<Picture> pictureUrls;

    public AddOfferDTO() {
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

    public AddOfferDTO   setTransportType(TransportType transportType) {
        this.transportType = transportType;
        return this;
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

    public List<Picture> getPictureUrls() {
        return pictureUrls;
    }

    public void setPictureUrls(List<Picture> pictureUrls) {
        this.pictureUrls = pictureUrls;
    }
}
