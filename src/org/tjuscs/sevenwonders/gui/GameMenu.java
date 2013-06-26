package org.tjuscs.sevenwonders.gui;

import java.util.ArrayList;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.util.Duration;

//import org.tjuscs.sevenwonders.LocalMessages;
import org.tjuscs.sevenwonders.Manager;
import org.tjuscs.sevenwonders.kernel.Difficulty;
import org.tjuscs.sevenwonders.kernel.GamePlayer;
import org.tjuscs.sevenwonders.kernel.RandBot;

public class GameMenu extends Group {
	static GameMenu gm;

	public GameMenu() {
		System.out.println(this.getClass().getName()+" - GameMenu()");
		//TODO Changed by zxn 4-7 new-2
		gm = this;
		ImageView menuBackground = new ImageView(ResManager.getImage("bg.png"));
		menuBackground.setScaleX(0.5f);	//0.4f
		menuBackground.setScaleY(0.15f);
		menuBackground.setLayoutX(-85.0);	//-50
		// menuBackground.setLayoutY(-255.0);
		menuBackground.setLayoutY(-335.0);
		if (GUIManager.enableDropShadowEffect)
			menuBackground.setEffect(new DropShadow());
		Rectangle mask = new Rectangle(600, 600);	
		mask.setArcWidth(50);
		mask.setArcHeight(133.3);
		menuBackground.setClip(mask);
		menuBackground.setOpacity(0.85f);
		this.getChildren().add(menuBackground);
		
		//TODO Added by zxn 4-7 new-2
		final Button botButton = new Button();
		botButton.setGraphic(new ImageView(ResManager.getImage("img_bot.png")));
		botButton.setLayoutX(80.0);
		// optionButton.setLayoutY(20.0);
		botButton.setLayoutY(-50.0);
		setButtonEffect(botButton);
		this.getChildren().add(botButton);


		final Button soundButton = new Button();
		soundButton.setGraphic(new ImageView(ResManager.getImage("img_sound.png")));
		soundButton.setLayoutX(150.0);
		// optionButton.setLayoutY(20.0);
		soundButton.setLayoutY(-50.0);
		setButtonEffect(soundButton);
		this.getChildren().add(soundButton);

		Button returnButton = new Button();
		returnButton.setGraphic(new ImageView(ResManager.getImage("img_return.png")));
		returnButton.setLayoutX(220.0);
		// returnButton.setLayoutY(20.0);
		returnButton.setLayoutY(-50.0);
		setButtonEffect(returnButton);
		this.getChildren().add(returnButton);

		Button exitButton = new Button();
		exitButton.setGraphic(new ImageView(ResManager.getImage("img_exit.png")));
		exitButton.setLayoutX(290.0);
		// exitButton.setLayoutY(20.0);
		exitButton.setLayoutY(-50.0);
		setButtonEffect(exitButton);
		this.getChildren().add(exitButton);

		//TODO Changed by zxn 4-7 new-2
		final Timeline down = new Timeline();
		down.getKeyFrames().addAll(
				new KeyFrame(Duration.ZERO, new KeyValue(menuBackground.layoutYProperty(), -335.0),new KeyValue(botButton.layoutYProperty(), -50.0), 
						new KeyValue(soundButton.layoutYProperty(), -50.0), new KeyValue(returnButton.layoutYProperty(), -50.0),
						new KeyValue(exitButton.layoutYProperty(), -50.0)),
				new KeyFrame(new Duration(100), new KeyValue(menuBackground.layoutYProperty(), -265.0), new KeyValue(botButton.layoutYProperty(), 15.0),
						new KeyValue(soundButton.layoutYProperty(), 15.0), new KeyValue(returnButton.layoutYProperty(), 15.0),
						new KeyValue(exitButton.layoutYProperty(), 15.0)));

		final Timeline up = new Timeline();
		up.getKeyFrames().addAll(
				new KeyFrame(Duration.ZERO, new KeyValue(menuBackground.layoutYProperty(), -265.0), new KeyValue(botButton.layoutYProperty(), 15.0),
						new KeyValue(soundButton.layoutYProperty(), 15.0), new KeyValue(returnButton.layoutYProperty(), 15.0),
						new KeyValue(exitButton.layoutYProperty(), 15.0)),
				new KeyFrame(new Duration(100), new KeyValue(menuBackground.layoutYProperty(), -335.0), new KeyValue(botButton.layoutYProperty(), -50.0),
						new KeyValue(soundButton.layoutYProperty(), -50.0), new KeyValue(returnButton.layoutYProperty(), -50.0),
						new KeyValue(exitButton.layoutYProperty(), -50.0)));
		
		//TODO Added by zxn 4-7 new-2
		botButton.setOnMouseClicked(new EventHandler<MouseEvent>() { // Bot Difficulty
			@Override
			public void handle(MouseEvent event) {
				int botNum=Manager.getKernel().getNumPlayers()-1;
				//Create bot difficulty dialog
				InnerDialog botDiffDialog=new InnerDialog(400,50*botNum+80);
				final ArrayList<ChoiceBox<String>> botDiffs=new ArrayList<ChoiceBox<String>>();
				int offset=50;
				GamePlayer[] players=Manager.getKernel().getPlayers();
				for (int i=0;i<botNum;i++) {
					Text t1 = new Text("Bot "+(i+1));
					t1.setFont(GUIManager.font);
					t1.setLayoutX(50);
					t1.setLayoutY(offset);
					botDiffDialog.getChildren().add(t1);
					
					final ChoiceBox<String> botDiff = new ChoiceBox<String>();
					botDiff.getItems().addAll("Easy","Normal","Hard");
					RandBot bot=(RandBot)players[i+1];
					if (bot.difficulty==Difficulty.EASY)
						botDiff.getSelectionModel().selectFirst();
					else if (bot.difficulty==Difficulty.NORMAL)
						botDiff.getSelectionModel().select(1);
					else
						botDiff.getSelectionModel().select(2);
					botDiff.setLayoutX(203);
					botDiff.setLayoutY(offset-27);
					botDiff.setStyle(GUIManager.style);
					botDiffDialog.getChildren().add(botDiff);
					botDiffs.add(botDiff);
					
					offset+=45;
				}
				offset-=15;
				Button btn = new Button("OK");
				btn.setFont(GUIManager.font);
				btn.setLayoutX(165);
				btn.setLayoutY(offset);		
				final int bn=botNum;
				final InnerDialog dlg=botDiffDialog;
				btn.setOnMouseClicked(new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent event) {
						Difficulty[] diffs=new Difficulty[bn];
						for (int i=0;i<bn;i++) {
							if (botDiffs.get(i).getSelectionModel().getSelectedItem().equals("Normal"))
								diffs[i]=Difficulty.NORMAL;
							if (botDiffs.get(i).getSelectionModel().getSelectedItem().equals("Hard"))
								diffs[i]=Difficulty.HARD;
							if (botDiffs.get(i).getSelectionModel().getSelectedItem().equals("Easy"))
								diffs[i]=Difficulty.EASY;
							Manager.getKernel().setAIDifficulty(i+1, diffs[i]);
						
						}
						dlg.setVisible(false);
							
					}
				});
					
				btn.setOnKeyPressed(new EventHandler<KeyEvent>() {
					@Override
					public void handle(KeyEvent event) {
						if (event.getCode().equals(KeyCode.ENTER)) {
								Difficulty[] diffs=new Difficulty[bn];
							for (int i=0;i<bn;i++) {
								if (botDiffs.get(i).getSelectionModel().getSelectedItem().equals("Normal"))
									diffs[i]=Difficulty.NORMAL;
								if (botDiffs.get(i).getSelectionModel().getSelectedItem().equals("Hard"))
									diffs[i]=Difficulty.HARD;
								if (botDiffs.get(i).getSelectionModel().getSelectedItem().equals("Easy"))
									diffs[i]=Difficulty.EASY;
									Manager.getKernel().setAIDifficulty(i+1, diffs[i]);

								}
							dlg.setVisible(false);
						}
					}
				});

				botDiffDialog.getChildren().add(btn);
					
				
				gm.getChildren().add(botDiffDialog);
				botDiffDialog.setLayoutX(50);
				botDiffDialog.setLayoutY(50);
				botDiffDialog.setVisible(true);
					
			} 
		});
		

//TODO Original Version		
//		gm = this;
//		ImageView menuBackground = new ImageView(ResManager.getImage("bg.png"));
//		menuBackground.setScaleX(0.4f);	//0.4f
//		menuBackground.setScaleY(0.15f);
//		menuBackground.setLayoutX(-50.0);	//-50
//		// menuBackground.setLayoutY(-255.0);
//		menuBackground.setLayoutY(-335.0);
//		if (GUIManager.enableDropShadowEffect)
//			menuBackground.setEffect(new DropShadow());
//		Rectangle mask = new Rectangle(600, 600);	
//		mask.setArcWidth(50);
//		mask.setArcHeight(133.3);
//		menuBackground.setClip(mask);
//		menuBackground.setOpacity(0.85f);
//		this.getChildren().add(menuBackground);
//
//		final Button soundButton = new Button();
//		soundButton.setGraphic(new ImageView(ResManager.getImage("img_sound.png")));
//		soundButton.setLayoutX(150.0);
//		// optionButton.setLayoutY(20.0);
//		soundButton.setLayoutY(-50.0);
//		setButtonEffect(soundButton);
//		this.getChildren().add(soundButton);
//
//		Button returnButton = new Button();
//		returnButton.setGraphic(new ImageView(ResManager.getImage("img_return.png")));
//		returnButton.setLayoutX(220.0);
//		// returnButton.setLayoutY(20.0);
//		returnButton.setLayoutY(-50.0);
//		setButtonEffect(returnButton);
//		this.getChildren().add(returnButton);
//
//		Button exitButton = new Button();
//		exitButton.setGraphic(new ImageView(ResManager.getImage("img_exit.png")));
//		exitButton.setLayoutX(290.0);
//		// exitButton.setLayoutY(20.0);
//		exitButton.setLayoutY(-50.0);
//		setButtonEffect(exitButton);
//		this.getChildren().add(exitButton);
//
//		final Timeline down = new Timeline();
//		down.getKeyFrames().addAll(
//				new KeyFrame(Duration.ZERO, new KeyValue(menuBackground.layoutYProperty(), -335.0), new KeyValue(
//						soundButton.layoutYProperty(), -50.0), new KeyValue(returnButton.layoutYProperty(), -50.0),
//						new KeyValue(exitButton.layoutYProperty(), -50.0)),
//				new KeyFrame(new Duration(100), new KeyValue(menuBackground.layoutYProperty(), -265.0), new KeyValue(
//						soundButton.layoutYProperty(), 15.0), new KeyValue(returnButton.layoutYProperty(), 15.0),
//						new KeyValue(exitButton.layoutYProperty(), 15.0)));
//
//		final Timeline up = new Timeline();
//		up.getKeyFrames().addAll(
//				new KeyFrame(Duration.ZERO, new KeyValue(menuBackground.layoutYProperty(), -265.0), new KeyValue(
//						soundButton.layoutYProperty(), 15.0), new KeyValue(returnButton.layoutYProperty(), 15.0),
//						new KeyValue(exitButton.layoutYProperty(), 15.0)),
//				new KeyFrame(new Duration(100), new KeyValue(menuBackground.layoutYProperty(), -335.0), new KeyValue(
//						soundButton.layoutYProperty(), -50.0), new KeyValue(returnButton.layoutYProperty(), -50.0),
//						new KeyValue(exitButton.layoutYProperty(), -50.0)));
//TODO End
		
		this.setOnMouseEntered(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				gm.toFront();
				down.play();
			}
		});

		this.setOnMouseExited(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				up.play();
			}
		});

		soundButton.setOnMouseClicked(new EventHandler<MouseEvent>() { // Sound
					@Override
					public void handle(MouseEvent event) {
						if (GUIManager.bgMusic.isPlaying()) {
							soundButton.setGraphic(new ImageView(ResManager.getImage("img_no_sound.png")));
							GUIManager.bgMusic.stop();
						} else {
							soundButton.setGraphic(new ImageView(ResManager.getImage("img_sound.png")));
							GUIManager.bgMusic.play(GUIManager.volumn);
						}
					}
				});

		returnButton.setOnMouseClicked(new EventHandler<MouseEvent>() { // Return
																		// to
																		// main
																		// menu
					@Override
					public void handle(MouseEvent event) {
						Manager.getGUI().restart();
					}
				});

		exitButton.setOnMouseClicked(new EventHandler<MouseEvent>() { // Exit
																		// Game
					@Override
					public void handle(MouseEvent event) {
						MainBackGround.quit();
					}
				});
		if (GUIManager.enableDropShadowEffect)
			this.setEffect(new DropShadow());
	}

	public static void setButtonEffect(Button btn) {
		btn.setStyle("-fx-base: #e9cf9e;");
		if (GUIManager.enableDropShadowEffect)
			btn.setEffect(new DropShadow());
		btn.setOpacity(0.6f);
	}

}
