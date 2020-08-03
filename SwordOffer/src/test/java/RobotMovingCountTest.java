
class RobotMovingCountTest {
    public static void main(String[] args) {
        RobotMovingCount robotMovingCount = new RobotMovingCount(3, 3, 3);
        System.out.println(robotMovingCount.movingCount(0, 0));
        /**
         * 正式批
         * */
        RobotMovingCount1 robotMovingCount1 = new RobotMovingCount1();
        System.out.println(robotMovingCount1.findNum(new boolean[3][3],3));
    }
}