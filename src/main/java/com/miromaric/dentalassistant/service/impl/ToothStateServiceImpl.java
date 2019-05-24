package com.miromaric.dentalassistant.service.impl;

import com.miromaric.dentalassistant.dao.ToothStateDao;
import com.miromaric.dentalassistant.dao.impl.ToothStateDaoImpl;
import com.miromaric.dentalassistant.exception.ResourceNotFoundException;
import com.miromaric.dentalassistant.model.ToothState;
import com.miromaric.dentalassistant.service.ToothStateService;
import java.util.List;

/**
 *
 * @author MikoPC
 */
public class ToothStateServiceImpl implements ToothStateService{

    private final ToothStateDao dao = new ToothStateDaoImpl();
    
    @Override
    public void save(ToothState toothState) {
        dao.save(toothState);
    }

    @Override
    public List<ToothState> getAll() {
        return dao.getAll();
    }

    @Override
    public ToothState getOne(Long id) {
        ToothState toothState = dao.getOne(id);
        if(toothState!=null)
            return toothState;
        throw new ResourceNotFoundException("Tooth state not found");
    }

    @Override
    public ToothState update(Long id, ToothState toothState) {
        ToothState uToothState = dao.update(id,toothState);
        if(uToothState!=null)
            return uToothState;
        throw new ResourceNotFoundException("Tooth state not found");
    }

    @Override
    public ToothState remove(Long id) {
        ToothState toothState = dao.remove(id);
        if(toothState!=null)
            return toothState;
        throw new ResourceNotFoundException("Tooth state not found");
    }
    
}
