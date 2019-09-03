package com.miromaric.dentalassistant.service.impl.filter.appointments;

import com.miromaric.dentalassistant.model.Appointment;
import com.miromaric.dentalassistant.model.Patient;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PatientAppointmentsFilterTest {
    private PatientAppointmentsFilter filter;
    private List<Appointment> dummyList;

    @Before
    public void setUp() {
        dummyList = new ArrayList<>(Arrays.asList(
                getDummyAppointmentWithExplicitPatientId(new Long(1), new Long(5)),
                getDummyAppointmentWithExplicitPatientId(new Long(2), new Long(5)),
                getDummyAppointmentWithExplicitPatientId(new Long(3), new Long(3)),
                getDummyAppointmentWithExplicitPatientId(new Long(4), new Long(2)),
                getDummyAppointmentWithExplicitPatientId(new Long(5), new Long(5))
        ));
    }

    @After
    public void tearDown() {
        filter = null;
        dummyList = null;
    }

    @Test
    public void testShouldBeRuturnFilteredList() {
        Long patientId = new Long(5);
        filter = new PatientAppointmentsFilter(patientId, null);
        List<Appointment> filteredAppointments = filter.filter(dummyList);
        Assert.assertEquals(3, filteredAppointments.size());
        for (Appointment a : filteredAppointments) {
            Assert.assertTrue(a.getPatient().getPatientID().equals(patientId));
        }
    }

    @Test
    public void testShouldBeReturnUnfilteredList() {
        filter = new PatientAppointmentsFilter(null, null);
        List<Appointment> filteredAppointments = filter.filter(dummyList);
        Assert.assertArrayEquals(dummyList.toArray(), filteredAppointments.toArray());
    }

    @Test(expected = RuntimeException.class)
    public void testShouldBeThrownRuntimeException() {
        filter = new PatientAppointmentsFilter(null, null);
        List<Appointment> filteredAppointments = filter.filter(null);
    }

    private Appointment getDummyAppointmentWithExplicitPatientId(Long appointmentId, Long patientId) {
        Appointment appointment = new Appointment();
        appointment.setAppointmentID(appointmentId);
        appointment.setPatient(new Patient(patientId));
        return appointment;
    }
}
