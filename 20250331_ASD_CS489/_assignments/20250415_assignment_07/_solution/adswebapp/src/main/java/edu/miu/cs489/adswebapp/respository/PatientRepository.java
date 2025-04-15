package edu.miu.cs489.adswebapp.respository;

import edu.miu.cs489.adswebapp.model.Dentist;
import edu.miu.cs489.adswebapp.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient, Integer> {
    Optional<Patient> findByUsername(String username);
    Optional<Patient> findByPatientNo(String patientNo);
}
