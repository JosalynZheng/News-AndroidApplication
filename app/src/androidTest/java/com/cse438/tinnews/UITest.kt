package com.cse438.tinnews

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.*
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.espresso.matcher.ViewMatchers.withText
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class UITest {

    @get:Rule
    var mainActivityTestRule: ActivityTestRule<MainActivity> = ActivityTestRule(MainActivity::class.java)

    @Test
    fun testClearTextbox() {

        onView(withId(R.id.rejectBtn)).perform(click())
        onView(withId(R.id.acceptBtn)).perform(click())
        //onView(withId(R.id.more)).perform(click())
        //onView(withId(R.id.title)).check(matches(withText("")))

    }
}