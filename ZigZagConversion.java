public class ZigZagConversion {
    public static String convert(String s, int numRows) {
        if (numRows == 1) return s;
        int len = s.length(), step = numRows * 2 - 2;
        StringBuilder sb = new StringBuilder();
        // top line
        for (int i = 0; i < len; i += step) {
            sb.append(s.charAt(i));
        }
        // middle lines;
        for (int i = 1; i < numRows - 1; i++) {
            int interval = i * 2;
            for (int j = i; j < len; j += interval) {
                sb.append(s.charAt(j));
                interval = step - interval;
            }
        }
        // bottom line
        for (int i = numRows - 1; i < len; i += step) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
       System.out.println(convert("PAYPALISHIRING", 3)); 
       System.out.println(convert("ABC", 2)); 
    }
}