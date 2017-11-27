package com.ys.test.androidtestsamples

import android.support.test.espresso.Espresso
import android.support.test.espresso.assertion.ViewAssertions
import android.support.test.espresso.matcher.ViewMatchers
import com.ys.test.androidtestsamples.junit.AddingMachine
import org.hamcrest.Matchers
import org.junit.Assert.*
import org.junit.Test


/**
 * Created by Albert-IM on 23/11/2017.
 */
class AddingMachineTest {
    private val addingMachine = AddingMachine()

    @Test
    fun baseTest() {
        assertThat("Zero is one", 0, Matchers.`is`(0))
    }
    @Test fun sum_shouldReturnCorrectResultAsString() {
        assertThat("sum ", addingMachine.sum("1", "1"), Matchers.`is`("2"))
        assertThat("not matched!!", addingMachine.sum("1", "1"), Matchers.not("1"))
        assertThat("not matched!!", addingMachine.sum("1", "1"), Matchers.not("3"))
    }


}