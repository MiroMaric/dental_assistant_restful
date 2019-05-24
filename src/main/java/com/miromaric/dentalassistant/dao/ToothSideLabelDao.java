package com.miromaric.dentalassistant.dao;

import com.miromaric.dentalassistant.model.ToothLabel;
import com.miromaric.dentalassistant.model.ToothSideLabel;
import java.util.List;

/**
 *
 * @author MikoPC
 */
public interface ToothSideLabelDao {
    
    void save(ToothSideLabel toothSideLabel);
    List<ToothSideLabel> getAll();
    ToothSideLabel getOne(int id);
    ToothSideLabel update(int id,ToothSideLabel toothSideLabel);
    ToothSideLabel remove(int id);
    
}
