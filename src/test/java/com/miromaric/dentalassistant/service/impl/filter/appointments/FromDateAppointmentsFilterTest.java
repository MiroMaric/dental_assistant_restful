package com.miromaric.dentalassistant.service.impl.filter.appointments;

import com.miromaric.dentalassistant.model.Appointment;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FromDateAppointmentsFilterTest {

    private FromDateAppointmentsFilter filter;
    private List<Appointment> dummyList;

    @Before
    public void setUp() {
        dummyList = new ArrayList<>(Arrays.asList(
                getDummyAppointmentWithExplicitStartDate(new Long(1), new Date(5)),
                getDummyAppointmentWithExplicitStartDate(new Long(2), new Date(150)),
                getDummyAppointmentWithExplicitStartDate(new Long(3), new Date(200)),
                getDummyAppointmentWithExplicitStartDate(new Long(4), new Date(300)),
                getDummyAppointmentWithExplicitStartDate(new Long(5), new Date(-505))
        ));
    }

    @After
    public void tearDown() {
        filter = null;
        dummyList = null;
    }

    @Test
    public void testShouldBeRuturnFilteredList() {
        long timeInMilliseconds = 200;
        filter = new FromDateAppointmentsFilter(new Date(timeInMilliseconds), null);
        List<Appointment> filteredAppointments = filter.filter(dummyList);
        Assert.assertEquals(2, filteredAppointments.size());
        for (Appointment a : filteredAppointments) {
            Assert.assertTrue(a.getStartTime().getTime() >= timeInMilliseconds);
        }
    }

    @Test
    public void testShouldBeReturnUnfilteredList() {
        filter = new FromDateAppointmentsFilter(null, null);
        List<Appointment> filteredAppointments = filter.filter(dummyList);
        Assert.assertArrayEquals(dummyList.toArray(), filteredAppointments.toArray());

    }

    @Test(expected = RuntimeException.class)
    public void testShouldBeThrownRuntimeException() {
        filter = new FromDateAppointmentsFilter(null, null);
        List<Appointment> filteredAppointments = filter.filter(null);
    }

    private Appointment getDummyAppointmentWithExplicitStartDate(Long appointmentId, Date date) {
        Appointment appointment = new Appointment();
        appointment.setAppointmentID(appointmentId);
        appointment.setStartTime(date);
        return appointment;
    }

}
