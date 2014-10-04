package Kernel;

/**
 * 奇迹板类
 * 
 * @author Lane
 *
 */
public class Board extends BuildingItem {
	/**
	 * 免费建造使用记录 如果0即为无资格 1即为未使用 2即为使用过
	 */
	protected int[] free = new int[3];

	/**
	 * 获取免费权限
	 * 
	 * @param age
	 * @return
	 */
	public boolean getFreeRight(int age) {
		int n = age - 1;
		if (free[n] == 1)
			return true;
		return false;
	}

	/**
	 * 设置免费权限
	 * 
	 * @param age
	 */
	public void setFreeRight(int age) {
		if (FreeBuild)
			for (int i = age - 1; i < 3; i++)
				free[i] = 1;
	}
}
