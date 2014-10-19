package AI;

import java.io.IOException;

import Kernel.AI;
import Kernel.Player;

/**
 * 测试AI 0号
 * 
 * @author Lane
 * 
 */
public class AI0 extends AI {
	/**
	 * 默认加载函数
	 * 
	 * @param player
	 * @throws IOException
	 */
	public void load(Player player) throws IOException {
		boolean choose = false;
		for (int i = 0; i < player.getHandNum(); i++) {
			if (player.setChoice(player.getHands()[i], 1)) {
				choose = true;
				break;
			}
			if (player.setChoice(player.getHands()[i], 2)) {
				choose = true;
				break;
			}
		}
		if (!choose)
			player.setChoice(player.getHands()[0], 3);
	}
}
