package com.example.mypkg.Controller;

import com.example.mypkg.Model.Doctor;
import com.example.mypkg.Payload.Request.DoctorRequest;
import com.example.mypkg.Payload.Response.MessageResponse;
import com.example.mypkg.Service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    DoctorService doctorService;

//    @GetMapping("/all")
    @RequestMapping(value="all", method = RequestMethod.GET)
    public ResponseEntity<List<Doctor>> getAllDoctor () {
        List<Doctor> doctorList = doctorService.getAllDoctor();
        return new ResponseEntity<>(doctorList, HttpStatus.OK);
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<Doctor> getDoctorById (@PathVariable("id") Integer id) {
        Doctor doctor = doctorService.getASingleDoctor(id);
        return new ResponseEntity<>(doctor, HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<MessageResponse> addDoctor( @RequestBody DoctorRequest doctor) {
        MessageResponse newDoctor = doctorService.createDoctor(doctor);
        return new ResponseEntity<>(newDoctor, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteDoctor(@PathVariable("id") Integer id) {
        doctorService.deleteDoctor(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
