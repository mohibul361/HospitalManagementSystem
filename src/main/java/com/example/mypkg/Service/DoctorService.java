package com.example.mypkg.Service;

import com.example.mypkg.Model.Doctor;
import com.example.mypkg.Payload.Request.DoctorRequest;
import com.example.mypkg.Payload.Response.MessageResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface DoctorService {
    MessageResponse createDoctor(DoctorRequest doctorRequest);
    Optional<Doctor> updateDoctor(Integer doctorId, DoctorRequest doctorRequest);
    void deleteDoctor(Integer doctorId);
    Doctor getASingleDoctor(Integer doctorId);
    List<Doctor> getAllDoctor();
}
