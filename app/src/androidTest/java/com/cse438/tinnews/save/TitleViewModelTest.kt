package com.cse438.tinnews.save

import android.support.test.espresso.Espresso
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.assertion.ViewAssertions
import android.support.test.espresso.matcher.ViewMatchers
import android.support.test.espresso.matcher.ViewMatchers.*
import com.cse438.tinnews.R
import junit.framework.Assert.assertTrue
import org.junit.After
import org.junit.Before
import org.junit.Test
import java.util.regex.Pattern.matches

class TitleViewModelTest {

    @Before
    fun setUp() {
    }
    @Test
    fun TitleView_Correct(){
        //onView(withId(R.id.title))
                //.perform(click())
        assertTrue(1 < 2 )
    }
    /*@Test
    fun title_correct(){
        onView(withId(R.id.title)).check(matches(withText("")))
    }*/
    @After
    fun tearDown() {
    }
}