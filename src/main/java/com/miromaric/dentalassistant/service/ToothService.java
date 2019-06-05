package com.miromaric.dentalassistant.service;

import com.miromaric.dentalassistant.model.Tooth;
import java.util.List;

/**
 *
 * @author MikoPC
 */
public interface ToothService extends Service<Tooth, Long>{
    
    List<Tooth> getAllPatientsTeeth(Long patientId);

    Tooth getPatientsTooth(Long patientId, Long toothId);
    
}
