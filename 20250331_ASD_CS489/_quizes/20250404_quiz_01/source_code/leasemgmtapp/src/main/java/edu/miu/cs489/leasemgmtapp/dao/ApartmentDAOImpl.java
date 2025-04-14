package edu.miu.cs489.leasemgmtapp.dao;

import edu.miu.cs489.leasemgmtapp.model.Apartment;
import edu.miu.cs489.leasemgmtapp.model.Lease;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class ApartmentDAOImpl implements ApartmentDAO {
    private final List<Apartment> apartments;

    public ApartmentDAOImpl() {
        // Create Lease objects
        Lease lease1 = new Lease(3128874121L, new BigDecimal("1750.50"), "Michael Philips",
                                 LocalDate.of(2025, 2, 1), LocalDate.of(2026, 2, 1));

        Lease lease2 = new Lease(2927458265L, new BigDecimal("1500.00"), "Anna Smith",
                                 LocalDate.of(2025, 4, 2), LocalDate.of(2025, 10, 2));

        Lease lease3 = new Lease(9189927460L, new BigDecimal("2560.75"), "Alex Campos",
                                 LocalDate.of(2025, 3, 1), LocalDate.of(2026, 3, 1));

        Lease lease4 = new Lease(3128874119L, new BigDecimal("1650.55"), "Michael Philips",
                                 LocalDate.of(2023, 2, 1), LocalDate.of(2024, 2, 1));

        // Create Apartment objects and assign leases
        Apartment apt1 = new Apartment("B1102", "The Cameron House", 11, 790, 3,
                                       new ArrayList<>(List.of(lease2)));

        Apartment apt2 = new Apartment("A705", "The Cameron House", 7, 855, 4,
                                       new ArrayList<>(Arrays.asList(lease1, lease4)));

        Apartment apt3 = new Apartment("C1210", "Pointe Palace", 12, 1000, 4,
                                       new ArrayList<>()); // no lease

        Apartment apt4 = new Apartment("A1371", "Pointe Palace", 13, 1000, 4,
                                       new ArrayList<>(List.of(lease3)));


        apartments = List.of(apt1, apt2, apt3, apt4);
    }

    @Override
    public List<Apartment> getAllApartments() {
        return apartments;
    }
}
