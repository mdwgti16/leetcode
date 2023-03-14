import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _4Sum {

    public static void main(String[] args) {
//        List<List<Integer>> lists = new Solution().fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0);
//        List<List<Integer>> lists = new Solution().fourSum(new int[]{0,0,0,0}, 0);
//        List<List<Integer>> lists = new Solution().fourSum(new int[]{2,1,0,-1}, 2);
//        List<List<Integer>> lists = new Solution().fourSum(new int[]{-3,-2,-1,0,0,1,2,3}, 0);
//        List<List<Integer>> lists = new Solution().fourSum(new int[]{1,-2,-5,-4,-3,3,3,5}, -11);
        List<List<Integer>> lists = new Solution().fourSum(new int[]{-1000000000, -1000000000, -1000000000, -1000000000}, 294967296);
        System.out.println(lists);
    }

    static class Solution {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            int len = nums.length;
            List<List<Integer>> results = new ArrayList<>();
            if (len < 4) {
                return results;
            }
            Arrays.sort(nums);

            for (int i = 0; i < len - 3; ) {
                int n1 = nums[i];

                for (int j = len - 1; j > i + 2; ) {
                    int n2 = nums[j];
                    int temp = n1 + n2;

                    int p = i + 1;
                    int q = j - 1;
                    while (p < q) {
                        int sum = temp + nums[p] + nums[q];

                        if (sum < target) {
                            p++;
                        } else if (sum > target) {
                            q--;
                        } else {
                            long checkOverflow = (long) temp + nums[p] + nums[q];
                            if (checkOverflow > Integer.MAX_VALUE || checkOverflow < Integer.MIN_VALUE){
                                break;
                            }

                            results.add(Arrays.asList(nums[i], nums[j], nums[p], nums[q]));

                            while (++p < q && nums[p - 1] == nums[p]) ;
                            while (p < --q && nums[q] == nums[q + 1]) ;
                        }
                    }
                    while (--j > i + 2 && nums[j] == nums[j + 1]) ;
                }
                while (++i < len - 3 && nums[i - 1] == nums[i]) ;
            }

            return results;
        }
    }

    static class Solution4 {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            int len = nums.length;
            List<List<Integer>> results = new ArrayList<>();
            if (len < 4) {
                return results;
            }
            Arrays.sort(nums);

            for (int i = 0; i < len - 3; ) {
                long n1 = nums[i];

                for (int j = len - 1; j > i + 2; ) {
                    int n2 = nums[j];
                    long temp = n1 + n2;

                    int p = i + 1;
                    int q = j - 1;
                    while (p < q) {
                        long sum = temp + nums[p] + nums[q];

                        if (sum < target) {
                            p++;
                        } else if (sum > target) {
                            q--;
                        } else {
                            results.add(Arrays.asList(nums[i], nums[j], nums[p], nums[q]));

                            while (++p < q && nums[p - 1] == nums[p]) ;
                            while (p < --q && nums[q] == nums[q + 1]) ;
                        }
                    }
                    while (--j > i + 2 && nums[j] == nums[j + 1]) ;
                }
                while (++i < len - 3 && nums[i - 1] == nums[i]) ;
            }

            return results;
        }
    }

    static class Solution3 {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            int len = nums.length;
            List<List<Integer>> results = new ArrayList<>();
            if (len < 4) {
                return results;
            }
            Arrays.sort(nums);


            for (int i = 0; i < len - 3; ) {
                long n1 = nums[i];

                for (int j = len - 1; j > i + 2; ) {
                    int n2 = nums[j];
                    long temp = n1 + n2;

                    int p = i + 1;
                    int q = j - 1;
                    while (p < q) {
                        long sum = temp + nums[p] + nums[q];

                        if (sum < target) {
                            p++;
                        } else if (sum > target) {
                            q--;
                        } else {
                            List<Integer> list = Arrays.asList(nums[i], nums[j], nums[p], nums[q]);
                            if (!results.contains(list)) {
                                results.add(list);
                            }

                            while (++p < q && nums[p - 1] == nums[p]) ;
                            while (p < --q && nums[q] == nums[q + 1]) ;
                        }
                    }

                    while (--j > i + 2 && nums[j] == nums[j + 1]) ;
                }

                while (++i < len - 3 && nums[i - 1] == nums[i]) ;
            }

            return results;
        }
    }

    static class Solution2 {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            int len = nums.length;
            List<List<Integer>> results = new ArrayList<>();
            if (len < 4) {
                return results;
            }
            Arrays.sort(nums);


            for (int i = 0; i < len - 3; i++) {
                long n1 = nums[i];

                for (int j = i + 1; j < len - 2; j++) {
                    int n2 = nums[j];
                    long temp = n1 + n2;

                    int p = j + 1;
                    int q = len - 1;
                    while (p < q) {
                        long sum = temp + nums[p] + nums[q];

                        if (sum < target) {
                            p++;
                        } else if (sum > target) {
                            q--;
                        } else {
                            List<Integer> list = Arrays.asList(nums[i], nums[j], nums[p], nums[q]);
                            if (!results.contains(list)) {
                                results.add(list);
                            }

                            while (++p < q && nums[p - 1] == nums[p]) ;
                            while (p < --q && nums[q] == nums[q + 1]) ;
                        }
                    }
                }
            }

            return results;
        }
    }

    static class Solution1 {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            int len = nums.length;
            List<List<Integer>> results = new ArrayList<>();
            if (len < 4) {
                return results;
            }
            Arrays.sort(nums);


            for (int i = 0; i < len - 3; i++) {
                long n1 = nums[i];

                for (int j = i + 1; j < len - 2; j++) {
                    int n2 = nums[j];
                    long temp = n1 + n2;

                    int p = j + 1;
                    int q = len - 1;
                    while (p < q) {
                        long sum = temp + nums[p] + nums[q];

                        if (sum < target) {
                            p++;
                        } else if (sum > target) {
                            q--;
                        } else {
                            List<Integer> list = Arrays.asList(nums[i], nums[j], nums[p], nums[q]);
                            if (!results.contains(list)) {
                                results.add(list);
                            }

                            p++;
                            q--;
                        }
                    }
                }
            }

            return results;
        }
    }
}
