class Solution {
    public int scheduleCourse(int[][] courses) {
        // 1) Sort by lastDay
        Arrays.sort(courses, (a, b) -> a[1] - b[1]);

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        int currentTime = 0;

        for (int[] c : courses) {
            int duration = c[0];
            int lastDay = c[1];

            currentTime += duration;
            maxHeap.offer(duration);

            // If deadline exceeded, remove the course with largest duration
            if (currentTime > lastDay) {
                currentTime -= maxHeap.poll();
            }
        }
        return maxHeap.size();
    }
}
