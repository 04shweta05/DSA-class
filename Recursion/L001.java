package DSAclass.Recursion;
import java.util.ArrayList;
import java.util.List;

public class L001 {

    // Time complexity : O(n)
    // Use case :
    // 1.Search in array
    // 2.do task for n numbers
    // 3.one call recursion

    // Print Increasing

    public static void printIncreasing(int num1, int num2) {
        if (num1 == num2 + 1) {
            return;
        }
        System.out.println(num1);
        printIncreasing(num1 + 1, num2);

    }

    public static void printDecreasing(int num1, int num2) {
        if (num1 == num2 + 1) {
            return;
        }

        printDecreasing(num1 + 1, num2);
        System.out.println(num1);
    }

    public static void printIncDecr(int num1, int num2) {
        if (num1 == num2 + 1) {
            return;
        }
        System.out.println(num1);
        printIncDecr(num1 + 1, num2);
        System.out.println(num1);
    }

    public static void printEvenOdd(int num1, int num2) {

        if (num1 > num2) {
            return;
        }
        if (num1 % 2 == 0) {
            System.out.println(num1);

        }
        printEvenOdd(num1 + 1, num2);
        if (num1 % 2 != 0) {
            System.out.println(num1);
        }
    }

    public static int fact(int num) {
        if (num == 0) {
            return 1;
        } else
            return num * fact(num - 1);

    }

    public static int power(int num1, int num2) {

        if (num1 == 0) {
            return 0;
        }
        if (num2 == 0) {
            return 1;
        }
        return num1 * power(num1, num2 - 1);

    }

    public static void powerBtr(int num1, int num2) {

    }

    // ==================Recursion on Array==================================
    public static void display(int idx, int arr[]) {

        if (arr.length == idx) {
            return;
        }
        System.out.println(arr[idx]);
        display(idx + 1, arr);
    }

    public static void displayReverse(int idx, int arr[]) {
        if (arr.length == idx) {
            return;
        }

        displayReverse(idx + 1, arr);
        System.out.println(arr[idx]);
    }

    public static void displayOnEvenLocations(int idx, int arr[]) {
        if (idx >= arr.length) {
            return;
        }

        if (idx % 2 == 0) {
            System.out.println(arr[idx]);
        }

        displayOnEvenLocations(idx + 1, arr);
    }

    public static void displayOnPrimeLocations(int idx, int arr[]) {
        if (idx >= arr.length) {
            return;
        }

        if (isPrime(idx)) {
            System.out.println(arr[idx]);

        }

        displayOnPrimeLocations(idx + 1, arr);

    }

    public static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static int find(int idx, int data, int arr[]) {
        if (idx >= arr.length) {
            return -1;
        }

        if (arr[idx] == data) {
            return idx;
        }

        return find(idx + 1, data, arr);

    }

    public static int[] findAll(int idx, int data, int arr[]) {
        return arr;

    }

    public static ArrayList<String> subsequence(String str, int idx) {

        if (idx == str.length()) {
            ArrayList<String> base = new ArrayList<String>();
            base.add("");
            return base;
        }

        char ch = str.charAt(idx);

        ArrayList<String> smallAns = subsequence(str, idx + 1);
        ArrayList<String> myans = new ArrayList<>();
        for (String s : smallAns) {
            myans.add(s);
            myans.add(ch + s);
        }
        return myans;

    }

    // =======================mazepath===================================
    // public static char dirs[] = {'H', 'V', 'D'};
    // public static int dirA[][] = {{0, 1}, {1, 0}, {1, 1}};

    // public static void mazepathHVD(int sr, int sc, int er, int ec, String ans) {

    // if (sr == er && sc == ec) {
    // System.out.println(ans);
    // return;
    // }

    // for (int d = 0; d < dirs.length; d++) {
    // int newSr = sr + dirA[d][0];
    // int newSc = sc + dirA[d][1];

    // if (newSr >= 0 && newSr <= er && newSc >= 0 && newSc <= ec) {
    // mazepathHVD(newSr, newSc, er, ec, ans + dirs[d]);
    // }
    // }
    // }

    // Flood Fill -->DFS

    public static String[] dirs = { "N", "E", "S", "W", "ne", "se", "sw", "nw" };
    public static int diraA[][] = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 1 }, { 1, 1 }, { 1, -1 },
            { -1, -1 } };
    static ArrayList<String> myanswer = new ArrayList<String>();

    public static void mazepathFloodfill(int sr, int sc, int er, int ec, String ans, int vis[][]) {
        if (sr == er && sc == ec) {
            System.out.println(ans);
            myanswer.add(ans);
            return;
        }
        vis[sr][sc] = 1;
        for (int d = 0; d < dirs.length; d++) {
            int r = sr + diraA[d][0];
            int c = sc + diraA[d][1];

            if (r >= 0 && r <= er && c >= 0 && c <= ec && vis[r][c] != -1 && vis[r][c] != 0) {
                mazepathFloodfill(r, c, er, ec, ans + dirs[d], vis);
            }
        }
        vis[sr][sc] = 0;
    }

    public static String ArrD[] = { "N", "E", "S", "W", "ne", "se", "sw", "nw" };
    public static int ArrC[][] = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 1 }, { 1, 1 }, { 1, -1 },
            { -1, -1 } };

    public static void mazepathFloodfillJump(int sr, int sc, int er, int ec, String ans, int vis[][],
            ArrayList<String> myans) {
        if (sr == er && sc == ec) {
            System.out.println(ans);

            myans.add(ans);
            return;
        }
        vis[sr][sc] = 1;

        for (int i = 0; i < ArrD.length; i++) {
            for (int jump = 1; jump <= 3; jump++) {

                int r = sr + jump * ArrC[i][0];
                int c = sc + jump * ArrC[i][1];

                if (r >= 0 && r <= er && c >= 0 && c <= ec && vis[r][c] != -1 && vis[r][c] != 0) {
                    mazepathFloodfillJump(r, c, er, ec, ans + ArrD[i] + jump, vis, myans);
                }
            }
            vis[sr][sc] = 0;

        }
    }

    // public static String[] dirss = { "D", "L", "R", "U" };
    // public static int diraaA[][] = { { 1, 0 }, { 0, -1 }, { 0, 1 }, { -1, 0 } };
    // static ArrayList<String> myanswers = new ArrayList<String>();
    // int n;
    // int[][] m;

    // public static void ratMaze(int sr, int sc, int er, int ec, String ans,
    // String[] dirss, int diraaA[][],
    // ArrayList<String> myanswers, int vis[][]) {
    // if (sr == er && sc == ec) {

    // myanswer.add(ans);
    // return;
    // }
    // int temp = vis[sr][sc];
    // vis[sr][sc] = -1;
    // for (int d = 0; d < dirss.length; d++) {
    // int r = sr + diraaA[d][0];
    // int c = sc + diraaA[d][1];

    // if (r >= 0 && r <= er && c >= 0 && c <= ec && vis[r][c] != -1 && vis[r][c] !=
    // 0) {
    // ratMaze(r, c, er, ec, ans + dirss[d], dirss, diraaA, myanswers, vis);
    // }
    // }
    // vis[sr][sc] = temp;
    // }

    // take cell count and print matrix
    public static void display(int arr[][]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {

            }
        }
        for (int ar[] : arr) {
            for (int num : ar) {
                System.out.println(num + " ");
            }
            System.out.println();
        }
    }

    static String dirS[] = { "E", "H", "N", "S" };
    static int dirA[][] = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    public static int[][] mazepathjump(int sr, int sc, int er, int ec, String ans, int arr[][], int vis[][]) {
        if (sr == er && sc == ec) {
            System.out.println(ans);
            display(vis);
            return vis;
        }
        int maxjump = arr[sc][sc];
        int temp[][] = new int[er + 1][er + 1];
        vis[sr][sc] = 1;
        for (int i = 0; i < dirS.length; i++) {
            for (int jump = 1; jump <= maxjump; jump++) {
                int r = sr + dirA[i][0] * jump;
                int c = sc + dirA[i][1] * jump;
                if (r <= er && c <= ec && r >= 0 && c >= 0) {
                    if (vis[r][c] != 1) {
                        temp = mazepathjump(sr, sc, er, ec, ans + dirS[i] + "" + jump, arr, vis);
                    }
                }
            }
            vis[sr][sc] = 0;
            return vis;

        }
        return temp;
    }

    static class Path {
        String longestPath;
        String shortestPath;
        int longestPathLength;
        int shortestPathLength;
        int[][] longestPathCo;
        int[][] shortestPathCo;
    }

    static int[][] dirArr = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
    static String dirrS[] = { "D", "R", "U", "L" };

    public static int[][] copyArray(int vis[][]) {

        int rows = vis.length;
        int cols = vis[0].length;
        int ans[][] = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                ans[i][j] = vis[i][j];
            }
        }
        return ans;
    }

    public static Path mazePathjump2(int sr, int sc, int er, int ec, String ans, int arr[][], int vis[][]) {

        if (sr == er && sc == ec) {
            System.out.println(ans);

            Path p = new Path();
            p.longestPath = ans;
            p.shortestPath = ans;
            p.longestPathLength = ans.length();
            p.shortestPathLength = ans.length();

            p.longestPathCo = copyArray(vis);
            p.shortestPathCo = copyArray(vis);

            return p;

        }

        int temp = arr[sr][sc];
        arr[sr][sc] = -1;
        vis[sr][sc] = 1;

        Path mypath = new Path();
        mypath.longestPathCo = new int[er + 1][ec + 1];
        mypath.shortestPathCo = new int[er + 1][er + 1];
        mypath.shortestPathLength = (int) 1e9;
        mypath.shortestPath = "";
        mypath.longestPath = "";
        mypath.longestPathLength = -(int) 1e9;

        for (int i = 0; i < dirrS.length; i++) {
            for (int jump = 1; jump <= temp; jump++) {
                int r = sr + jump * dirArr[i][0];
                int c = sc + jump * dirArr[i][1];
                if (r <= er && c <= ec && r >= 0 && c >= 0) {
                    if (arr[r][c] > 0) {
                        Path tempans = mazePathjump2(r, c, er, ec, ans + "" + dirrS[i] + "" + jump, arr, vis);

                        if (tempans.longestPathLength > mypath.longestPathLength) {
                            mypath.longestPath = tempans.longestPath;
                            mypath.longestPathCo = tempans.longestPathCo;
                            mypath.longestPathLength = tempans.longestPathLength;

                        }

                        if (tempans.shortestPathLength < mypath.shortestPathLength) {
                            mypath.shortestPath = tempans.shortestPath;
                            mypath.shortestPathCo = tempans.shortestPathCo;
                            mypath.shortestPathLength = tempans.shortestPathLength;

                        }
                    }

                } else {
                    break;
                }

            }
        }
        arr[sr][sc] = temp;
        vis[sr][sc] = 0;
        return mypath;

    }

    // print the longest path and all the path having the same length
    // && print the shortest path and all the path having the same length

    static class Path1 {
        String longestPath;
        String shortestPath;
        int longestPathLength;
        int shortestPathLength;
        int[][] longestPathCo;
        int[][] shortestPathCo;
        List<String> allShortestPaths;
        List<String> allLongestPaths;

        public Path1() {
            allShortestPaths = new ArrayList<>();
            allLongestPaths = new ArrayList<>();
        }

    }

    ///////////////// Permutation and Combination//////////////////////////

    // find all permutations where target can be achieved using given coins
    // if one coin can be used infinite times

    public static int permutationInfiCoins(int arr[], int tar, String ans) {
        if (tar == 0) {
            System.out.println(ans);
            return 1;
        }

        int count = 0;
        for (int element : arr) {
            if (tar - element >= 0) {
                count += permutationInfiCoins(arr, tar - element, ans + "" + element);
            }
        }
        return count;
    }

    // find all combination where target can be achieved using given coins
    // if one coin can be used infinite times

    public static int combinationInfiCoins(int arr[], int idx, int tar, String ans) {
        if (tar == 0) {
            System.out.println(ans);
            return 1;
        }

        int count = 0;
        for (int i = idx; i < arr.length; i++) {
            if (tar - arr[i] >= 0) {
                count += combinationInfiCoins(arr, i, tar - arr[i], ans + "" + arr[i]);
            }
        }
        return count;
    }

    // Permutation(one coin can be used only once)

    public static int permutationSingleUseCoins(int[] arr, int tar, String ans, boolean[] used) {
        if (tar == 0) {
            System.out.println(ans);
            return 1;
        }

        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (!used[i] && tar - arr[i] >= 0) {
                used[i] = true;
                count += permutationSingleUseCoins(arr, tar - arr[i], ans + arr[i], used);
                used[i] = false;
            }
        }
        return count;
    }

    // Combination(one coin can be used only once)

    public static int combinationSingleUseCoins(int arr[], int idx, int tar, String ans) {
        if (tar == 0) {
            System.out.println(ans);
            return 1;
        }

        int count = 0;
        for (int i = idx; i < arr.length; i++) {
            if (tar - arr[i] >= 0) {
                count += combinationInfiCoins(arr, i + 1, tar - arr[i], ans + "" + arr[i]);
            }
        }
        return count;
    }
    // ---------Refrence--------
    // public static void subsequence1(String str, int indx, String ans) {
    // if (str.length() == indx) {
    // System.out.println(ans);
    // return;
    // }
    // subsequence1(str, indx + 1, ans);
    // char ch = str.charAt(indx);
    // subsequence1(str, indx + 1, ans = ans + ch);

    //     }
    public static int combinationInfiCoinsSub(int arr[], int idx, int tar, String ans) {
        if (tar == 0 || idx == arr.length) {
            if (tar == 0) {
                System.out.println(ans);
                return 1;
            }
            return 0;
        }
        int count = 0;
        if (tar - arr[idx] >= 0) {
            count += combinationInfiCoinsSub(arr, idx, tar - arr[idx], ans + arr[idx] + "");
        }
        count += combinationInfiCoinsSub(arr, idx + 1, tar, ans);

        return count;
    }

    public static int combinationSingleUseCoinsSub(int arr[], int idx, int tar, String ans) {
        if (tar == 0 || idx == arr.length) {
            if (tar == 0) {
                System.out.println(ans);
                return 1;
            }
            return 0;
        }

        int count = 0;
        if (tar - arr[idx] >= 0)
            count += combinationSingleUseCoinsSub(arr, idx + 1, tar - arr[idx], ans + arr[idx] + " "); // Include the
                                                                                                       // current coin
                                                                                                       // and move to
                                                                                                       // the next index

        count += combinationSingleUseCoinsSub(arr, idx + 1, tar, ans); //// Exclude the current coin and move to the
                                                                       //// next index

        return count;
    }

    public static int permutationSingleSub(int arr[], int idx, int tar, String ans) {
        if (tar == 0 || idx == arr.length) {
            if (tar == 0) {
                System.out.println(ans);
                return 1;
            }
            return 0;
        }

        int count = 0;
        if (arr[idx] > 0 && tar - arr[idx] >= 0) {
            int val = arr[idx];
            arr[idx] = -val;
            count += permutationSingleSub(arr, idx, tar - val, ans + val + "");
            arr[idx] = val;
        }
        count += permutationSingleSub(arr, idx + 1, idx, ans);
        return count;
    }

    // private static boolean findEqualSumSubsets(int[] numbers, int index, int
    // sum1, int sum2, List<Integer> subset1, List<Integer> subset2) {
    // // Base case- If we've reached the end of the array and the sums are equal
    // if (index == numbers.length) {
    // return sum1 == sum2;
    // }

    // // Try adding the current element to subset1
    // subset1.add(numbers[index]);
    // if (findEqualSumSubsets(numbers, index + 1, sum1 + numbers[index], sum2,subset1, subset2)) {
    // return true;
    // }
    // subset1.remove(subset1.size() - 1);

    // // Try adding the current element to subset2
    // subset2.add(numbers[index]);
    // if (findEqualSumSubsets(numbers, index + 1, sum1, sum2 + numbers[index],subset1, subset2)) {
    // return true;
    // }
    // subset2.remove(subset2.size() - 1);

    //
    // return false;
    // }
    // }

    public static int subSet(int[] arr, int idx, int sum1, int sum2, String ans1, String ans2) {
        if (idx == arr.length) {
            if (sum1 == sum2) {
                System.out.println("Subset1 : " + ans1 + " " + "Subset2 : " + ans2);
                return 1;

            }
            return 0;
        }
        int count = 0;
        count += subSet(arr, idx + 1, sum1 + arr[idx], sum2, ans1 + arr[idx] + " ", ans2);
        count += subSet(arr, idx + 1, sum1, sum2 + arr[idx], ans1, ans2 + arr[idx] + " ");
        return count;

    }

    

    // ===========================Solve Function==============================
    public static void solve() {
        // printIncreasing(1, 5);
        // printDecreasing(1, 5);
        // printIncDecr(1, 5);
        // printEvenOdd(3, 8);
        // int ans = fact(5);
        // System.out.println(ans);
        // int answer = power(2, 3);
        // System.out.println(answer);
        // int arr[]={5,7,9,3,1};
        // displayReverse(0, arr);
        // int arr[]={5,7,9,3,1};
        // displayOnEvenLocations(0, arr);
        // int[] arr = {1,2,3,4,5,6,7,8,9,10,11,12};
        // displayOnPrimeLocations(0, arr);

        // int[] arr = {1,2,3,4,5,6,7,8,9};
        // int data=4;
        // int index = find(0, data, arr);
        // if(index != -1){
        // System.out.println("Element" + data + "found at index" + index);
        // }
        // else{
        // System.out.println("Element" + data + "not found");
        // }
        // ArrayList<String> myans =subsequence("abc", 0);
        // for(String s : myans)
        // {
        // System.out.println(myans);
        // }
        // int sr = 0;
        // int sc = 0;
        // int er = 2;
        // int ec = 2;

        // mazepathHVD(sr, sc, er, ec, "");

        // int vis[][]={{0,0,0},{0,0,0},{0,0,0}};
        // mazepathFloodfill(0, 0, 2, 2,"", vis);
        // System.out.println(myanswer.size());

        // if (m[0][0] == 0 || m[n - 1][n - 1] == 0) {
        // return myanswer;
        // }

        // ratMaze(0, 0, n - 1, n - 1, "", dirs, diraA, myanswer, m);
        // return myanswer;

        // ArrayList<String>myans=new ArrayList<>();
        // int arr[][] = {{0,0,0},{0,0,0},{0,0,0}};
        // mazepathFloodfillJump(0,0,2,2,"",arr,myans);
        // System.out.println(myans.size());

        // int vis[][] = { { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0
        // } };
        // int arr[][] = { { 2, 1, 1, 1 }, { 3, 1, 0, 1 }, { 1, 1, 1, 1 }, { 0, 1, 1, 1
        // } };

        // Path result = mazePathjump2(0, 0, 3, 3, "", arr, vis);
        // System.out.println("Longest path " + result.longestPath);
        // System.out.println("Shortest path " + result.shortestPath);

        // int[] coins = {2, 3, 5, 7}; // Array of coins
        // int target = 10; // Target sum
        // String ans = ""; // Initial answer string (empty)

        // int totalPermutations = permutationInfiCoins(coins, target, ans);

        // System.out.println("Total permutations: " + totalPermutations);

        // int[] coins = {2, 3, 5, 7}; // Array of coins
        // int target = 10; // Target sum
        // String ans = ""; // Initial answer string (empty)

        // int totalCombination = combinationInfiCoins(coins, 0,target, ans);

        // System.out.println("Total combination: " + totalCombination);
        // boolean[] used = new boolean[coins.length];
        // int totalPermutations = permutationSingleUseCoins(coins, target,ans,used);
        // System.out.println("Total permutation: " + totalPermutations);

        // combinationInfiCoinsSub(coins,0,target,"");

        // combinationSingleUseCoinsSub(coins,0,target,"");

        // int count = permutationSingleSub(coins, 0, target, ans);
        // System.out.println("Total permutations: " + count);

        // int[] arr = { 10, 20, 30, 40, 50, 60, 70 };
        // int idx = 0;
        // int sum1 = 0;
        // int sum2 = 0;
        // String ans1 = "";
        // String ans2 = "";

        //  int count = subSet(arr, idx, sum1, sum2, ans1, ans2);
        //  System.out.println("Subsets: " + count);

         int[] arr = { 10, 20, 30, 40, 50, 60, 70 };
         int idx = 1; //starts from the second element means idx[1]
         int sum1 = arr[0]; 
         int sum2 = 0;
         String ans1 = arr[0] +  ""; //add 10 to subset1 as default 
         String ans2 = "";
 
          int count = subSet(arr, idx, sum1, sum2, ans1, ans2);
          System.out.println("Subsets: " + count);

       
    }

    // ===========================Main Method==============================
    public static void main(String args[]) {
        solve();
    }
}

