class Solution {
    public long countCommas(long n){
        long start=1000;
        long commas=1;
        long ans=0;
        while(start<=n){
            long end=start*1000-1;
            long last=Math.min(n,end);
            long count=last-start+1;
            ans+=count*commas;
            start*=1000;
            commas++;
        }
        return ans;
    }
    public long countCommasInRange(long l,long r){
        return countCommas(r)-countCommas(l-1);
    }
}