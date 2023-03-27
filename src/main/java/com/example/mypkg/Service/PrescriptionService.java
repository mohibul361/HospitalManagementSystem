package com.example.mypkg.Service;

import com.example.mypkg.Model.Patient;
import com.example.mypkg.Model.Prescription;
import com.example.mypkg.Payload.Request.PrescriptionRequest;
import com.example.mypkg.Payload.Response.MessageResponse;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface PrescriptionService {
    MessageResponse createPrescription(PrescriptionRequest prescriptionRequest);
    MessageResponse deletePrescription(Integer prescriptionId);
    List<Prescription> findPrescriptionByPatient(Patient patient);
    List<Prescription> getAllPrescription();

}

