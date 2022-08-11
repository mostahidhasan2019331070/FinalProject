package sample;
import com.TracPro.gui.login.LoginViewController;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = LoginViewController.getRoot();
        primaryStage.setTitle("TracPro");
        primaryStage.setScene(new Scene(root));
        primaryStage.getIcons().add(new Image("/com/TracPro/gui/resources/TracPro-Icon.png"));
        primaryStage.show();
        primaryStage.setResizable(false);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
