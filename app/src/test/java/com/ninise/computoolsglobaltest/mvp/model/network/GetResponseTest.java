package com.ninise.computoolsglobaltest.mvp.model.network;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

import static org.junit.Assert.*;


public class GetResponseTest {

    public static final String TEST_URL = "https://www.google.com.ua/";

    @Test
    public void testCreateResponse() throws Exception {
        Assertions.assertThat(GetResponse.createResponse(TEST_URL)).isNotNull();
    }
}