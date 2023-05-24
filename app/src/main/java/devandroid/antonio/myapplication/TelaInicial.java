package devandroid.antonio.myapplication;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.bottomappbar.BottomAppBar;


public class TelaInicial extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_inicial);
        Toolbar toolbar = findViewById(R.id.toolbar);


    }
    public void buttonMapas(MenuItem item) {
        // Lógica para tratar o clique no item "COMPS"
        Intent intent = new Intent();
        startActivity(intent);
    }

    public void buttonPersonagens(MenuItem item) {
        // Lógica para tratar o clique no item "PERSONAGENS"
        Intent intent = new Intent();
        startActivity(intent);
    }

    public void buttonComps(MenuItem item) {
        // Lógica para tratar o clique no item "COMPS"
        Intent intent = new Intent();
        startActivity(intent);
    }
}