package com.Microsoft.二分查找;



/**
 * @author 熊立伟
 * @version 1.0
 * @date 2019/12/7 18:28
 */
public class main {
    public static void main(String[] args) {

        System.out.println(search(new int[]{1,2},2));
    }

    public  static int search(int[] nums, int target) {
        StringBuffer s=new StringBuffer();
        for (int tmp:nums
             ) {
            s.append(tmp);
        }
        return s.indexOf(Integer.toString(target));
        if(nums.length==1&&nums[0]!=target)return -1;
        int p= nums.length/2+1;
        int tmp=nums.length+1;
        while (nums[p-1]!=target){
            if(nums[p-1]>target){
                if(p==1)return -1;
                tmp=p;
                p=tmp/2;
            }else {
                if(tmp-p==1)return -1;
                p=(tmp-p)/2+p;
            }
        }
        return p-1;
    }
}
