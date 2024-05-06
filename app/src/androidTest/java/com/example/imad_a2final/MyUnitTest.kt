package com.example.imad_a2final

import android.content.Intent
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Assert
import org.junit.Assert.assertNotNull
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @Test
    fun testButtonClick() {
        // Start the MainActivity
        val scenario = ActivityScenario.launch(MainActivity::class.java)

        // Click the start button
        onView(withId(R.id.startBtn)).perform(click())

        // Get the launched activity
        scenario.onActivity { activity ->
            // Get the intent that was started
            val startedIntent = activity.intent

            // Assert that the intent is not null
            assertNotNull(startedIntent)

            // Assert that the intent points to MainActivity2
            val expectedIntent = Intent(activity, MainActivity2::class.java)
            Assert.assertEquals(expectedIntent.component, startedIntent.component)
        }
    }
}
