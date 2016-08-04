package sample;

import Geometry.GeometricObject;
import Language.Sentence;
import Launcher.Driver;
import javafx.animation.FadeTransition;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Controller implements Initializable {
	public ListView<String> rightListView;
	public Button buttonStartRayTrace;
	public ProgressBar rayTraceProgress;
	public ImageView imagePane;
	public Button forceUpdateButton;
	public TextField textField;
	private ControllerConverter controllerConverter;
	private boolean locked;

	private ObservableList<String>  items;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		items = FXCollections.observableArrayList("One Sphere", "Two Spheres", "Three Spheres", "Three Spheres and Plane");
		rightListView.setItems(items);
		controllerConverter = new ControllerConverter();
		locked = false;
	}

	public void listViewMouseClicked(Event event) {
		rayTraceProgress.setProgress(0);
	}

	public void buttonStartRayTrace(ActionEvent actionEvent) {
		ArrayList<GeometricObject> geometricObjects = controllerConverter.getObjectWorld(rightListView.getSelectionModel().getSelectedItem());
		rightListView.setDisable(true);
		Driver driver = new Driver();
		Task<Integer> task = new Task<Integer>() {
			@Override
			protected Integer call() throws Exception {
				try {
					Utility.Image tempImage = driver.writeToFile(rayTraceProgress, geometricObjects);
					Platform.runLater(() -> {
						Image tempImageFx = SwingFXUtils.toFXImage(tempImage.buffer, null);
						FadeTransition fadeTransition = new FadeTransition(Duration.millis(500), imagePane);
						fadeTransition.setFromValue(1.0);
						fadeTransition.setToValue(0);
						fadeTransition.play();


						fadeTransition.setOnFinished(event -> {
							imagePane.setImage(tempImageFx);

							FadeTransition fadeTrans = new FadeTransition(Duration.millis(500), imagePane);
							fadeTrans.setFromValue(0.0);
							fadeTrans.setToValue(1.0);
							fadeTrans.play();
						});
					});
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Setting enabled");
				Platform.runLater(() -> rightListView.setDisable(false));
				return 0;
			}
		};
		Thread thread = new Thread(task);
		thread.start();
	}

	public void forceUpdateImage(ActionEvent actionEvent) {
		Platform.runLater(() -> imagePane.setImage(new Image("image.png")));

	}

	public void onEnterPressedTextField(ActionEvent actionEvent) {
		Sentence sentence = new Sentence(textField.getText());
		sentence.classify();
		sentence.removeUnclassified();
		items.add(sentence.toString());
		rightListView.setItems(items);
	}

}

