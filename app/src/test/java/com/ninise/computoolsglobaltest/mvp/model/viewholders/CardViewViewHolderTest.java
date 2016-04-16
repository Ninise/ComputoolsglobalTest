package com.ninise.computoolsglobaltest.mvp.model.viewholders;

import android.view.View;

import com.ninise.computoolsglobaltest.BuildConfig;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowActivity;

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class CardViewViewHolderTest {

    private ShadowActivity mShadowActivity;

    @Before
    public void setUp() throws Exception {
        mShadowActivity = new ShadowActivity();
    }

    @Test
    public void testViewHolderShouldBeNotNull() {
        Assertions.assertThat(
                new CardViewViewHolder(new View(mShadowActivity.getApplicationContext()))).isNotNull();
    }


}