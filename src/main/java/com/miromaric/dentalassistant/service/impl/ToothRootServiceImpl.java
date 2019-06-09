package com.miromaric.dentalassistant.service.impl;

import com.miromaric.dentalassistant.dao.DAO;
import com.miromaric.dentalassistant.dao.impl.ToothRootDaoImpl;
import com.miromaric.dentalassistant.exception.ResourceNotFoundException;
import com.miromaric.dentalassistant.model.ToothRoot;
import com.miromaric.dentalassistant.service.ToothRootService;
import java.util.LinkedList;
import java.util.List;

public class ToothRootServiceImpl implements ToothRootService{

    private final DAO<ToothRoot,Long> dao = new ToothRootDaoImpl();

    @Override
    public void save(ToothRoot resource) {
        dao.save(resource);
    }

    @Override
    public List<ToothRoot> getAll() {
        return dao.getAll();
    }

    @Override
    public ToothRoot getOne(Long id) {
        ToothRoot toothRoot = dao.getOne(id);
        if(toothRoot!=null)
            return toothRoot;
        throw new ResourceNotFoundException("Tooth root not found");
    }

    @Override
    public ToothRoot update(Long id, ToothRoot resource) {
        ToothRoot toothRoot = dao.update(id, resource);
        if(toothRoot!=null)
            return toothRoot;
        throw new ResourceNotFoundException("Tooth root not found");
    }

    @Override
    public ToothRoot remove(Long id) {
        ToothRoot toothRoot = dao.remove(id);
        if(toothRoot!=null)
            return toothRoot;
        throw new ResourceNotFoundException("Tooth root not found");
    }

    @Override
    public List<ToothRoot> getAllPatientsToothRoots(Long patientId, Long toothId) {
        List<ToothRoot> toothRoots = new LinkedList<>();
        for(ToothRoot tr:dao.getAll()){
            if(tr.getTooth().getToothID().equals(toothId) && tr.getTooth().getPatient().getPatientID().equals(patientId))
                toothRoots.add(tr);
        }
        return toothRoots;
    }

    @Override
    public ToothRoot getPatientsToothRoot(Long patientId, Long toothId, Long toothRootId) {
        for(ToothRoot tr:dao.getAll()){
            if(tr.getToothRootID().equals(toothRootId) && tr.getTooth().getToothID().equals(toothId) && tr.getTooth().getPatient().getPatientID().equals(patientId))
                return tr;
        }
        throw new ResourceNotFoundException("Tooth root not found");
    }
}
