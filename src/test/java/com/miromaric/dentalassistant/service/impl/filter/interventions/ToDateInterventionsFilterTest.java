
package com.miromaric.dentalassistant.service.impl.filter.interventions;

import com.miromaric.dentalassistant.service.impl.filter.interventions.ToDateInterventionsFilter;
import com.miromaric.dentalassistant.model.Intervention;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class ToDateInterventionsFilterTest {
    
    private ToDateInterventionsFilter filter;
    private List<Intervention> dummyList;

    @Before
    public void setUp() {
        dummyList = new ArrayList<>(Arrays.asList(
                getDummyInterventionWithExplicitDate(new Long(1),new Date(5)),
                getDummyInterventionWithExplicitDate(new Long(2),new Date(100)),
                getDummyInterventionWithExplicitDate(new Long(3),new Date(500)),
                getDummyInterventionWithExplicitDate(new Long(4),new Date(-10)),
                getDummyInterventionWithExplicitDate(new Long(5),new Date(-50))
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
        filter = new ToDateInterventionsFilter(new Date(timeInMilliseconds), null);
        List<Intervention> filteredInterventions = filter.filter(dummyList);
        Assert.assertEquals(4,filteredInterventions.size());
        for(Intervention i:filteredInterventions){
            Assert.assertTrue(i.getDate().getTime() <= timeInMilliseconds );
        }
    }
    
    @Test
    public void testShouldBeReturnUnfilteredList() {
        filter = new ToDateInterventionsFilter(null, null);
        List<Intervention> filteredInterventions = filter.filter(dummyList);
        Assert.assertArrayEquals(dummyList.toArray(), filteredInterventions.toArray());

    }
    
    @Test(expected = RuntimeException.class)
    public void testShouldBeThrownRuntimeException() {
        filter = new ToDateInterventionsFilter(null, null);
        List<Intervention> filteredInterventions = filter.filter(null);
    }

    private Intervention getDummyInterventionWithExplicitDate(Long interventionId,Date date) {
        Intervention i = new Intervention();
        i.setInterventionID(interventionId);
        i.setInterventionID(date.getTime());
        i.setDate(date);
        return i;
    }
    
}
