package cl.duoc.android.controlesyeventos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

public class EventoTextChanged extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evento_text_changed);
        EditText et = (EditText) findViewById(R.id.editText);
        et.addTextChangedListener(new TextWatcher() {

            // Método que se lanza antes de cambiar el texto
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            // Método que se lanza cuando el texto cambia
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                TextView tv = (TextView) findViewById(R.id.textView);
                tv.setText(charSequence.toString());
            }

            // Método que se lanza cuando el texto cambia. La diferencia con el método anterior
            // es que la variable es modificable
            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }
}
