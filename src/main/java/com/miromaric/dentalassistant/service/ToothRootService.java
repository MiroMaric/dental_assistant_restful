package com.miromaric.dentalassistant.service;

import com.miromaric.dentalassistant.model.ToothRoot;
import java.util.List;

public interface ToothRootService extends Service<ToothRoot, Long>{

    public List<ToothRoot> getAllPatientsToothRoots(Long patientId, Long toothId);

    public ToothRoot getPatientsToothRoot(Long patientId, Long toothId, Long toothRootId);
    
}
