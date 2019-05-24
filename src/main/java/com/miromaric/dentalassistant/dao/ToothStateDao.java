package com.miromaric.dentalassistant.dao;

import com.miromaric.dentalassistant.model.ToothLabel;
import com.miromaric.dentalassistant.model.ToothState;
import java.util.List;

/**
 *
 * @author MikoPC
 */
public interface ToothStateDao {
    
    void save(ToothState toothState);
    List<ToothState> getAll();
    ToothState getOne(Long id);
    ToothState update(Long id,ToothState toothState);
    ToothState remove(Long id);
    
}
