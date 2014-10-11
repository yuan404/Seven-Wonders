package Kernel;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

import GUI.GUIManager;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * 总接口调入口
 * 
 * @author Lane
 * 
 */
public class Manager extends Application {
	/**
	 * 界面管理者
	 */
	private static GUIManager gm = new GUIManager();
	/**
	 * 游戏管理者
	 */
	private static KernelManager km;

	public static void main(String[] args) {
		launch(args);
	}

	public void start(Stage stage) {
		gm.setStage(stage);
		stage.show();
		gm.setBackGround();
	}

	/**
	 * @return GUIManager
	 */
	public GUIManager getGUIManager() {
		return gm;
	}

	/**
	 * @return KernelManager
	 */
	public KernelManager getKernelManager() {
		return km;
	}

	/**
	 * 游戏开始
	 * 
	 * @throws ClassNotFoundException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 */
	public void testAiGame() throws ClassNotFoundException,
			InstantiationException, IllegalAccessException {
		File file = new File("src/AI");
		String[] filelist = file.list();
		String[] str = new String[filelist.length];
		Class<?>[] ai = new Class[filelist.length];
		for (int i = 0; i < filelist.length; i++) {
			str[i] = filelist[i].substring(0, filelist[i].length() - 5);
			ai[i] = Class.forName("AI." + str[i]);
		}
		for (int j = 0; j < Math.ceil((double) filelist.length / 5); j++) {

			String[] name = new String[5];
			for (int i = 0; i < 5; i++) {
				name[i] = str[(i + j * 5) % filelist.length];
			}
			SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
			long intTime = System.currentTimeMillis();
			String time = df.format(intTime);
			for (int i1 = 0; i1 < 5; i1++) {
				if (System.currentTimeMillis() - intTime <= i1 * 1000) {
					i1--;
					continue;
				}
				try {
					km = new KernelManager();
					km.initAI(ai[(0 + j * 5) % filelist.length], ai[(1 + j * 5)
							% filelist.length], ai[(2 + j * 5)
							% filelist.length], ai[(3 + j * 5)
							% filelist.length], ai[(4 + j * 5)
							% filelist.length], name);
					km.init(5, time);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
