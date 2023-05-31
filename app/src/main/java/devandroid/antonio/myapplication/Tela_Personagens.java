package devandroid.antonio.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;



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
    }

    private void carregaLista(){
        Personagens personagens1 = new Personagens();
        Personagens personagens2 = new Personagens();
        personagens1.setNome("Jett");
        personagens2.setNome("Sova");
        personagensList.add(personagens1);
        personagensList.add(personagens2);
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
            Intent intent = new Intent(this,DescricaoPersonagens.class);
            intent.putExtra("nome_personagem",Nomepersonagem);
            startActivity(intent);
    }
}