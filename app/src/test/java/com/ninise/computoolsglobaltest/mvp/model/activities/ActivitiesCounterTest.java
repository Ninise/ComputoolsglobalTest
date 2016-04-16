package com.ninise.computoolsglobaltest.mvp.model.activities;

import com.ninise.computoolsglobaltest.mvp.model.entities.DoubleViewEntity;

import org.assertj.core.api.Assertions;
import org.junit.Test;


public class ActivitiesCounterTest {

    @Test
    public void testGetInstance() throws Exception {
        Assertions.assertThat(ActivitiesCounter.getInstance()).isNotNull();
    }

    @Test
    public void testAddActivity() throws Exception {
        DoubleViewEntity doubleViewEntity = new DoubleViewEntity("1", "one");
        ActivitiesCounter.getInstance().addActivity(doubleViewEntity);
        Assertions.assertThat(ActivitiesCounter.getInstance().getActivities().get(1))
                .isEqualTo(doubleViewEntity);
    }

    @Test
    public void testGetActivities() throws Exception {
        ActivitiesCounter.getInstance().addActivity(new DoubleViewEntity("1", "one"));
        Assertions.assertThat(ActivitiesCounter.getInstance()).isNotNull();
    }
}