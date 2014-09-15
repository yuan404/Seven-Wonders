package GUI;

import Kernel.Manager;
import Kernel.MathGame;
import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.Paint;
import javafx.scene.paint.RadialGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Circle;
import javafx.scene.shape.StrokeLineCap;
import javafx.scene.shape.StrokeLineJoin;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;

/**
 * @author Lane 背景板
 */
public class GameBack {

	public Image im = new Image("resource/image/bg.jpg", 1099, 713, false,
			false);
	public ImageView iv = new ImageView(im);

	public Image a[] = new Image[3];
	public ImageView age = new ImageView();

	public Text discardNum = new Text(990, 130, "0");

	public Circle cir = new Circle(1050, 50, 40);

	public Image score = new Image("resource/image/centerstat.png");

	public GameBack() {
		for (int i = 0; i < 3; i++)
			a[i] = new Image("resource/image/ph" + (i + 1) + ".png");
		age.setImage(a[0]);
		age.setX(30);
		age.setY(0);

		discardNum.setFont(new Font(80));
		discardNum.setFill(Color.GOLD.darker());

		cir.setStroke(Color.GRAY);
		cir.setStrokeWidth(5);
		cir.getStrokeDashArray().setAll(10d, 10d);
		cir.setStrokeLineCap(StrokeLineCap.ROUND);
		cir.setStrokeLineJoin(StrokeLineJoin.ROUND);
		cir.setFill(null);
	}

	public ImageView getIv() {
		iv.autosize();
		return iv;
	}

	public ImageView getAge() {
		return age;
	}

	public void setAge(int i) {
		age.setImage(a[i - 1]);
	}

	public Text getText() {
		return discardNum;
	}

	public Circle getCir() {
		RotateTransition rt = new RotateTransition(Duration.millis(3000), cir);
		rt.setCycleCount(Timeline.INDEFINITE);
		rt.setFromAngle(0);
		rt.setToAngle(360);
		rt.play();
		return cir;
	}

	public Circle getBall(double angle, Paint color) {
		Circle ball = new Circle();
		double x = MathGame.getCircleX(angle, 1050, 50, 40);
		double y = MathGame.getCircleY(angle, 1050, 50, 40);
		ball.setLayoutX(x);
		ball.setLayoutY(y);
		ball.setFill(color);
		ball.setRadius(5);

		RadialGradient fill = new RadialGradient(300, 0.7, 0.3, 0.4, 0.2, true,
				CycleMethod.NO_CYCLE, new Stop(1, (Color) color), new Stop(0,
						Color.WHITE));
		ball.setFill(fill);
		ball.setEffect(getDropShadow());
		return ball;
	}

	public DropShadow getDropShadow() {
		DropShadow dropShadow = new DropShadow();
		dropShadow.setRadius(5.0);
		dropShadow.setOffsetX(1.0);
		dropShadow.setOffsetY(1.0);
		dropShadow.setColor(Color.WHITE);
		return dropShadow;
	}

	public AnchorPane getDropGroup(int i) {
		final AnchorPane ap = new AnchorPane();
		ap.setMinSize(540, 295);
		final Manager m = new Manager();
		ImageView sc = new ImageView(score);
		m.getKenelManager().player[i].board.iv.setX(29);
		m.getKenelManager().player[i].board.iv.setY(85);
		ap.getChildren().add(m.getKenelManager().player[i].board.iv);
		ap.setLayoutX(1099 / 4);
		ap.setLayoutY(713 / 5 * 2 + 50);
		m.getKenelManager().player[i].board.iv.setEffect(m.getGUIManager()
				.getBack().getDropShadow());
		ap.getChildren().add(sc);
		sc.setX(150);
		return ap;
	}

	// 之后如果改成奇迹板可移动形式，这里的函数算法得进一步变化，考虑特殊角度
	public void setAnchorPosition(AnchorPane ap, double angle) {
		ap.setScaleX(1);
		ap.setScaleY(1);
		double x = MathGame.getCircleX(angle, 1099 / 4, 713 / 5 + 20, 340);
		double y = MathGame.getCircleY(angle, 1099 / 4, 713 / 5 + 20, 200);
		ap.setLayoutX(x);
		ap.setLayoutY(y);
		double scale = Math.abs(x - 1099 / 4) / 250 / 2;
		if (angle != 180 && angle != 360) {
			ap.setScaleX(scale);
			ap.setScaleY(scale);
		}
		if (angle == 360) {
			ap.setScaleX(0.4);
			ap.setScaleY(0.4);
		}
	}
}
