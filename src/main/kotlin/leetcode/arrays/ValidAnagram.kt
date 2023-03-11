
class ValidAnagram {
    fun isAnagram(s: String, t: String): Boolean {
        if (s.length != t.length) return false

        val lettersArray = IntArray(26)

        for ((index, sChar) in s.withIndex()) {
            lettersArray[sChar - 'a'] += 1
            lettersArray[t[index] - 'a'] -= 1
        }

        lettersArray.forEach {
            if (it != 0) return false
        }

        return true
    }
}
