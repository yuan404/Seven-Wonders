package GUI;

import Kernel.Manager;
import javafx.animation.FadeTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;

/**
 * @author Lane 背景板界面
 */

public class Block {

	private String version = new String("Version 0.1.9");

	private Image bg = new Image("resource/image/newbg.png");
	private ImageView block = new ImageView(bg);

	private Image lg = new Image("resource/image/logo.png");
	private ImageView logo = new ImageView(lg);

	private Image mn = new Image("resource/image/engtext_normal.png");
	private ImageView menu = new ImageView(mn);
	private Image pt = new Image("resource/image/paper_top.png");
	private Image pm = new Image("resource/image/paper_middle.png");
	private Image pf = new Image("resource/image/paper_foot.png");
	private ImageView paperTop = new ImageView(pt);
	private ImageView paperMiddle = new ImageView(pm);
	private ImageView paperFoot = new ImageView(pf);

	private Image mBg = new Image("resource/image/bg.png");
	private ImageView menuBg = new ImageView(mBg);

	private double width;
	private double height;

	public Block(double width, double height) {
		this.width = width;
		this.height = height;

		// 让背景板圆角
		// Rectangle rec = new Rectangle(width,height);
		// rec.setArcHeight(100);
		// rec.setArcWidth(100);
		// block.setClip(rec);

		// Logo位置
		logo.setX(width / 3);

		// 菜单内容及背景位置
		menu.setX(width / 3 * 2 + 30);
		menu.setY(height / 3);
		paperTop.setX(width / 3 * 2);
		paperMiddle.setX(width / 3 * 2 - 18);
		paperFoot.setX(width / 3 * 2 - 28);
		paperTop.setY(height / 3 - 55);
		paperMiddle.setY(height / 3 + 20);
		paperFoot.setY(height / 3 + 20);

		// 菜单子菜单页面
		Rectangle rec = new Rectangle(300, 400);
		rec.setArcHeight(50);
		rec.setArcWidth(50);
		menuBg.setClip(rec);
		menuBg.setLayoutX(width / 3);
		menuBg.setLayoutY(height / 3 - 60);
		menuBg.setOpacity(0.7);
	}

	public ImageView getBlock() {
		return block;
	}

	public ImageView getLogo() {
		return logo;
	}

	public ImageView getMenu() {
		return menu;
	}

	public ImageView getpt() {
		return paperTop;
	}

	public ImageView getpm() {
		return paperMiddle;
	}

	public ImageView getpf() {
		return paperFoot;
	}

	public ImageView getMenuBg() {
		return menuBg;
	}

	// 开始动画效果
	public void setStartEffect() {
		FadeTransition ft = new FadeTransition(Duration.millis(2000), block);
		ft.setFromValue(0);
		ft.setToValue(10);
		ScaleTransition st = new ScaleTransition(Duration.millis(2000), logo);
		st.setFromX(2f);
		st.setFromY(2f);
		st.setToX(1f);
		st.setToY(1f);
		TranslateTransition tt = new TranslateTransition(Duration.millis(350),
				paperFoot);
		tt.setByY(265);
		ParallelTransition pt = new ParallelTransition(ft, st, tt);
		pt.play();
	}

	// 版本号
	public Text getVersion() {
		Text tf = new Text();
		tf.setText(version);
		tf.setFont(new Font(25));
		tf.setFill(Color.GOLD);
		tf.setLayoutX(10);
		tf.setLayoutY(height - 10);
		return tf;
	}

	// 菜单
	public Rectangle getLabel(int n) {
		final Rectangle[] Rectangle = new Rectangle[7];
		for (int i = 0; i < 7; i++) {
			Rectangle[i] = new Rectangle(170, 40);
			Rectangle[i].setLayoutX(width / 3 * 2 + 60);
			Rectangle[i].setLayoutY(height / 3 + 45 * (i));
			Rectangle[i].setFill(Color.GRAY);
			Rectangle[i].setOpacity(0);
			final int k = i;
			Rectangle[i].setOnMouseEntered(new EventHandler<MouseEvent>() {
				public void handle(MouseEvent event) {
					Rectangle[k].setOpacity(0.1);
				}
			});
			Rectangle[i].setOnMouseExited(new EventHandler<MouseEvent>() {
				public void handle(MouseEvent event) {
					Rectangle[k].setOpacity(0);
				}
			});
		}
		Rectangle[0].setOnMouseClicked(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				Manager m = new Manager();
				m.getGUIManager().setNewGame();
			}
		});
		Rectangle[6].setOnMouseClicked(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				System.exit(0);
			}
		});
		return Rectangle[n];
	}

	final ChoiceBox<Integer> playerNum = new ChoiceBox<Integer>();

	public ChoiceBox<Integer> getPlayerNum() {
		playerNum.getItems().clear();
		playerNum.getItems().addAll(3, 4, 5, 6, 7);
		playerNum.getSelectionModel().selectFirst();
		playerNum.setLayoutX(width / 3 + 180);
		playerNum.setLayoutY(height / 3 - 40);
		playerNum.setMinSize(30, 30);
		playerNum.setOnMouseClicked(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				menuBg.setOnMouseMoved(new EventHandler<MouseEvent>() {
					public void handle(MouseEvent event) {
						Manager m = new Manager();
						m.getGUIManager().removePlayer(7);
						m.getGUIManager()
								.setPlayer(
										playerNum.getSelectionModel()
												.getSelectedItem());
						menuBg.setOnMouseMoved(null);
					}
				});
			}
		});
		return playerNum;
	}

	public ChoiceBox<String> getPlayerLevel(int i) {
		final ChoiceBox<String> Level = new ChoiceBox<String>();
		if (i == 1)
			Level.getItems().add("Player");
		Manager m = new Manager();
		Level.getItems().addAll(m.getGUIManager().Level);
		Level.getSelectionModel().select(0);
		Level.setLayoutX(width / 3 + 180);
		Level.setLayoutY(height / 3 - 40 + i * 40);
		Level.setMinSize(30, 30);
		return Level;
	}

	public Text getText(String str, double x, double y, int size) {
		Text text = new Text(str);
		text.setX(x);
		text.setY(y);
		text.setFont(new Font(size));
		return text;
	}

	public Button getStart() {
		Button start = new Button();
		start.setText("Start");
		start.setFont(new Font(22));
		start.setLayoutX(width / 3 + 30);
		start.setLayoutY(height / 3 + 280);
		start.setOnMouseClicked(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				Manager m = new Manager();
				m.startGame();
			}
		});
		return start;
	}

	public Button getCancel() {
		Button cancel = new Button();
		cancel.setText("Cancel");
		cancel.setFont(new Font(22));
		cancel.setLayoutX(width / 3 + 150);
		cancel.setLayoutY(height / 3 + 280);
		cancel.setOnMouseClicked(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				Manager m = new Manager();
				m.getGUIManager().removeNewGame();
			}
		});
		return cancel;
	}
}