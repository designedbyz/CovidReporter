package com.designedbyz.covidreporter.timessearch

import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.RelaxedMockK
import org.junit.Before

import org.junit.Assert.*

class NytSearchUseCaseTest {

    @RelaxedMockK

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
    }
}
