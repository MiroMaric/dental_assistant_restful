package com.miromaric.dentalassistant.service.impl;

import com.miromaric.dentalassistant.dao.DAO;
import com.miromaric.dentalassistant.dao.impl.ToothDaoImpl;
import com.miromaric.dentalassistant.exception.ResourceNotFoundException;
import com.miromaric.dentalassistant.model.Tooth;
import com.miromaric.dentalassistant.service.ToothService;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author MikoPC
 */
public class ToothServiceImpl implements ToothService{

    private final DAO<Tooth,Long> dao = new ToothDaoImpl();
    
    @Override
    public void save(Tooth resource) {
        dao.save(resource);
    }

    @Override
    public List<Tooth> getAll() {
        return dao.getAll();
    }

    @Override
    public Tooth getOne(Long id) {
        Tooth tooth = dao.getOne(id);
        if(tooth!=null)
            return tooth;
        throw new ResourceNotFoundException("Tooth not found");
    }

    @Override
    public Tooth update(Long id, Tooth resource) {
        Tooth tooth = dao.update(id, resource);
        if(tooth!=null)
            return tooth;
        throw new ResourceNotFoundException("Tooth not found");
    }

    @Override
    public Tooth remove(Long id) {
        Tooth tooth = dao.remove(id);
        if(tooth!=null)
            return tooth;
        throw new ResourceNotFoundException("Tooth not found");
    }

    @Override
    public List<Tooth> getAllPatientsTeeth(Long patientId) {
        List<Tooth> teeth = new ArrayList<>();
        for(Tooth tooth:getAll()){
            if(Objects.equals(tooth.getPatient().getPatientID(), patientId))
                teeth.add(tooth);
        }
        return teeth;
    }

    @Override
    public Tooth getPatientsTooth(Long patientId, Long toothId) {
        for(Tooth tooth:getAll()){
            if(Objects.equals(tooth.getToothID(), toothId) && Objects.equals(tooth.getPatient().getPatientID(), patientId))
                return tooth;
        }
        throw new ResourceNotFoundException("Tooth not found");
    }
    
}
