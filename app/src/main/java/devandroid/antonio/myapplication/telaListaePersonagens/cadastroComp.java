package devandroid.antonio.myapplication.telaListaePersonagens;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import devandroid.antonio.myapplication.R;

public class cadastroComp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_comp);

        Button button = (Button) findViewById(R.id.buttonVoltar);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Ação a ser executada quando o botão for clicado
                Intent intent = new Intent(cadastroComp.this, TelaComposicoes.class);
                intent.putExtra("cadastroPendente", true);
                startActivity(intent);
            }
        });
    }
}