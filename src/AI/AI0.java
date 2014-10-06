package AI;

import Kernel.Player;
import M.Manager;

/**
 * 测试AI 0号
 * 
 * @author Lane
 * 
 */
public class AI0 {
	/**
	 * 默认加载函数
	 * 
	 * @param player
	 */
	public void load(Player player) {
		player.setChoose(player.getHands()[0], 1);
	}
}
