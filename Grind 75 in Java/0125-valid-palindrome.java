class Solution {
    public boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;

        while (l < r) {
            while (l < r && !isValid(s, l)) l++;
            while (l < r && !isValid(s, r)) r--;

            char a = s.charAt(l);
            char b = s.charAt(r);
            if (Character.toLowerCase(a) != Character.toLowerCase(b))
                return false;
                
            l++;
            r--;
        }

        return true;
    }

    private boolean isValid(String s, int i) {
        char c = s.charAt(i);
        return Character.isLetterOrDigit(c);
    }
}
