package yzl.leetcode;

/**
 * Valid palindrome string.
 */
public class Solution_125_验证回文串 {
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(new Solution_125_验证回文串().isPalindrome(s));
    }

    public boolean isPalindrome(String s) {
        String forward = s.toLowerCase().replaceAll("[^a-z0-9]", "");
        String backward = new StringBuilder(forward).reverse().toString();
        return forward.equals(backward);
    }
}
