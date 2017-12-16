package LeetCode;

public class _4MidTwoArray {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if ( nums1 == null && nums2 == null)
            throw new Error("Invalid Input!!!");

        if (nums1 == null || nums1.length == 0){
            if (nums2.length == 0)
                throw new Error("Invalid Input!!!");

            if (nums2.length % 2 ==0)
                return 1.0*(nums2[nums2.length/2-1]+nums2[nums2.length/2])/2;
            else
                return nums2[nums2.length/2];
        }

        if (nums2 == null || nums2.length == 0){
            if (nums1.length == 0)
                throw new Error("Invalid Input!!!");

            if (nums1.length % 2 ==0)
                return 1.0*(nums1[nums1.length/2-1]+nums1[nums1.length/2])/2;
            else
                return nums1[nums1.length/2];
        }
        int[] merge = new int[nums1.length + nums2.length];

        int index1 = 0, index2 = 0;
        int index = 0;
        while (index1 < nums1.length && index2 < nums2.length) {
            if (nums1[index1] <= nums2[index2]){
                merge[index] = nums1[index1];
                index1++;
            } else {
                merge[index] = nums2[index2];
                index2++;
            }
            index++;
        }

        while (index1 < nums1.length)
            merge[index++] = nums1[index1++];

        while (index2 < nums2.length)
            merge[index++] = nums2[index2++];

        if (merge.length % 2 ==0)
            return 1.0*(merge[merge.length/2-1]+merge[merge.length/2])/2;
        else
            return merge[merge.length/2];
    }




}
