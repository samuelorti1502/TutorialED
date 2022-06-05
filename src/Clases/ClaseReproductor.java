package Clases;

//Se importan las librerias utilizadas
import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.Label;
import java.awt.Toolkit;
import java.io.File;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.media.Media;
import javafx.scene.media.MediaException;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.util.Duration;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;

/**
 *
 * @author geovany
 */
public class ClaseReproductor {

    private JFXPanel jfxPanel;
    private JPanel jpanel;
    private MediaPlayer mediaPlayer;
    private Media media;
    private MediaView view;
    private Scene escena;
    private File file;
    private String ruta;

    public ClaseReproductor() {
        this.jfxPanel = new JFXPanel();
    }

    /**
     * @param ruta the ruta to set
     */
    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    /**
     * @param jpanel the jpanel to set
     */
    public void setJpanel(JPanel jpanel) {
        this.jpanel = jpanel;
    }

    public void reproducir() {
        try {
            getMediaPlayer().play();
        } catch (MediaException e) {
            System.out.println(e.getMessage());
        }
    }

    public void pausar() {
        try {
            getMediaPlayer().pause();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void parar() {
        try {
            getMediaPlayer().stop();
        } catch (MediaException e) {
            System.out.println(e.getMessage());
        }
    }

    public void setVolumen(double value) {
        try {
            getMediaPlayer().setVolume(value);
        } catch (Exception e) {
        }
    }

    /**
     * @return the mediaPlayer
     */
    public MediaPlayer getMediaPlayer() {
        return mediaPlayer;
    }

    public void mostrarVideo() {
        try {
            int x = this.jpanel.getHeight();
            int y = this.jpanel.getWidth();

            this.file = new File(this.ruta);

            this.media = new Media(this.file.toURI().toString());
            media.setOnError(() -> System.out.println("Media: " + media.getError().getMessage()));

            this.mediaPlayer = new MediaPlayer(this.media);
            mediaPlayer.setOnError(() -> System.out.println("MediaPlayer: " + mediaPlayer.getError().getMessage()));

            this.view = new MediaView(this.getMediaPlayer());
            this.view.setFitHeight(x);
            this.view.setFitWidth(y);

            escena = new Scene(new Group(view));
            jfxPanel.removeAll();
            jfxPanel.setSize(this.jpanel.getSize());
            jfxPanel.setScene(escena);
            getMediaPlayer().setCycleCount(MediaPlayer.INDEFINITE);

            this.jpanel.setLayout(new BorderLayout());
            this.jpanel.add(jfxPanel, BorderLayout.CENTER);
            this.jpanel.updateUI();
            
        } catch (MediaException e) {
            JOptionPane.showMessageDialog(null, "Solo puede reproducir videos MP4", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().
                getImage(ClassLoader.getSystemResource("img/logo pro.png"));

        return retValue;
    }

    public void sliderTime(JLabel label1, JLabel label2, JSlider sliderT) {
        Slider slider_time = new Slider();
        //Label actual_time = new Label("0");
        //Label total_time = new Label("0");

        mediaPlayer.setOnReady(() -> {

            // obtener metadatos, si existen
            media.getMetadata().forEach((k, v) -> System.out.println(k + ", " + v));
            
            System.out.println(mediaPlayer.getTotalDuration().toMinutes());
            
            label2.setText(String.format("%.2f", mediaPlayer.getTotalDuration().toMinutes()));     
            sliderT.setMaximum((int) mediaPlayer.getTotalDuration().toSeconds());
            
            slider_time.valueProperty().addListener((p, o, value) -> {
                if (sliderT.isCursorSet()) {
                    mediaPlayer.seek(Duration.seconds(value.doubleValue()));
                }
            });

            mediaPlayer.currentTimeProperty().addListener((p, o, value) -> {
                sliderT.setValue((int) value.toSeconds());
                label1.setText(String.format("%.2f", value.toMinutes()));
            });
        });
    }
}
