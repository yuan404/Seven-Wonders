package AI;

import java.io.IOException;

import Kernel.AI;
import Kernel.Player;

public class AI1 extends AI {
	public void load(Player player) throws IOException {
		player.payFeeOfBuild(player.getHands()[0]);
		// player.setChoice(player.getHands()[0], 3);
	}
}
