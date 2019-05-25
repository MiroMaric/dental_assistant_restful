package com.miromaric.dentalassistant.service;

import com.miromaric.dentalassistant.model.ToothSideState;
import java.util.List;

/**
 *
 * @author MikoPC
 */
public interface ToothSideStateService {
    
    void save(ToothSideState toothSideState);
    List<ToothSideState> getAll();
    ToothSideState getOne(Long id);
    ToothSideState update(Long id,ToothSideState toothSideState);
    ToothSideState remove(Long id);
    
}
