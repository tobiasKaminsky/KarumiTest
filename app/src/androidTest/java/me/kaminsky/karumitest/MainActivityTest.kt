package me.kaminsky.karumitest

import android.app.Activity
import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.internal.runner.junit4.statement.UiThreadStatement
import com.facebook.testing.screenshot.Screenshot
import org.junit.Rule
import org.junit.Test

class MainActivityTest {
    @get:Rule
    var activityRule: IntentsTestRule<MainActivity> = IntentsTestRule(
        MainActivity::class.java,
        true,
        false
    )
    
    @Test
    fun open() {
        val sut: Activity = activityRule.launchActivity(null)

        Thread.sleep(2000)

        Screenshot.snapActivity(sut).record()
    }

    @Test
    fun changeText() {
        val sut: MainActivity = activityRule.launchActivity(null)

        Thread.sleep(2000)
        
        UiThreadStatement.runOnUiThread { sut.changeText() }

        Thread.sleep(2000)

        Screenshot.snapActivity(sut).record()
    }
}
