public class LongestValidParentheses {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s1 = "(()";
        System.out.println(solution.longestValidParentheses(s1));
        String s2 = ")()())";
        System.out.println(solution.longestValidParentheses(s2));
        String s3 = "";
        System.out.println(solution.longestValidParentheses(s3));
        String s4 = "()(()";
        System.out.println(solution.longestValidParentheses(s4));
        String s5 = "(()()";
        System.out.println(solution.longestValidParentheses(s5));
    }

    static class Solution {
        public int longestValidParentheses(String s) {
            int length = 0;
            char start = '(';
            int[] arr = new int[s.length()];

            int before = -1;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == start) {
                    before = i;
                    arr[i] = -1;
                } else {
                    while (before >= 0) {
                        if (arr[before] == -1) {
                            arr[i] = 1;
                            arr[before--] = 1;
                            break;
                        }
                        before--;
                    }
                }
            }

            int temp = 0;
            for (int j : arr) {
                if (j == 1) {
                    length = Math.max(length, ++temp);
                } else {
                    temp = 0;
                }
            }

            return length;
        }
    }

//    static class Solution {
//        public int longestValidParentheses(String s) {
//            int length = 0;
//            char start = '(';
//
//            int p = 0;
//            int m = 0;
//            int temp = 0;
//            for (int i = 0; i < s.length(); i++) {
//                if (s.charAt(i) == start) {
//                    p++;
//                    temp = 0;
//                } else {
//                    m++;
//                    length = Math.max(length, ++temp);
//                }
//
////                if (p > 0 && m > 0 && ((diff < 0) || (i == s.length() - 1))) {
//                int diff = p - m;
//
//                if (diff == 0){
//                    length = Math.max(length, m);
//                } else if ((diff < 0) ) {
//                    p = 0;
//                    m = 0;
//                }
//            }
//
//            return length * 2;
//        }
//    }
}
