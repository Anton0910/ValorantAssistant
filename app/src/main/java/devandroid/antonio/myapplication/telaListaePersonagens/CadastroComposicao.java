package devandroid.antonio.myapplication.telaListaePersonagens;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import devandroid.antonio.myapplication.R;

public class CadastroComposicao extends AppCompatActivity {

    EditText duelista;
    EditText iniciador;
    EditText controlador;
    EditText sentinela;
    EditText flexivel;

    Button btn_cadastro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_composicao);
        duelista = findViewById(R.id.editTextTextPersonName);
        iniciador = findViewById(R.id.editTextTextPersonName2);
        controlador = findViewById(R.id.editTextTextPersonName3);
        sentinela = findViewById(R.id.editTextTextPersonName4);
        flexivel = findViewById(R.id.editTextTextPersonName5);
        btn_cadastro = findViewById(R.id.button);

        btn_cadastro.setOnClickListener(view -> {
            Intent intent = new Intent(this,TelaComposicoes.class);
            intent.putExtra("cadastroPendente",true);
            intent.putExtra("iniciador",iniciador.getText().toString());
            intent.putExtra("controlador",controlador.getText().toString());
            intent.putExtra("sentinela",sentinela.getText().toString());
            intent.putExtra("flexivel",flexivel.getText().toString());
            intent.putExtra("duelista",duelista.getText().toString());
            startActivity(intent);


        });


    }
}