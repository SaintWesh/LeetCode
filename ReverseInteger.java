public class ReverseInteger {
    public static int reverse(int x) {
        if (x == Integer.MIN_VALUE) return 0;
        int sign = x < 0 ? -1 : 1;
        x = sign * x;
        int ret = 0, lastRet = -1, remainder = 0;
        while (x != 0) {
            remainder = x % 10;
            lastRet = ret;
            ret = ret * 10 + remainder;
            if ((ret - remainder) / 10 != lastRet) return 0;
            x /= 10;
        }
        return ret * sign;
    }

    public static void main(String[] args) {
        System.out.println(reverse(123));
        System.out.println(reverse(-123456));
        System.out.println(reverse(1534236469));
    }
}