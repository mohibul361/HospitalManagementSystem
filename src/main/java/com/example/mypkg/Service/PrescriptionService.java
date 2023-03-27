package com.example.HospitalManagementSystem.Service;

import com.example.HospitalManagementSystem.Model.Invoice;
import com.example.HospitalManagementSystem.Model.Prescription;
import com.example.HospitalManagementSystem.Payload.Request.InvoiceRequest;
import com.example.HospitalManagementSystem.Payload.Request.PrescriptionRequest;
import com.example.HospitalManagementSystem.Payload.Response.MessageResponse;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface PrescriptionService {
    MessageResponse createPrescription(PrescriptionRequest prescriptionRequest);
    MessageResponse deletePrescription(Integer prescriptionId);
    List<Prescription> getAllPrescription();
}
