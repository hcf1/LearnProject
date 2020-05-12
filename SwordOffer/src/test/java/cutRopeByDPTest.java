class cutRopeByDPTest {
    public static void main(String[] args) {
        CutRopeByDynamicProgramming cut = new CutRopeByDynamicProgramming();
        System.out.println(cut.findMaxByDP(8));
        System.out.println(cut.findMaxByGA(8));
    }

}