package com.example.alg.arraypkg;

public class MedianArray {

    /**
     * There are two sorted arrays nums1 and nums2 of size m and n respectively.

     Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

     Example 1:
     nums1 = [1, 3]
     nums2 = [2]

     The median is 2.0
     Example 2:
     nums1 = [1, 2]
     nums2 = [3, 4]

     The median is (2 + 3)/2 = 2.5
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        final int len1 = nums1.length;
        final int len2 = nums2.length;

        int position1=(len1+len2)/2;
        int position2=-1;
        if((len1+len2)%2==0){
            position1--;
            position2=position1+1;
        }

        int i1 =0;
        int i2 =0;
        int iS = 0;
        double median=0;
        int firstNum=0;
        while (i1<len1 || i2 <len2){

            int num;
            if(i1>=len1){
                num=nums2[i2];
                i2++;
            }else if(i2>=len2){
                num=nums1[i1];
                i1++;
            }else {

                final int n1 = nums1[i1];
                final int n2 = nums2[i2];

                if (n1 < n2) {
                    num=n1;
                    i1++;
                } else {
                    num=n2;
                    i2++;
                }
            }
            if(iS==position1){
                if(position2==-1) {
                    median = num;
                    break;
                }
                firstNum=num;
            }
            if(iS==position2){
                median=((double)(firstNum+num)/2);
            }
            iS++;

        }
        return median;
    }
}
