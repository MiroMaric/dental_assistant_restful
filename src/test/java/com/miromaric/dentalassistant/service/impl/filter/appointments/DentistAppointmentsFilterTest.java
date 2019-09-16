package com.miromaric.dentalassistant.service.impl.filter.appointments;

import com.miromaric.dentalassistant.model.Appointment;
import com.miromaric.dentalassistant.model.User;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DentistAppointmentsFilterTest {
    private DentistAppointmentsFilter filter;
    private List<Appointment> dummyList;

    @Before
    public void setUp() {
        dummyList = new ArrayList<>(Arrays.asList(
                getDummyAppointmentWithExplicitDentistUsername(new Long(1), "pera"),
                getDummyAppointmentWithExplicitDentistUsername(new Long(2), "zika"),
                getDummyAppointmentWithExplicitDentistUsername(new Long(3), "laza"),
                getDummyAppointmentWithExplicitDentistUsername(new Long(4), "mika"),
                getDummyAppointmentWithExplicitDentistUsername(new Long(5), "pera")
        ));
    }

    @After
    public void tearDown() {
        filter = null;
        dummyList = null;
    }

    @Test
    public void testShouldBeRuturnFilteredList() {
        String username = "perica";
        filter = new DentistAppointmentsFilter(username, null);
        List<Appointment> filteredAppointments = filter.filter(dummyList);
        Assert.assertEquals(0, filteredAppointments.size());
        filteredAppointments.forEach((a) -> {
            Assert.assertTrue(a.getUser().getUsername().equals(username));
        });
    }

    @Test
    public void testShouldBeReturnUnfilteredList() {
        filter = new DentistAppointmentsFilter(null, null);
        List<Appointment> filteredAppointments = filter.filter(dummyList);
        Assert.assertArrayEquals(dummyList.toArray(), filteredAppointments.toArray());
    }

    @Test(expected = RuntimeException.class)
    public void testShouldBeThrownRuntimeException() {
        filter = new DentistAppointmentsFilter(null, null);
        List<Appointment> filteredAppointments = filter.filter(null);
    }

    private Appointment getDummyAppointmentWithExplicitDentistUsername(Long appointmentId,String username) {
        Appointment appointment = new Appointment();
        appointment.setAppointmentID(appointmentId);
        appointment.setUser(new User(username));
        return appointment;
    }
}
