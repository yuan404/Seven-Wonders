package Kernel;

public class Card extends BuildingItem {
	/**
	 * 免费建造列表
	 */
	public String[] freeBuild = new String[2];
	/**
	 * 添加至免费列表
	 * @param name
	 */
	public void addFree(String name) {
		if (freeBuild[0] == null)
			freeBuild[0] = new String(name);
		else
			freeBuild[1] = new String(name);
	}
}
