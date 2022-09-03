package com.example.demo;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.*;

public class HelloResource {
    public static void main(String[] args) {
        String test = "bccaaacb";
        Map<Character, Integer> freq = new HashMap<>();
        Map<Integer, Integer> maxCnt = new HashMap<>();
        Stack<int[]> stack = new Stack<>();
        char[] chars = test.toCharArray();
        stack.push(new int[]{chars[0]-'a', 1});
        int max= 0;
        int res = 0;
        for (int i = 1; i < chars.length; i++) {
            freq.put(chars[i], freq.getOrDefault(chars[i], 0) + 1);
            while (!stack.isEmpty() && stack.peek()[1] < freq.get(chars[i])) {
                stack.pop();
            }
            if (stack.isEmpty() || stack.peek()[1] == freq.get(chars[i])) {
                stack.push(new int[]{chars[i]-'a', freq.get(chars[i])});
            }
            Iterator<int[]> it = stack.iterator();
            while (it.hasNext()) {
                int[] arr = it.next();
                maxCnt.put(arr[0], maxCnt.getOrDefault(arr[0], 0) + 1);
                if (max < maxCnt.get(arr[0])) {
                    max = maxCnt.get(arr[0]);
                    res = arr[0];
                }
            }
        }
        System.out.println(res);
    }

//    public static int test(int[] price, int k) {
//        int n = price.length, res = 1;
//        Map<Integer, List<Integer>> map = new HashMap<>();
//        for (int i = 0; i < n; i++) {
//            List<Integer> list = map.getOrDefault(price[i], new ArrayList<>());
//            list.add(i);
//            map.put(price[i], list);
//        }
//        for (List<Integer> list: map.values()) {
//            int l = list.size();
//            if (l == 1) continue;
//            int curLong = 1;
//            int delete = list.get(1)-list.get(0)-1, left = 0, right = 1;
//            while (left < l && right < l) {
//                while (delete > k) {
//                    left++;
//                    delete -= list.get(left) - list.get(left-1) -1;
//                }
//                curLong = Math.max(right - left +1, curLong);
//                right++;
//                if (right < l) {
//                    delete += list.get(right) - list.get(right-1)- 1;
//                }
//            }
//            res = Math.max(res, curLong);
//        }
//        return res;
//    }


//    public static int findMax(int[] nums, int k) {
//        int n = nums.length;
//        Map<Integer, Integer> map = new HashMap<>();
//        int sum = 0;
//        for (int i = 0; i < k; i++) {
//            sum += nums[i]
//            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
//        }
//        int r
//    }

//    public static String[] simPass(String[] newPass, String[] oldPass) {
//        int n = newPass.length;
//        String[] res = new String[n];
//        for (int i = 0; i<n; i++) {
//            boolean ret = method(newPass[i], oldPass[i], 0, 0);
//            if (ret) {
//                res[i] = "YES";
//            } else {
//                res[i] = "NO";
//            }
//        }
//        return res;
//    }

//    public static boolean method(String np, String op, int nl, int ol) {
//        if (np.length() < op.length()) return false;
//        if (ol == op.length()) return true;
//        for (int i = nl; i < np.length(); i++) {
//            int c = np.charAt(i) - 'a', a = op.charAt(ol)-'a';
//            int p1 = c + 1;
//            if (c == 26) p1 = 0;
//            if (c == a || p1 == a || c-1 == a) {
//                System.out.print(a);
//                return true && method(np, op, i+1, ol+1);
//            }
//        }
//        return false;
//    }
}