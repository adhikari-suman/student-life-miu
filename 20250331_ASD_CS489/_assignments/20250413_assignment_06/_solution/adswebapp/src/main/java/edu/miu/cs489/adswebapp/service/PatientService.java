package edu.miu.cs489.adswebapp.service;

import edu.miu.cs489.adswebapp.model.Patient;

import java.util.List;

public interface PatientService {
    public List<Patient> getAllPatients();
    public Patient  getPatientByPatientNo(String patientNo);
    public Patient addPatient(Patient patient);
    public Patient updatePatient(Patient patient);
    public void deletePatient(Patient patient);
}
