package com.miromaric.dentalassistant.service;

import com.miromaric.dentalassistant.model.ToothSide;
import java.util.List;

public interface ToothSideService extends Service<ToothSide, Long>{

    public List<ToothSide> getAllPatientsToothSides(Long patientId, Long toothId);

    public ToothSide getPatientsToothSide(Long patientId, Long toothId, Long toothSideId);
    
}
