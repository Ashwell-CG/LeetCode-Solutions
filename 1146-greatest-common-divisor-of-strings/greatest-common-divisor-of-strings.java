
class Solution {
    public String gcdOfStrings(String str1, String str2) {

        int n = Math.min(str1.length(), str2.length());

        for (int len = n; len >= 1; len--) {

            String s = str1.substring(0, len);

            String a = "";
            while (a.length() < str1.length()) {
                a += s;
            }

            String b = "";
            while (b.length() < str2.length()) {
                b += s;
            }

            if (a.equals(str1) && b.equals(str2)) {
                return s;
            }
        }
        return "";
    }
}
