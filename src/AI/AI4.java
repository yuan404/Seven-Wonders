package AI;

import java.io.IOException;

import Kernel.AI;
import Kernel.Player;

public class AI4 extends AI {
	public void load(Player player) throws IOException {
		player.setChoice(player.getHands()[0], 3);
	}
}
