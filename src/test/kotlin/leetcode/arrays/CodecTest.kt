package leetcode.arrays

import EncodeAndDecodeStrings
import org.junit.jupiter.api.Test
import kotlin.test.assertContentEquals

class CodecTest {
    val solution = EncodeAndDecodeStrings()

    @Test
    fun encodeAndDecode1() {
        val input = listOf("Hello", "World")
        val result = solution.encodeAndDecode(input)

        assertContentEquals(input, result)
    }

    @Test
    fun encodeAndDecode2() {
        val input = listOf("")
        val result = solution.encodeAndDecode(input)

        assertContentEquals(input, result)
    }
}
