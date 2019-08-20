package com.miromaric.dentalassistant.service.impl.filter.intervention;

import com.miromaric.dentalassistant.model.Intervention;
import com.miromaric.dentalassistant.model.User;
import com.miromaric.dentalassistant.service.impl.filter.intervention.DentistFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DentistFilterTest {

    private DentistFilter filter;
    private List<Intervention> dummyList;

    @Before
    public void setUp() {
        dummyList = new ArrayList<>(Arrays.asList(
                getDummyInterventionWithExplicitDentistUsername("pera"),
                getDummyInterventionWithExplicitDentistUsername("zika"),
                getDummyInterventionWithExplicitDentistUsername("laza"),
                getDummyInterventionWithExplicitDentistUsername("pera"),
                getDummyInterventionWithExplicitDentistUsername("mika")
        ));
    }

    @After
    public void tearDown() {
        filter = null;
        dummyList = null;
    }

    @Test
    public void testShouldBeRuturnFilteredList() {
        filter = new DentistFilter("pera", null);
        List<Intervention> filteredInterventions = filter.handleRequest(dummyList);
        for (Intervention i : filteredInterventions) {
            Assert.assertTrue(i.getUser().getUsername().equals("pera"));
        }
    }

    @Test
    public void testShouldBeReturnUnfilteredList() {
        filter = new DentistFilter(null, null);
        List<Intervention> filteredInterventions = filter.handleRequest(dummyList);
        Assert.assertArrayEquals(dummyList.toArray(), filteredInterventions.toArray());

    }

    @Test(expected = RuntimeException.class)
    public void testShouldBeThrownRuntimeException() {
        filter = new DentistFilter("pera", null);
        List<Intervention> filteredInterventions = filter.handleRequest(null);
    }

    private Intervention getDummyInterventionWithExplicitDentistUsername(String username) {
        Intervention i = new Intervention();
        i.setUser(new User(username));
        return i;
    }

}
