package Kernel;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Random;

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
	 * @throws InterruptedException
	 * @throws IOException
	 */
	public void testAiGame() throws ClassNotFoundException,
			InstantiationException, IllegalAccessException,
			InterruptedException, IOException {
		File file = new File("src/AI");
		String[] filelist = file.list();
		String[] str = new String[filelist.length];
		Class<?>[] ai = new Class[filelist.length];
		for (int i = 0; i < filelist.length; i++) {
			str[i] = filelist[i].substring(0, filelist[i].length() - 5);
			ai[i] = Class.forName("AI." + str[i]);
		}
		String[] named = str.clone();
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
		String t = df.format(System.currentTimeMillis());
		int[] score = new int[filelist.length];
		int[] barScore = new int[filelist.length];
		File fileT = new File("D://workspace//" + t);
		fileT.mkdirs();
		FileWriter fw = new FileWriter("D://workspace/" + t + "/" + t + ".txt");
		for (int i1 = 0; i1 < 5; i1++) {
			Random random = new Random();
			for (int m = 0; m < filelist.length; m++) {
				int a = random.nextInt(filelist.length) % filelist.length;
				int b = random.nextInt(filelist.length) % filelist.length;
				Class<?> tempAi = ai[a];
				String tempStr = str[a];
				ai[a] = ai[b];
				str[a] = str[b];
				ai[b] = tempAi;
				str[b] = tempStr;
			}
			for (int j = 0; j < Math.ceil((double) filelist.length / 5); j++) {
				String[] name = new String[5];
				for (int i = 0; i < 5; i++) {
					name[i] = str[(i + j * 5) % filelist.length];
				}
				String time = df.format(System.currentTimeMillis());
				try {
					km = new KernelManager();
					km.initAI(ai[(0 + j * 5) % filelist.length], ai[(1 + j * 5)
							% filelist.length], ai[(2 + j * 5)
							% filelist.length], ai[(3 + j * 5)
							% filelist.length], ai[(4 + j * 5)
							% filelist.length], name);
					int[] temp = km.init(5, time, t, j);
					Thread.sleep(1);
					for (int m = 0; m < 5 && m + j * 5 < filelist.length; m++) {
						int n;
						for (n = 0; n < filelist.length; n++) {
							if (name[m] == named[n])
								break;
						}
						score[n] += temp[m];
						barScore[n] += getRank(temp, temp[m]);
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			Thread.sleep(2);
		}
		fw.write("Name\tTotalScores\tRankScores\r\n");
		for (int i = 0; i < filelist.length; i++)
			fw.write(named[i] + "\t" + score[i] + "\t" + barScore[i] + "\r\n");
		fw.flush();
		fw.close();
	}

	public int getRank(int[] num, int i) {
		int a = 0;
		for (int m = 0; m < num.length; m++) {
			if (num[m] < i)
				a++;
		}
		return a;
	}
}
