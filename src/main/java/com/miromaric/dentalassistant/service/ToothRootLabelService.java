/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miromaric.dentalassistant.service;

import com.miromaric.dentalassistant.model.ToothRootLabel;
import java.util.List;

/**
 *
 * @author MikoPC
 */
public interface ToothRootLabelService {
    void save(ToothRootLabel toothRootLabel);
    List<ToothRootLabel> getAll();
    ToothRootLabel getOne(Long id);
    ToothRootLabel update(Long id,ToothRootLabel toothRootLabel);
    ToothRootLabel remove(Long id);
}
