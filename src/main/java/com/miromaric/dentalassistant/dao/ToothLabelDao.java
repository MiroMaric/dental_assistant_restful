package com.miromaric.dentalassistant.dao;

import com.miromaric.dentalassistant.model.ToothLabel;
import java.util.List;

/**
 *
 * @author Tatjana
 */
public interface ToothLabelDao {
    void save(ToothLabel toothLabel);
    List<ToothLabel> getAll();
    ToothLabel getOne(Long id);
    ToothLabel update(Long id,ToothLabel toothLabel);
    ToothLabel remove(Long id);
}
