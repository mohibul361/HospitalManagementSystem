package com.example.mypkg.Service;

import com.example.mypkg.Exception.ResourceNotFoundException;
import com.example.mypkg.Model.Patient;
import com.example.mypkg.Model.Prescription;
import com.example.mypkg.Payload.Request.PrescriptionRequest;
import com.example.mypkg.Payload.Response.MessageResponse;
import com.example.mypkg.Repository.PrescriptionRepository;
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

    @Override
    public MessageResponse deletePrescription(Integer prescriptionId) throws ResourceNotFoundException {
        if (prescriptionRepository.getById(prescriptionId).getId().equals(prescriptionId)){
            prescriptionRepository.deleteById(prescriptionId);
            return new MessageResponse("Prescription deleted successfully");

        }
        else throw new ResourceNotFoundException("Prescription", "id", prescriptionId);
    }
    @Override
    public List<Prescription> findPrescriptionByPatient(Patient patient) throws ResourceNotFoundException{
        List<Prescription>  prescriptionList = prescriptionRepository.findPrescriptionByPatient(patient);
        if(prescriptionList == null){
            throw new ResourceNotFoundException("Prescription", "prescription", patient);
        }
        else {
            return prescriptionList;
        }

    }
}
