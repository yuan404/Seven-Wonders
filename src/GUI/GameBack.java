package GUI;

import Kernel.Manager;
import Kernel.MathGame;
import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
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

	public AnchorPane getDropGroup() {
		final AnchorPane ap = new AnchorPane();
		ap.setMinSize(540, 230);
		final Manager m = new Manager();
		ap.getChildren().add(m.getKenelManager().player[0].board.iv);
		ap.setLayoutX(1099 / 4);
		ap.setLayoutY(713 / 5 * 3 - 25);
		m.getKenelManager().player[0].board.iv.setEffect(m.getGUIManager()
				.getBack().getDropShadow());
		ap.setOnMouseDragged(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				ap.setLayoutX(event.getX());
				ap.setLayoutY(event.getY());

			}
		});

		return ap;
	}
}
