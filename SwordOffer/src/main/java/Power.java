/**
 * 实现函数double power(double base, int exponent)，求base的exponent次方。不得使用库函数，同时不需要考虑大数问题。
 *
 * @author hasee
 */
public class Power {
    public boolean ifError = false;

    /**
     * 直接将base重复乘exponent次,时间复杂度O(n)
     * 缺点：未考虑指数为0和负数
     */
    double power1(double base, int exponent) {
        double number = base;
        for (int i = 1; i < exponent; ++i) {
            number *= base;
        }
        return number;
    }

    /**
     * 考虑指数小于0的情况
     */
    double power2(double base, int exponent) {
//        使用异常的优点是可以自己定义异常类型，清晰明了，缺点是影响性能，某些语言还可能不支持
//        if (base == 0 && exponent == 0) {
//            throw new IllegalArgumentException("无法计算0的0次方");
//        }
//        使用全局变量判断是否出错。优点是依然可以使用函数返回值，不用函数返回值来判断出错。缺点是可能会忘记去检查全局变量，导致留下安全隐患
        if (base == 0 && exponent == 0) {
            ifError = true;
            return 0;
        }
//        如果使用函数返回值表示出错，那么返回0表示出错（很多系统API返回0表示调用出错），但是函数结果也可能返回0，导致函数返回结果不可用
        double number = base;
        if (exponent >= 1) {
            for (int i = 1; i < exponent; ++i) {
                number *= base;
            }
        }
        /*此处需要开根号,这种情况不考虑，因为指数是整数*/
        else if (exponent < 1 && exponent > 0) {

        }
        /*任意数的零次方都是1*/
        else if (exponent == 0) {
            return 1;
        } else if (exponent < 0) {
            if (base == 0) {
                ifError = true;
                return 0;
            }
            for (int i = 0; i >= exponent; i--) {
                number /= base;
            }
        }
        return number;
    }

    /**
     * 利用公式：偶数：a**n=a**(n/2)*a**(n/2)；奇数：a**n=a**((n-1)/2)*a**((n-1)/2)*a
     * 时间复杂度为O(logn)
     */
    double power3(double base, int exponent) {
        if (exponent == 0) {
            return 1;
        } else if (exponent == 1) {
            return base;
        }
//        利用移位进行除2，效率更高
        double result = power3(base, exponent >> 1);
        result *= result;
//        使用按位与判断是否为奇数，结果为1表示是奇数
        if ((exponent & 0b1) == 1) {
            result *= base;
        }
        return result;
    }
}
