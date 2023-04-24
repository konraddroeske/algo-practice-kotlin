package leetcode.graphs
class WordLadder {
    fun convertToPattern(index: Int, word: String): List<Char> {
        return word.mapIndexed { i, c ->
            if (i == index) '*' else c
        }
    }
    fun ladderLength(
        beginWord: String,
        endWord: String,
        wordList: List<String>,
    ): Int {
        if (!wordList.contains(endWord)) return 0

        val neighbours = HashMap<List<Char>, MutableList<String>>().withDefault { mutableListOf() }

        for (word in (wordList)) {
            for (index in word.indices) {
                val pattern = convertToPattern(index, word)

                val words = neighbours.getValue(pattern)
                words.add(word)
                neighbours[pattern] = words
            }
        }

        val queue = ArrayDeque<String>()
        queue.add(beginWord)

        val visited = mutableSetOf<String>()
        var result = 1

        while (queue.isNotEmpty()) {
            repeat(queue.size) {
                val word = queue.removeFirst()

                if (word == endWord) {
                    return result
                }

                visited.add(word)

                for (index in word.indices) {
                    val pattern = convertToPattern(index, word)
                    val curNeighbours = neighbours.getValue(pattern)

                    for (neighbour in curNeighbours) {
                        if (visited.contains(neighbour)) {
                            continue
                        }

                        queue.add(neighbour)
                    }
                }
            }

            result += 1
        }

        return 0
    }
}