package com.example.mypkg.Controller;

import com.example.mypkg.Model.Patient;
import com.example.mypkg.Payload.Request.PatientRequest;
import com.example.mypkg.Payload.Response.MessageResponse;
import com.example.mypkg.Service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    PatientService patientService;

    @GetMapping("/all")
    public ResponseEntity<List<Patient>> getAllPatient () {
        List<Patient> patient = patientService.getAllPatient();
        return new ResponseEntity<>(patient, HttpStatus.OK);
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<Patient> getPatientById (@PathVariable("id") Integer id) {
        Patient patient = patientService.getASinglePatient(id);
        return new ResponseEntity<>(patient, HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<MessageResponse> addPatient( @RequestBody PatientRequest patient) {
        MessageResponse newPatient = patientService.createPatient(patient);
        return new ResponseEntity<>(newPatient, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletePatient(@PathVariable("id") Integer id) {
        patientService.deletePatient(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
