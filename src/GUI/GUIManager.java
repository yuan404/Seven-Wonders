package GUI;

import Kernel.Buy;
import Kernel.Card;
import Kernel.CardInfo;
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
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
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
	// TODO 图标及光标
	private Image icon = new Image("resource/image/icon.png");
	private Image cursor = new Image("resource/image/arrow.png");

	public ChoiceBox<Integer> PlayerNum;
	@SuppressWarnings("unchecked")
	public ChoiceBox<String>[] PlayerLevel = new ChoiceBox[7];

	public String[] Level = { "Level1" };

	// TODO 玩家各自小屏信息
	public AnchorPane[] ap = new AnchorPane[7];
	// TODO 玩家各自红战斗力及蓝分
	public Text[] blueScore = new Text[7];
	public Text[] redScore = new Text[7];

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

	// TODO 设置开始背景
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

	// TODO 开始游戏的一些元素
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

			blueScore[i] = Game.blueScore[i];
			redScore[i] = Game.redScore[i];
			ap[i].getChildren().add(blueScore[i]);
			ap[i].getChildren().add(redScore[i]);

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
					// TODO 当资源足够或者 有免费建造的奇迹属性
					if (MathGame.ifBuild(player,
							m.getKenelManager().hand[player.index].card[index])) {
						root.getChildren().removeAll(card);
						root.getChildren().remove(chooser[index]);
						player.turn.setChoose(
								m.getKenelManager().hand[player.index].card[index],
								1);
					} else if (player.free[m.getKenelManager().age - 1] != 0) {
						root.getChildren().removeAll(card);
						root.getChildren().remove(chooser[index]);
						player.freeBuild(m.getKenelManager().hand[player.index].card[index]);
					}
				} else if (event.getY() < 619) {
					if (MathGame.ifBuildStage(player)) {
						root.getChildren().removeAll(card);
						root.getChildren().remove(chooser[index]);
						player.turn.setChoose(
								m.getKenelManager().hand[player.index].card[index],
								2);
					}
				} else {
					root.getChildren().removeAll(card);
					root.getChildren().remove(chooser[index]);
					player.turn.setChoose(
							m.getKenelManager().hand[player.index].card[index],
							0);
				}
			}

		});
		this.card[index].setOnMouseEntered(enteredCard);
		this.card[index].setOnMouseExited(exitedCard);
		root.getChildren().add(this.card[index]);
	}

	// TODO 更新弃牌数目
	public void updateDiscard() {
		Manager m = new Manager();
		discard.setText(String.valueOf(m.getKenelManager().disNum));
	}

	// TODO 更新红战斗力和蓝分
	public void updateRedBlue() {
		Manager m = new Manager();
		for (int i = 0; i < m.getKenelManager().playerNum; i++) {
			blueScore[i].setText(Game.blueScore[i].getText());
			blueScore[i].setFont(Game.blueScore[i].getFont());
			redScore[i].setText(Game.redScore[i].getText());
			redScore[i].setFont(Game.redScore[i].getFont());
		}
	}

	// TODO 新时代
	public void newAge(int age) {
		bk.setAge(age);
	}

	// TODO 时代战争
	public void addLeftForce(Player player, int age, boolean win) {
		Image im;
		ImageView iv;
		if (win) {
			im = new Image("resource/image/fight" + age + ".png");
			iv = new ImageView(im);
			iv.setX(-5 + 25 * age);
			iv.setY(180);
			iv.setScaleX(0.5);
			iv.setScaleY(0.5);
		} else {
			im = new Image("resource/image/fight0.png");
			iv = new ImageView(im);
			iv.setX(-5 + 25 * age);
			iv.setY(193);
			iv.setScaleX(0.5);
			iv.setScaleY(0.5);
		}
		ap[player.index].getChildren().add(iv);
	}

	public void addRightForce(Player player, int age, boolean win) {
		Image im;
		ImageView iv;
		if (win) {
			im = new Image("resource/image/fight" + age + ".png");
			iv = new ImageView(im);
			iv.setX(522 - 25 * age);
			iv.setY(180);
			iv.setScaleX(0.5);
			iv.setScaleY(0.5);
		} else {
			im = new Image("resource/image/fight0.png");
			iv = new ImageView(im);
			iv.setX(522 - 25 * age);
			iv.setY(193);
			iv.setScaleX(0.5);
			iv.setScaleY(0.5);
		}
		ap[player.index].getChildren().add(iv);
	}

	// TODO 记分板
	public void ScoreBoard() {
		Image im = new Image("resource/image/scorehead.jpg");
		ImageView iv = new ImageView(im);
		iv.setX(400);
		iv.setY(300);
		iv.setOpacity(1);
		root.getChildren().add(iv);
	}

	public void score(Player player) {
		Rectangle rec = new Rectangle(400, 330 + 30 * player.index, 338, 30);
		rec.setFill(Color.BROWN.brighter());
		root.getChildren().add(rec);
		Text name = new Text(player.board.name);
		name.setX(410);
		name.setY(340 + 30 * player.index);
		name.setFill(Color.WHITE);
		root.getChildren().add(name);
		Text[] sc = new Text[8];
		for (int i = 0; i < 8; i++) {
			sc[i] = new Text("0");
			sc[i].setFill(Color.WHITE);
			sc[i].setX(510 + 29 * i);
			sc[i].setY(340 + 30 * player.index);
		}
		sc[0].setText(String.valueOf(player.GforceScore));
		sc[1].setText(String.valueOf((int) player.Gcoin / 3));
		sc[2].setText(String.valueOf(player.GboardScore));
		sc[3].setText(String.valueOf(player.GblueScore));
		sc[4].setText(String.valueOf(player.GyellowScore));
		sc[5].setText(String.valueOf(player.GpurpleScore));
		sc[6].setText(String.valueOf(player.GgreenScore));
		int total = player.GforceScore + (int) player.Gcoin / 3
				+ player.GboardScore + player.GblueScore + player.GyellowScore
				+ player.GpurpleScore + player.GgreenScore;
		sc[7].setText(String.valueOf(total));
		root.getChildren().addAll(sc);
	}

	Image ok = new Image("resource/image/ok.png");
	Image freeok = new Image("resource/image/freeok.png");
	Image notok = new Image("resource/image/notok.png");
	ImageView[] OK = new ImageView[7];
	ImageView[] freeOK = new ImageView[7];
	ImageView[] notOK = new ImageView[7];

	// TODO 增加免费信号
	public void addFreeOK(Card card, int i) {
		freeOK[i] = new ImageView(freeok);
		freeOK[i].setScaleX(0.5);
		freeOK[i].setScaleY(0.5);
		freeOK[i].setX(card.iv.getX() + 50);
		freeOK[i].setY(card.iv.getY() + 50);
		root.getChildren().add(freeOK[i]);
	}

	// TODO 增加可建信号
	public void addOK(Card card, int i) {
		OK[i] = new ImageView(ok);
		OK[i].setScaleX(0.5);
		OK[i].setScaleY(0.5);
		OK[i].setX(card.iv.getX() + 30);
		OK[i].setY(card.iv.getY() + 50);
		root.getChildren().add(OK[i]);
	}

	// TODO 移除
	public void removeOK() {
		root.getChildren().removeAll(OK);
		root.getChildren().removeAll(freeOK);
		root.getChildren().removeAll(notOK);
	}

	// TODO 不可建
	public void addnotOK(Card card, int i) {
		notOK[i] = new ImageView(notok);
		notOK[i].setScaleX(0.5);
		notOK[i].setScaleY(0.5);
		notOK[i].setX(card.iv.getX() + 30);
		notOK[i].setY(card.iv.getY() + 50);
		root.getChildren().add(notOK[i]);
	}

	Image top = new Image("resource/image/frametop.png");
	final Image bg = new Image("resource/image/dist2.jpg");
	final Image bg2 = new Image("resource/image/dist.jpg");
	Image foot = new Image("resource/image/framebottom.jpg");
	ImageView topIv = new ImageView(top);
	final ImageView[] bgIv = new ImageView[55];
	ImageView footIv = new ImageView(foot);
	final Text[] dis = new Text[55];
	ImageView okIv = new ImageView(ok);
	ImageView notokIv = new ImageView(notok);

	// TODO 弃牌选择
	public void addDiscard(final Player player) {
		final Manager m = new Manager();
		int num = m.getKenelManager().disNum;
		if (num > 10)
			num = 10;
		if (num == 0)
			return;
		final int number = num;
		topIv.setX(200);
		topIv.setY(100);
		root.getChildren().add(topIv);
		root.getChildren().add(footIv);
		for (int i = 0; i < num; i++) {
			bgIv[i] = new ImageView(bg);
			bgIv[i].setX(215);
			bgIv[i].setY(135 + 35 * i);
			bgIv[i].setScaleX(0.5);
			bgIv[i].setScaleY(0.5);
			bgIv[i].setId(String.valueOf(i));
			bgIv[i].setOnMouseClicked(new EventHandler<MouseEvent>() {
				public void handle(MouseEvent event) {
					for (int i = 0; i < number; i++) {
						bgIv[i].setImage(bg);
					}
					final int i = Integer.parseInt(((ImageView) event
							.getSource()).getId());
					((ImageView) event.getSource()).setImage(bg2);
					root.getChildren().remove(okIv);
					root.getChildren().remove(notokIv);
					root.getChildren().add(okIv);
					okIv.setOnMouseClicked(new EventHandler<MouseEvent>() {
						public void handle(MouseEvent event) {
							removeDis();
							player.turn.setChoose(
									m.getKenelManager().discard[m
											.getKenelManager().disNum - i - 1],
									1);
							m.getKenelManager().removeDiscard(
									m.getKenelManager().discard[m
											.getKenelManager().disNum - i - 1]);
						}
					});
				}
			});
			notokIv.setOnMouseClicked(new EventHandler<MouseEvent>() {
				public void handle(MouseEvent event) {
					removeDis();
				}
			});
			root.getChildren().add(bgIv[i]);
			dis[i] = new Text(
					m.getKenelManager().discard[m.getKenelManager().disNum - i
							- 1].name);
			dis[i].setX(275);
			dis[i].setY(185 + 35 * i);
			dis[i].setScaleX(0.5);
			dis[i].setScaleY(0.5);
			dis[i].setFont(new Font(40));
			root.getChildren().add(dis[i]);
			dis[i].setId(String.valueOf(i));
			dis[i].setOnMouseClicked(new EventHandler<MouseEvent>() {
				public void handle(MouseEvent event) {
					for (int i = 0; i < number; i++) {
						bgIv[i].setImage(bg);
					}
					final int i = Integer.parseInt(((Text) event.getSource())
							.getId());
					bgIv[i].setImage(bg2);
					root.getChildren().remove(okIv);
					root.getChildren().remove(notokIv);
					root.getChildren().add(okIv);
					okIv.setOnMouseClicked(new EventHandler<MouseEvent>() {
						public void handle(MouseEvent event) {
							removeDis();
							player.turn.setChoose(
									m.getKenelManager().discard[m
											.getKenelManager().disNum - i - 1],
									1);
							m.getKenelManager().removeDiscard(
									m.getKenelManager().discard[m
											.getKenelManager().disNum - i - 1]);

						}
					});
				}
			});
		}
		footIv.setX(200);
		footIv.setY(100 + 35 * num);
		topIv.setScaleX(0.5);
		topIv.setScaleY(0.5);
		footIv.setScaleX(0.5);
		footIv.setScaleY(0.5);
		notokIv.setX(410);
		notokIv.setY(120);
		notokIv.setScaleX(0.5);
		notokIv.setScaleY(0.5);
		okIv.setX(410);
		okIv.setY(120);
		okIv.setScaleX(0.5);
		okIv.setScaleY(0.5);
		root.getChildren().add(notokIv);
	}

	// TODO 弃牌选择
	public boolean addPurple(final Player player) {
		final Manager m = new Manager();
		final int Lnum = m.getKenelManager().player[(player.index
				+ m.getKenelManager().playerNum + 1)
				% m.getKenelManager().playerNum].purpleNum;
		final int Rnum = m.getKenelManager().player[(player.index
				+ m.getKenelManager().playerNum - 1)
				% m.getKenelManager().playerNum].purpleNum;
		if (Lnum + Rnum == 0)
			return false;
		topIv.setX(200);
		topIv.setY(100);
		root.getChildren().add(topIv);
		root.getChildren().add(footIv);
		for (int i = 0; i < Lnum + Rnum; i++) {
			bgIv[i] = new ImageView(bg);
			bgIv[i].setX(215);
			bgIv[i].setY(135 + 35 * i);
			bgIv[i].setScaleX(0.5);
			bgIv[i].setScaleY(0.5);
			bgIv[i].setId(String.valueOf(i));
			bgIv[i].setOnMouseClicked(new EventHandler<MouseEvent>() {
				public void handle(MouseEvent event) {
					for (int i = 0; i < Lnum + Rnum; i++) {
						bgIv[i].setImage(bg);
					}
					final int i = Integer.parseInt(((ImageView) event
							.getSource()).getId());
					((ImageView) event.getSource()).setImage(bg2);
					root.getChildren().remove(okIv);
					root.getChildren().remove(notokIv);
					root.getChildren().add(okIv);
					okIv.setOnMouseClicked(new EventHandler<MouseEvent>() {
						public void handle(MouseEvent event) {
							removeDis();
							MathGame.doAction(player,
									CardInfo.getCardByName(dis[i].getText()));
							m.getKenelManager().update(player);
							m.getKenelManager().endGame();
						}
					});
				}
			});
			notokIv.setOnMouseClicked(new EventHandler<MouseEvent>() {
				public void handle(MouseEvent event) {
					removeDis();
				}
			});
			root.getChildren().add(bgIv[i]);
			if (i < Lnum) {
				int k = 0;
				for (; k < m.getKenelManager().player[(player.index
						+ m.getKenelManager().playerNum + 1)
						% m.getKenelManager().playerNum].cardNum; k++) {
					if (m.getKenelManager().player[(player.index
							+ m.getKenelManager().playerNum + 1)
							% m.getKenelManager().playerNum].card[k].color == "Purple") {
						dis[i] = new Text(
								m.getKenelManager().player[(player.index
										+ m.getKenelManager().playerNum + 1)
										% m.getKenelManager().playerNum].card[k].name);
						break;
					}
				}

			} else {
				int k = 0;
				for (; k < m.getKenelManager().player[(player.index
						+ m.getKenelManager().playerNum - 1)
						% m.getKenelManager().playerNum].cardNum; k++) {
					if (m.getKenelManager().player[(player.index
							+ m.getKenelManager().playerNum - 1)
							% m.getKenelManager().playerNum].card[k].color == "Purple") {
						dis[i] = new Text(
								m.getKenelManager().player[(player.index
										+ m.getKenelManager().playerNum - 1)
										% m.getKenelManager().playerNum].card[k].name);
						break;
					}
				}

			}
			dis[i].setX(275);
			dis[i].setY(185 + 35 * i);
			dis[i].setScaleX(0.5);
			dis[i].setScaleY(0.5);
			dis[i].setFont(new Font(40));
			root.getChildren().add(dis[i]);
			dis[i].setId(String.valueOf(i));
			dis[i].setOnMouseClicked(new EventHandler<MouseEvent>() {
				public void handle(MouseEvent event) {
					for (int i = 0; i < Lnum + Rnum; i++) {
						bgIv[i].setImage(bg);
					}
					final int i = Integer.parseInt(((Text) event.getSource())
							.getId());
					bgIv[i].setImage(bg2);
					root.getChildren().remove(okIv);
					root.getChildren().remove(notokIv);
					root.getChildren().add(okIv);
					okIv.setOnMouseClicked(new EventHandler<MouseEvent>() {
						public void handle(MouseEvent event) {
							removeDis();
							MathGame.doAction(player,
									CardInfo.getCardByName(dis[i].getText()));
							m.getKenelManager().update(player);
							m.getKenelManager().endGame();
						}
					});
				}
			});
		}
		footIv.setX(200);
		footIv.setY(100 + 35 * (Lnum + Rnum));
		topIv.setScaleX(0.5);
		topIv.setScaleY(0.5);
		footIv.setScaleX(0.5);
		footIv.setScaleY(0.5);
		notokIv.setX(410);
		notokIv.setY(120);
		notokIv.setScaleX(0.5);
		notokIv.setScaleY(0.5);
		okIv.setX(410);
		okIv.setY(120);
		okIv.setScaleX(0.5);
		okIv.setScaleY(0.5);
		root.getChildren().add(notokIv);
		return true;
	}

	public void removeDis() {
		root.getChildren().remove(topIv);
		root.getChildren().remove(okIv);
		root.getChildren().remove(notokIv);
		root.getChildren().remove(footIv);
		root.getChildren().removeAll(bgIv);
		root.getChildren().removeAll(dis);
		root.getChildren().removeAll(re);

	}

	public Image[] res = new Image[7];
	public ImageView[] re = new ImageView[7];

	// TODO 买卖交易
	public void addBuy(final Player player, final int side) {
		final Buy b = new Buy();
		final Manager m = new Manager();
		int ind;
		ind = 0;
		if (side == 0) {
			ind = (player.index + 1 + m.getKenelManager().playerNum)
					% m.getKenelManager().playerNum;
		} else {
			ind = (player.index - 1 + m.getKenelManager().playerNum)
					% m.getKenelManager().playerNum;
		}
		final int index = ind;
		for (int i = 0; i < 7; i++) {
			res[i] = new Image("resource/image/rs" + (i + 1) + ".png");
			re[i] = new ImageView(res[i]);
		}
		re[0].setId("brick");
		re[1].setId("ore");
		re[2].setId("stone");
		re[3].setId("wood");
		re[4].setId("cloth");
		re[5].setId("glass");
		re[6].setId("paper");

		topIv.setX(200);
		topIv.setY(100);
		footIv.setX(200);
		footIv.setY(100 + 35 * (7));
		topIv.setScaleX(0.5);
		topIv.setScaleY(0.5);
		footIv.setScaleX(0.5);
		footIv.setScaleY(0.5);
		notokIv.setX(410);
		notokIv.setY(120);
		notokIv.setScaleX(0.5);
		notokIv.setScaleY(0.5);
		okIv.setX(410);
		okIv.setY(120);
		okIv.setScaleX(0.5);
		okIv.setScaleY(0.5);
		root.getChildren().add(topIv);
		root.getChildren().add(footIv);

		for (int i = 0; i < 7; i++) {
			bgIv[i] = new ImageView(bg);
			bgIv[i].setX(215);
			bgIv[i].setY(135 + 35 * i);
			bgIv[i].setScaleX(0.5);
			bgIv[i].setScaleY(0.5);
			root.getChildren().add(bgIv[i]);
			re[i].setX(315);
			re[i].setY(145 + 35 * i);
			re[i].setScaleX(0.5);
			re[i].setScaleY(0.5);
			root.getChildren().add(re[i]);
			dis[i] = new Text();
			dis[i].setText(String.valueOf(0));
			dis[i].setX(405);
			dis[i].setY(185 + 35 * i);
			dis[i].setScaleX(0.5);
			dis[i].setScaleY(0.5);
			dis[i].setFont(new Font(40));
			root.getChildren().add(dis[i]);
			re[i].setOnMouseClicked(new EventHandler<MouseEvent>() {
				public void handle(MouseEvent event) {
					String str = ((ImageView) event.getSource()).getId();
					if (str == "wood") {
						b.Cwood++;
						dis[3].setText(String.valueOf(b.Cwood));
						if ((player.CheapBuy)
								|| (side == 0 && player.LeftCheap)
								|| (side == 1 && player.RightCheap))
							b.coin++;
						else
							b.coin += 2;
					} else if (str == "stone") {
						b.Cstone++;
						dis[2].setText(String.valueOf(b.Cstone));
						if ((player.CheapBuy)
								|| (side == 0 && player.LeftCheap)
								|| (side == 1 && player.RightCheap))
							b.coin++;
						else
							b.coin += 2;
					} else if (str == "brick") {
						b.Cbrick++;
						dis[0].setText(String.valueOf(b.Cbrick));
						if ((player.CheapBuy)
								|| (side == 0 && player.LeftCheap)
								|| (side == 1 && player.RightCheap))
							b.coin++;
						else
							b.coin += 2;
					} else if (str == "ore") {
						b.Core++;
						dis[1].setText(String.valueOf(b.Core));
						if ((player.CheapBuy)
								|| (side == 0 && player.LeftCheap)
								|| (side == 1 && player.RightCheap))
							b.coin++;
						else
							b.coin += 2;
					} else if (str == "glass") {
						b.Cglass++;
						dis[5].setText(String.valueOf(b.Cglass));
						if ((player.GrayCheap))
							b.coin++;
						else
							b.coin += 2;
					} else if (str == "cloth") {
						b.Ccloth++;
						dis[4].setText(String.valueOf(b.Ccloth));
						if ((player.GrayCheap))
							b.coin++;
						else
							b.coin += 2;
					} else if (str == "paper") {
						b.Cpaper++;
						dis[6].setText(String.valueOf(b.Cpaper));
						if ((player.GrayCheap))
							b.coin++;
						else
							b.coin += 2;
					}
					root.getChildren().remove(notokIv);
					root.getChildren().remove(okIv);
					if (b.coin > player.Gcoin
							|| !MathGame.ifBuy(
									m.getKenelManager().player[index], b)) {
						root.getChildren().add(notokIv);
					} else
						root.getChildren().add(okIv);

				}
			});
		}
		notokIv.setOnMouseClicked(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				b.clear();
				removeDis();
			}
		});
		okIv.setOnMouseClicked(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				b.update(player);
				removeDis();
				for (int i = 0; i < m.getKenelManager().hand[0].cardNum; i++) {
					if (MathGame.ifBuild(player,
							m.getKenelManager().hand[0].card[i])) {
						root.getChildren().remove(OK[i]);
						m.getGUIManager().addOK(
								m.getKenelManager().hand[0].card[i], i);
					}
				}
			}
		});
		root.getChildren().add(notokIv);
	}
}
