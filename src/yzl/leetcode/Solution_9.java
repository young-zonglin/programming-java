package yzl.leetcode;

/**
 * Determine if a number is a palindrome.
 */
public class Solution_9 {
    public static void main(String[] args) {
        int x = 121;
        System.out.println(new Solution_9_three().isPalindrome(x));
    }
}

class Solution_9_one {
    public boolean isPalindrome(int x) {
        String forward = Integer.toString(x);
        String backward = reverse(forward);
        return forward.equals(backward);
    }

    private String reverse(String n) {
        char[] chars = n.toCharArray();
        int i = 0, j = chars.length-1;
        while (i < j) {
            swap(chars, i++, j--);
        }
        return new String(chars);
    }

    private void swap(char[] arr, int i, int j) {
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}

class Solution_9_two {
    public boolean isPalindrome(int x) {
        String forward = String.valueOf(x);
        String backward = new StringBuffer(forward).reverse().toString();
        return forward.equals(backward);
    }
}

class Solution_9_three {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        int count = 0;
        int place[] = new int[20];
        int tmp;
        while (x != 0) {
            tmp = x % 10;
            x /= 10;
            place[count++] = tmp;
        }
        int i = 0, j = count-1;
        while (i < j) {
            if (place[i] != place[j]) return false;
            i++;
            j--;
        }
        return true;
    }
}
