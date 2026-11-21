class Solution {
    public int removeDuplicates(int[] nums) {
        int k=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(k<2 || nums[i]!=nums[k-2]){
                nums[k]=nums[i];
                k++;
            }
        }
        return k;
    }
}