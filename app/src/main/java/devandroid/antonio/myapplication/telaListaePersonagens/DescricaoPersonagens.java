package devandroid.antonio.myapplication.telaListaePersonagens;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import devandroid.antonio.myapplication.R;

public class DescricaoPersonagens extends AppCompatActivity {
    ImageView img;

    int drawable;

    TextView Nomepersonagem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descricao_personagens);
        String nome = (String) getIntent().getSerializableExtra("nome_personagem");
        Nomepersonagem = findViewById(R.id.textView2);
        if (nome.equals("Sova")){
            Nomepersonagem.setText("Sova");
            img = findViewById(R.id.imageView4);
            drawable = R.drawable.img_1;
            img.setImageResource(drawable);
        }
    }
}