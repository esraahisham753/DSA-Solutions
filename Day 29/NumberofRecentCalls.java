/*
You have a RecentCounter class which counts the number of recent requests within a certain time frame.

Implement the RecentCounter class:

RecentCounter() Initializes the counter with zero recent requests.
int ping(int t) Adds a new request at time t, where t represents some time in milliseconds, and returns the number of requests that have happened in the inclusive range [t - 3000, t], that is, the new request plus every earlier request that is no more than 3000 milliseconds older.
It is guaranteed that every call to ping uses a strictly larger value of t than the previous call.
*/

import java.util.Deque;
import java.util.ArrayDeque;

class RecentCounter {
    private Deque<Integer> queue;

    public RecentCounter() {
        queue = new ArrayDeque<>();    
    }
    
    public int ping(int t) {
        int min = t - 3000;

        while (! queue.isEmpty() && queue.peekFirst() < min) {
            queue.pollFirst();
        }

        queue.addLast(t);

        return queue.size();
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */