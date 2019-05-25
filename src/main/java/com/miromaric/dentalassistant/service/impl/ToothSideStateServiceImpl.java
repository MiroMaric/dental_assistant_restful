package com.miromaric.dentalassistant.service.impl;

import com.miromaric.dentalassistant.dao.ToothSideStateDao;
import com.miromaric.dentalassistant.dao.impl.ToothSideStateDaoImpl;
import com.miromaric.dentalassistant.exception.ResourceNotFoundException;
import com.miromaric.dentalassistant.model.ToothSideState;
import com.miromaric.dentalassistant.service.ToothSideStateService;
import java.util.List;

/**
 *
 * @author MikoPC
 */
public class ToothSideStateServiceImpl implements ToothSideStateService{

    private final ToothSideStateDao dao = new ToothSideStateDaoImpl();
    
    @Override
    public void save(ToothSideState toothSideState) {
        dao.save(toothSideState);
    }

    @Override
    public List<ToothSideState> getAll() {
        return dao.getAll();
    }

    @Override
    public ToothSideState getOne(Long id) {
        ToothSideState toothSideState = dao.getOne(id);
        if(toothSideState!=null)
            return toothSideState;
        throw new ResourceNotFoundException("Tooth side state not found");
    }

    @Override
    public ToothSideState update(Long id, ToothSideState toothSideState) {
        ToothSideState uToothSideState = dao.update(id,toothSideState);
        if(uToothSideState!=null)
            return uToothSideState;
        throw new ResourceNotFoundException("Tooth side state not found");
    }

    @Override
    public ToothSideState remove(Long id) {
        ToothSideState toothSideState = dao.remove(id);
        if(toothSideState!=null)
            return toothSideState;
        throw new ResourceNotFoundException("Tooth side state not found");
    }
    
}
