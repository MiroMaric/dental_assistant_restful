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
    ToothLabel getOne(Long id);
    ToothLabel update(Long id,ToothLabel toothLabel);
    ToothLabel remove(Long id);
}
