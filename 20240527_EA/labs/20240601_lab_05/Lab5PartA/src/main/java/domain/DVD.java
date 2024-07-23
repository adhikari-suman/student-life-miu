package domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "dvds")
public class DVD extends Product {

    @Column(nullable = false, length = 255)
    private String genre;

    public DVD() {
    }

    public DVD(String productNumber, String name, double price, String genre) {
        super(productNumber, name, price);
        this.genre = genre;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "CD{" +
                "artist='" + genre + '\'' +
                "} " + super.toString();
    }
}

