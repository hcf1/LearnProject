class PowerTest {
    public static void main(String[] args) {
        Power power = new Power();
        double result = power.power2(2, 3);
        if (power.ifError == false) {
            System.out.println(result);
        } else {
            System.out.println("输入数据有误");
        }
        System.out.println(power.power3(2,10));
    }
}