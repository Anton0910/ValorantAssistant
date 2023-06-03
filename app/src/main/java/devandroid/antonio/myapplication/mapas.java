package devandroid.antonio.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import devandroid.antonio.myapplication.telaListaePersonagens.TelaComposicoes;
import devandroid.antonio.myapplication.telaListaePersonagens.Tela_Personagens;


public class mapas extends AppCompatActivity {

    ImageView img;

    int drawable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapas);
        img = findViewById(R.id.imageView4);
        drawable = R.drawable.img_3;
        img.setImageResource(drawable);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_nav);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();

                if (itemId == R.id.menu_button3) {
                    // Abrir outra tela aqui
                    Intent intent = new Intent(mapas.this, TelaComposicoes.class);
                    startActivity(intent);
                    return true;
                }

                if (itemId == R.id.menu_button1) {
                    // Abrir outra tela aqui
                    Intent intent = new Intent(mapas.this, mapas.class);
                    startActivity(intent);
                    return true;
                }

                if (itemId == R.id.menu_button2) {
                    // Abrir outra tela aqui
                    Intent intent = new Intent(mapas.this, Tela_Personagens.class);
                    startActivity(intent);
                    return true;
                }

                return false;
            }
        });
    }
}