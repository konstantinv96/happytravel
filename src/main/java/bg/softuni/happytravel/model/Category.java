package bg.softuni.happytravel.model;

import bg.softuni.happytravel.model.enums.ExcursionType;

import javax.persistence.*;

@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false , unique = true)
    @Enumerated(EnumType.STRING)
    private ExcursionType name;

    @Column(columnDefinition = "TEXT")
    private String description;

    public Category() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ExcursionType getName() {
        return name;
    }

    public void setName(ExcursionType name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
