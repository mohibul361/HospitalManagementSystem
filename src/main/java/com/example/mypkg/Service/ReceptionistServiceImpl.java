package com.example.HospitalManagementSystem.Service;

import com.example.HospitalManagementSystem.Exception.ResourceNotFoundException;
import com.example.HospitalManagementSystem.Model.Receptionist;
import com.example.HospitalManagementSystem.Payload.Request.ReceptionistRequest;
import com.example.HospitalManagementSystem.Payload.Response.MessageResponse;
import com.example.HospitalManagementSystem.Repository.ReceptionistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ReceptionistServiceImpl implements ReceptionistService{
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
    public MessageResponse updateReceptionist(Integer receptionistId, ReceptionistRequest receptionistRequest)  throws ResourceNotFoundException{
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
        return new MessageResponse("Receptionist edited successfully");
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
    public MessageResponse deleteReceptionist(Integer receptionistId) throws ResourceNotFoundException {
        if (receptionistRepository.getById(receptionistId).getId().equals(receptionistId)){
            receptionistRepository.deleteById(receptionistId);
            return new MessageResponse("Receptionist deleted successfully");

        }
        else throw new ResourceNotFoundException("Receptionist", "id",receptionistId);
    }
}
