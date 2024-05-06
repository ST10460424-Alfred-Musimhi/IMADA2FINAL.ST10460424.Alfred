package com.example.imad_a2final

import android.os.Handler
import android.os.Looper
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.util.*

@RunWith(AndroidJUnit4::class)
class MainActivity2Test {

    private lateinit var scenario: ActivityScenario<MainActivity2>

    @Before
    fun setUp() {
        scenario = ActivityScenario.launch(MainActivity2::class.java)
    }

    @Test
    fun testButtonClick_feedButton() {
        onView(withId(R.id.feedButton)).perform(click())
        val activity = getActivityInstance()
        assertEquals(10, activity.feed)
    }

    @Test
    fun testButtonClick_cleanButton() {
        onView(withId(R.id.cleanButton)).perform(click())
        val activity = getActivityInstance()
        assertEquals(10, activity.clean)
    }

    @Test
    fun testButtonClick_happyButton() {
        onView(withId(R.id.happyButton)).perform(click())
        val activity = getActivityInstance()
        assertEquals(10, activity.happy)
    }

    @Test
    fun testStatusDecrease() {
        val activity = getActivityInstance()
        activity.decreaseStatus()
        assertEquals(0, activity.happy)
        assertEquals(0, activity.feed)
        assertEquals(0, activity.clean)
    }

    private fun getActivityInstance(): MainActivity2 {
        var activityInstance: MainActivity2? = null
        scenario.onActivity {
            activityInstance = it
        }
        return activityInstance!!
    }
}
