package com.ys.test.androidtestsamples

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.rule.ActivityTestRule
import org.junit.Rule
import org.junit.Test

/**
 * Created by Albert-IM on 24/11/2017.
 */
class MainActivityTest {

    @Rule @JvmField
    var activityRule: ActivityTestRule<MainActivity> = ActivityTestRule(MainActivity::class.java)

    @Test
    fun shouldInitState() {
        onView(withId(R.id.tvHello)).check(matches(isDisplayed()))
    }

    @Test
    fun shouldSayHelloWrold() {
        onView(withId(R.id.tvHello)).check(matches(withText("Hello World!")))
    }
}