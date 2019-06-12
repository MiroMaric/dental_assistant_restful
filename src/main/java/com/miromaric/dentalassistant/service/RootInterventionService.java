package com.miromaric.dentalassistant.service;

import com.miromaric.dentalassistant.model.RootIntervention;
import java.util.List;

public interface RootInterventionService extends Service<RootIntervention, Long>{

    public List<RootIntervention> getAllPatientsToothRootInterventions(Long patientId, Long toothId, Long toothRootId);

    public RootIntervention getPatientsToothRootIntervention(Long patientId, Long toothId, Long toothRootId, Long rootInterventionId);
    
}
