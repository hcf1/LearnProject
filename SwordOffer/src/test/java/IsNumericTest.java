
class IsNumericTest {
    public static void main(String[] args) {
        IsNumeric numeric = new IsNumeric();
        System.out.println(numeric.isNumeric(new char[]{'-', '1', 'E', '-', '1', '6'}));
    }
}