package Kernel;

/**
 * 玩家类
 * 
 * @author Lane
 *
 */
public class Player {
	/**
	 * 序号
	 */
	private int index;

	/**
	 * 构造函数
	 * 
	 * @param id
	 */
	public Player(int id) {
		index = id;
	}

	/**
	 * 获取序号
	 * 
	 * @return
	 */
	public int getIndex() {
		return index;
	}
}
