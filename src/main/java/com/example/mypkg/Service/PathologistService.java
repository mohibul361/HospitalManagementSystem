package com.example.mypkg.Service;

import com.example.mypkg.Model.Pathologist;
import com.example.mypkg.Payload.Request.PathologistRequest;
import com.example.mypkg.Payload.Response.MessageResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface PathologistService {
    MessageResponse createPathologist(PathologistRequest pathologistRequest);
    Optional<Pathologist> updatePathologist(Integer pathologistId, PathologistRequest pathologistRequest);
    void deletePathologist(Integer pathologistId);
    Pathologist getASinglePathologist(Integer pathologistId);
    List<Pathologist> getAllPathologist();
}
