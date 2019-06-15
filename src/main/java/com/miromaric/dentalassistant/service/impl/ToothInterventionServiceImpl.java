package com.miromaric.dentalassistant.service.impl;

import com.miromaric.dentalassistant.dao.ToothInterventionDao;
import com.miromaric.dentalassistant.dao.impl.ToothInterventionDaoImpl;
import com.miromaric.dentalassistant.exception.ResourceNotFoundException;
import com.miromaric.dentalassistant.model.ToothIntervention;
import com.miromaric.dentalassistant.service.ToothInterventionService;
import java.util.List;

public class ToothInterventionServiceImpl implements ToothInterventionService {

    private final ToothInterventionDao dao = new ToothInterventionDaoImpl();

    @Override
    public void save(ToothIntervention toothIntervention) {
        dao.save(toothIntervention);
    }

    @Override
    public List<ToothIntervention> getAll(Long patientId, Long toothId) {
        return dao.getAll(patientId, toothId);
    }

    @Override
    public ToothIntervention getOne(Long patientId, Long toothId, Long toothInterventionId) {
        ToothIntervention toothIntervention = dao.getOne(patientId, toothId, toothInterventionId);
        if (toothIntervention != null) {
            return toothIntervention;
        }
        throw new ResourceNotFoundException("Tooth intervention not found");
    }
    
    @Override
    public ToothIntervention update(Long patientId, Long toothId, Long toothInterventionId, ToothIntervention toothIntervention) {
        ToothIntervention ti = dao.update(patientId, toothId, toothInterventionId, toothIntervention);
        if (ti != null) {
            return ti;
        }
        throw new ResourceNotFoundException("Tooth intervention not found");
    }

    @Override
    public ToothIntervention remove(Long patientId, Long toothId, Long toothInterventionId) {
        ToothIntervention toothIntervention = dao.remove(patientId, toothId, toothInterventionId);
        if (toothIntervention != null) {
            return toothIntervention;
        }
        throw new ResourceNotFoundException("Tooth intervention not found");
    }

}
