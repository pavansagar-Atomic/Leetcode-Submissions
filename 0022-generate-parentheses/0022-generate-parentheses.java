class Solution {
    public void generate(String s,int open ,int close,int n,List<String>lst){
        if(open==n && close==n){
            lst.add(s);
            return;
        }
        if(open<n){
            generate(s+"(",open+1,close,n,lst);
        }
        if(close<open){
            generate(s+")",open,close+1,n,lst);
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String>ans=new ArrayList<>();
        generate("",0,0,n,ans);
        return ans;
        
    }
}