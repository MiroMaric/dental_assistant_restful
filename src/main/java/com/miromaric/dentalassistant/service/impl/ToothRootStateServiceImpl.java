package com.miromaric.dentalassistant.service.impl;

import com.miromaric.dentalassistant.dao.DAO;
import com.miromaric.dentalassistant.dao.impl.ToothRootStateDaoImpl;
import com.miromaric.dentalassistant.exception.ResourceNotFoundException;
import com.miromaric.dentalassistant.model.ToothRootState;
import com.miromaric.dentalassistant.service.ToothRootStateService;
import java.util.List;

/**
 *
 * @author MikoPC
 */
public class ToothRootStateServiceImpl implements ToothRootStateService{

    private final DAO<ToothRootState,Long> dao = new ToothRootStateDaoImpl();
    
    @Override
    public void save(ToothRootState toothRootState) {
        dao.save(toothRootState);
    }

    @Override
    public List<ToothRootState> getAll() {
        return dao.getAll();
    }

    @Override
    public ToothRootState getOne(Long id) {
        ToothRootState toothRootState = dao.getOne(id);
        if(toothRootState!=null)
            return toothRootState;
        throw new ResourceNotFoundException("Tooth root state not found");
    }

    @Override
    public ToothRootState update(Long id, ToothRootState toothRootState) {
        ToothRootState uToothRootState = dao.update(id,toothRootState);
        if(uToothRootState!=null)
            return uToothRootState;
        throw new ResourceNotFoundException("Tooth root state not found");
    }

    @Override
    public ToothRootState remove(Long id) {
        ToothRootState toothRootState = dao.remove(id);
        if(toothRootState!=null)
            return toothRootState;
        throw new ResourceNotFoundException("Tooth root state not found");
    }
    
}
