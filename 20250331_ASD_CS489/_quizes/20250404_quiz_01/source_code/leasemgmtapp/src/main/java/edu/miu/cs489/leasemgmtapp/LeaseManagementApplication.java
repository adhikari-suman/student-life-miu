package edu.miu.cs489.leasemgmtapp;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import edu.miu.cs489.leasemgmtapp.dao.ApartmentDAO;
import edu.miu.cs489.leasemgmtapp.model.Apartment;
import edu.miu.cs489.leasemgmtapp.model.Lease;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.Comparator;
import java.util.List;

@SpringBootApplication
public class LeaseManagementApplication implements CommandLineRunner {
    private ApartmentDAO apartmentDAO;

    public LeaseManagementApplication(ApartmentDAO apartmentDAO) {
        this.apartmentDAO = apartmentDAO;
    }

    public static void main(String[] args) {
        SpringApplication.run(LeaseManagementApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // Task B - 1
        printAllApartmentsAsJson();

        // Task B - 2
        printTotalRevenue();
    }

    /**
     * Implement a feature to print-out the list of all the Apartments in JSON format. The Company requires this list
     * to include the Lease(s) data for each Apartment (if it exists) and the list is to be displayed sorted in
     * descending order of the Apartments’ sizes and ascending order of the Apartment number.
     */
    private  void printAllApartmentsAsJson() throws JsonProcessingException {
        List<Apartment> apartments = apartmentDAO.getAllApartments()
                .stream()
                .sorted(Comparator.comparing(Apartment::getSize).reversed().thenComparing(Apartment::getApartmentNo))
                .toList();

        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        String sortedApartments = mapper.writeValueAsString(apartments);

        System.out.println("List of apartments sorted in descending order of the Apartments’ sizes and ascending order of the Apartment number");
        System.out.println(sortedApartments);

    }

    private void printTotalRevenue(){
        List<Lease> leases = apartmentDAO.getAllApartments()
                                             .stream()
                                             .flatMap(apartment -> apartment.getLeases().stream())
                                             .toList();

        BigDecimal totalRevenue = leases.stream().map(
                lease -> {
                    long months = ChronoUnit.MONTHS.between(lease.getStartDate(), lease.getEndDate());
                    return lease.getMonthlyRentalRate().multiply(BigDecimal.valueOf(months));
                }
                           )
                .reduce(BigDecimal.ZERO, BigDecimal::add);


        System.out.println("\nPrinting the total(expected) revenue form all the leases:");
        System.out.printf("Total revenue: $%,.2f", totalRevenue);;

    }
}
