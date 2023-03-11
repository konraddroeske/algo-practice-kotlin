class GroupAnagrams {
    fun getFreqHash(word: String): Int {
        val freqs = IntArray(26)
        for (char in word) {
            freqs[char - 'a'] += 1
        }
        return freqs.contentHashCode()
    }
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        return strs.groupBy(this::getFreqHash).values.toList()
    }
}
