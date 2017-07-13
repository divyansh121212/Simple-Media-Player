package sample;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.FileChooser;

import java.io.File;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class Controller implements Initializable{

        @FXML
        private MediaView mv;

       private MediaPlayer mp;
       private Media me;
    @FXML
    private TextField findtext;

    @FXML
    private Button selectbutton;
    @FXML
    private Button playb;

    @FXML
    private Button pauseb;

    @FXML
    private Button reloadb;

    @FXML
    private Button slowb;

    @FXML
    private Button fastb;

    @FXML
    private Button startb;

    @FXML
    private Button lastb;

    @FXML
    void fast(ActionEvent event) {
mp.setRate(2);
    }

    @FXML
    void last(ActionEvent event) {
mp.seek(mp.getStartTime());
    mp.stop();
    }
int x=0;
    @FXML
    void pause(ActionEvent event) {
if(x==0)
{ mp.pause(); x=1;}
else if(x==1)
{mp.play(); x=0;}
    }


    @FXML
    void reload(ActionEvent event) {
mp.seek(mp.getStartTime());
mp.play();
    }

    @FXML
    void slow(ActionEvent event) {
mp.setRate(.5);
    }
@FXML
void normal(ActionEvent event){mp.setRate(1);}
    @FXML
    void start(ActionEvent event) {
mp.seek(mp.getStartTime());
mp.stop();
    }
    String ffff = new File("src/sample/media/JavaFX Splash Screen - Welcome Screen  (Inside Same Window).mp4").getAbsolutePath();
    ;
    @FXML
    void select(ActionEvent event){
        FileChooser fc=new FileChooser();
        File selectedfile = fc.showOpenDialog(null);
        fc.setInitialDirectory(new File("C:/Users/com/Downloads"));
        if(selectedfile!=null) {
            findtext.setText(selectedfile.getName());
     ffff=new File(selectedfile.getAbsolutePath()).getAbsolutePath();
        }
        else{
            ffff = new File("src/sample/media/JavaFX Splash Screen - Welcome Screen  (Inside Same Window).mp4").getAbsolutePath();
        }
    }

       @Override
    public void initialize(URL location, ResourceBundle resources) {
String path = new File("src/sample/media/JavaFX Splash Screen - Welcome Screen  (Inside Same Window).mp4").getAbsolutePath();
me = new Media(new File(ffff).toURI().toString());
mp =new MediaPlayer(me);
mv.setMediaPlayer(mp);
mp.setAutoPlay(true);
        DoubleProperty width=mv.fitWidthProperty();
        DoubleProperty height=mv.fitHeightProperty();
        width.bind(Bindings.selectDouble(mv.sceneProperty(),"width"));
        height.bind(Bindings.selectDouble(mv.sceneProperty(),"height"));
    }
String lll="SFF";
    public void play(ActionEvent actionEvent) {
          mp.stop();
        me = new Media(new File(ffff).toURI().toString());
        mp =new MediaPlayer(me);
        mv.setMediaPlayer(mp);
        mp.setAutoPlay(true);
        DoubleProperty width=mv.fitWidthProperty();
        DoubleProperty height=mv.fitHeightProperty();
        width.bind(Bindings.selectDouble(mv.sceneProperty(),"width"));
        height.bind(Bindings.selectDouble(mv.sceneProperty(),"height"));
        lll=ffff;
mp.play();
mp.setRate(1);

    }
}
