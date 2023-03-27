package com.example.mypkg.Service;

import com.example.mypkg.Exception.ResourceNotFoundException;
import com.example.mypkg.Model.Appointment;
import com.example.mypkg.Payload.Request.AppointmentRequest;
import com.example.mypkg.Payload.Response.MessageResponse;
import com.example.mypkg.Repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentServiceImpl implements AppointmentService{
    @Autowired
    AppointmentRepository appointmentRepository;


    @Override
    public MessageResponse createAppointment(AppointmentRequest appointmentRequest) {
        Appointment newAppointment = new Appointment();
        newAppointment.setAppointmentTime(appointmentRequest.getAppointmentTime());
        newAppointment.setDescription(appointmentRequest.getDescription());
        newAppointment.setPatient(appointmentRequest.getPatient());
        newAppointment.setDoctor(appointmentRequest.getDoctor());
        appointmentRepository.save(newAppointment);
        return new MessageResponse("New Appointment created successfully");

    }

    @Override
    public MessageResponse updateAppointment(Integer appointmentId, AppointmentRequest appointmentRequest){
        Optional<Appointment> appointmentData = appointmentRepository.findById(appointmentId);
        if (appointmentData.isEmpty()){
            throw new ResourceNotFoundException("Doctor", "id", appointmentId);
        }
        else
            appointmentData.get().setAppointmentTime(appointmentRequest.getAppointmentTime());
        appointmentData.get().setDescription(appointmentRequest.getDescription());
        appointmentData.get().setPatient(appointmentRequest.getPatient());
        appointmentData.get().setDoctor(appointmentRequest.getDoctor());
        appointmentRepository.save(appointmentData.get());
        return new MessageResponse("Appointed edited successfully");
    }

    @Override
    public Appointment getASingleAppointment(Integer appointmentId) throws ResourceNotFoundException{
        return appointmentRepository.findById(appointmentId).orElseThrow(() -> new ResourceNotFoundException("Appointment", "id", appointmentId));
    }

    @Override
    public List<Appointment> getAllAppointment() {
        return appointmentRepository.findAll();
    }


    public MessageResponse deleteAppointment(Integer appointmentId) throws ResourceNotFoundException {
        if (appointmentRepository.getById(appointmentId).getId().equals(appointmentId)){
            appointmentRepository.deleteById(appointmentId);
            return new MessageResponse("Appointment deleted Succesfully!");
        }
        else throw new ResourceNotFoundException("Appointment", "id", appointmentId);
    }
}
