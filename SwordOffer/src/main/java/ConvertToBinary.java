import java.util.ArrayDeque;

/**
 * 将一个整数转换成二进制，计算二进制中1个个数（考虑符号位,原码）
 * 思路：直接按照十进制转换成二进制的公式进行转换
 *
 * @author hasee
 */
public class ConvertToBinary {
    private ArrayDeque<Integer> binary = new ArrayDeque<>();

    public ArrayDeque<Integer> getBinary() {
        return binary;
    }

    int convert(int number) {
        int counter = 0;
        int p = number;
        while (number != 0) {
            int quotient = number / 2;
            int remainder = number % 2;
            if (remainder == 1) {
                counter++;
            }
            binary.push(remainder);
            number = quotient;
        }
//        添加符号位
        if (p < 0) {
            counter++;
            binary.push(1);
        }
        if (p > 0) {
            binary.push(0);
        }
        return counter;
    }
}

/**
 * 输入一个整数，输出该数二进制表示中1的个数。例如，把9表示成二进制是1001，有两位是1.因此，如果输入9，则该函数输出2。
 * 思路：位运算时自动将输入的数转换成二进制（考虑符号位）
 * 注意：二进制移位规则：正数向右移左补零，向左移右补零；负数右移左补1，左移右补0；
 */
class CountOneInBinary {
    /**
     * 将数字向右移位，每次将数的最低位和1进行&运算，如果结果为1则表示其最低位为1
     */
    int count1(int number) {
//        此算法只能处理输入的数是正数，如果是负数会造成number无限向右移动，造成死循环
        if (number < 0) {
            return 0;
        }
        int counter = 0;
        while (number != 0) {
            if ((number & 1) == 1) {
                counter++;
            }
            number = number >> 1;
        }
        return counter;
    }

    /**
     * 数字不动，将1向左移位
     */
    int count2(int number) {
        int counter= 0;
        int flag = 1;
//      向左移动32位，直到1变为全0
        while (flag != 0) {
            if ((number & flag) >= 1) {
                counter++;
            }
            flag = flag << 1;
        }
        return counter;
    }
/**
 * 把一个整数减一，再和原来的整数做&运算，会将整数最右边的1变成0
 * */
    int count3(int number) {
        int counter = 0;
        while (number != 0) {
            counter++;
            number = (number - 1) & number;
        }
        return counter;
    }
}
