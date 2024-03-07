class Solution {
    public String addBinary(String a, String b) {
        int carry = 0;
        int aP = a.length() - 1;
        int bP = b.length() - 1;
        StringBuilder sb = new StringBuilder();

        while (aP >= 0 || bP >= 0) {
            int bits = carry;
            if (aP >= 0)
                bits += a.charAt(aP--) == '1' ? 1 : 0;
            if (bP >= 0)
                bits += b.charAt(bP--) == '1' ? 1 : 0;  
            sb.append(bits % 2);
            carry = bits / 2;
        }

        if (carry > 0)
            sb.append(1);

        return sb.reverse().toString();
    }
}
