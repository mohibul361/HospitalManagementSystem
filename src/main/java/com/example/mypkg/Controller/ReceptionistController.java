package com.example.mypkg.Controller;

import com.example.mypkg.Model.Receptionist;
import com.example.mypkg.Payload.Request.ReceptionistRequest;
import com.example.mypkg.Payload.Response.MessageResponse;
import com.example.mypkg.Service.ReceptionistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/receptionist")
public class ReceptionistController {

    @Autowired
    ReceptionistService receptionistService;

    @GetMapping("/all")
    public ResponseEntity<List<Receptionist>> getAllReceptionist () {
        List<Receptionist> receptionist = receptionistService.getAllReceptionist();
        return new ResponseEntity<>(receptionist, HttpStatus.OK);
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<Receptionist> getReceptionistById (@PathVariable("id") Integer id) {
    	Receptionist receptionist = receptionistService.getASingleReceptionist(id);
        return new ResponseEntity<>(receptionist, HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<MessageResponse> addReceptionist( @RequestBody ReceptionistRequest receptionist) {
        MessageResponse newReceptionist = receptionistService.createReceptionist(receptionist);
        return new ResponseEntity<>(newReceptionist, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteReceptionist(@PathVariable("id") Integer id) {
    	receptionistService.deleteReceptionist(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
