package com.example.HospitalManagementSystem.Service;

import com.example.HospitalManagementSystem.Exception.ResourceNotFoundException;
import com.example.HospitalManagementSystem.Model.Pathologist;
import com.example.HospitalManagementSystem.Payload.Request.PathologistRequest;
import com.example.HospitalManagementSystem.Payload.Response.MessageResponse;
import com.example.HospitalManagementSystem.Repository.PathologistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class PathologistServiceImpl implements PathologistService{
    @Autowired
    PathologistRepository pathologistRepository;

    @Override
    public MessageResponse createPathologist(PathologistRequest pathologistRequest) {
        Pathologist newPathologist = new Pathologist();
        newPathologist.setFirstName(pathologistRequest.getFirstName());
        newPathologist.setLastname(pathologistRequest.getLastname());
        newPathologist.setPhoneNumber(pathologistRequest.getPhoneNumber());
        newPathologist.setEmail(pathologistRequest.getEmail());
        newPathologist.setDepartment(pathologistRequest.getDepartment());
        newPathologist.setSalary(pathologistRequest.getSalary());
        pathologistRepository.save(newPathologist);
        return new MessageResponse("New Pathologist created successfully");

    }

    @Override
    public MessageResponse  updatePathologist(Integer pathologistId, PathologistRequest pathologistRequest)  throws ResourceNotFoundException {
        Optional<Pathologist> pathologist = pathologistRepository.findById(pathologistId);
        if (pathologist.isEmpty()){
            throw new ResourceNotFoundException("Pathologist", "id", pathologistId);
        }
        else
            pathologist.get().setFirstName(pathologistRequest.getFirstName());
        pathologist.get().setLastname(pathologistRequest.getLastname());
        pathologist.get().setPhoneNumber(pathologistRequest.getPhoneNumber());
        pathologist.get().setEmail(pathologistRequest.getEmail());
        pathologist.get().setDepartment(pathologistRequest.getDepartment());
        pathologist.get().setSalary(pathologistRequest.getSalary());
        pathologistRepository.save(pathologist.get());
        return new MessageResponse("Pathologist edited successfully");
    }

    @Override
    public Pathologist getASinglePathologist(Integer pathologistId) throws ResourceNotFoundException{
        return pathologistRepository.findById(pathologistId).orElseThrow(() -> new ResourceNotFoundException("pathologist", "id", pathologistId));
    }

    @Override
    public List<Pathologist> getAllPathologist() {
        return pathologistRepository.findAll();
    }
    @Override
    public MessageResponse deletePathologist(Integer pathologistId) throws ResourceNotFoundException {
        if (pathologistRepository.getById(pathologistId).getId().equals(pathologistId)){
            pathologistRepository.deleteById(pathologistId);
            return new MessageResponse("Pathologist deleted successfully");

        }
        else throw new ResourceNotFoundException("Pathologist", "id", pathologistId);
    }
}
