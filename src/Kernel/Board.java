package Kernel;

import javafx.scene.image.ImageView;

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

	/**
	 * 奇迹板翻面
	 */
	protected int side = 0;

	/**
	 * 构造函数
	 * 
	 * @param name
	 * @param side
	 */
	public Board(String name, int side) {
		this.name = name;
		this.side = side;
	}

	/**
	 * 图
	 */
	public ImageView iv = new ImageView();
	/**
	 * 费用及收益效果
	 */
	protected Card[] cards = new Card[5];
	/**
	 * 可建造的最大层数
	 */
	protected int max = 3;
	/**
	 * 已建造层数
	 */
	protected int age = 0;
}
