package com.ninise.computoolsglobaltest.mvp.model.entities;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import static org.junit.Assert.*;


public class DoubleViewEntityTest {

    DoubleViewEntity mEntity = new DoubleViewEntity("1", "one");

    @Test
    public void testGetTitle() throws Exception {
        Assertions.assertThat(mEntity.getTitle()).isNotNull();
        Assertions.assertThat(mEntity.getTitle()).isEqualTo("1");
    }

    @Test
    public void testSetTitle() throws Exception {
        mEntity.setTitle("2");
        Assertions.assertThat(mEntity.getTitle()).isNotNull();
        Assertions.assertThat(mEntity.getTitle()).isEqualTo("2");
    }

    @Test
    public void testGetDesrp() throws Exception {
        Assertions.assertThat(mEntity.getDesrp()).isNotNull();
        Assertions.assertThat(mEntity.getDesrp()).isEqualTo("one");
    }

    @Test
    public void testSetDesrp() throws Exception {
        mEntity.setDesrp("two");
        Assertions.assertThat(mEntity.getDesrp()).isNotNull();
        Assertions.assertThat(mEntity.getDesrp()).isEqualTo("two");
    }
}