public class DivideTwoIntegers {

    public static void main(String[] args) {
//        System.out.println(new Solution().divide(-2147483648, -1));
        System.out.println(new Solution().divide(15, 1));
//        System.out.println(new Solution().divide(24, 3));
    }

    static class Solution {

        public int divide(int dividend, int divisor) {
            if (divisor == 0 || (dividend == Integer.MIN_VALUE && divisor == -1)) {
                return Integer.MAX_VALUE;
            }

            boolean isPos = (dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0);

            int q = 0;
            long absDividend = Math.abs((long) dividend);
            long absDivisor = Math.abs((long) divisor);

            while (absDividend >= absDivisor) {
                int shift = 0;
                while (absDividend >= (absDivisor << shift)) {
                    shift++;
                }
                shift--;
                q += (1 << shift);
                absDividend -= absDivisor << shift;
            }

            return isPos ? -q : q;
        }
    }

    static class Solution2 {

        public int divide(int dividend, int divisor) {
            int i = 0;
            boolean p = (dividend >= 0 && divisor >= 0) || (dividend < 0 && divisor < 0);

            if ((divisor == 1 || divisor == -1) && dividend != 0) {
                if (dividend == Integer.MIN_VALUE && divisor == -1) {
                    return Integer.MAX_VALUE;
                }

                if (p) {
                    return Math.abs(dividend);
                } else {
                    return -Math.abs(dividend);
                }
            }

            long n = Math.abs((long) dividend);
            long m = Math.abs((long) divisor);

            while (n >= m) {
                n -= m;

                if (p) {
                    i++;
                } else {
                    i--;
                }
            }

            return i;
        }
    }

    static class Solution1 {
        public int divide(int dividend, int divisor) {
            long i = 0;
            long n = Math.abs((long) dividend);
            long m = Math.abs((long) divisor);
            boolean p = (dividend >= 0 && divisor >= 0) || (dividend < 0 && divisor < 0);
            if ((divisor == 1 || divisor == -1) && dividend != 0) {
                if (dividend == Integer.MIN_VALUE && p) {
                    return Integer.MAX_VALUE;
                }

                return p ? (int) n
                        : 1 - (int) n + 1;
            }

            while (n >= m) {
                n -= m;


                if (p) {
                    i++;
                } else {
                    i--;
                }
            }

            if (i > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            } else if (i < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            } else {
                return (int) i;
            }
        }
    }
}
