package Kernel;

/**
 * 
 * @author Lane 人工智能
 */
public class AI {
	public AI() {

	}

	public static void Level1(Player player) {
		Manager m = new Manager();
		for (int i = 0; i < m.getKenelManager().hand[player.index].cardNum; i++) {
			if (MathGame.ifBuildStage(player)) {
				player.turn.setChoose(
						m.getKenelManager().hand[player.index].card[i], 2);
				return;
			}
			if (MathGame.ifBuild(player,
					m.getKenelManager().hand[player.index].card[i])) {
				player.turn.setChoose(
						m.getKenelManager().hand[player.index].card[i], 1);
				return;
			}
		}
		player.turn
				.setChoose(m.getKenelManager().hand[player.index].card[0], 0);
	}
}
