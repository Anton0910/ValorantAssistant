package devandroid.antonio.myapplication.telaListaePersonagens;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

import devandroid.antonio.myapplication.R;
import devandroid.antonio.myapplication.TelaInicial;
import devandroid.antonio.myapplication.classes.AdapterPersonagens;
import devandroid.antonio.myapplication.classes.Personagens;
import devandroid.antonio.myapplication.mapas;


public class Tela_Personagens extends AppCompatActivity implements AdapterPersonagens.Onclick {

    private String Nomepersonagem;

    private String descricao;


    private List<Personagens> personagensList = new ArrayList<>();


    private RecyclerView rvPersonagens;
    private AdapterPersonagens adapterPersonagem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_personagens);

        rvPersonagens = findViewById(R.id.rvPersonagens);
        carregaLista();
        configRecyclerView();

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_nav);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();

                if (itemId == R.id.menu_button3) {
                    // Abrir outra tela aqui
                    Intent intent = new Intent(Tela_Personagens.this, TelaComposicoes.class);
                    startActivity(intent);
                    return true;
                }

                if (itemId == R.id.menu_button1) {
                    // Abrir outra tela aqui
                    Intent intent = new Intent(Tela_Personagens.this, devandroid.antonio.myapplication.mapas.class);
                    startActivity(intent);
                    return true;
                }

                if (itemId == R.id.menu_button2) {
                    // Abrir outra tela aqui
                    Intent intent = new Intent(Tela_Personagens.this, Tela_Personagens.class);
                    startActivity(intent);
                    return true;
                }

                return false;
            }
        });
    }

    private void carregaLista(){
        Personagens personagens1 = new Personagens();
        Personagens personagens2 = new Personagens();
        Personagens personagens3 = new Personagens();
        Personagens personagens4 = new Personagens();
        Personagens personagens5 = new Personagens();
        Personagens personagens6 = new Personagens();
        Personagens personagens7 = new Personagens();
        personagens1.setNome("Jett");
        personagens2.setNome("Sova");
        personagens3.setNome("Omen");
        personagens4.setNome("Sage");
        personagens5.setNome("Chypher");
        personagens6.setNome("Raze");
        personagens7.setNome("Fade");
        personagensList.add(personagens1);
        personagensList.add(personagens2);
        personagensList.add(personagens3);
        personagensList.add(personagens4);
        personagensList.add(personagens5);
        personagensList.add(personagens6);
        personagensList.add(personagens7);
    }

    private void configRecyclerView(){
        rvPersonagens.setLayoutManager(new LinearLayoutManager(this));
        rvPersonagens.setHasFixedSize(true);
        adapterPersonagem = new AdapterPersonagens(personagensList, this);
        rvPersonagens.setAdapter(adapterPersonagem);
    }


    @Override
    public void onClickListerner(Personagens personagens) {
            Nomepersonagem = personagens.getNome();
            Intent intent = new Intent(this, DescricaoPersonagens.class);
            intent.putExtra("nome_personagem",Nomepersonagem);
            startActivity(intent);
    }

    public static class mapas extends AppCompatActivity {

        ImageView img;

        int drawable;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_mapas);
            img = findViewById(R.id.imageView4);
            drawable = R.drawable.img_3;
            img.setImageResource(drawable);
        }
    }
}