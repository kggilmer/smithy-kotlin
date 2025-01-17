/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0.
 */

package aws.smithy.kotlin.runtime.retries.impl

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineScope
import kotlinx.coroutines.test.runBlockingTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class ExponentialBackoffWithJitterTest {
    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun testScaling() = runBlockingTest {
        val options = ExponentialBackoffWithJitterOptions(
            initialDelayMs = 10,
            scaleFactor = 2.0, // Make the numbers easy for tests
            jitter = 0.0, // Disable jitter for this test
            maxBackoffMs = Int.MAX_VALUE, // Effectively disable max backoff
        )
        assertEquals(listOf(10, 20, 40, 80, 160, 320), backoffSeries(6, options))
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun testJitter() = runBlockingTest {
        val options = ExponentialBackoffWithJitterOptions(
            initialDelayMs = 10,
            scaleFactor = 2.0, // Make the numbers easy for tests
            jitter = 0.6, // 60% jitter for this test
            maxBackoffMs = Int.MAX_VALUE, // Effectively disable max backoff
        )
        backoffSeries(6, options)
            .zip(listOf(4..10, 8..20, 16..40, 32..80, 64..160, 128..320))
            .forEach { (actualMs, rangeMs) ->
                assertTrue(actualMs in rangeMs, "Actual ms $actualMs was not in expected range $rangeMs")
            }
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun testMaxBackoff() = runBlockingTest {
        val options = ExponentialBackoffWithJitterOptions(
            initialDelayMs = 10,
            scaleFactor = 2.0, // Make the numbers easy for tests
            jitter = 0.0, // Disable jitter for this test
            maxBackoffMs = 100,
        )
        assertEquals(listOf(10, 20, 40, 80, 100, 100), backoffSeries(6, options))
    }
}

@OptIn(ExperimentalCoroutinesApi::class)
private suspend fun TestCoroutineScope.backoffSeries(
    times: Int,
    options: ExponentialBackoffWithJitterOptions,
): List<Int> {
    val delayer = ExponentialBackoffWithJitter(options)
    return (1..times)
        .map { idx -> measure { delayer.backoff(idx) } }
        .map { it.first } // Just need the timing, not the results
}
