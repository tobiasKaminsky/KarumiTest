package me.kaminsky.karumitest

import android.app.Activity
import android.os.Looper
import android.view.View
import android.widget.LinearLayout
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.facebook.testing.screenshot.Screenshot
import com.facebook.testing.screenshot.ViewHelpers
import kotlinx.android.synthetic.main.bottom_sheet.*
import me.kaminsky.karumitest.dialog.MyBottomSheetDialog
import org.junit.Rule
import org.junit.Test

class BottomSheetTest {
    @get:Rule
    var activityRule: IntentsTestRule<MainActivity> = IntentsTestRule(
        MainActivity::class.java,
        true,
        false
    )

    @Test
    fun open_recordsOnlyMainActivity() {
        val sut: Activity = activityRule.launchActivity(null)

        onView(withId(R.id.open_bottom_sheet)).perform(ViewActions.click())
        
        Screenshot.snapActivity(sut).record()
    }

    @Test
    fun open_measureOnNullObject() {
        Looper.prepare()
        val sut: MainActivity = activityRule.launchActivity(null)

        val dialog = MyBottomSheetDialog(sut)

        ViewHelpers.setupView(dialog.bottom_sheet_main)
            .setExactHeightPx(100)
            .setExactWidthPx(100)
            .layout()

        Screenshot.snap(dialog.bottom_sheet_main).record()
    }

    @Test
    fun open_null() {
        Looper.prepare()
        val sut: MainActivity = activityRule.launchActivity(null)

        onView(withId(R.id.open_bottom_sheet)).perform(ViewActions.click())
        
        Thread.sleep(1000)

        val view: View = sut.findViewById<LinearLayout>(R.id.bottom_sheet_main)
        ViewHelpers.setupView(view).layout()

        Screenshot.snap(view).record()
    }
}
