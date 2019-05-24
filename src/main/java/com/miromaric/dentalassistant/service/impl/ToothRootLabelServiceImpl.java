package com.miromaric.dentalassistant.service.impl;

import com.miromaric.dentalassistant.dao.ToothRootLabelDao;
import com.miromaric.dentalassistant.dao.impl.ToothRootLabelDaoImpl;
import com.miromaric.dentalassistant.exception.ResourceNotFoundException;
import com.miromaric.dentalassistant.model.ToothRootLabel;
import com.miromaric.dentalassistant.service.ToothRootLabelService;
import java.util.List;

/**
 *
 * @author MikoPC
 */
public class ToothRootLabelServiceImpl implements ToothRootLabelService{

    private final ToothRootLabelDao dao = new ToothRootLabelDaoImpl();

    @Override
    public void save(ToothRootLabel toothRootLabel) {
        dao.save(toothRootLabel);
    }

    @Override
    public List<ToothRootLabel> getAll() {
        return dao.getAll();
    }

    @Override
    public ToothRootLabel getOne(Long id) {
        ToothRootLabel toothRootLabel = dao.getOne(id);
        if(toothRootLabel!=null)
            return toothRootLabel;
        throw new ResourceNotFoundException("Tooth root label not found");
    }

    @Override
    public ToothRootLabel update(Long id, ToothRootLabel toothRootLabel) {
        ToothRootLabel dbToothRootLabel = dao.update(id,toothRootLabel);
        if(dbToothRootLabel!=null)
            return dbToothRootLabel;
        throw new ResourceNotFoundException("Tooth root label not found");
    }

    @Override
    public ToothRootLabel remove(Long id) {
        ToothRootLabel toothRootLabel = dao.remove(id);
        if(toothRootLabel!=null)
            return toothRootLabel;
        throw new ResourceNotFoundException("Tooth root label not found");
    }
    
    
}
