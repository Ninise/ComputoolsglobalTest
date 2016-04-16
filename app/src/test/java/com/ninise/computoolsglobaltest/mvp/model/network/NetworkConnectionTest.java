package com.ninise.computoolsglobaltest.mvp.model.network;

import com.ninise.computoolsglobaltest.BuildConfig;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowActivity;

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class NetworkConnectionTest {

    ShadowActivity mActivity = new ShadowActivity();

    @Test
    public void testIsNetworkConnectionOn() throws Exception {

        Assertions.assertThat(
                NetworkConnection.isNetworkConnectionOn(mActivity.getApplicationContext())).isFalse();
    }
}