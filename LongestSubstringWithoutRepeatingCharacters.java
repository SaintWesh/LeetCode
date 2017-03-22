public class LongestSubstringWithoutRepeatingCharacters {
    public static int lengthOfLongestSubstring(String s) {
        // keep track of the index of the last occured character
        int[] lastIndexOf = new int[256];
        for (int i = 0; i < 255; i++) lastIndexOf[i] = -1;
        // keep track of the left bound of the current longest substring
        int left = 0;
        int maxLen = 0, curLen = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (lastIndexOf[c] >= left) left = lastIndexOf[c] + 1;
            curLen = i - left + 1;
            if (maxLen < curLen) maxLen = curLen;
            lastIndexOf[c] = i;
        }
        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("hello world"));
        System.out.println(lengthOfLongestSubstring("aaaaa"));
    }
}