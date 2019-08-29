package com.miromaric.dentalassistant.service.impl;

import com.miromaric.dentalassistant.dao.DAO;
import com.miromaric.dentalassistant.dao.impl.InterventionDaoImpl;
import com.miromaric.dentalassistant.dao.impl.PatientDaoImpl;
import com.miromaric.dentalassistant.exception.ResourceNotFoundException;
import com.miromaric.dentalassistant.model.Intervention;
import com.miromaric.dentalassistant.model.Patient;
import com.miromaric.dentalassistant.model.RootIntervention;
import com.miromaric.dentalassistant.model.SideIntervention;
import com.miromaric.dentalassistant.model.Tooth;
import com.miromaric.dentalassistant.model.ToothIntervention;
import com.miromaric.dentalassistant.model.ToothLabel;
import com.miromaric.dentalassistant.model.ToothRoot;
import com.miromaric.dentalassistant.model.ToothRootLabel;
import com.miromaric.dentalassistant.model.ToothRootState;
import com.miromaric.dentalassistant.model.ToothSide;
import com.miromaric.dentalassistant.model.ToothSideLabel;
import com.miromaric.dentalassistant.model.ToothSideState;
import com.miromaric.dentalassistant.model.ToothState;
import com.miromaric.dentalassistant.model.User;
import com.miromaric.dentalassistant.service.PatientService;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class PatientServiceImpl implements PatientService {

    private final DAO<Patient, Long> patientDao = new PatientDaoImpl();
    private final DAO<Intervention, Long> interventionDao = new InterventionDaoImpl();

    @Override
    public void save(Patient patient) {
        Intervention intervention = new Intervention(new Date(), "Novi elektronski karton", new User("pera"));
        if (interventionDao.save(intervention)) {
            System.out.println("\n\n\n");
            System.out.println(intervention.getInterventionID());
            System.out.println("\n\n\n");

            List<Tooth> teeth = new LinkedList<>();
            for (int i = 1; i <= 32; i++) {
                Tooth tooth = new Tooth(null, patient, new ToothLabel(new Long(i)));
                List<ToothIntervention> toothInterventions = new ArrayList<>();
                toothInterventions.add(
                        new ToothIntervention(
                                tooth, 
                                new ToothState(new Long(1)),
                                null, 
                                new Intervention(intervention.getInterventionID()), 
                                "Pocetno stanje"));
                tooth.setToothInterventions(toothInterventions);
                List<ToothSide> toothSides = new ArrayList<>(5);
                for (int j = 1; j <= 5; j++) {
                    ToothSide toothSide = new ToothSide(null, tooth, new ToothSideLabel(new Long(j)), null);
                    List<SideIntervention> sideInerventions = new ArrayList<>();
                    sideInerventions.add(
                            new SideIntervention(
                                    toothSide ,
                                    new ToothSideState(new Long(1)),
                                    null,
                                    new Intervention(intervention.getInterventionID()),
                                    "Pocetno stanja"));
                    toothSide.setSideInterventions(sideInerventions);
                    toothSides.add(toothSide);
                }
                tooth.setToothSides(toothSides);
                int numOfRoots = getNumberOfRoots(i);
                List<ToothRoot> toothRoots = new ArrayList<>(numOfRoots);
                for (int k = 1; k <= numOfRoots; k++) {
                    ToothRoot toothRoot = new ToothRoot();
                    toothRoot.setRootLabel(new ToothRootLabel(new Long(numOfRoots)));
                    List<RootIntervention> rootInterventions = new ArrayList<>();
                    rootInterventions.add(
                            new RootIntervention(
                                    toothRoot,
                                    new ToothRootState(new Long(1)),
                                    null, 
                                    new Intervention(intervention.getInterventionID()), 
                                    "Pocetno stanje"));
                    toothRoot.setRootInterventions(rootInterventions);
                    toothRoot.setTooth(tooth);
                    toothRoots.add(toothRoot);
                }
                tooth.setToothRoots(toothRoots);
                teeth.add(tooth);
            }
            patient.setTeeth(teeth);
            patientDao.save(patient);
        }
    }

    @Override
    public List<Patient> getAll() {
        return patientDao.getAll();
    }

    @Override
    public Patient getOne(Long id) {
        Patient patient = patientDao.getOne(id);
        if (patient != null) {
            return patient;
        }
        throw new ResourceNotFoundException("Patient not found");
    }

    @Override
    public Patient update(Long id, Patient patient) {
        Patient dbPatient = patientDao.update(id, patient);
        if (dbPatient != null) {
            return dbPatient;
        }
        throw new ResourceNotFoundException("Patient not found");
    }

    @Override
    public Patient remove(Long id) {
        Patient patient = patientDao.remove(id);
        if (patient != null) {
            return patient;
        }
        throw new ResourceNotFoundException("Patient not found");
    }

    private int getNumberOfRoots(int id) {
        if (id <= 16) {
            if (id == 4 || id == 12) {
                return 2;
            } else if (id == 1 || id == 2 || id == 3 || id == 5 || id == 9 || id == 10 || id == 11 || id == 13) {
                return 1;
            }
            return 3;
        } else {
            if (id == 30 || id == 31 || id == 32 || id == 22 || id == 23 || id == 24) {
                return 2;
            }
            return 1;
        }
    }

}
