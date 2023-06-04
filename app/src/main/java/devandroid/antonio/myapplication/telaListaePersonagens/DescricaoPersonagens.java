package devandroid.antonio.myapplication.telaListaePersonagens;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import devandroid.antonio.myapplication.R;

public class DescricaoPersonagens extends AppCompatActivity {
    ImageView img;

    int drawable;

    TextView Nomepersonagem;

    TextView texto;
    TextView funcao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descricao_personagens);
        String nome = (String) getIntent().getSerializableExtra("nome_personagem");
        Nomepersonagem = findViewById(R.id.textView2);
        texto = findViewById(R.id.textView3);
        funcao = findViewById(R.id.textView);
        if (nome.equals("Sova")){
            Nomepersonagem.setText("Sova");
            img = findViewById(R.id.imageView4);
            drawable = R.drawable.img_1;
            img.setImageResource(drawable);
            funcao.setText("Iniciador");
            texto.setText("Nascido sob o eterno inverno das tundras russas, Sova rastreia, encontra e elimina inimigos com eficiência e precisão implacáveis. Seu arco personalizado e suas habilidades inigualáveis de reconhecimento garantem que nenhuma presa escape.");
        }

        if (nome.equals("Jett")){
            Nomepersonagem.setText("Jett");
            img = findViewById(R.id.imageView4);
            drawable = R.drawable.imgjett_2;
            img.setImageResource(drawable);
            funcao.setText("Duelista");
            texto.setText("Representando a Coreia do Sul, sua terra natal, Jett tem um estilo de luta ágil e evasivo que permite que ela assuma riscos como ninguém. Ela corre em meio a qualquer confronto, cortando os inimigos antes mesmo que eles percebam quem ou o que os atingiu.");
        }

        if (nome.equals("Omen")){
            Nomepersonagem.setText("Omen");
            img = findViewById(R.id.imageView4);
            drawable = R.drawable.imgomen_2;
            img.setImageResource(drawable);
            funcao.setText("Controlador");
            texto.setText("Omen, uma lembrança fantasmagórica, caça nas sombras. Ele cega os inimigos, teleporta-se pelo campo e deixa a paranoia assumir o controle enquanto o adversário tenta descobrir de onde virá seu próximo ataque.");
        }

        if (nome.equals("Sage")){
            Nomepersonagem.setText("Sage");
            img = findViewById(R.id.imageView4);
            drawable = R.drawable.imgsage_2;
            img.setImageResource(drawable);
            funcao.setText("Sentinela");
            texto.setText("Como uma verdadeira fortaleza chinesa, Sage traz segurança para si mesma e para a equipe aonde quer que vá. Capaz de reviver aliados e rechaçar investidas agressivas, ela oferece um centro de calmaria em meio ao caos da batalha.");
        }

        if (nome.equals("Chypher")){
            Nomepersonagem.setText("Chypher");
            Nomepersonagem.setTextSize(50);
            img = findViewById(R.id.imageView4);
            drawable = R.drawable.img_2;
            img.setImageResource(drawable);
            funcao.setText("Sentinela");
            texto.setText("Cypher, um vendedor de informações do Marrocos, é uma verdadeira rede de vigilância de um homem só que fica de olho em cada movimento dos inimigos. Nenhum segredo está a salvo. Nenhuma manobra passa despercebida. Cypher está sempre vigiando.");
        }

        if (nome.equals("Raze")){
            Nomepersonagem.setText("Raze");
            img = findViewById(R.id.imageView4);
            drawable = R.drawable.imgraze_4;
            img.setImageResource(drawable);
            funcao.setText("Duelista");
            texto.setText("Raze chega do Brasil em uma explosão de carisma e armas letais. Com seu estilo de jogo \"porradeiro\", ela é craque em desentocar inimigos entrincheirados e limpar espaços apertados com uma bela dose de BUUUM!");
        }

        if (nome.equals("Fade")){
            Nomepersonagem.setText("Fade");
            img = findViewById(R.id.imageView4);
            drawable = R.drawable.imgfade_4;
            img.setImageResource(drawable);
            funcao.setText("Iniciador");
            texto.setText("Fade, uma caçadora de recompensas turca, usa o poder dos pesadelos para capturar os segredos dos inimigos. Personificando o próprio terror, ela persegue os alvos e revela seus medos mais profundos para, depois, destruí-los na escuridão.");
        }


        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_nav);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();

                if (itemId == R.id.menu_button3) {
                    // Abrir outra tela aqui
                    Intent intent = new Intent(DescricaoPersonagens.this, TelaComposicoes.class);
                    startActivity(intent);
                    return true;
                }

                if (itemId == R.id.menu_button1) {
                    // Abrir outra tela aqui
                    Intent intent = new Intent(DescricaoPersonagens.this, devandroid.antonio.myapplication.mapas.class);
                    startActivity(intent);
                    return true;
                }

                if (itemId == R.id.menu_button2) {
                    // Abrir outra tela aqui
                    Intent intent = new Intent(DescricaoPersonagens.this, Tela_Personagens.class);
                    startActivity(intent);
                    return true;
                }

                return false;
            }
        });
    }
}