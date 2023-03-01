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
    fun calculate_20_percent_tip_with_roundup() {

        //имитируем ввод текста в поле
        onView(withId(R.id.cost_of_service_edit_text)).perform(typeText("50.00"))

        //имитируем клик по кнопке
        onView(withId(bes.max.tiptime.R.id.calculate_button)).perform(click())

        //проверяем сколько отобразилось чаевых
        onView(withId(R.id.tip_result))
            .check(matches(withText(containsString("$10.00"))))
    }

    @Test
    fun calculate_20_percent_tip_without_roundup() {
        onView(withId(R.id.cost_of_service_edit_text)).perform(typeText("54.00"))
        onView(withId(R.id.round_up_switch)).perform(click())
        onView(withId(bes.max.tiptime.R.id.calculate_button)).perform(click())
        onView(withId(R.id.tip_result))
            .check(matches(withText(containsString("$10.80"))))
    }

    @Test
    fun calculate_18_percent_tip_with_roundup() {
        onView(withId(R.id.cost_of_service_edit_text)).perform(typeText("50.00"))
        onView(withId(R.id.option_eighteen_percent)).perform(click())
        onView(withId(bes.max.tiptime.R.id.calculate_button)).perform(click())
        onView(withId(R.id.tip_result))
            .check(matches(withText(containsString("$9.00"))))
    }

    @Test
    fun calculate_18_percent_tip_without_roundup() {
        onView(withId(R.id.cost_of_service_edit_text)).perform(typeText("54.00"))
        onView(withId(R.id.option_eighteen_percent)).perform(click())
        onView(withId(R.id.round_up_switch)).perform(click())
        onView(withId(bes.max.tiptime.R.id.calculate_button)).perform(click())
        onView(withId(R.id.tip_result))
            .check(matches(withText(containsString("$9.72"))))
    }

    @Test
    fun calculate_15_percent_tip_with_roundup() {
        onView(withId(R.id.cost_of_service_edit_text)).perform(typeText("50.00"))
        onView(withId(R.id.option_fifteen_percent)).perform(click())
        onView(withId(bes.max.tiptime.R.id.calculate_button)).perform(click())
        onView(withId(R.id.tip_result))
            .check(matches(withText(containsString("$8.00"))))
    }

    @Test
    fun calculate_15_percent_tip_without_roundup() {
        onView(withId(R.id.cost_of_service_edit_text)).perform(typeText("50.00"))
        onView(withId(R.id.option_fifteen_percent)).perform(click())
        onView(withId(R.id.round_up_switch)).perform(click())
        onView(withId(bes.max.tiptime.R.id.calculate_button)).perform(click())
        onView(withId(R.id.tip_result))
            .check(matches(withText(containsString("$7.50"))))
    }
}