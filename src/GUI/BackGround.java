package GUI;

import M.Manager;
import javafx.animation.FadeTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

/**
 * 
 * @author Lane
 *
 */
public class BackGround {
	/**
	 * 管理者
	 */
	private Manager m = new Manager();
	/**
	 * 背景图1
	 */
	private Image im1 = new Image("resource/image/newbg.png");
	/**
	 * View-背景图1
	 */
	private ImageView iv1 = new ImageView(im1);
	/**
	 * Logo图
	 */
	private Image im2 = new Image("resource/image/logo.png");
	/**
	 * View-Logo图
	 */
	private ImageView iv2 = new ImageView(im2);
	/**
	 * 书轴1
	 */
	private Image im3 = new Image("resource/image/paper_top.png");
	/**
	 * View-书轴1
	 */
	private ImageView iv3 = new ImageView(im3);
	/**
	 * 书轴2
	 */
	private Image im4 = new Image("resource/image/paper_middle.png");
	/**
	 * View-书轴2
	 */
	private ImageView iv4 = new ImageView(im4);
	/**
	 * 书轴3
	 */
	private Image im5 = new Image("resource/image/paper_foot.png");
	/**
	 * View-书轴3
	 */
	private ImageView iv5 = new ImageView(im5);
	/**
	 * 选择图
	 */
	private Image im6 = new Image("resource/image/engtext_normal.png");
	/**
	 * View-选择图
	 */
	private ImageView iv6 = new ImageView(im6);
	/**
	 * 方块阴影
	 */
	private Rectangle[] rect = new Rectangle[7];

	/**
	 * 设置背景
	 * 
	 * @return
	 */
	public void setBackGround() {
		m.getGUIManager().getGroup().getChildren().add(iv1);
		setLogo();
		m.getGUIManager().getGroup().getChildren().add(iv2);
		setMenu();
		m.getGUIManager().getGroup().getChildren().add(iv3);
		m.getGUIManager().getGroup().getChildren().add(iv4);
		m.getGUIManager().getGroup().getChildren().add(iv5);
		setStartEffect();
		setChoose();
		m.getGUIManager().getGroup().getChildren().add(iv6);
		setRectangle();
		m.getGUIManager().getGroup().getChildren().addAll(rect);
	}

	/**
	 * 移除背景
	 * 
	 * @return
	 */
	public void removeBackGround() {
		m.getGUIManager().getGroup().getChildren().remove(iv1);
		m.getGUIManager().getGroup().getChildren().remove(iv2);
		m.getGUIManager().getGroup().getChildren().remove(iv3);
		m.getGUIManager().getGroup().getChildren().remove(iv4);
		m.getGUIManager().getGroup().getChildren().remove(iv5);
		m.getGUIManager().getGroup().getChildren().remove(iv6);
		m.getGUIManager().getGroup().getChildren().removeAll(rect);
	}

	/**
	 * 设置Logo
	 */
	public void setLogo() {
		iv2.setX(350);
	}

	/**
	 * 设置选择菜单
	 */
	public void setMenu() {
		iv3.setX(500);
		iv3.setY(200);
		iv4.setX(483);
		iv4.setY(275);
		iv5.setX(471);
		iv5.setY(275);
	}

	/**
	 * 设置选择图
	 */
	public void setChoose() {
		iv6.setX(525);
		iv6.setY(250);
	}

	/**
	 * 设置阴影
	 */
	public void setRectangle() {
		for (int i = 0; i < 7; i++) {
			rect[i] = new Rectangle(170, 40);
			rect[i].setLayoutX(550);
			rect[i].setLayoutY(260 + 42 * i);
			rect[i].setFill(Color.GRAY);
			rect[i].setOpacity(0);
			final int n = i;
			rect[i].setOnMouseEntered(new EventHandler<MouseEvent>() {
				public void handle(MouseEvent event) {
					rect[n].setOpacity(0.1);
				}
			});
			rect[i].setOnMouseExited(new EventHandler<MouseEvent>() {
				public void handle(MouseEvent event) {
					rect[n].setOpacity(0);
				}
			});
		}
	}

	/**
	 * 设置开始动画
	 */
	public void setStartEffect() {
		FadeTransition ft = new FadeTransition(Duration.millis(2000), iv1);
		ft.setFromValue(0);
		ft.setToValue(1);
		ScaleTransition st = new ScaleTransition(Duration.millis(2000), iv2);
		st.setFromX(2f);
		st.setFromY(2f);
		st.setToX(1f);
		st.setToY(1f);
		TranslateTransition tt = new TranslateTransition(Duration.millis(350),
				iv5);
		tt.setByY(265);
		ParallelTransition pt = new ParallelTransition(ft, st, tt);
		pt.play();
	}
}
