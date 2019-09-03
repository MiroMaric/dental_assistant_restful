package com.miromaric.dentalassistant.service.impl.filter.interventions;

import com.miromaric.dentalassistant.service.impl.filter.interventions.DentistInterventionsFilter;
import com.miromaric.dentalassistant.model.Intervention;
import com.miromaric.dentalassistant.model.User;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DentistInterventionsFilterTest {

    private DentistInterventionsFilter filter;
    private List<Intervention> dummyList;

    @Before
    public void setUp() {
        dummyList = new ArrayList<>(Arrays.asList(
                getDummyInterventionWithExplicitDentistUsername(new Long(1),"pera"),
                getDummyInterventionWithExplicitDentistUsername(new Long(2),"zika"),
                getDummyInterventionWithExplicitDentistUsername(new Long(3),"laza"),
                getDummyInterventionWithExplicitDentistUsername(new Long(4),"pera"),
                getDummyInterventionWithExplicitDentistUsername(new Long(5),"mika")
        ));
    }

    @After
    public void tearDown() {
        filter = null;
        dummyList = null;
    }

    @Test
    public void testShouldBeRuturnFilteredList() {
        filter = new DentistInterventionsFilter("pera", null);
        List<Intervention> filteredInterventions = filter.filter(dummyList);
        Assert.assertEquals(2,filteredInterventions.size());
        for (Intervention i : filteredInterventions) {
            Assert.assertTrue(i.getUser().getUsername().equals("pera"));
        }
    }

    @Test
    public void testShouldBeReturnUnfilteredList() {
        filter = new DentistInterventionsFilter(null, null);
        List<Intervention> filteredInterventions = filter.filter(dummyList);
        Assert.assertArrayEquals(dummyList.toArray(), filteredInterventions.toArray());

    }

    @Test(expected = RuntimeException.class)
    public void testShouldBeThrownRuntimeException() {
        filter = new DentistInterventionsFilter("pera", null);
        List<Intervention> filteredInterventions = filter.filter(null);
    }

    private Intervention getDummyInterventionWithExplicitDentistUsername(Long interventionId,String username) {
        Intervention i = new Intervention();
        i.setInterventionID(interventionId);
        i.setUser(new User(username));
        return i;
    }

}
