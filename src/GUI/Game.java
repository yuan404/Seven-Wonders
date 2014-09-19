package GUI;

import Kernel.Card;
import Kernel.Manager;
import Kernel.Player;
import javafx.animation.FadeTransition;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;

/**
 * 
 * @author Lane-游戏进行更新信息
 * 
 */
public class Game {

	public static Text[] blueScore = new Text[7];
	public static Text[] redScore = new Text[7];

	public static ImageView[][] bCoin = new ImageView[7][100];
	public static ImageView[][] sCoin = new ImageView[7][5];

	public Game() {

	}

	// TODO 更新蓝分和红战斗力
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

	// TODO 呈现增加的资源
	public static void AddResource(Player player, String str, int num) {
		Manager m = new Manager();
		if (str == "wood") {
			Image im = new Image("resource/image/rs4.png");
			ImageView iv = new ImageView(im);
			iv.setX(10 - 25 * (num + player.Gwood));
			iv.setY(70);
			iv.setScaleX(0.5);
			iv.setScaleY(0.5);
			m.getGUIManager().ap[player.index].getChildren().add(iv);
		} else if (str == "stone") {
			Image im = new Image("resource/image/rs3.png");
			ImageView iv = new ImageView(im);
			iv.setX(10 - 25 * (num + player.Gstone));
			iv.setY(70 + 25);
			iv.setScaleX(0.5);
			iv.setScaleY(0.5);
			m.getGUIManager().ap[player.index].getChildren().add(iv);
		} else if (str == "brick") {
			Image im = new Image("resource/image/rs1.png");
			ImageView iv = new ImageView(im);
			iv.setX(10 - 25 * (num + player.Gbrick));
			iv.setY(70 + 50);
			iv.setScaleX(0.5);
			iv.setScaleY(0.5);
			m.getGUIManager().ap[player.index].getChildren().add(iv);
		} else if (str == "ore") {
			Image im = new Image("resource/image/rs2.png");
			ImageView iv = new ImageView(im);
			iv.setX(10 - 25 * (num + player.Gore));
			iv.setY(70 + 75);
			iv.setScaleX(0.5);
			iv.setScaleY(0.5);
			m.getGUIManager().ap[player.index].getChildren().add(iv);
		} else if (str == "glass") {
			Image im = new Image("resource/image/rs6.png");
			ImageView iv = new ImageView(im);
			iv.setX(10 - 25 * (num + player.Gglass));
			iv.setY(70 + 100);
			iv.setScaleX(0.5);
			iv.setScaleY(0.5);
			m.getGUIManager().ap[player.index].getChildren().add(iv);
		} else if (str == "cloth") {
			Image im = new Image("resource/image/rs5.png");
			ImageView iv = new ImageView(im);
			iv.setX(10 - 25 * (num + player.Gcloth));
			iv.setY(70 + 125);
			iv.setScaleX(0.5);
			iv.setScaleY(0.5);
			m.getGUIManager().ap[player.index].getChildren().add(iv);
		} else if (str == "paper") {
			Image im = new Image("resource/image/rs7.png");
			ImageView iv = new ImageView(im);
			iv.setX(10 - 25 * (num + player.Gpaper));
			iv.setY(70 + 150);
			iv.setScaleX(0.5);
			iv.setScaleY(0.5);
			m.getGUIManager().ap[player.index].getChildren().add(iv);
		} else if (str == "wood_stone") {
			Image im = new Image("resource/image/rs11.png");
			ImageView iv = new ImageView(im);
			iv.setX(-170);
			iv.setY(70);
			iv.setScaleX(0.5);
			iv.setScaleY(0.5);
			m.getGUIManager().ap[player.index].getChildren().add(iv);
		} else if (str == "wood_brick") {
			Image im = new Image("resource/image/rs8.png");
			ImageView i = new ImageView(im);
			i.setX(-170);
			i.setY(95);
			i.setScaleX(0.5);
			i.setScaleY(0.5);
			m.getGUIManager().ap[player.index].getChildren().add(i);
		} else if (str == "wood_ore") {
			Image im = new Image("resource/image/rs12.png");
			ImageView i = new ImageView(im);
			i.setX(-170);
			i.setY(120);
			i.setScaleX(0.5);
			i.setScaleY(0.5);
			m.getGUIManager().ap[player.index].getChildren().add(i);
		} else if (str == "stone_brick") {
			Image im = new Image("resource/image/rs9.png");
			ImageView i = new ImageView(im);
			i.setX(-170);
			i.setY(145);
			i.setScaleX(0.5);
			i.setScaleY(0.5);
			m.getGUIManager().ap[player.index].getChildren().add(i);
		} else if (str == "stone_ore") {
			Image im = new Image("resource/image/rs13.png");
			ImageView i = new ImageView(im);
			i.setX(-170);
			i.setY(170);
			i.setScaleX(0.5);
			i.setScaleY(0.5);
			m.getGUIManager().ap[player.index].getChildren().add(i);
		} else if (str == "brick_ore") {
			Image im = new Image("resource/image/rs10.png");
			ImageView i = new ImageView(im);
			i.setX(-170);
			i.setY(195);
			i.setScaleX(0.5);
			i.setScaleY(0.5);
			m.getGUIManager().ap[player.index].getChildren().add(i);
		} else if (str == "wood_stone_brick_ore") {
			Image im = new Image("resource/image/rs15.png");
			ImageView i = new ImageView(im);
			i.setX(-80 - 80 * player.Gwood_stone_brick_ore);
			i.setY(245);
			i.setScaleX(0.5);
			i.setScaleY(0.5);
			m.getGUIManager().ap[player.index].getChildren().add(i);
		} else if (str == "glass_cloth_paper") {
			Image im = new Image("resource/image/rs14.png");
			ImageView i = new ImageView(im);
			i.setX(-80 - 80 * player.Gglass_cloth_paper);
			i.setY(270);
			i.setScaleX(0.5);
			i.setScaleY(0.5);
			m.getGUIManager().ap[player.index].getChildren().add(i);
		}
		if (num == 1)
			return;
		AddResource(player, str, --num);
	}

	// TODO 呈现玩家手牌
	public static ImageView addCard(Player player, Card card, int index, int num) {
		ImageView iv = card.iv;
		iv.setX(150 + index * 120);
		iv.setY(620);
		iv.setScaleX(0.6);
		iv.setScaleY(0.6);
		Manager m = new Manager();
		m.getGUIManager().addCard(player, iv, index);
		return iv;
	}

	// TODO 更新金钱
	public static void updateCoin(Player player) {
		player.Gcoin += player.turn.Gcoin;
		Manager m = new Manager();
		m.getGUIManager().ap[player.index].getChildren().removeAll(
				bCoin[player.index]);
		m.getGUIManager().ap[player.index].getChildren().removeAll(
				sCoin[player.index]);
		int big = player.Gcoin / 3;
		int small = player.Gcoin % 3;
		Image bc = new Image("resource/image/geld3.png");
		Image sc = new Image("resource/image/geld1.png");
		int i;
		for (i = 0; i < big; i++) {
			bCoin[player.index][i] = new ImageView(bc);
			bCoin[player.index][i].setScaleX(0.5);
			bCoin[player.index][i].setScaleY(0.5);
			bCoin[player.index][i].setX(16 + 25 * i);
			bCoin[player.index][i].setY(150);
			m.getGUIManager().ap[player.index].getChildren().add(
					bCoin[player.index][i]);
		}
		for (int j = 0; j < small; j++) {
			sCoin[player.index][j] = new ImageView(sc);
			sCoin[player.index][j].setScaleX(0.5);
			sCoin[player.index][j].setScaleY(0.5);
			sCoin[player.index][j].setX(16 + (25) * (i + j));
			sCoin[player.index][j].setY(150);
			m.getGUIManager().ap[player.index].getChildren().add(
					sCoin[player.index][j]);
		}
	}

	// TODO 更新奇迹等级
	public static void updateStage(Player player) {
		Manager m = new Manager();
		if (player.board.age == 1) {
			Image im = new Image("resource/image/build1.png");
			ImageView iv = new ImageView(im);
			iv.setX(40);
			iv.setY(260);
			iv.setScaleX(0.5);
			iv.setScaleY(0.5);
			m.getGUIManager().ap[player.index].getChildren().add(iv);
		} else if (player.board.age == 2) {
			Image im = new Image("resource/image/build2.png");
			ImageView iv = new ImageView(im);
			iv.setX(195);
			iv.setY(260);
			iv.setScaleX(0.5);
			iv.setScaleY(0.5);
			m.getGUIManager().ap[player.index].getChildren().add(iv);
		} else if (player.board.age == 3) {
			Image im = new Image("resource/image/build3.png");
			ImageView iv = new ImageView(im);
			iv.setX(355);
			iv.setY(260);
			iv.setScaleX(0.5);
			iv.setScaleY(0.5);
			m.getGUIManager().ap[player.index].getChildren().add(iv);
		}
	}

	// TODO 建造卡牌后有个卡牌消失效果
	public static void hideCard(Player player, Card card) {
		Manager m = new Manager();
		ImageView iv = new ImageView(card.iv.getImage());
		iv.setScaleX(0.6);
		iv.setScaleY(0.6);
		iv.setX(200);
		iv.setY(20);
		m.getGUIManager().ap[player.index].getChildren().add(iv);
		FadeTransition ft = new FadeTransition(Duration.millis(2000), iv);
		ft.setFromValue(1);
		ft.setToValue(0);
		ft.play();
	}

	// TODO 加入点
	public static void addPoint(String color, final Player player, int i,
			final Card card) {
		Circle cir = new Circle();
		final Manager m = new Manager();
		if (color == "Brown") {
			cir.setFill(Color.BROWN);
			cir.setLayoutX(30 + player.brownNum * 11);
			cir.setLayoutY(140);
		} else if (color == "Gray") {
			cir.setFill(Color.GRAY);
			cir.setLayoutX(30 + player.grayNum * 11);
			cir.setLayoutY(151);
		} else if (color == "Green") {
			cir.setFill(Color.GREEN);
			cir.setLayoutY(70);
			if (i == 1) {
				cir.setLayoutX(220 + player.Gliterature * 11);
			} else if (i == 2) {
				cir.setLayoutX(170 + player.Gphysics * 11);
			} else if (i == 3) {
				cir.setLayoutX(270 + player.Gmath * 11);
			}
		} else if (color == "Blue") {
			cir.setFill(Color.BLUE);
			cir.setLayoutX(339 + player.blueNum * 11);
			cir.setLayoutY(75);
		} else if (color == "Red") {
			cir.setFill(Color.RED);
			cir.setLayoutX(429 + player.redNum * 11);
			cir.setLayoutY(75);
		} else if (color == "Yellow") {
			cir.setFill(Color.YELLOW);
			cir.setLayoutX(541 - player.yellowNum * 11);
			cir.setLayoutY(140);
		} else if (color == "Purple") {
			cir.setFill(Color.PURPLE);
			cir.setLayoutX(541 - player.purpleNum * 11);
			cir.setLayoutY(151);
		}
		cir.setRadius(5);
		final ImageView iv = new ImageView(card.iv.getImage());
		EventHandler<MouseEvent> enter = new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				m.getGUIManager().ap[player.index].getChildren().remove(iv);
				m.getGUIManager().ap[player.index].getChildren().add(iv);
				iv.setScaleX(0.4);
				iv.setScaleY(0.4);
				iv.setX(((Circle) event.getSource()).getCenterX());
				iv.setY(((Circle) event.getSource()).getCenterX());
				iv.setOnMouseExited(new EventHandler<MouseEvent>() {
					public void handle(MouseEvent event) {
						m.getGUIManager().ap[player.index].getChildren()
								.remove(iv);
					}
				});
			}
		};
		cir.setOnMouseClicked(enter);

		m.getGUIManager().ap[player.index].getChildren().add(cir);
	}

	// TODO 买卖标志
	public static void setBuy(final Player player) {
		Image b = new Image("resource/image/zeus.png");
		ImageView[] iv = new ImageView[2];
		iv[0] = new ImageView(b);
		iv[1] = new ImageView(b);
		iv[0].setX(100);
		iv[1].setX(520);
		final Manager m = new Manager();
		for (int i = 0; i < 2; i++) {
			m.getGUIManager().ap[0].getChildren().add(iv[i]);
			iv[i].setId(String.valueOf(i));
			iv[i].setOnMouseClicked(new EventHandler<MouseEvent>() {
				public void handle(MouseEvent event) {
					int i = Integer.parseInt(((ImageView) event.getSource())
							.getId());
					if (m.getKenelManager().times == 6
							&& m.getKenelManager().age == 3
							&& player.turn.card != null)
						;
					else
						m.getGUIManager().addBuy(player, i);
				}
			});
		}
	}
}
