package leetcode.heap

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import kotlin.test.assertContentEquals

class DesignTwitterTest {

    @Test
    fun test1() {
        val twitter = DesignTwitter()

        twitter.postTweet(1, 5)
        val userTweets1 = twitter.tweetMap.getValue(1)
        assertEquals(Pair(0, 5), userTweets1[0])

        val newsfeed1 = twitter.getNewsFeed(1)
        assertContentEquals(listOf(5), newsfeed1)

        twitter.follow(1, 2)
        assertEquals(true, twitter.followerMap.getValue(1).contains(2))

        twitter.postTweet(2, 6)
        val userTweets2 = twitter.tweetMap.getValue(2)
        assertEquals(Pair(1, 6), userTweets2[0])

        val newsfeed2 = twitter.getNewsFeed(1)
        assertContentEquals(listOf(6, 5), newsfeed2)

        twitter.unfollow(1, 2)
        assertEquals(false, twitter.followerMap.getValue(1).contains(2))

        val newsfeed3 = twitter.getNewsFeed(1)
        assertContentEquals(listOf(5), newsfeed3)
    }
}