package com.example.mypkg.Service;

import com.example.mypkg.Model.Appointment;
import com.example.mypkg.Payload.Request.AppointmentRequest;
import com.example.mypkg.Payload.Response.MessageResponse;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface AppointmentService {
    MessageResponse createAppointment(AppointmentRequest appointmentRequest);
    MessageResponse updateAppointment(Integer appointmentId, AppointmentRequest appointmentRequest);
    MessageResponse deleteAppointment(Integer appointmentId);
    Appointment getASingleAppointment(Integer appointmentId);
    List<Appointment> getAllAppointment();
}
