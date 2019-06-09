package com.miromaric.dentalassistant.service.impl;

import com.miromaric.dentalassistant.dao.DAO;
import com.miromaric.dentalassistant.dao.impl.SideInterventionDaoImpl;
import com.miromaric.dentalassistant.exception.ResourceNotFoundException;
import com.miromaric.dentalassistant.model.SideIntervention;
import com.miromaric.dentalassistant.service.SideInterventionService;
import java.util.LinkedList;
import java.util.List;

public class SideInterventionServiceImpl implements SideInterventionService{

    private final DAO<SideIntervention,Long> dao = new SideInterventionDaoImpl();
    
    @Override
    public void save(SideIntervention resource) {
        dao.save(resource);
    }

    @Override
    public List<SideIntervention> getAll() {
        return dao.getAll();
    }

    @Override
    public SideIntervention getOne(Long id) {
        SideIntervention sideIntervention = dao.getOne(id);
        if(sideIntervention!=null)
            return sideIntervention;
        throw new ResourceNotFoundException("Intervention on the tooth side not found");
    }

    @Override
    public SideIntervention update(Long id, SideIntervention resource) {
        SideIntervention sideIntervention = dao.update(id, resource);
        if(sideIntervention!=null)
            return sideIntervention;
        throw new ResourceNotFoundException("Intervention on the tooth side not found");
    }

    @Override
    public SideIntervention remove(Long id) {
        SideIntervention sideIntervention = dao.remove(id);
        if(sideIntervention!=null)
            return sideIntervention;
        throw new ResourceNotFoundException("Intervention on the tooth side not found");
    }

    @Override
    public List<SideIntervention> getAllPatientsToothSideInterventions(Long patientId, Long toothId, Long toothSideId) {
        List<SideIntervention> sideInterventions = new LinkedList<>();
        for(SideIntervention si:dao.getAll()){
            if(si.getToothSide().getToothSideID().equals(toothSideId) && 
                    si.getToothSide().getTooth().getToothID().equals(toothId) &&
                    si.getToothSide().getTooth().getPatient().getPatientID().equals(patientId)){
                sideInterventions.add(si);
            }
        }
        return sideInterventions;
    }

    @Override
    public SideIntervention getPatientsToothSideIntervention(Long patientId, Long toothId, Long toothSideId, Long sideInterventionId) {
        for(SideIntervention si:dao.getAll()){
            if(si.getItemID().equals(sideInterventionId) && si.getToothSide().getToothSideID().equals(toothSideId) && 
                    si.getToothSide().getTooth().getToothID().equals(toothId) &&
                    si.getToothSide().getTooth().getPatient().getPatientID().equals(patientId)){
                return si;
            }
        }
        throw new ResourceNotFoundException("Intervention on the tooth side not found");
    }

}
