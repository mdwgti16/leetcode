import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    public static void main(String[] args) {
        List<String> strings = new Solution().generateParenthesis(3);
        System.out.println(strings);
    }

    public static class Solution {
        public List<String> generateParenthesis(int n) {
            List<String> results = new ArrayList<>();
            generateParenthesis(n, n, results, new StringBuilder());
            return results;
        }

        private void generateParenthesis(int l, int r, List<String> results, StringBuilder sb) {
            if (l == 0 && r == 0) {
                results.add(sb.toString());
                return;
            }

            if (l > 0) {
                generateParenthesis(l - 1, r, results, sb.append('('));
                sb.deleteCharAt(sb.length() - 1);
            }

            if (r > l) {
                generateParenthesis(l, r - 1, results, sb.append(')'));
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    public static class Solution1 {
        public List<String> generateParenthesis(int n) {
            List<String> results = new ArrayList<>();
            generateParenthesis(0, 0, 0, n * 2, "", results);

            return results;
        }

        private void generateParenthesis(int cur, int left, int right, int len, String s, List<String> results) {
            if (cur == 0) {
                generateParenthesis(++cur, 1, 0, len, "(", results);
                return;
            }

            if (cur == len - 1) {
                results.add(s + ")");
                return;
            }

            if (left != len / 2) {
                generateParenthesis(cur + 1, left + 1, right, len, s + "(", results);
            }

            if (right != (len / 2) - 1 && right < left) {
                generateParenthesis(cur + 1, left, right + 1, len, s + ")", results);
            }
        }
    }
}
