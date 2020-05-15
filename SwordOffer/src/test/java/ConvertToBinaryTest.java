class ConvertToBinaryTest {
    public static void main(String[] args) {
        ConvertToBinary convertToBinary = new ConvertToBinary();
        System.out.println(convertToBinary.convert(9));
        for (int n : convertToBinary.getBinary()) {
            System.out.print(n+"\t");
        }
        System.out.println("");
        CountOneInBinary count = new CountOneInBinary();
        System.out.println(count.count1(9));
        System.out.println(count.count2(9));
        System.out.println(count.count3(9));
    }
}