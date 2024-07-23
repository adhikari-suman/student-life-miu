package domain;

import jakarta.persistence.*;

@Entity
@Table(name = "cds")
public class CD extends Product {

    @Column(nullable = false, length = 255)
    private String artist;

    public CD() {
    }

    public CD(String productNumber, String name, double price, String artist) {
        super(productNumber, name, price);
        this.artist = artist;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    @Override
    public String toString() {
        return "CD{" +
                "artist='" + artist + '\'' +
                "} " + super.toString();
    }
}

