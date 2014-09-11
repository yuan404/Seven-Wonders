package Kernel;

/**
 * 
 * @author Lane 数学逻辑函数
 * 
 */
public class MathGame {
	public MathGame() {

	}

	public static double getCircleX(double angle, double X, double Y,
			double radius) {
		double x = X + radius * Math.sin(angle * Math.PI / 180);
		return x;
	}

	public static double getCircleY(double angle, double X, double Y,
			double radius) {
		double y = Y - radius * Math.cos(angle * Math.PI / 180);
		return y;
	}
}
