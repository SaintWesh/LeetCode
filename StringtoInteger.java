public class StringtoInteger {
    public static int myAtoi(String str) {
        int len = str == null ? 0 : str.length();
        if (len == 0) return 0;
        int sign = 1, i = 0;
        char c = ' ';
        Long ret = 0l;
        // skip the blank characters
        while (i < len && Character.isWhitespace(c = str.charAt(i)))
            i++;
        sign = c == '-' ? -1 : 1;
        i = Character.isDigit(c) ? i : i + 1;
        // skip the blank characters between the sign and the digits
        while (i < len && Character.isWhitespace(c = str.charAt(i)))
            i++;
        while (i < len && Character.isDigit(c = str.charAt(i))) {
            ret  = ret * 10 + c - '0';
            i++;
        }
        ret *= sign;
        if (ret > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        else if (ret < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        else return new Long(ret).intValue();
    }
    

    public static void main(String[] args) {
        System.out.println(myAtoi("    + 123   "));
        System.out.println(myAtoi(" - 12300 "));
    }


}