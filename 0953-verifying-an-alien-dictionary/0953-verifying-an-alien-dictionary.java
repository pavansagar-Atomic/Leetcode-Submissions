class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int []rank=new int[26];
        int n=order.length();
        for(int i=0;i<n;i++){
            rank[order.charAt(i)-'a']=i;
        }
        for(int i=0;i<words.length-1;i++){
            String a=words[i];
            String b=words[i+1];
        
            int len=Math.min(a.length(),b.length());
            boolean diff=false;
            for(int j=0;j<len;j++){
            if(a.charAt(j)!=b.charAt(j)){
                if(rank[a.charAt(j)-'a']>rank[b.charAt(j)-'a']){
                    return false;
                }
                    diff=true;
                    break;
                
            }
            }
            if(!diff && a.length()>b.length()){
                return false;
            }
        
        }
        return true;
        
    }

}