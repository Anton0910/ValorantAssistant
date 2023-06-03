package devandroid.antonio.myapplication;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import devandroid.antonio.myapplication.telaListaePersonagens.TelaComposicoes;
import devandroid.antonio.myapplication.telaListaePersonagens.Tela_Personagens;


public class TelaInicial extends AppCompatActivity  {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_inicial);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_nav);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();

                if (itemId == R.id.menu_button3) {
                    // Abrir outra tela aqui
                    Intent intent = new Intent(TelaInicial.this, TelaComposicoes.class);
                    startActivity(intent);
                    return true;
                }

                if (itemId == R.id.menu_button1) {
                    // Abrir outra tela aqui
                    Intent intent = new Intent(TelaInicial.this, mapas.class);
                    startActivity(intent);
                    return true;
                }

                if (itemId == R.id.menu_button2) {
                    // Abrir outra tela aqui
                    Intent intent = new Intent(TelaInicial.this, Tela_Personagens.class);
                    startActivity(intent);
                    return true;
                }

                return false;
            }
        });




    }





}