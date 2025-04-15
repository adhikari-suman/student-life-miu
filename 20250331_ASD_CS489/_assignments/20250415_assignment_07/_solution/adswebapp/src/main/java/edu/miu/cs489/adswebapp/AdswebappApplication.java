package edu.miu.cs489.adswebapp;

import edu.miu.cs489.adswebapp.model.Address;
import edu.miu.cs489.adswebapp.model.Patient;
import edu.miu.cs489.adswebapp.service.PatientService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Date;

@SpringBootApplication
@RequiredArgsConstructor
public class AdswebappApplication implements CommandLineRunner {

    private final PatientService patientService;

    public static void main(String[] args) {
        SpringApplication.run(AdswebappApplication.class, args);
    }


    @Transactional
    @Override
    public void run(String... args) throws Exception {
        System.out.println("I am running now");

        // CRUD operations
        Patient p1 = new Patient("P987",
                                 new Address(null, "1000 N. 4th St."),
                                 new Date(2000, 1, 1),
                                 new ArrayList<>()
        );
        p1.setFirstName("Ariel");
        p1.setLastName("Keller");
        p1.setUsername("user123");
        p1.setEmail("some@email.com");
        p1.setPasswordHash("sdkasjdlkajslak");
        p1.setPhoneNumber("18001234567");


        patientService.addPatient(p1);

        // Get the patient
        Patient p = patientService.getPatientByPatientNo("P987");
        System.out.println("Patient retrieved: "+ p);

        // Update the patient
        p.setEmail("patient@email.com");
        p.setLastName("Kinomoto");
        patientService.updatePatient(p);

        System.out.println("Patient updated: "+ p);

        // Delete the patient
        patientService.deletePatient(p);
        System.out.println("Patient deleted: "+ p);

    }
}
