
package com.miromaric.dentalassistant.service;

import com.miromaric.dentalassistant.model.SideIntervention;
import java.util.List;

public interface SideInterventionService extends Service<SideIntervention, Long>{

    public List<SideIntervention> getAllPatientsToothSideInterventions(Long patientId, Long toothId, Long toothSideId);

    public SideIntervention getPatientsToothSideIntervention(Long patientId, Long toothId, Long toothSideId, Long sideInterventionId);

}
