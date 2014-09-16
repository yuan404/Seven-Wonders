package Kernel;

import GUI.GUIManager;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * @author Lane 游戏管理者-游戏开始的入口
 * 
 *         Manager是整个游戏的入口 GUIManager管理界面 KernelManager管理游戏信息
 * 
 *         Block管理游戏的初始界面 GameBack管理游戏进行的默认背景 Game里是变化的动态界面
 * 
 *         Board是奇迹板类 BoardInfo是奇迹板信息 Card里是卡牌类 CardInfo是卡牌信息
 *         MathGame里是一些关键的游戏函数 Player是玩家信息-保存着所有玩家持有的资源
 */

public class Manager extends Application {

	//TODO 单击游戏时采用static，如果更改成局域网或许需要改成数组形式.
	private static GUIManager gm = new GUIManager();
	private static KernelManager km;

	public static void main(String[] args) {
		Application.launch(args);
	}

	public void start(Stage stage) throws Exception {
		gm.initScene();
		gm.initStage();
		stage = gm.getStage();
		stage.show();
	}

	public GUIManager getGUIManager() {
		return gm;
	}

	public KernelManager getKenelManager() {
		return km;
	}

	public void startGame() {
		km = new KernelManager(getGUIManager().PlayerNum.getSelectionModel()
				.getSelectedItem());
		km.initGame();
	}
}