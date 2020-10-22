class longestPalindromicSubstring {
	// Approach 4: Expand Around Center
    // Time Complexity O(n^2)
    // Space Complexity O(1)
    public String longestPalindrome(String s) {
        if(s == null || s.length() <1)
            return "";
        
        int start = 0, end = 0;
        for(int i = 0; i <s.length(); i++){
        	System.out.println("\n\nROUND: " + i);
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            
            System.out.println("LEN: " + len);
            
            if(len > end - start) {
                start = i - (len - 1) /2;
                end = i + len/2;
                System.out.println("START: " + start);
                System.out.println("END: " + end);
            }
        }
        return s.substring(start, end+1); //NON INCLUSIVE ON END!
    }
    
    private int expandAroundCenter(String s, int left, int right){
        int L = left, R = right;
        while(L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)){
            L--;
            R++;
        }
        System.out.println("RIGHT AND LEFT: " + R + " " + L);
        return R - L - 1;
    }

	static public void main(String[] args)
	{
		longestPalindromicSubstring solution = new longestPalindromicSubstring();
	    System.out.println(solution.longestPalindrome("babad"));
	}
}

