package com.miromaric.dentalassistant.service;

import com.miromaric.dentalassistant.model.Intervention;
import java.util.Date;
import java.util.List;

/**
 *
 * @author MikoPC
 */
public interface InterventionService extends Service<Intervention, Long>{
    List<Intervention>getFiltered(Date fromDate,Date toDate,String username);
}
