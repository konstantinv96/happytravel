package bg.softuni.happytravel.model.views;

import bg.softuni.happytravel.model.enums.TransportType;

import java.math.BigDecimal;
import java.time.LocalDate;

public class OfferIndexView {
    private Long id;
    private String name;
    private Integer overnightStays;
    private LocalDate checkInDate;
    private LocalDate returnDate;
    private BigDecimal price;
    private String imageUrl;

    public OfferIndexView(Long id, String name, Integer overnightStays, LocalDate checkInDate, LocalDate returnDate, BigDecimal price, String imageUrl) {
        this.id = id;
        this.name = name;
        this.overnightStays = overnightStays;
        this.checkInDate = checkInDate;
        this.returnDate = returnDate;
        this.price = price;
        this.imageUrl = imageUrl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOvernightStays() {
        return overnightStays;
    }

    public void setOvernightStays(Integer overnightStays) {
        this.overnightStays = overnightStays;
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
