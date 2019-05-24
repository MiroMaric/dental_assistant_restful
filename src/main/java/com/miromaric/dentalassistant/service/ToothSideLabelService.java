package com.miromaric.dentalassistant.service;

import com.miromaric.dentalassistant.model.ToothSideLabel;
import java.util.List;

/**
 *
 * @author MikoPC
 */
public interface ToothSideLabelService {
    
    void save(ToothSideLabel toothSideLabel);
    List<ToothSideLabel> getAll();
    ToothSideLabel getOne(Long id);
    ToothSideLabel update(Long id,ToothSideLabel toothSideLabel);
    ToothSideLabel remove(Long id);
}
