package com.example.mypkg.Service;

import com.example.mypkg.Model.Receptionist;
import com.example.mypkg.Payload.Request.ReceptionistRequest;
import com.example.mypkg.Payload.Response.MessageResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface ReceptionistService {
    MessageResponse createReceptionist(ReceptionistRequest receptionistRequest);
    Optional<Receptionist> updateReceptionist(Integer receptionistId, ReceptionistRequest receptionistRequest);
    void deleteReceptionist(Integer receptionistId);
    Receptionist getASingleReceptionist(Integer receptionistId);
    List<Receptionist> getAllReceptionist();
}

