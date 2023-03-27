package com.example.HospitalManagementSystem.Service;

import com.example.HospitalManagementSystem.Model.Patient;
import com.example.HospitalManagementSystem.Payload.Request.PatientRequest;
import com.example.HospitalManagementSystem.Payload.Response.MessageResponse;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface PatientService {
    MessageResponse createPatient(PatientRequest patientRequest);
    MessageResponse updatePatient(Integer patientId, PatientRequest patientRequest);
    MessageResponse deletePatient(Integer patientId);
    Patient getASinglePatient(Integer patientId);
    List<Patient> getAllPatient();
    List<Patient> getPatientByGender(String gender);
}
