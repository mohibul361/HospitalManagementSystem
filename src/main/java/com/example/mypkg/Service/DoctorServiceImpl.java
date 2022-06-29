package com.example.mypkg.Service;

import com.example.mypkg.Model.Doctor;
import com.example.mypkg.Payload.Request.DoctorRequest;
import com.example.mypkg.Payload.Response.MessageResponse;
import com.example.mypkg.Repository.DoctorRepository;
import com.example.mypkg.Exception.ResourceNotFoundException;
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
    public Optional<Doctor> updateDoctor(Integer doctorId, DoctorRequest doctorRequest)  throws ResourceNotFoundException{
        Optional<Doctor> doctor = doctorRepository.findById(doctorId);
        if (doctor.isEmpty()){
        throw new ResourceNotFoundException("Doctor", "id", doctorId);
        }
        else
        doctor.get().setFirstName(doctorRequest.getFirstName());
        doctor.get().setLastname(doctorRequest.getLastname());
        doctor.get().setPhoneNumber(doctorRequest.getPhoneNumber());
        doctor.get().setEmail(doctorRequest.getEmail());
        doctor.get().setDepartment(doctorRequest.getDepartment());
        doctor.get().setSalary(doctorRequest.getSalary());
        doctorRepository.save(doctor.get());
        return doctor;
    }

    @Override
    public Doctor getASingleDoctor(Integer doctorId) throws ResourceNotFoundException{
        return doctorRepository.findById(doctorId).orElseThrow(() -> new ResourceNotFoundException("Doctor", "id", doctorId));
    }

    @Override
    public List<Doctor> getAllDoctor() {
        return doctorRepository.findAll();
    }
    @Override
    public void deleteDoctor(Integer doctorId) throws ResourceNotFoundException {
        if (doctorRepository.getById(doctorId).getId().equals(doctorId)){
            doctorRepository.deleteById(doctorId);
        }
        else throw new ResourceNotFoundException("Doctor", "id", doctorId);
    }
}