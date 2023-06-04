package devandroid.antonio.myapplication.telaListaePersonagens;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.strictmode.SqliteObjectLeakedViolation;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import devandroid.antonio.myapplication.R;

public class TelaComposicoes extends AppCompatActivity {

    private SQLiteDatabase bancoDados;
    private ListView listViewDados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_composicoes);

        listViewDados = (ListView) findViewById(R.id.listViewDados);

        criarBancoDados();
        listarDados();
    }

    public void criarBancoDados(){
        try {
            bancoDados = openOrCreateDatabase("comps", MODE_PRIVATE, null);
            bancoDados.execSQL("CREATE TABLE IF NOT EXISTS comps("+
                    "id INT PRIMARY KEY,"+
                    "nome VARCHAR(30))");

        }catch (Exception e){
            System.out.println("ERROR");
            e.printStackTrace();
        }
    }
    public void listarDados(){
        try {
            bancoDados = openOrCreateDatabase("comps", MODE_PRIVATE, null);
            Cursor meuCursor = bancoDados.rawQuery("SELECT id, nome FROM comps;",null);
            ArrayList<String> linhas = new ArrayList<String>();
            ArrayAdapter meuAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, linhas);
        }catch (Exception e){

        }
    }

}