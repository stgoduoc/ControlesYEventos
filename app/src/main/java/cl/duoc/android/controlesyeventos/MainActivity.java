package cl.duoc.android.controlesyeventos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private void goToActivity(Class cls) {
        Intent intent = new Intent(MainActivity.this, cls);
        startActivity(intent);
    }

    // Forma 1.1 - Clase anónima - para manejar eventos
    public View.OnClickListener ocl = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            goToActivity(EventoTextChanged.class);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // Forma 3 para para manejar eventos
    public void mostrarToast(View view) {
        Log.v("mostrarToast", "Mostrando TOAST");
        Toast.makeText(MainActivity.this, "Texto para mostrar en Toast", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onClick(View view) {
        Log.v("onClick:", "View ID: "+view.getId());
        switch (view.getId()) {
            case R.id.btnTextChanged:
                goToActivity(EventoTextChanged.class);
                break;
            case R.id.btnMenuContextual:
                goToActivity(MenuContextual.class);
                break;
            case R.id.btnControles:
                goToActivity(ControlesActivity.class);
                break;
            default:
                break;
        }
    }


}
