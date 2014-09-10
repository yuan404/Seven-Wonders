package GUI;

import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
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
}
