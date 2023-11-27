import java.util.Arrays;
import java.util.stream.Collectors;

public class NextPermutation {

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        int[] nums = {1, 2, 3};
        solution.nextPermutation(nums);
        System.out.println(Arrays.stream(nums).mapToObj(String::valueOf).collect(Collectors.joining()));
        int[] nums1 = {3, 2, 1};
        solution.nextPermutation(nums1);
        System.out.println(Arrays.stream(nums1).mapToObj(String::valueOf).collect(Collectors.joining()));
        int[] nums2 = {1, 1, 5};
        solution.nextPermutation(nums2);
        System.out.println(Arrays.stream(nums2).mapToObj(String::valueOf).collect(Collectors.joining()));
        int[] nums3 = {1, 3, 2};
        solution.nextPermutation(nums3);
        System.out.println(Arrays.stream(nums3).mapToObj(String::valueOf).collect(Collectors.joining()));
        int[] nums4 = {1, 2};
        solution.nextPermutation(nums4);
        System.out.println(Arrays.stream(nums4).mapToObj(String::valueOf).collect(Collectors.joining()));
        int[] nums5 = {2, 3, 1};
        solution.nextPermutation(nums5);
        System.out.println(Arrays.stream(nums5).mapToObj(String::valueOf).collect(Collectors.joining()));
        int[] nums6 = {5, 4, 7, 5, 3, 2};
        solution.nextPermutation(nums6);
        System.out.println(Arrays.stream(nums6).mapToObj(String::valueOf).collect(Collectors.joining()));
        int[] nums7 = {4, 2, 0, 2, 3, 2, 0}; // 4,2,0,3,0,2,2
        solution.nextPermutation(nums7);
        System.out.println(Arrays.stream(nums7).mapToObj(String::valueOf).collect(Collectors.joining()));
    }

    static class Solution2 {
        public void nextPermutation(int[] nums) {
            int len = nums.length;
            int idx1 = -1;
            int idx2 = -1;
            for (int i = len - 2; i >= 0; i--) {
                if (nums[i] < nums[i + 1]) {
                    idx1 = i;
                    break;
                }
            }

            if (idx1 == -1) {
                reverse(nums, 0);
            } else {
                for (int i = len - 1; i >= 0; i--) {
                    if (nums[i] > nums[idx1]) {
                        idx2 = i;
                        break;
                    }
                }

                swap(nums, idx1, idx2);
                reverse(nums, idx1 + 1);
            }
        }

        public void swap(int[] nums, int i, int j) {
            int temp = nums[j];
            nums[j] = nums[i];
            nums[i] = temp;
        }

        public void reverse(int[] nums, int start) {
            int i = start;
            int j = nums.length - 1;
            while (i < j) {
                swap(nums, i, j);
                i++;
                j--;
            }
        }
    }

    static class Solution1 {
        public void nextPermutation(int[] nums) {
            int len = nums.length;
            if (len == 1) {
                return;
            }


            int start = 1;

            for (int i = len - 2; i >= 0; i--) {
                boolean isStopped = false;
                for (int j = len - 1; j > i; j--) {
                    if (nums[i] < nums[j]) {
                        swap(nums, i, j);
                        isStopped = true;
                        start = i + 1;
                        break;
                    }
                }
                if (isStopped) {
                    break;
                }

                if (i == 0) {
                    swap(nums, 0, len - 1);
                    break;
                }
            }

            while (true) {
                boolean isSwapped = false;
                for (int i = start; i < len - 1; i++) {
                    if (nums[i] > nums[i + 1]) {
                        swap(nums, i, i + 1);
                        isSwapped = true;
                    }
                }

                if (!isSwapped) {
                    break;
                }
            }
        }

        public void swap(int[] nums, int i, int j) {
            int temp = nums[j];
            nums[j] = nums[i];
            nums[i] = temp;
        }
    }
}
