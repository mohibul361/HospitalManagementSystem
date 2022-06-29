package com.example.mypkg.Service;

import com.example.mypkg.Model.Patient;
import com.example.mypkg.Payload.Request.PatientRequest;
import com.example.mypkg.Payload.Response.MessageResponse;
import com.example.mypkg.Repository.PatientRepository;
import com.example.mypkg.Exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientServiceImpl implements PatientService {
	
    @Autowired
    PatientRepository patientRepository;

    @Override
    public MessageResponse createPatient(PatientRequest patientRequest) {
        Patient newPatient = new Patient();
        newPatient.setFirstName(patientRequest.getFirstName());
        newPatient.setLastname(patientRequest.getLastname());
        newPatient.setPhoneNumber(patientRequest.getAddress());
        newPatient.setPhoneNumber(patientRequest.getGender());
        newPatient.setPhoneNumber(patientRequest.getDisease());
        newPatient.setPhoneNumber(patientRequest.getPhoneNumber());
        newPatient.setEmail(patientRequest.getEmail());
        patientRepository.save(newPatient);
        return new MessageResponse("New Patient created successfully");

    }

    @Override
    public Optional<Patient> updatePatient(Integer patientId, PatientRequest patientRequest)  throws ResourceNotFoundException{
        Optional<Patient> patient = patientRepository.findById(patientId);
        if (patient.isEmpty()){
        throw new ResourceNotFoundException("Patient", "id", patientId);
        }
        else
        patient.get().setFirstName( patientRequest.getFirstName());
        patient.get().setLastname(patientRequest.getLastname());
        patient.get().setAddress(patientRequest.getAddress());
        patient.get().setGender(patientRequest.getGender());
        patient.get().setDisease(patientRequest.getDisease());
        patient.get().setPhoneNumber(patientRequest.getPhoneNumber());
        patient.get().setEmail(patientRequest.getEmail());
        patientRepository.save(patient.get());
        return patient;
    }

    @Override
    public Patient getASinglePatient(Integer patientId) throws ResourceNotFoundException{
        return patientRepository.findById(patientId).orElseThrow(() -> new ResourceNotFoundException("Patient", "id", patientId));
    }

    @Override
    public List<Patient> getAllPatient() {
        return patientRepository.findAll();
    }
    @Override
    public void deletePatient(Integer patientId) throws ResourceNotFoundException {
        if (patientRepository.getById(patientId).getId().equals(patientId)){
            patientRepository.deleteById(patientId);
        }
        else throw new ResourceNotFoundException("Patient", "id", patientId);
    }
}