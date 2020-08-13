package main;

/**
 * 判断两个矩形相交,考虑两个矩形重心的距离分别在x轴和y轴上都小于两个矩形宽或高之和的一半
 */

public class TwoRectangle {
    public static void main(String[] args) {
        System.out.println(hasCrossPoint(new float[][]{{0, 0}, {2, 3}}, new float[][]{{1, -1}, {3, 1}}));
    }

    static boolean hasCrossPoint(float[][] rectangle1, float[][] rectangle2) {
        float[] core1 = new float[2];
        float[] core2 = new float[2];
        core1[0] = (rectangle1[0][0] + rectangle1[1][0]) / 2;
        core1[1] = (rectangle1[0][1] + rectangle1[1][1]) / 2;
        core2[0] = (rectangle2[0][0] + rectangle2[1][0]) / 2;
        core2[1] = (rectangle2[0][1] + rectangle2[1][1]) / 2;
        float coreSpaceX = Math.abs(core1[0] - core2[0]);
        float coreSpaceY = Math.abs(core1[1] - core2[1]);
        return (rectangle1[1][0] - rectangle1[0][0] + rectangle2[1][0] - rectangle2[0][0]) / 2 > coreSpaceX &&
                (rectangle1[1][1] - rectangle1[0][1] + rectangle2[1][1] - rectangle2[0][1]) / 2 > coreSpaceY;
    }
}
