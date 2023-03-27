package com.example.mypkg.Controller;

import com.example.mypkg.Model.Appointment;
import com.example.mypkg.Payload.Request.AppointmentRequest;
import com.example.mypkg.Payload.Response.MessageResponse;
import com.example.mypkg.Service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/appointment")
public class AppointmentController {
    @Autowired
    AppointmentService appointmentService;

    @RequestMapping(value="all", method = RequestMethod.GET)
    public ResponseEntity<List<Appointment>> getAllAppointment () {
        List<Appointment> appointmentList = appointmentService.getAllAppointment();
        return new ResponseEntity<>(appointmentList, HttpStatus.OK);
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<Appointment> getAppointmentById (@PathVariable("id") Integer id) {
        Appointment appointment = appointmentService.getASingleAppointment(id);
        return new ResponseEntity<>(appointment, HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<MessageResponse> addAppointment(@RequestBody AppointmentRequest appointment) {
        MessageResponse newAppointment = appointmentService.createAppointment(appointment);
        return new ResponseEntity<>(newAppointment, HttpStatus.CREATED);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<MessageResponse> updateAppointment(@PathVariable("id") Integer id, @RequestBody AppointmentRequest appointment){
        MessageResponse editAppointment = appointmentService.updateAppointment(id, appointment);
        return new ResponseEntity<>(editAppointment, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<MessageResponse> deleteAppointment(@PathVariable("id") Integer id) {
        appointmentService.deleteAppointment(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
