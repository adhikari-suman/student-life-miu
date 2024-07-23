package repository;

import domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface BookRepository extends JpaRepository<Book, Long> {

    public void deleteAllByPublicationYearBefore(int publicationYear);

    @Modifying
    @Query("UPDATE Book b SET b.locationCode= CONCAT(:locationCodeSuffix, " +
            "b.locationCode)")
    public void updateBooksLocationCode(String locationCodeSuffix);
}
