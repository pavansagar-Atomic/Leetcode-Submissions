class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int n=nums.length;
        HashMap<Integer,Integer>mp=new HashMap<>();
        for(int i=0;i<n;i++){
            if(mp.containsKey(nums[i])){
                int diff=i-mp.get(nums[i]);
                    if(diff<=k){
                        return true;
                    
                }
            }
            mp.put(nums[i],i);
        }
        return false;

        
    }
}