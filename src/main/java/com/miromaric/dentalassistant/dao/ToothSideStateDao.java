/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miromaric.dentalassistant.dao;

import com.miromaric.dentalassistant.model.ToothSideState;
import java.util.List;

/**
 *
 * @author MikoPC
 */
public interface ToothSideStateDao {
    
    void save(ToothSideState toothSideState);
    List<ToothSideState> getAll();
    ToothSideState getOne(Long id);
    ToothSideState update(Long id,ToothSideState toothSideState);
    ToothSideState remove(Long id);
    
}
