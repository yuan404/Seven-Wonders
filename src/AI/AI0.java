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
		boolean choose = false;
		for (int i = 0; i < player.getHandNum(); i++) {
			if (player.setChoose(player.getHands()[i], 1)) {
				choose = true;
				break;
			}
			if (player.setChoose(player.getHands()[i], 2)) {
				choose = true;
				break;
			}
		}
		if (!choose)
			player.setChoose(player.getHands()[0], 3);
	}
}
