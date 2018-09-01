package yzl.leetcode;

import java.util.*;

/**
 * Find the closest palindrome of a certain number.
 */
public class Solution_564 {
    public static void main(String[] args) {
        String n = "123892133";
        System.out.println(new Solution_564_three().nearestPalindromic(n));
    }
}

/**
 * Exhaustion solution.
 * It will time out.
 */
class Solution_564_one {
    public String nearestPalindromic(String n) {
        Long n_num = Long.valueOf(n);
        Long bigger = bigger(n_num);
        Long smaller = smaller(n_num);
        Long closest = n_num-smaller <= bigger-n_num ? smaller : bigger;
        return closest.toString();
    }

    private Long bigger(Long n) {
        if (isPalindromic(n)) n++;
        while (!isPalindromic(n)) {
            n++;
        }
        return n;
    }

    private Long smaller(Long n) {
        if (n>0 && isPalindromic(n)) n--;
        while (!isPalindromic(n)) {
            n--;
        }
        return n;
    }

    private boolean isPalindromic(Long n) {
        List<Long> front_end = new Solution_564_two().partition(n.toString());
        return front_end.get(0).equals(front_end.get(1));
    }
}

/**
 * Wrong solution.
 * But don't want to delete it.
 */
class Solution_564_two {
    public String nearestPalindromic(String n) {
        Long n_num = Long.valueOf(n);
        Long bigger = bigger(n);
        System.out.println("bigger: "+bigger);
        Long smaller = smaller(n);
        System.out.println("smaller: "+smaller);
        Long closest = n_num-smaller <= bigger-n_num ? smaller : bigger;
        return closest.toString();
    }

    private Long bigger(String n) {
        int len = n.length();
        if (len <= 0) {
            return 0L;
        } else if (isAllNine(n)) {
            return Long.parseLong(n)+2;
        } else {
            List<Long> front_end = partition(n);
            Long front = front_end.get(0);
            Long end = front_end.get(1);
            if (front <= end) {
                front += 1;
            }
            boolean isLenEven = len % 2 == 0;
            return Long.valueOf(combine(front, isLenEven));
        }
    }

    private boolean isAllNine(String n) {
        char[] chars = n.toCharArray();
        boolean isAllNine = true;
        for (char tmp : chars) {
            if (tmp != '9') {
                isAllNine = false;
                break;
            }
        }
        return isAllNine;
    }

    private Long smaller(String n) {
        String matchOneZeroStr = "10+";
        String matchOneZeroOneStr = "10*1";
        int len = n.length();
        long n_num = Long.parseLong(n);
        if (len <= 0 || n_num == 0) {
            return 0L;
        } else if (n.matches(matchOneZeroStr)) {
            return n_num-1;
        } else if (n.matches(matchOneZeroOneStr)) {
            return n_num-2;
        } else {
            List<Long> front_end = partition(n);
            Long front = front_end.get(0);
            Long end = front_end.get(1);
            if (front >= end) {
                front -= 1;
            }
            boolean isLenEven = len % 2 == 0;
            return Long.valueOf(combine(front, isLenEven));
        }
    }

    public List<Long> partition(String n) {
        int len = n.length();
        List<Long> ret = new ArrayList<>();
        Long front, end;
        if (len % 2 == 0) {
            front = Long.valueOf(n.substring(0, len/2));
            end = Long.valueOf(
                    new StringBuffer(n.substring(len/2, len)).reverse().toString());
        } else {
            front = Long.valueOf(n.substring(0, len/2+1));
            end = Long.valueOf(
                    new StringBuffer(n.substring(len/2, len)).reverse().toString());
        }
        ret.add(front);
        ret.add(end);
        return ret;
    }

    private String combine(Long front, boolean isLenEven) {
        String frontStr = front.toString();
        String end = new StringBuffer(frontStr).reverse().toString();
        if (isLenEven) {
            return frontStr+end;
        } else {
            return frontStr.substring(0, frontStr.length()-1)+end;
        }
    }
}

/**
 * Very easy solution.
 */
class Solution_564_three {
    public String nearestPalindromic(String n) {
        long n_num = Long.parseLong(n);
        List<Long> res = getPossiblePalindromic(n);
        Long min = 0L;
        long minDist = Long.MAX_VALUE, dist;
        res.sort(Comparator.naturalOrder());
        for (long possible : res) {
            dist = Math.abs(possible-n_num);
            if (dist < minDist) {
                minDist = dist;
                min = possible;
            }
        }
        return min.toString();
    }

    private List<Long> getPossiblePalindromic(String n) {
        List<Long> res = new ArrayList<>();
        Long n_num = Long.valueOf(n);
        int[] try_ = new int[]{-2, -1, +2};
        for (int todo : try_) {
            if (isPalindromic(n_num+todo)) {
                res.add(n_num+todo);
            }
        }
        try_ = isPalindromic(n_num) ? new int[]{-1, +1} : new int[]{-1, 0, +1};
        Long front = partition(n).get(0);
        for (int todo : try_) {
            if (front+todo < 0) continue;
            boolean isLenEven = n.length()%2 == 0;
            res.add(Long.valueOf(combine(front+todo, isLenEven)));
        }
        return res;
    }

    private List<Long> partition(String n) {
        int len = n.length();
        List<Long> ret = new ArrayList<>();
        Long front;
        if (len % 2 == 0) {
            front = Long.valueOf(n.substring(0, len/2));
        } else {
            front = Long.valueOf(n.substring(0, len/2+1));
        }
        Long end = Long.valueOf(
                new StringBuffer(n.substring(len/2, len)).reverse().toString());
        ret.add(front);
        ret.add(end);
        return ret;
    }

    private String combine(Long front, boolean isLenEven) {
        String frontStr = front.toString();
        String end = new StringBuffer(frontStr).reverse().toString();
        if (isLenEven) {
            return frontStr+end;
        } else {
            return frontStr.substring(0, frontStr.length()-1)+end;
        }
    }

    private boolean isPalindromic(Long n) {
        if (n < 0) return false;
        List<Long> front_end = partition(n.toString());
        return front_end.get(0).equals(front_end.get(1));
    }
}
