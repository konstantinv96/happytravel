package bg.softuni.happytravel.model;

import bg.softuni.happytravel.model.enums.TransportType;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "offers")
public class Offer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String country;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private BigDecimal price;

    private String name;

    private int overnightStays;

    private String imageUrl;

    @Enumerated(EnumType.STRING)
    @Column(name = "transport_type" , nullable = false)
    private TransportType transportType;

    private LocalDate checkInDate;

    private LocalDate returnDate;

    @Column(columnDefinition = "TEXT" , nullable = false)
    private String description;

    @ManyToOne
    private UserEntity agencyName;

    @OneToMany(targetEntity = Comment.class , mappedBy = "offer" , cascade = CascadeType.ALL)
    private Set<Comment> comments;

    @OneToMany(mappedBy = "offer" , fetch = FetchType.EAGER)
    private List<Picture> pictures;

    @ManyToMany
    private Set<Category> categories;

    public Offer() {
        this.comments = new HashSet<>();
        this.categories = new HashSet<>();

    }

    public Offer(String country, String city, BigDecimal price, String name, int overnightStays,
                 String imageUrl , TransportType transportType, LocalDate checkInDate,
                 LocalDate returnDate, String description, List<Picture> pictures) {

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
        this.pictures = pictures;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public UserEntity getAgencyName() {
        return agencyName;
    }

    public void setAgencyName(UserEntity agencyName) {
        this.agencyName = agencyName;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }

    public List<Picture> getPictures() {
        return pictures;
    }

    public void setPictures(List<Picture> pictures) {
        this.pictures = pictures;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
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

    public void setOvernightStays(int overnightStays) {
        this.overnightStays = overnightStays;
    }
}
