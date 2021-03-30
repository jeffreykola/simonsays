package com.example.simonsays

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun sequence_equals() {
        val testSays = SimonSays(1)
        assertEquals(1, testSays.sequence.size)
        val testLevelTen = SimonSays(10)
        assertEquals(10, testLevelTen.sequence.size)

    }





}