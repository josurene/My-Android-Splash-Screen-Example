package josu.lospinosmonitoreo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Josu on 11/11/2015.
 */
public class SplashScreenActivity extends Activity {

    // Duracion de La pantalla
    int SPLASH_SCREEN_DELAY = 1500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Conloca la orientacion en vertical
        //setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        // Esconde la barra
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.splash_screen);

        TimerTask task = new TimerTask() {
            @Override
            public void run() {

                // Comienza la proxima actividad
                Intent mainIntent = new Intent().setClass(SplashScreenActivity.this, MainActivity.class);
                startActivity(mainIntent);
                //overridePendingTransition(R.animator.entrada_derecha, R.animator.salida_izquierda);
                // cierra la actividad
                finish();
            }
        };

        // Tiempo de espera en el splash screen
        Timer timer = new Timer();
        timer.schedule(task, SPLASH_SCREEN_DELAY);

    }

}
