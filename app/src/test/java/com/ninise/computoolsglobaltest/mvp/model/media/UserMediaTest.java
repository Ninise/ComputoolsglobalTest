package com.ninise.computoolsglobaltest.mvp.model.media;

import com.ninise.computoolsglobaltest.BuildConfig;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowActivity;

import static org.junit.Assert.*;

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class UserMediaTest {

    ShadowActivity mActivity = new ShadowActivity();

    @Test
    public void testGetUserMusic() throws Exception {
        Assertions.assertThat(UserMedia.getUserMusic(mActivity.getApplicationContext())).isNotNull();
    }
}