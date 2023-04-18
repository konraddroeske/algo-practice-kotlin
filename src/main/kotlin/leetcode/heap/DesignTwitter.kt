package leetcode.heap

import java.util.PriorityQueue

class DesignTwitter {
    val followerMap = HashMap<Int, HashSet<Int>>().withDefault {
        hashSetOf(it)
    }
    val tweetMap = HashMap<Int, MutableList<Pair<Int, Int>>>().withDefault {
        mutableListOf()
    }
    private var curTime = 0

    fun postTweet(userId: Int, tweetId: Int) {
        val userTweets = tweetMap.getValue(userId)
        userTweets.add(Pair(curTime, tweetId))
        tweetMap[userId] = userTweets

        curTime += 1
    }

    fun getNewsFeed(userId: Int): List<Int> {
        val result = mutableListOf<Int>()
        val maxHeap = PriorityQueue<List<Int>>() { a, b ->
            b[0] - a[0]
        }

        for (followeeId in followerMap.getValue(userId)) {
            val userTweets = tweetMap.getValue(followeeId)

            if (userTweets.size > 0) {
                val index = userTweets.size - 1
                val (tweetTime, tweetId) = userTweets[index]
                maxHeap.add(listOf(tweetTime, tweetId, followeeId, index - 1))
            }
        }

        while (maxHeap.isNotEmpty() && result.size < 10) {
            val (_, tweetId, followeeId, prevIndex) = maxHeap.poll()
            result.add(tweetId)

            val userTweets = tweetMap.getValue(followeeId)

            if (prevIndex >= 0 && prevIndex < userTweets.size - 1) {
                val (prevTweetTime, prevTweetId) = userTweets[prevIndex]
                maxHeap.add(
                    listOf(
                        prevTweetTime,
                        prevTweetId,
                        followeeId,
                        prevIndex - 1,
                    ),
                )
            }
        }

        return result
    }

    fun follow(followerId: Int, followeeId: Int) {
        val followees = followerMap.getValue(followerId)
        followees.add(followeeId)
        followerMap[followerId] = followees
    }

    fun unfollow(followerId: Int, followeeId: Int) {
        followerMap[followerId]?.remove(followeeId)
    }
}