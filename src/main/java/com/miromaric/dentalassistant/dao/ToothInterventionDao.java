package com.miromaric.dentalassistant.dao;

import com.miromaric.dentalassistant.model.ToothIntervention;
import java.util.List;

public interface ToothInterventionDao {
    
    boolean save(ToothIntervention toothIntervention);
    List<ToothIntervention> getAll(Long patientId,Long toothId);
    ToothIntervention getOne(Long patientId,Long toothId,Long toothInterventionId);
    ToothIntervention update(Long patientId,Long toothId,Long toothInterventionId,ToothIntervention toothIntervention);
    ToothIntervention remove(Long patientId,Long toothId,Long toothInterventionId);
    
}
