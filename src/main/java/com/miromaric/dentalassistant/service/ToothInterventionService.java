package com.miromaric.dentalassistant.service;

import com.miromaric.dentalassistant.model.ToothIntervention;
import java.util.List;

public interface ToothInterventionService {
    
    void save(ToothIntervention toothIntervention);
    List<ToothIntervention> getAll(Long patientId,Long toothId);
    ToothIntervention getOne(Long patientId,Long toothId,Long toothInterventionId);
    ToothIntervention update(Long patientId,Long toothId,Long toothInterventionId,ToothIntervention toothIntervention);
    ToothIntervention remove(Long patientId,Long toothId,Long toothInterventionId);
    
}
