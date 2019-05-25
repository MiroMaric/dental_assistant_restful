package com.miromaric.dentalassistant.service;

import com.miromaric.dentalassistant.model.ToothState;
import java.util.List;

/**
 *
 * @author MikoPC
 */
public interface ToothStateService {
    
    void save(ToothState toothState);
    List<ToothState> getAll();
    ToothState getOne(Long id);
    ToothState update(Long id,ToothState toothState);
    ToothState remove(Long id);
}
