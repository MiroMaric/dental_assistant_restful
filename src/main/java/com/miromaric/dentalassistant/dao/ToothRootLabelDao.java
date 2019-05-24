package com.miromaric.dentalassistant.dao;

import com.miromaric.dentalassistant.model.ToothRootLabel;
import java.util.List;

/**
 *
 * @author MikoPC
 */
public interface ToothRootLabelDao {
    void save(ToothRootLabel toothRootLabel);
    List<ToothRootLabel> getAll();
    ToothRootLabel getOne(Long id);
    ToothRootLabel update(Long id,ToothRootLabel toothRootLabel);
    ToothRootLabel remove(Long id);
}
