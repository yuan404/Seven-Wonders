package Kernel;

import javafx.scene.image.ImageView;

/**
 * 卡牌类
 * 
 * @author Lane
 *
 */
public class Card extends BuildingItem {
	/**
	 * 免费建造列表
	 */
	private String[] freeBuild = new String[2];

	/**
	 * 添加至免费列表
	 * 
	 * @param name
	 */
	public void addFree(String name) {
		if (freeBuild[0] == null)
			freeBuild[0] = new String(name);
		else
			freeBuild[1] = new String(name);
	}

	/**
	 * 卡牌颜色
	 */
	private String color;
	/**
	 * 卡牌时代
	 */
	private int age;
	/**
	 * 卡牌开启人数
	 */
	private int num;

	/**
	 * 构造函数
	 * 
	 * @param name
	 * @param color
	 * @param age
	 * @param num
	 */
	public Card(String name, String color, int age, int num) {
		this.name = name;
		this.color = color;
		this.age = age;
		this.num = num;
	}

	/**
	 * 卡牌模型
	 */
	public ImageView iv = new ImageView();

	/**
	 * 由卡牌得到名称
	 */
	public String getName() {
		return name;
	}

	/**
	 * 由卡牌得到颜色
	 * 
	 * @return
	 */
	public String getColor() {
		return color;
	}

	/**
	 * 由卡牌得到时代数
	 * 
	 * @return
	 */
	public int getAge() {
		return age;
	}

	/**
	 * 由卡牌得到人数限制
	 * 
	 * @return
	 */
	public int getNum() {
		return num;
	}
}
