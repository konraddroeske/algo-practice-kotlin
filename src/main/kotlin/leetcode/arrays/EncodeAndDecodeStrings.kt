
class EncodeAndDecodeStrings {
    private fun encode(strs: List<String>): String {
        val result = StringBuilder()

        for (word in strs) {
            val size = word.length
            result.append("$size#$word")
        }

        return result.toString()
    }

    private fun decode(s: String): List<String> {
        val result = mutableListOf<String>()
        var i = 0

        while (i < s.length) {
            var j = i

            while (s[j] != '#') {
                j += 1
            }

            val wordLength = s.slice(i until j).toInt()
            i = j + 1 + wordLength
            val word = s.slice(j + 1 until i)
            result.add(word)
        }

        return result
    }

    fun encodeAndDecode(strs: List<String>): List<String> {
        val encoded = encode(strs)
        return decode(encoded)
    }
}
