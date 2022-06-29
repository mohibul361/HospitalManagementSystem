package com.example.mypkg.Service;

import com.example.mypkg.Model.Receptionist;
import com.example.mypkg.Payload.Request.ReceptionistRequest;
import com.example.mypkg.Payload.Response.MessageResponse;
import com.example.mypkg.Repository.ReceptionistRepository;
import com.example.mypkg.Exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReceptionistServiceImpl implements ReceptionistService {
	
    @Autowired
    ReceptionistRepository receptionistRepository;

    @Override
    public MessageResponse createReceptionist(ReceptionistRequest receptionistRequest) {
    	Receptionist newReceptionist = new Receptionist();
        newReceptionist.setFirstName(receptionistRequest.getFirstName());
        newReceptionist.setLastname(receptionistRequest.getLastname());
        newReceptionist.setPhoneNumber(receptionistRequest.getPhoneNumber());
        newReceptionist.setEmail(receptionistRequest.getEmail());
        newReceptionist.setSalary(receptionistRequest.getSalary());
        receptionistRepository.save(newReceptionist);
        return new MessageResponse("New Receptionist created successfully");

    }

    @Override
    public Optional<Receptionist> updateReceptionist(Integer receptionistId, ReceptionistRequest receptionistRequest)  throws ResourceNotFoundException{
        Optional<Receptionist> receptionist = receptionistRepository.findById(receptionistId);
        if (receptionist.isEmpty()){
        throw new ResourceNotFoundException("Receptionist", "id", receptionistId);
        }
        else
        receptionist.get().setFirstName(receptionistRequest.getFirstName());
        receptionist.get().setLastname(receptionistRequest.getLastname());
        receptionist.get().setPhoneNumber(receptionistRequest.getPhoneNumber());
        receptionist.get().setEmail(receptionistRequest.getEmail());
        receptionist.get().setSalary(receptionistRequest.getSalary());
        receptionistRepository.save(receptionist.get());
        return receptionist;
    }

    @Override
    public Receptionist getASingleReceptionist(Integer receptionistId) throws ResourceNotFoundException{
        return receptionistRepository.findById(receptionistId).orElseThrow(() -> new ResourceNotFoundException("Receptionist", "id", receptionistId));
    }

    @Override
    public List<Receptionist> getAllReceptionist() {
        return receptionistRepository.findAll();
    }
    @Override
    public void deleteReceptionist(Integer receptionistId) throws ResourceNotFoundException {
        if (receptionistRepository.getById(receptionistId).getId().equals(receptionistId)){
        	receptionistRepository.deleteById(receptionistId);
        }
        else throw new ResourceNotFoundException("Receptionist", "id",receptionistId);
    }
}