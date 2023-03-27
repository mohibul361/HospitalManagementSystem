package com.example.HospitalManagementSystem.Service;

import com.example.HospitalManagementSystem.Model.Doctor;
import com.example.HospitalManagementSystem.Payload.Request.DoctorRequest;
import com.example.HospitalManagementSystem.Payload.Response.MessageResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
@Component
public interface DoctorService {
    MessageResponse createDoctor(DoctorRequest doctorRequest);
    MessageResponse updateDoctor(Integer doctorId, DoctorRequest doctorRequest);
    MessageResponse deleteDoctor(Integer doctorId);
    Doctor getASingleDoctor(Integer doctorId);
    List<Doctor> getAllDoctor();
}

