package GUI;

import Kernel.KernelManager;
import Kernel.Manager;
import Kernel.MathGame;
import Kernel.Player;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.ImageCursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * @author Lane 界面管理者-通过该类管理所有界面
 */

public class GUIManager {

	private double XScreen;
	private double YScreen;

	private Group root;
	private Scene scene;
	private Stage stage;

	private Block block;

	private Image icon = new Image("resource/image/icon.png");
	private Image cursor = new Image("resource/image/arrow.png");

	public ChoiceBox<Integer> PlayerNum;
	@SuppressWarnings("unchecked")
	public ChoiceBox<String>[] PlayerLevel = new ChoiceBox[7];

	public String[] Level = { "Level1" };

	public AnchorPane[] ap = new AnchorPane[7];

	public GUIManager() {
		XScreen = 1099;
		YScreen = 713;
		root = new Group();
		block = new Block(XScreen, YScreen);
	}

	public void initScene() {
		scene = new Scene(root, XScreen, YScreen);
		scene.setCursor(new ImageCursor(cursor));
	}

	public void initStage() throws Exception {
		stage = new Stage();
		stage.setTitle("Seven Wonders");
		stage.setResizable(false);
		stage.initStyle(StageStyle.TRANSPARENT);
		stage.setScene(scene);
		stage.getIcons().add(icon);
		setBlock();
	}

	public Group getGroup() {
		return root;
	}

	public Scene getScene() {
		return scene;
	}

	public Stage getStage() {
		return stage;
	}

	public void setBlock() {
		root.getChildren().add(block.getBlock());
		root.getChildren().add(block.getLogo());
		root.getChildren().add(block.getVersion());
		root.getChildren().add(block.getpt());
		root.getChildren().add(block.getpm());
		root.getChildren().add(block.getpf());
		root.getChildren().add(block.getMenu());
		for (int i = 0; i < 7; i++)
			root.getChildren().add(block.getLabel(i));
		block.setStartEffect();
	}

	public ImageView iv;
	public Text[] text = new Text[8];
	public Button[] button = new Button[2];

	public void setNewGame() {
		if (PlayerNum != null)
			removeNewGame();
		iv = block.getMenuBg();
		root.getChildren().add(iv);

		PlayerNum = block.getPlayerNum();
		root.getChildren().add(PlayerNum);

		text[0] = block.getText("Player Num", XScreen / 3 + 30,
				YScreen / 3 - 20, 25);
		root.getChildren().add(text[0]);
		setPlayer(PlayerNum.getSelectionModel().getSelectedItem());

		button[0] = block.getStart();
		button[1] = block.getCancel();
		root.getChildren().add(button[0]);
		root.getChildren().add(button[1]);
	}

	public void setPlayer(int num) {
		for (int i = 1; i <= num; i++) {
			text[i] = block.getText("Player " + i, XScreen / 3 + 30, YScreen
					/ 3 - 20 + i * 40, 25);
			root.getChildren().add(text[i]);
			PlayerLevel[i - 1] = block.getPlayerLevel(i);
			root.getChildren().add(PlayerLevel[i - 1]);
		}
	}

	public void removePlayer(int num) {
		for (int i = 1; i <= num; i++) {
			root.getChildren().remove(text[i]);
			root.getChildren().remove(PlayerLevel[i - 1]);
		}
	}

	public void removeNewGame() {
		root.getChildren().remove(iv);
		root.getChildren().remove(PlayerNum);
		root.getChildren().remove(text[0]);
		root.getChildren().remove(button[0]);
		root.getChildren().remove(button[1]);
		removePlayer(PlayerNum.getSelectionModel().getSelectedItem());
	}

	private GameBack bk = new GameBack();

	public GameBack getBack() {
		return bk;
	}

	// TODO 弃牌数目
	Text discard;

	public void startGame() {
		// 背景图
		root.getChildren().add(bk.getIv());
		// 时代标志
		root.getChildren().add(bk.getAge());
		// 弃牌数目标志
		discard = bk.getText();
		root.getChildren().add(discard);
		// 玩家定位-滚动圆圈
		root.getChildren().add(bk.getCir());

		int num = PlayerNum.getSelectionModel().getSelectedItem();
		Circle[] cir = new Circle[num];
		for (int i = num - 1; i >= 0; i--) {
			double angle = 180 + i * (int) (360.0 / num);
			cir[i] = bk.getBall(angle, KernelManager.color[i]);
			root.getChildren().add(cir[i]);

			ap[i] = bk.getDropGroup(i);
			root.getChildren().add(ap[i]);
			Game.blueScore[i].setX(369);
			Game.blueScore[i].setY(55);
			Game.redScore[i].setX(459);
			Game.redScore[i].setY(55);
			bk.setAnchorPosition(ap[i], angle);

			ap[i].getChildren().add(Game.blueScore[i]);
			ap[i].getChildren().add(Game.redScore[i]);

			final int n = i;
			final int number = num;
			cir[i].setOnMouseClicked(new EventHandler<MouseEvent>() {
				public void handle(MouseEvent event) {
					for (int i = number - 1; i >= 0; i--)
						root.getChildren().remove(ap[i]);
					int k = number - 1;
					for (int i = n - 1; i >= 0; i--) {
						root.getChildren().add(ap[i]);
						bk.setAnchorPosition(ap[i], 180 + k--
								* (int) (360.0 / number));
					}
					for (int i = number - 1; i >= n; i--) {
						root.getChildren().add(ap[i]);
						bk.setAnchorPosition(ap[i], 180 + k--
								* (int) (360.0 / number));
					}
				}
			});
		}
	}

	public final ImageView[] card = new ImageView[7];
	public Image choose = new Image("resource/image/chooser.png");
	public final ImageView[] chooser = new ImageView[7];

	public void updateHand() {
		root.getChildren().removeAll(card);
	}

	// 如果以后要改局域网游戏 final变量必须全部重查！！！-Lane
	public void addCard(final Player player, ImageView Ncard, int ind) {
		chooser[ind] = new ImageView(choose);
		this.card[ind] = Ncard;
		final int index = ind;
		final EventHandler<MouseEvent> exitedCard = new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				card[index].setScaleX(0.6);
				card[index].setScaleY(0.6);
				card[index].setTranslateY(0);
			}
		};
		final EventHandler<MouseEvent> enteredCard = new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				root.getChildren().remove(chooser[index]);
				for (int i = 0; i < 7; i++) {
					if (card[i] != null && i != index) {
						card[i].setScaleX(0.6);
						card[i].setScaleY(0.6);
						card[i].setTranslateY(0);
					}
				}
				card[index].setTranslateY(-190);
				card[index].setScaleX(0.8);
				card[index].setScaleY(0.8);
				root.getChildren().remove(card[index]);
				root.getChildren().add(card[index]);
				card[index].setOnMouseClicked(new EventHandler<MouseEvent>() {
					public void handle(MouseEvent event) {
						root.getChildren().remove(chooser[index]);
						chooser[index].setX(180 + index * 120);
						chooser[index].setY(500);
						root.getChildren().add(chooser[index]);
						chooser[index]
								.setOnMouseEntered(new EventHandler<MouseEvent>() {
									public void handle(MouseEvent event) {
										card[index].setTranslateY(-190);
										card[index].setScaleX(0.8);
										card[index].setScaleY(0.8);
										root.getChildren().remove(
												chooser[index]);
										root.getChildren().add(chooser[index]);
									}
								});
					}
				});
			}
		};
		chooser[index].setOnMouseExited(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				root.getChildren().remove(chooser[index]);
				card[index].setOnMouseExited(exitedCard);
			}
		});
		chooser[index].setOnMouseClicked(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				Manager m = new Manager();
				if (event.getY() < 567) {
					if (MathGame.ifBuild(
							player,
							m.getKenelManager().hand[(player.index
									+ m.getKenelManager().times + 6) % 7].card[index])) {
						player.turn.setChoose(
								m.getKenelManager().hand[(player.index
										+ m.getKenelManager().times + 6) % 7].card[index],
								1);
						root.getChildren().removeAll(card);
						root.getChildren().remove(chooser[index]);
					}
				} else if (event.getY() < 619) {
					if (MathGame.ifBuildStage(player)) {
						player.turn.setChoose(
								m.getKenelManager().hand[(player.index
										+ m.getKenelManager().times + 6) % 7].card[index],
								2);
						root.getChildren().removeAll(card);
						root.getChildren().remove(chooser[index]);
					}
				} else {
					player.turn.setChoose(
							m.getKenelManager().hand[(player.index
									+ m.getKenelManager().times + 6) % 7].card[index],
							0);
					root.getChildren().removeAll(card);
					root.getChildren().remove(chooser[index]);
				}
			}

		});
		this.card[index].setOnMouseEntered(enteredCard);
		this.card[index].setOnMouseExited(exitedCard);
		root.getChildren().add(this.card[index]);
	}
	//TODO 更新弃牌数目
	public void updateDiscard() {
		Manager m = new Manager();
		discard.setText(String.valueOf(m.getKenelManager().disNum));
	}
	
	
}
