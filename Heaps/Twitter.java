package Heaps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class Twitter {

    // Global timestamp to ensure each tweet has a strictly increasing time
    private static int timestamp = 0;

    // Map: userId -> list of tweets
    // Each tweet stored as int[]{timestamp, tweetId}
    private Map<Integer, List<int[]>> tweets = new HashMap<>();

    // Map: userId -> set of followees
    // Stores which users a particular user follows.
    private Map<Integer, Set<Integer>> followMap = new HashMap<>();

    // postTweet(): Add a new tweet by a user
    public void postTweet(int userId, int tweetId) {

        // Initialize user tweet list if not present
        tweets.putIfAbsent(userId, new ArrayList<>());

        // Add the tweet with a unique increasing timestamp
        tweets.get(userId).add(new int[] { timestamp++, tweetId });
    }

    // getNewsFeed(): Return the 10 most recent tweets from the user
    // and the users they follow, ordered from most recent → oldest.
    public List<Integer> getNewsFeed(int userId) {

        // Max-heap sorted DESCENDING by timestamp
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);

        // Get followees; if none, return empty set
        Set<Integer> followees = followMap.getOrDefault(userId, new HashSet<>());

        // A user always sees their own tweets
        followees.add(userId);

        // Push all tweets of each followee into the heap
        for (int followee : followees) {
            List<int[]> tweetList = tweets.getOrDefault(followee, new ArrayList<>());
            maxHeap.addAll(tweetList);
        }

        // Extract up to 10 most recent tweetIds
        List<Integer> res = new ArrayList<>();
        while (!maxHeap.isEmpty() && res.size() < 10) {
            res.add(maxHeap.poll()[1]); // take tweetId
        }

        return res;
    }

    // follow(): followerId starts following followeeId
    public void follow(int followerId, int followeeId) {

        // Ensure the follower has a follow set
        followMap.putIfAbsent(followerId, new HashSet<>());

        // Add followee to follower's follow set
        followMap.get(followerId).add(followeeId);
    }

    // unfollow(): followerId stops following followeeId
    public void unfollow(int followerId, int followeeId) {

        // If user follows someone, remove followee from the set
        if (followMap.containsKey(followerId)) {
            followMap.get(followerId).remove(followeeId);
        }
    }

    public static void main(String[] args) {

        String[] commands = {
                "Twitter", "postTweet", "getNewsFeed", "follow",
                "postTweet", "getNewsFeed", "unfollow", "getNewsFeed"
        };

        Object[][] inputs = {
                {}, { 1, 5 }, { 1 }, { 1, 2 },
                { 2, 6 }, { 1 }, { 1, 2 }, { 1 }
        };

        List<Object> output = new ArrayList<>();
        Twitter twitter = null;

        for (int i = 0; i < commands.length; i++) {
            String cmd = commands[i];

            switch (cmd) {

                case "Twitter":
                    twitter = new Twitter();
                    output.add(null);
                    break;

                case "postTweet":
                    int userId1 = (int) inputs[i][0];
                    int tweetId = (int) inputs[i][1];
                    twitter.postTweet(userId1, tweetId);
                    output.add(null);
                    break;

                case "getNewsFeed":
                    int userId2 = (int) inputs[i][0];
                    output.add(twitter.getNewsFeed(userId2));
                    break;

                case "follow":
                    int followerId = (int) inputs[i][0];
                    int followeeId = (int) inputs[i][1];
                    twitter.follow(followerId, followeeId);
                    output.add(null);
                    break;

                case "unfollow":
                    int followerId2 = (int) inputs[i][0];
                    int followeeId2 = (int) inputs[i][1];
                    twitter.unfollow(followerId2, followeeId2);
                    output.add(null);
                    break;
            }
        }

        System.out.println(output);
    }
}
