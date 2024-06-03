package repository;

import domain.CD;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CDRepository extends JpaRepository<CD, Long> {

    public List<CD> findDistinctByArtistAndPriceLessThan(String artist, double price);

    public List<CD> allFromU2();

@Query(value = "SELECT p.id, c.artist, p.name, p.price, p.product_number  " +
        "FROM `cds` c INNER JOIN `products` p ON p.id = c.id WHERE c.artist='U2'",
        nativeQuery =
        true)
    public List<CD> allFromU2Natives();

    @Query("SELECT c FROM CD c WHERE c.artist = :artist AND c.price > :price")
    public List<CD> findAllBy(String artist,
                              @Param("price") double priceGreaterThan);
}
