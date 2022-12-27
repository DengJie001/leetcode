package year2022.month12.day27;

import java.util.Scanner;

/**
 * 231.2的幂
 * https://leetcode.cn/problems/power-of-two/?envType=study-plan&id=suan-fa-ru-men&plan=algorithms&plan_progress=yu2b416
 */
public class PowerOfTwo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println(new PowerOfTwo().isPowerOfTwo(scanner.nextInt()));
        }
    }

    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        if (n == 1) {
            return true;
        }
        String binary = Integer.toBinaryString(n);
        return !binary.replaceFirst("1", "0").contains("1");
    }
}
