package com.miromaric.dentalassistant.service.impl;

import com.miromaric.dentalassistant.dao.DAO;
import com.miromaric.dentalassistant.dao.impl.ToothSideDaoImpl;
import com.miromaric.dentalassistant.exception.ResourceNotFoundException;
import com.miromaric.dentalassistant.model.ToothSide;
import com.miromaric.dentalassistant.service.ToothSideService;
import java.util.LinkedList;
import java.util.List;


public class ToothSideServiceImpl implements ToothSideService{

    private final DAO<ToothSide,Long> dao = new ToothSideDaoImpl();
    
    @Override
    public void save(ToothSide resource) {
        dao.save(resource);
    }

    @Override
    public List<ToothSide> getAll() {
        return dao.getAll();
    }

    @Override
    public ToothSide getOne(Long id) {
        ToothSide toothSide = dao.getOne(id);
        if(toothSide!=null)
            return toothSide;
        throw new ResourceNotFoundException("Tooth side not found");
    }

    @Override
    public ToothSide update(Long id, ToothSide resource) {
        ToothSide toothSide = dao.update(id, resource);
        if(toothSide!=null)
            return toothSide;
        throw new ResourceNotFoundException("Tooth side not found");
    }

    @Override
    public ToothSide remove(Long id) {
        ToothSide toothSide = dao.remove(id);
        if(toothSide!=null)
            return toothSide;
        throw new ResourceNotFoundException("Tooth side not found");
    }

    @Override
    public List<ToothSide> getAllPatientsToothSides(Long patientId, Long toothId) {
        List<ToothSide> toothSides = new LinkedList<>();
        for(ToothSide ts:dao.getAll()){
            if(ts.getTooth().getToothID().equals(toothId) && ts.getTooth().getPatient().getPatientID().equals(patientId))
                toothSides.add(ts);
        }
        return toothSides;
    }

    @Override
    public ToothSide getPatientsToothSide(Long patientId, Long toothId, Long toothSideId) {
        for(ToothSide ts:dao.getAll()){
            if(ts.getToothSideID().equals(toothSideId) && ts.getTooth().getToothID().equals(toothId) && ts.getTooth().getPatient().getPatientID().equals(patientId))
                return ts;
        }
        throw new ResourceNotFoundException("Tooth side not found");
    }
    
}
