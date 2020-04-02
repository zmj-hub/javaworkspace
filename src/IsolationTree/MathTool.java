package IsolationTree;

public class MathTool {

    private MathTool() {
    }

    public static double EulerConstant = 0.57721566490153286060651209;


    /**
     * 计算以二为底的对数
     */
    public static double log2(double value) {
        return Math.log(value) / Math.log(2);
    }
}