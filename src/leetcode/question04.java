package leetcode;

public class question04 {

//    给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
//
//    请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
//
//    你可以假设 nums1 和 nums2 不会同时为空。
//
//    示例 1:
//
//    nums1 = [1, 3]
//    nums2 = [2]
//
//    则中位数是 2.0
//    示例 2:
//
//    nums1 = [1, 2]
//    nums2 = [3, 4]
//
//    则中位数是 (2 + 3)/2 = 2.5


    public static void main(String[] args) {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        System.out.println(findMedianSortedArrays(nums1, nums2));

    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] nums;
        int m = nums1.length;
        int n = nums2.length;
        nums = new int[m + n];
        if (m == 0) {
            if (n % 2 == 0) {
                return (nums2[n / 2 - 1] + nums2[n / 2]) / 2.0;
            } else {

                return nums2[n / 2];
            }
        }
        if (n == 0) {
            if (m % 2 == 0) {
                return (nums1[m / 2 - 1] + nums1[m / 2]) / 2.0;
            } else {
                return nums1[m / 2];
            }
        }

        int count = 0;
        int i = 0, j = 0;
        while (count != (m + n)) {
            if (i == m) {
                while (j != n) {
                    nums[count++] = nums2[j++];
                }
                break;
            }
            if (j == n) {
                while (i != m) {
                    nums[count++] = nums1[i++];
                }
                break;
            }

            if (nums1[i] < nums2[j]) {
                nums[count++] = nums1[i++];
            } else {
                nums[count++] = nums2[j++];
            }
        }

        if (count % 2 == 0) {
            return (nums[count / 2 - 1] + nums[count / 2]) / 2.0;
        } else {
            return nums[count / 2];
        }

    }


}
