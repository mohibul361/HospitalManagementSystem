package com.example.mypkg.Controller;

import com.example.mypkg.Model.Patient;
import com.example.mypkg.Model.Prescription;
import com.example.mypkg.Payload.Request.PrescriptionRequest;
import com.example.mypkg.Payload.Response.MessageResponse;
import com.example.mypkg.Service.PrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/prescription")
public class PrescriptionController {
    @Autowired
    PrescriptionService prescriptionService;

    @RequestMapping(value="all", method = RequestMethod.GET)
    public ResponseEntity<List<Prescription>> getAllPrescription () {
        List<Prescription> prescriptionList = prescriptionService.getAllPrescription();
        return new ResponseEntity<>(prescriptionList, HttpStatus.OK);
    }

    @GetMapping("/all/{patient}")
    public ResponseEntity<List<Prescription>> getAllPrescriptionByPatient (Patient patient) {
        List<Prescription> prescriptionList = prescriptionService.findPrescriptionByPatient(patient);
        return new ResponseEntity<>(prescriptionList, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<MessageResponse> addPrescription(@RequestBody PrescriptionRequest prescription) {
        MessageResponse newPrescription = prescriptionService.createPrescription(prescription);
        return new ResponseEntity<>(newPrescription, HttpStatus.CREATED);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<MessageResponse> deletePrescription(@PathVariable("id") Integer id) {
        MessageResponse removePrescription = prescriptionService.deletePrescription(id);
        return new ResponseEntity<>(removePrescription, HttpStatus.OK);
    }
}
