package com.example.mypkg.Controller;

import com.example.mypkg.Model.Pathologist;
import com.example.mypkg.Payload.Request.PathologistRequest;
import com.example.mypkg.Payload.Response.MessageResponse;
import com.example.mypkg.Service.PathologistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pathologist")
public class PathologistController {

    @Autowired
    PathologistService pathologistService;

    @GetMapping("/all")
    public ResponseEntity<List<Pathologist>> getAllPathologist () {
        List<Pathologist> pathologist = pathologistService.getAllPathologist();
        return new ResponseEntity<>(pathologist, HttpStatus.OK);
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<Pathologist> getPathologistById (@PathVariable("id") Integer id) {
    	Pathologist pathologist = pathologistService.getASinglePathologist(id);
        return new ResponseEntity<>(pathologist, HttpStatus.OK);
    }
    
    @PostMapping("/add")
    public ResponseEntity<MessageResponse> addPathologist( @RequestBody PathologistRequest pathologist) {
        MessageResponse newPathologist = pathologistService.createPathologist(pathologist);
        return new ResponseEntity<>(newPathologist, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletePathologist(@PathVariable("id") Integer id) {
    	pathologistService.deletePathologist(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
