//给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。//
//示例 1://
//输入: 123
//输出: 321

// 示例 2:
//输入: -123
//输出: -321

//示例 3:
//输入: 120
//输出: 21
//注意:
//
//假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−2^31,  2^31 − 1]。
// 请根据这个假设，如果反转后整数溢出那么就返回 0

public class Q7 {

    public static int reverse(int x) {
        int res = 0;
        while (x != 0) {
            int pop = x % 10;
            // 判断是否溢出。res大于最大值/10的时候，在乘以10就会溢出。或者乘以10后加上大于7的数字就会溢出
            // 因为MAX_VALUE最后一位是7（2147483647）
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && pop > 7))
                return 0;
            if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && pop < -8))
                return 0;
            res = res * 10 + pop;
            x = x / 10;
        }
        return res;
    }

    public static void main(String[] args) {
//        System.out.println(Integer.MAX_VALUE);
        System.out.println(Q7.reverse(1534236469));
    }

}
