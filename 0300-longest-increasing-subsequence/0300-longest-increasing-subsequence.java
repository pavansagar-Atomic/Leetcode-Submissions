class Solution {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        ArrayList<Integer>temp=new ArrayList<>();
        temp.add(nums[0]);
        for(int i=1;i<n;i++){
            if(nums[i]>temp.get(temp.size()-1)){
                temp.add(nums[i]);
            }else{
                int low=0;
                int high=temp.size()-1;
                while(low<=high){
                    int mid=low+(high-low)/2;
                    if(temp.get(mid)>=nums[i]){
                        high=mid-1;
                    }else{
                        low=mid+1;
                    }
                }
                temp.set(low,nums[i]);
            }
        }   
        return temp.size();     
    }
}