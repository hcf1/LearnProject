public class ReplaceSpaceTest {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("   ");
        ReplaceSpace.replaceSpace(sb);
        System.out.println(sb.toString());
        /**
         * 正式批
         * */
        StringBuilder sb1 = new StringBuilder("   ");
        ReplaceSpace.ReplaceSpace1.replace(sb1);
        System.out.print(sb1);
    }
}
