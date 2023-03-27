package com.example.HospitalManagementSystem.Service;

import com.example.HospitalManagementSystem.Exception.ResourceNotFoundException;
import com.example.HospitalManagementSystem.Model.Prescription;
import com.example.HospitalManagementSystem.Payload.Request.PrescriptionRequest;
import com.example.HospitalManagementSystem.Payload.Response.MessageResponse;
import com.example.HospitalManagementSystem.Repository.PrescriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PrescriptionServiceImpl implements PrescriptionService{
    @Autowired
    PrescriptionRepository prescriptionRepository;


    @Override
    public MessageResponse createPrescription(PrescriptionRequest prescriptionRequest) {
        Prescription newPrescription = new Prescription();
        newPrescription.setAppointment(prescriptionRequest.getAppointment());
        newPrescription.setDescription(prescriptionRequest.getDescription());
        prescriptionRepository.save(newPrescription);
        return new MessageResponse("New Prescription created successfully");

    }

    @Override
    public List<Prescription> getAllPrescription() {
        return prescriptionRepository.findAll();
    }


    public MessageResponse deletePrescription(Integer prescriptionId) throws ResourceNotFoundException {
        if (prescriptionRepository.getById(prescriptionId).getId().equals(prescriptionId)){
            prescriptionRepository.deleteById(prescriptionId);
            return new MessageResponse("Prescription deleted successfully");

        }
        else throw new ResourceNotFoundException("Prescription", "id", prescriptionId);
    }
}
