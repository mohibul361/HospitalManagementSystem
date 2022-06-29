package com.example.mypkg.Service;

import com.example.mypkg.Model.Patient;
import com.example.mypkg.Payload.Request.PatientRequest;
import com.example.mypkg.Payload.Response.MessageResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface PatientService {
    MessageResponse createPatient(PatientRequest patientRequest);
    Optional<Patient> updatePatient(Integer patientId, PatientRequest patientRequest);
    void deletePatient(Integer patientId);
    Patient getASinglePatient(Integer patientId);
    List<Patient> getAllPatient();
}
