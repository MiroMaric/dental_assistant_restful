package com.miromaric.dentalassistant.service.impl;

import com.miromaric.dentalassistant.dao.DAO;
import com.miromaric.dentalassistant.dao.impl.InterventionDaoImpl;
import com.miromaric.dentalassistant.exception.ResourceNotFoundException;
import com.miromaric.dentalassistant.model.Appointment;
import com.miromaric.dentalassistant.model.Intervention;
import com.miromaric.dentalassistant.service.InterventionService;
import com.miromaric.dentalassistant.service.impl.filter.FilterHandler;
import com.miromaric.dentalassistant.service.impl.filter.intervention.DentistFilter;
import com.miromaric.dentalassistant.service.impl.filter.intervention.FromDateFilter;
import com.miromaric.dentalassistant.service.impl.filter.intervention.ToDateFilter;
import java.util.Date;
import java.util.List;

/**
 *
 * @author MikoPC
 */
public class InterventionServiceImpl implements InterventionService {

    private final DAO<Intervention, Long> dao = new InterventionDaoImpl();

    @Override
    public void save(Intervention resource) {
        dao.save(resource);
    }

    @Override
    public List<Intervention> getAll() {
        return dao.getAll();
    }

    @Override
    public Intervention getOne(Long id) {
        Intervention intervention = dao.getOne(id);
        if (intervention != null) {
            return intervention;
        }
        throw new ResourceNotFoundException("Intervention not found");
    }

    @Override
    public Intervention update(Long id, Intervention resource) {
        Intervention intervention = dao.update(id, resource);
        if (intervention != null) {
            return intervention;
        }
        throw new ResourceNotFoundException("Intervention not found");
    }

    @Override
    public Intervention remove(Long id) {
        Intervention intervention = dao.remove(id);
        if (intervention != null) {
            return intervention;
        }
        throw new ResourceNotFoundException("Intervention not found");
    }

    @Override
    public List<Intervention> getFiltered(Date fromDate, Date toDate, String username) {
        return (new FromDateFilter(fromDate,
                new ToDateFilter(toDate,
                        new DentistFilter(username, null))))
                .handleRequest(dao.getAll());
    }

}
