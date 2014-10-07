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
		for (int i = 0; i < player.getHandNum(); i++)
			if (!player.setChoose(player.getHands()[i], 1))
				if (!player.setChoose(player.getHands()[i], 2))
					player.setChoose(player.getHands()[i], 3);
	}
}
