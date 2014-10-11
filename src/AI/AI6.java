package AI;

import Kernel.AI;
import Kernel.Player;

public class AI6 extends AI {
	public void load(Player player) {
		player.setChoose(player.getHands()[0], 3);
	}
}
