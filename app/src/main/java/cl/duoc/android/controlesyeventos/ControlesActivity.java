package cl.duoc.android.controlesyeventos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class ControlesActivity extends AppCompatActivity {

    private CompoundButton.OnCheckedChangeListener checkedChangeListener
            = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
            if(isChecked) {
                // botón activado
                mostrarToast("Botón activado");
            } else {
                // botón desactivado
                mostrarToast("Botón desactivado");
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_controles);

        // Eventos
        // #################################

        // ToggleButton
        ToggleButton toggleButton = (ToggleButton) findViewById(R.id.toggleButton);
        toggleButton.setOnCheckedChangeListener(checkedChangeListener);

        // Switch
        Switch aSwitch = (Switch) findViewById(R.id.switch1);
        aSwitch.setOnCheckedChangeListener(checkedChangeListener);

        // SeekBar
        SeekBar seekBar = (SeekBar) findViewById(R.id.seekBar);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            /**
             *
             * @param seekBar
             * @param progress por defecto de 0 a 100
             * @param fromUser boolean: True if the progress change was initiated by the user.
             */
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                String s = String.format("Progreso de %d%%", progress);
                TextView tvPorcentaje = (TextView) findViewById(R.id.tvPorcentaje);
                tvPorcentaje.setText(s);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        // RatingBar
        RatingBar ratingBar = (RatingBar) findViewById(R.id.ratingBar);
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            /**
             *
             * @param ratingBar
             * @param rating
             * @param fromUser si el cambio de rating fue iniciado por el usuario
             */
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                String s = String.format("Evaluación del usuario: %.1f", rating);
                TextView tvRating = (TextView) findViewById(R.id.tvRating);
                tvRating.setText(s);
            }
        });
    }

    // Para ejecutar a través de XML con onClick
    public void onClickButton(View v) {
        Log.v("manejoEvento()", "Se ha llamado a manejoEvento()");
        mostrarToast(String.format("Has pinchado el elemento con ID:%s", v.getId() ));
    }

    private void mostrarToast(String s) {
        Toast.makeText(ControlesActivity.this, s, Toast.LENGTH_SHORT).show();
    }

    public void onClickCheckBox(View v) {
        switch (v.getId()) {
            case R.id.cbDeportes:
                mostrarToast("Preferencia: Deportes");
                break;
            case R.id.cbViajes:
                mostrarToast("Preferencia: Viajes");
                break;
            case R.id.cbLectura:
                mostrarToast("Preferencia: Lectura");
                break;
            default:
                break;
        }
    }

    public void onClickRadio(View v) {
        switch (v.getId()) {
            case R.id.radioNegro:
                mostrarToast("Escogiste el color NEGRO");
                break;
            case R.id.radioRojo:
                mostrarToast("Escogiste el color ROJO");
                break;
            case R.id.radioVerde:
                mostrarToast("Escogiste el color VERDE");
                break;
            default:
                break;
        }
    }
}
