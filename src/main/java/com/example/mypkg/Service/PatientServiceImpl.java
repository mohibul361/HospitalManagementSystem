package com.example.HospitalManagementSystem.Service;

import com.example.HospitalManagementSystem.Exception.ResourceNotFoundException;
import com.example.HospitalManagementSystem.Model.Patient;
import com.example.HospitalManagementSystem.Payload.Request.PatientRequest;
import com.example.HospitalManagementSystem.Payload.Response.MessageResponse;
import com.example.HospitalManagementSystem.Repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientServiceImpl implements PatientService{
    @Autowired
    PatientRepository patientRepository;

    @Override
    public MessageResponse createPatient(PatientRequest patientRequest) {
        Patient newPatient = new Patient();
        newPatient.setFirstName(patientRequest.getFirstName());
        newPatient.setAddress(patientRequest.getAddress());
        newPatient.setGender(patientRequest.getGender());
        newPatient.setDisease(patientRequest.getDisease());
        newPatient.setPhoneNumber(patientRequest.getPhoneNumber());
        newPatient.setEmail(patientRequest.getEmail());
        patientRepository.save(newPatient);
        return new MessageResponse("New Patient created successfully");

    }

    @Override
    public MessageResponse updatePatient(Integer patientId, PatientRequest patientRequest)  throws ResourceNotFoundException {
        Optional<Patient> patient = patientRepository.findById(patientId);
        if (patient.isEmpty()){
            throw new ResourceNotFoundException("Patient", "id", patientId);
        }
        else
            patient.get().setFirstName( patientRequest.getFirstName());
        patient.get().setAddress(patientRequest.getAddress());
        patient.get().setGender(patientRequest.getGender());
        patient.get().setDisease(patientRequest.getDisease());
        patient.get().setPhoneNumber(patientRequest.getPhoneNumber());
        patient.get().setEmail(patientRequest.getEmail());
        patientRepository.save(patient.get());
        return new MessageResponse("Patient edited successfully");
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
    public MessageResponse deletePatient(Integer patientId) throws ResourceNotFoundException {
        if (patientRepository.getById(patientId).getId().equals(patientId)){
            patientRepository.deleteById(patientId);
            return new MessageResponse("Patient deleted successfully");
        }
        else throw new ResourceNotFoundException("Patient", "id", patientId);
    }

    public List<Patient> getPatientByGender(String gender) throws ResourceNotFoundException{
        List<Patient>  patient = patientRepository.findPatientByGender(gender);
        if(patient == null){
            throw new ResourceNotFoundException("Patient", "gender", gender);
        }
        else {
            return patient;
        }

    }

}
