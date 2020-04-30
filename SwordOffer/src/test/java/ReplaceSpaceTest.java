public class ReplaceSpaceTest {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("   ");
        ReplaceSpace.replaceSpace(sb);
        System.out.println(sb.toString());
    }
}
