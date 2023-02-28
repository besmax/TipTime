package bes.max.tiptime

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.hamcrest.core.StringContains.containsString
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class CalculatorTests {

    @get:Rule()
    val activity = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun calculate_20_percent_tip() {

        //имитируем ввод текста в поле
        onView(withId(R.id.cost_of_service_edit_text)).perform(typeText("50.00"))

        //имитируем клик по кнопке
        onView(withId(bes.max.tiptime.R.id.calculate_button)).perform(click())

        //проверяем сколько отобразилось чаевых
        onView(withId(R.id.tip_result))
            .check(matches(withText(containsString("$10.00"))))
    }
}