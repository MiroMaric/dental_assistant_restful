package com.miromaric.dentalassistant.service.impl;

import com.miromaric.dentalassistant.dao.DAO;
import com.miromaric.dentalassistant.dao.impl.RootInterventionDaoImpl;
import com.miromaric.dentalassistant.exception.ResourceNotFoundException;
import com.miromaric.dentalassistant.model.RootIntervention;
import com.miromaric.dentalassistant.service.RootInterventionService;
import java.util.LinkedList;
import java.util.List;

public class RootInterventionServiceImpl implements RootInterventionService {

    private final DAO<RootIntervention, Long> dao = new RootInterventionDaoImpl();

    @Override
    public void save(RootIntervention resource) {
        dao.save(resource);
    }

    @Override
    public List<RootIntervention> getAll() {
        return dao.getAll();
    }

    @Override
    public RootIntervention getOne(Long id) {
        RootIntervention rootIntervention = dao.getOne(id);
        if (rootIntervention != null) {
            return rootIntervention;
        }
        throw new ResourceNotFoundException("Intervention on the tooth root not found");
    }

    @Override
    public RootIntervention update(Long id, RootIntervention resource) {
        RootIntervention rootIntervention = dao.update(id, resource);
        if (rootIntervention != null) {
            return rootIntervention;
        }
        throw new ResourceNotFoundException("Intervention on the tooth root not found");
    }

    @Override
    public RootIntervention remove(Long id) {
        RootIntervention rootIntervention = dao.remove(id);
        if (rootIntervention != null) {
            return rootIntervention;
        }
        throw new ResourceNotFoundException("Intervention on the tooth root not found");
    }

    @Override
    public List<RootIntervention> getAllPatientsToothRootInterventions(Long patientId, Long toothId, Long toothRootId) {
        List<RootIntervention> rootInterventions = new LinkedList<>();
        for(RootIntervention ri:dao.getAll()){
            if(ri.getToothRoot().getToothRootID().equals(toothRootId) && 
                    ri.getToothRoot().getTooth().getToothID().equals(toothId) &&
                    ri.getToothRoot().getTooth().getPatient().getPatientID().equals(patientId)){
                rootInterventions.add(ri);
            }
        }
        return rootInterventions;
    }

    @Override
    public RootIntervention getPatientsToothRootIntervention(Long patientId, Long toothId, Long toothRootId, Long rootInterventionId) {
        for(RootIntervention ri:dao.getAll()){
            if(ri.getItemID().equals(rootInterventionId) && ri.getToothRoot().getToothRootID().equals(toothRootId) && 
                    ri.getToothRoot().getTooth().getToothID().equals(toothId) &&
                    ri.getToothRoot().getTooth().getPatient().getPatientID().equals(patientId)){
                return ri;
            }
        }
        throw new ResourceNotFoundException("Intervention on the tooth root not found");
    }

}
