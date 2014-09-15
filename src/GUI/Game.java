package GUI;

import Kernel.Board;
import Kernel.Manager;
import Kernel.Player;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Game {

	public static Text[] blueScore = new Text[7];
	public static Text[] redScore = new Text[7];

	public Game() {

	}

	public static void setText(Player[] player) {
		Manager m = new Manager();
		for (int i = 0; i < m.getKenelManager().playerNum; i++) {
			blueScore[i] = new Text();
			redScore[i] = new Text();
			if (player[i].GblueScore < 10)
				blueScore[i].setFont(new Font(30));
			else
				blueScore[i].setFont(new Font(20));
			if (player[i].Gforce < 10)
				redScore[i].setFont(new Font(30));
			else
				redScore[i].setFont(new Font(20));
			blueScore[i].setFill(Color.WHITE);
			redScore[i].setFill(Color.WHITE);
			blueScore[i].setText(String.valueOf(player[i].GblueScore));
			redScore[i].setText(String.valueOf(player[i].Gforce));
		}
	}
	
	public static void AddResource(Player player){
		
	}
}
