package Kernel;

import GUI.Game;

/**
 * 
 * @author Lane
 * 
 */
public class Buy {

	public int Cwood = 0;
	public int Cstone = 0;
	public int Cbrick = 0;
	public int Core = 0;
	public int Cglass = 0;
	public int Ccloth = 0;
	public int Cpaper = 0;

	public int coin = 0;

	public Buy() {

	}

	public void clear() {
		Cwood = 0;
		Cstone = 0;
		Cbrick = 0;
		Core = 0;
		Cglass = 0;
		Ccloth = 0;
		Cpaper = 0;
		coin = 0;
	}

	public void update(Player player) {
		player.Bbrick += Cbrick;
		player.Bcloth += Ccloth;
		player.Bglass += Cglass;
		player.Bore += Core;
		player.Bwood += Cwood;
		player.Bstone += Cstone;
		player.Bpaper += Cpaper;
		player.Gcoin -= coin;
		Game.updateCoin(player);
	}
}
