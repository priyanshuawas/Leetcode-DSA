class Solution {

    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        
        final ArrayList<Integer>[] parentChilds = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            if (i == headID) continue;

            final int parent = manager[i];
            if (parentChilds[parent] == null) parentChilds[parent] = new ArrayList<>();
            parentChilds[parent].add(i);
        }

        final Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] { headID, informTime[headID] });

        int maxInformTime = Integer.MIN_VALUE;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int currParent = curr[0];
            int currInformTime = curr[1];

            maxInformTime = Math.max(maxInformTime, currInformTime);

            final ArrayList<Integer> childs = parentChilds[currParent];
            if (childs != null) {
                for (Integer child : childs) {
                    queue.offer(new int[] { child, currInformTime + informTime[child] });
                }
            }
        }

        return maxInformTime;
    }
}