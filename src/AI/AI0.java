package AI;

import Kernel.Player;

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
		if (!player.setChoose(player.getHands()[0], 1))
			if (!player.setChoose(player.getHands()[0], 2))
				player.setChoose(player.getHands()[0], 3);
	}
}
