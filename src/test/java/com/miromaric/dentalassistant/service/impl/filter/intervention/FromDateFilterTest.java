package com.miromaric.dentalassistant.service.impl.filter.intervention;

import com.miromaric.dentalassistant.model.Intervention;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FromDateFilterTest {

    private FromDateFilter filter;
    private List<Intervention> dummyList;

    @Before
    public void setUp() {
        dummyList = new ArrayList<>(Arrays.asList(
                getDummyInterventionWithExplicitDate(new Date(5)),
                getDummyInterventionWithExplicitDate(new Date(100)),
                getDummyInterventionWithExplicitDate(new Date(500)),
                getDummyInterventionWithExplicitDate(new Date(-10)),
                getDummyInterventionWithExplicitDate(new Date(-50))
        ));
    }

    @After
    public void tearDown() {
        filter = null;
        dummyList = null;
    }

    @Test
    public void testShouldBeRuturnFilteredList() {
        long timeInMilliseconds = 100;
        filter = new FromDateFilter(new Date(timeInMilliseconds), null);
        List<Intervention> filteredInterventions = filter.handleRequest(dummyList);
        Assert.assertEquals(2,filteredInterventions.size());
        for(Intervention i:filteredInterventions){
            Assert.assertTrue(i.getDate().getTime() >= timeInMilliseconds );
        }
    }
    
    @Test
    public void testShouldBeReturnUnfilteredList() {
        filter = new FromDateFilter(null, null);
        List<Intervention> filteredInterventions = filter.handleRequest(dummyList);
        Assert.assertArrayEquals(dummyList.toArray(), filteredInterventions.toArray());

    }
    
    @Test(expected = RuntimeException.class)
    public void testShouldBeThrownRuntimeException() {
        filter = new FromDateFilter(null, null);
        List<Intervention> filteredInterventions = filter.handleRequest(null);
    }

    private Intervention getDummyInterventionWithExplicitDate(Date date) {
        Intervention i = new Intervention();
        i.setInterventionID(date.getTime());
        i.setDate(date);
        return i;
    }

}
