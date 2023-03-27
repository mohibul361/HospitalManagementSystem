package com.example.HospitalManagementSystem.Service;

import com.example.HospitalManagementSystem.Exception.ResourceNotFoundException;
import com.example.HospitalManagementSystem.Model.Doctor;
import com.example.HospitalManagementSystem.Payload.Request.DoctorRequest;
import com.example.HospitalManagementSystem.Payload.Response.MessageResponse;
import com.example.HospitalManagementSystem.Repository.DoctorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;


@Service
public class DoctorServiceImpl implements DoctorService {
    @Autowired
    DoctorRepository doctorRepository;


    @Override
    public MessageResponse createDoctor(DoctorRequest doctorRequest) {
        Doctor newDoctor = new Doctor();
        newDoctor.setFirstName(doctorRequest.getFirstName());
        newDoctor.setLastname(doctorRequest.getLastname());
        newDoctor.setPhoneNumber(doctorRequest.getPhoneNumber());
        newDoctor.setEmail(doctorRequest.getEmail());
        newDoctor.setDepartment(doctorRequest.getDepartment());
        newDoctor.setSalary(doctorRequest.getSalary());
        doctorRepository.save(newDoctor);
        return new MessageResponse("New Doctor created successfully");

    }



    @Override
    public MessageResponse updateDoctor(Integer doctorId, DoctorRequest doctorRequest){
        Optional<Doctor> doctorData = doctorRepository.findById(doctorId);
        if (doctorData.isEmpty()){
            throw new ResourceNotFoundException("Doctor", "id", doctorId);
        }
        else
            doctorData.get().setFirstName(doctorRequest.getFirstName());
        doctorData.get().setLastname(doctorRequest.getLastname());
        doctorData.get().setPhoneNumber(doctorRequest.getPhoneNumber());
        doctorData.get().setEmail(doctorRequest.getEmail());
        doctorData.get().setDepartment(doctorRequest.getDepartment());
        doctorData.get().setSalary(doctorRequest.getSalary());
        doctorRepository.save(doctorData.get());
        return new MessageResponse("Doctor edited successfully");
    }

    @Override
    public Doctor getASingleDoctor(Integer doctorId) throws ResourceNotFoundException{
        return doctorRepository.findById(doctorId).orElseThrow(() -> new ResourceNotFoundException("Doctor", "id", doctorId));
    }

    @Override
    public List<Doctor> getAllDoctor() {
        return doctorRepository.findAll();
    }


    public MessageResponse deleteDoctor(Integer doctorId) throws ResourceNotFoundException {
        if (doctorRepository.getById(doctorId).getId().equals(doctorId)){
            doctorRepository.deleteById(doctorId);
            return new MessageResponse("Doctor deleted successfully");
        }
        else throw new ResourceNotFoundException("Doctor", "id", doctorId);
    }
}
