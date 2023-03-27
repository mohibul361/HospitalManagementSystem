package com.example.HospitalManagementSystem.Service;

import com.example.HospitalManagementSystem.Model.Receptionist;
import com.example.HospitalManagementSystem.Payload.Request.ReceptionistRequest;
import com.example.HospitalManagementSystem.Payload.Response.MessageResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface ReceptionistService {
    MessageResponse createReceptionist(ReceptionistRequest receptionistRequest);
    MessageResponse updateReceptionist(Integer receptionistId, ReceptionistRequest receptionistRequest);
    MessageResponse deleteReceptionist(Integer receptionistId);
    Receptionist getASingleReceptionist(Integer receptionistId);
    List<Receptionist> getAllReceptionist();
}
