package com.miromaric.dentalassistant.service.impl;

import com.miromaric.dentalassistant.dao.ToothSideLabelDao;
import com.miromaric.dentalassistant.dao.impl.ToothSideLabelDaoImpl;
import com.miromaric.dentalassistant.exception.ResourceNotFoundException;
import com.miromaric.dentalassistant.model.ToothSideLabel;
import com.miromaric.dentalassistant.service.ToothSideLabelService;
import java.util.List;

/**
 *
 * @author MikoPC
 */
public class ToothSideLabelServiceImpl implements ToothSideLabelService{

    private final ToothSideLabelDao dao = new ToothSideLabelDaoImpl();
    @Override
    public void save(ToothSideLabel toothSideLabel) {
        dao.save(toothSideLabel);
    }

    @Override
    public List<ToothSideLabel> getAll() {
        return dao.getAll();
    }

    @Override
    public ToothSideLabel getOne(Long id) {
        ToothSideLabel toothSideLabel = dao.getOne(id);
        if(toothSideLabel!=null)
            return toothSideLabel;
        throw new ResourceNotFoundException("Tooth side label not found");
    }

    @Override
    public ToothSideLabel update(Long id, ToothSideLabel toothSideLabel) {
        ToothSideLabel dbToothSideLabel = dao.update(id,toothSideLabel);
        if(dbToothSideLabel!=null)
            return dbToothSideLabel;
        throw new ResourceNotFoundException("Tooth side label not found");
    }

    @Override
    public ToothSideLabel remove(Long id) {
        ToothSideLabel toothSideLabel = dao.remove(id);
        if(toothSideLabel!=null)
            return toothSideLabel;
        throw new ResourceNotFoundException("Tooth side label not found");
    }
    
}
