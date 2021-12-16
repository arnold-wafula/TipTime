package com.lemonboy.tiptime

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.hamcrest.Matchers.containsString
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class CalculationTests {
    @get:Rule
    val activity = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun calculate_default_tip(){
        onView(withId(R.id.cost_of_service_edit_text)).perform(typeText("36.00"))

        onView(withId(R.id.round_up_switch)).perform(click())
        onView(withId(R.id.round_up_switch)).check(matches(isEnabled()))

        onView(withId(R.id.calculate_button)).perform(click())

        onView(withId(R.id.tip_result)).check(matches(withText(containsString("7.20"))))
    }

    @Test
    fun calculate_eighteen_percent_tip(){
        onView(withId(R.id.cost_of_service_edit_text)).perform(typeText("50.00"))

        onView(withId(R.id.option_eighteen_percent)).perform(click())
        onView(withId(R.id.option_eighteen_percent)).check(matches(isChecked()))

        onView(withId(R.id.round_up_switch)).perform(click())
        onView(withId(R.id.round_up_switch)).check(matches(isEnabled()))

        onView(withId(R.id.calculate_button)).perform(click())

        onView(withId(R.id.tip_result)).check(matches(withText(containsString("9.00"))))
    }

    @Test
    fun calculate_fifteen_percent_tip(){
        onView(withId(R.id.cost_of_service_edit_text)).perform(typeText("38.00"))

        onView(withId(R.id.option_fifteen_percent)).perform(click())
        onView(withId(R.id.option_fifteen_percent)).check(matches(isChecked()))

        onView(withId(R.id.round_up_switch)).perform(click())
        onView(withId(R.id.round_up_switch)).check(matches(isEnabled()))

        onView(withId(R.id.calculate_button)).perform(click())
        onView(withId(R.id.tip_result)).check(matches(withText(containsString("5.70"))))
    }
}