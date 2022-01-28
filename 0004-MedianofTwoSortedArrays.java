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