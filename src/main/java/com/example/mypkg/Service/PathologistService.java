package com.example.HospitalManagementSystem.Service;

import com.example.HospitalManagementSystem.Model.Pathologist;
import com.example.HospitalManagementSystem.Payload.Request.PathologistRequest;
import com.example.HospitalManagementSystem.Payload.Response.MessageResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
@Component
public interface PathologistService {
    MessageResponse createPathologist(PathologistRequest pathologistRequest);
    MessageResponse updatePathologist(Integer pathologistId, PathologistRequest pathologistRequest);
    MessageResponse deletePathologist(Integer pathologistId);
    Pathologist getASinglePathologist(Integer pathologistId);
    List<Pathologist> getAllPathologist();
}
