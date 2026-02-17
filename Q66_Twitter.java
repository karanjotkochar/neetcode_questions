import java.util.*;

public class Q66_Twitter {
    private int time;                                       // for ordering tweets, increase with every tweet
    private Map<Integer, List< int[]> > tweetMap;           // list of (time, tweetId)
    private Map<Integer, Set<Integer> > followMap;          // set of (followee Ids)

    public Q66_Twitter() {
        // TC = O(1) for all methods
        // TC = O(n.m + t.logt) for getNewsFeed method
        // Space = O(N.m + N.M)

        // n = total no. of followee Ids
        // m = max no. of tweets by any user
        // t = total no. of tweets by any user
        // N = total no. of users
        // M = max no. of followers for any user

        time = 0;
        tweetMap = new HashMap<>();
        followMap = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {

        tweetMap.putIfAbsent(userId, new ArrayList<>());
        tweetMap.get(userId).add(new int[]{time++, tweetId} );
    }

    public List<Integer> getNewsFeed(int userId) {

        List<Integer> result = new ArrayList<>();

        List<int[]> feed = new ArrayList<>(tweetMap.getOrDefault(userId, new ArrayList<>()));       // add user to have his own tweets

        for (int followeeId : followMap.getOrDefault(userId, new HashSet<>()) ) {                   // add tweets from followee's
            feed.addAll(tweetMap.getOrDefault(followeeId, new ArrayList<>()));
        }

        feed.sort((a,b) -> b[0] - a[0] );                                                           // sort tweets as per time

        for (int i=0; i < Math.min(10, feed.size()); i++) {                                         // take top 10 tweets
            result.add(feed.get(i)[1]);
        }

        return result;
    }

    public void follow(int followerId, int followeeId) {

        if (followeeId != followerId) {
            followMap.putIfAbsent(followerId, new HashSet<>());
            followMap.get(followerId).add(followeeId);
        }
    }

    public void unfollow(int followerId, int followeeId) {

        followMap.getOrDefault(followerId, new HashSet<>()).remove(followeeId);
    }

}
