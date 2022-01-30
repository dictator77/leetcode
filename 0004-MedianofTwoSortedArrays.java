//method1:Binary Search
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int N1 = nums1.length;
        int N2 = nums2.length;
        if(N1 > N2){
            return findMedianSortedArrays(nums2, nums1);
        }

        int left = 0;
        int right = N1;
        while(left <= right){
            int positionx = left + (right - left) / 2;
            int positiony = (N1 + N2 + 1)/2 - positionx;
            int L1 = (positionx == 0) ? Integer.MIN_VALUE : nums1[positionx - 1];
            int L2 = (positiony == 0) ? Integer.MIN_VALUE : nums2[positiony - 1];
            int R1 = (positionx == N1) ? Integer.MAX_VALUE : nums1[positionx];
            int R2 = (positiony == N2) ? Integer.MAX_VALUE : nums2[positiony];
            if(L1 <= R2 && L2 <= R1){
                if((N1 + N2) % 2 == 0){
                    return (double)(Math.max(L1,L2)+Math.min(R1,R2))/2;
                }else{
                    return (double)Math.max(L1,L2);
                }
            }else if(L1 > R2){
                right = positionx - 1;
            }else{
                left = positionx + 1;
            }
        }
        throw new IllegalArgumentException();
    }
}

//method2:Count
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int totalcount = nums1.length + nums2.length;
        boolean flag = true;
        if(totalcount % 2 == 1){
            flag = false;
        }
        int index = totalcount / 2;
        int l1 = 0;
        int l2 = 0;
        double result = 0;
        if(nums1.length == 0){
            result += nums2[index];
            if(flag){
                result += nums2[index-1];
                result /= 2;
            }
            return result;
        }
        if(nums2.length == 0){
            result += nums1[index];
            if(flag){
                result += nums1[index-1];
                result /= 2;
            }
            return result;
        }
        for(int i = 0; i < index; i++){
            if(l1 == nums1.length){
                l2++;
            }else if(l2 == nums2.length){
                l1++;
            }else if(l1 < nums1.length && nums1[l1] <= nums2[l2]){
                l1++;
            }else if(l2 < nums2.length && nums1[l1] >= nums2[l2]){
                l2++;
            }
        }

        if(l1 == nums1.length){
            result += nums2[l2];
            if(flag){
                if(l2 == 0){
                    result += nums1[l1 - 1];
                }else{
                    result += Math.max(nums1[l1 - 1], nums2[l2 - 1]);
                }
                result /= 2;
            }
        }else if(l2 == nums2.length){
            result += nums1[l1];
            if(flag){
                if(l1 == 0){
                    result += nums2[l2 - 1];
                }else{
                    result += Math.max(nums1[l1 - 1], nums2[l2 - 1]);
                }
                result /= 2;
            }
        }else{
            if(nums1[l1] < nums2[l2]){
                result += nums1[l1];
                if(flag){
                    if(l1 - 1 >= 0 && l2 -1 >= 0){
                        result += Math.max(nums1[l1-1],nums2[l2-1]);
                    }else if(l1 - 1 < 0){
                        result += nums2[l2-1];
                    }else{
                        result += nums1[l1-1];
                    }
                    result /= 2;
                }
            }else{
                result += nums2[l2];
                if(flag){
                    if(l1 - 1 >= 0 && l2 -1 >= 0){
                        result += Math.max(nums1[l1-1],nums2[l2-1]);
                    }else if(l1 - 1 < 0){
                        result += nums2[l2-1];
                    }else{
                        result += nums1[l1-1];
                    }
                    result /= 2;
                }
            }
        }
        return result;
    }
}