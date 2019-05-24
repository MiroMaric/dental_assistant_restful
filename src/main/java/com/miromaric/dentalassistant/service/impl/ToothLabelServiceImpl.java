package com.miromaric.dentalassistant.service.impl;

import com.miromaric.dentalassistant.dao.ToothLabelDao;
import com.miromaric.dentalassistant.dao.impl.ToothLabelDaoImpl;
import com.miromaric.dentalassistant.exception.ResourceNotFoundException;
import com.miromaric.dentalassistant.model.ToothLabel;
import com.miromaric.dentalassistant.service.ToothLabelService;
import java.util.List;

/**
 *
 * @author Tatjana
 */
public class ToothLabelServiceImpl implements ToothLabelService{

    private final ToothLabelDao dao = new ToothLabelDaoImpl();
    
    @Override
    public void save(ToothLabel toothLabel) {
        dao.save(toothLabel);
    }

    @Override
    public List<ToothLabel> getAll() {
        return dao.getAll();
    }

    @Override
    public ToothLabel getOne(Long id) {
        ToothLabel toothLabel = dao.getOne(id);
        if(toothLabel!=null)
            return toothLabel;
        throw new ResourceNotFoundException("Tooth label not found");
    }

    @Override
    public ToothLabel update(Long id, ToothLabel toothLabel) {
        ToothLabel dbToothLabel = dao.update(id,toothLabel);
        if(dbToothLabel!=null)
            return dbToothLabel;
        throw new ResourceNotFoundException("Tooth label not found");
    }

    @Override
    public ToothLabel remove(Long id) {
        ToothLabel toothLabel = dao.remove(id);
        if(toothLabel!=null)
            return toothLabel;
        throw new ResourceNotFoundException("Tooth label not found");
    }
    
}
