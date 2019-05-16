package com.miromaric.dentalassistant.service;

import com.miromaric.dentalassistant.model.ToothLabel;
import java.util.List;

/**
 *
 * @author Tatjana
 */
public interface ToothLabelService {
    void save(ToothLabel toothLabel);
    List<ToothLabel> getAll();
    ToothLabel getOne(int id);
    ToothLabel update(int id,ToothLabel toothLabel);
    ToothLabel remove(int id);
}
