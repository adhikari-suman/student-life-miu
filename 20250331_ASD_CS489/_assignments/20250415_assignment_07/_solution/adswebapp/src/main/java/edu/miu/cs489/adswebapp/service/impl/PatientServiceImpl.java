package edu.miu.cs489.adswebapp.service.impl;

import edu.miu.cs489.adswebapp.model.Patient;
import edu.miu.cs489.adswebapp.respository.PatientRepository;
import edu.miu.cs489.adswebapp.service.PatientService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;

    @Override
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    @Override
    public Patient getPatientByPatientNo(String patientNo) {
        return patientRepository.findByPatientNo(patientNo)
                .orElse(null);
    }

    @Override
    public Patient addPatient(Patient patient) {
       return patientRepository.save(patient);
    }

    @Override
    public Patient updatePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public void deletePatient(Patient patient) {
        patientRepository.delete(patient);
    }
}
