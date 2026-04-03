class Solution {
    int[][] t;

    public int maxWalls(int[] robots, int[] distance, int[] walls) {
        int n = distance.length;
        int[][] roboDist = new int[n][2];
        for (int i = 0; i < n; i++) {
            roboDist[i][0] = robots[i];
            roboDist[i][1] = distance[i];
        }
        Arrays.sort(roboDist, (a, b) -> a[0] - b[0]);
        Arrays.sort(walls);
        int[][] range = new int[n][2];
        for (int i = 0; i < n; i++) {
            int pos = roboDist[i][0];
            int d = roboDist[i][1];

            int leftLimit = (i == 0) ? 1 : roboDist[i - 1][0] + 1;
            int rightLimit = (i == n - 1) ? (int) 1e9 : roboDist[i + 1][0] - 1;
            int L = Math.max(pos - d, leftLimit);
            int R = Math.min(pos + d, rightLimit);
            range[i][0] = L;
            range[i][1] = R;
        }
        t = new int[n][2];
        for (int[] row : t)
            Arrays.fill(row, -1);
        return solve(walls, roboDist, range, 0, 0);
    }

    int solve(int[] walls, int[][] roboDist, int[][] range, int i, int dir) {
        if (i == roboDist.length)
            return 0;
        if (t[i][dir] != -1)
            return t[i][dir];
        int leftStart = range[i][0];
        if (dir == 1 && i > 0) {
            leftStart = Math.max(leftStart, range[i - 1][1] + 1);
        }

        int leftTake = solve(walls, roboDist, range, i + 1, 0) + countWalls(walls, leftStart, roboDist[i][0]);
        int rightTake = solve(walls, roboDist, range, i + 1, 1) + countWalls(walls, roboDist[i][0], range[i][1]);
        return t[i][dir] = Math.max(leftTake, rightTake);
    }

    int countWalls(int[] walls, int l, int r) {
        int left = lowerBound(walls, l);
        int right = upperBound(walls, r);
        return right - left;
    }

    int upperBound(int[] arr, int target) {
        int l = 0;
        int r = arr.length;
        while (l < r) {
            int mid = l + (r-l) / 2;
            if (arr[mid] > target)
                r = mid;
            else
                l = mid + 1;
        }
        return l;
    }

    int lowerBound(int[] arr, int target) {
        int l = 0;
        int r = arr.length;
        while (l < r) {
            int mid = l + (r-l) / 2;
            if (arr[mid] >= target)
                r = mid;
            else
                l = mid + 1;
        }
        return l;
    }
}