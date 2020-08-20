/**
 * 给一个字符数组，里面有很多单词，让单词首字母大写、每个单词空一格子输出
 */
public class A {
    public static void main(String[] args) {
        //Scanner in = new Scanner(System.in);
        //int a = in.nextInt();
        //System.out.println(a);
        char c = 'a';//97
        char C = 'A';//65
        char z = 'z';//122
        char Z = 'Z';//90
//        System.out.println((int) Z);
        System.out.println(Upper(new char[]{' ', ' ', 'c', 'c', ' ', ' ', 'c', ' ', 'a', ' ', ' ', ' '}));

    }

    static char[] Upper(char[] list) {
        boolean hasSpace = false;
        if (list[0] != ' ') {
            list[0] = (char) (list[0] - 32);
        }
        for (int i = 0; i < list.length; i++) {
            if (list[i] == ' ') {
                hasSpace = true;
                continue;
            }
            if (list[i] >= 97 && list[i] <= 122 && hasSpace) {
                list[i] = (char) (list[i] - 32);//换成大写
                hasSpace = false;
            }
        }
        /*去除多余空格*/
        boolean firstSpace = false;
        int index = -1;
        for (int i = 0; i < list.length; i++) {
            if (list[i] != ' ') {
                index++;
                list[index] = list[i];
                list[i] = ' ';
            } else {
                if (index >= 0 && list[index] != ' ') {//允许添加一个空格
                    firstSpace = true;
                }
                if (firstSpace) {//添加空格
                    index++;
                    list[index] = list[i];
                    list[i] = ' ';
                    firstSpace = false;
                }
            }
        }

        return list;
    }
}
