package devandroid.antonio.myapplication.telaListaePersonagens;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.os.Bundle;
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

        listViewDados = findViewById(R.id.listViewDados);

        criarBancoDados();
        inserirDadosTemp();
        listarDados();
    }

    public void criarBancoDados() {
        try {
            bancoDados = openOrCreateDatabase("comps", MODE_PRIVATE, null);
            bancoDados.execSQL("CREATE TABLE IF NOT EXISTS comps(" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "nome VARCHAR(30)," +
                    "atributo3 VARCHAR(30)," +
                    "atributo4 VARCHAR(30)," +
                    "atributo5 VARCHAR(30))");
            bancoDados.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void listarDados() {
        try {
            bancoDados = openOrCreateDatabase("comps", MODE_PRIVATE, null);
            Cursor meuCursor = bancoDados.rawQuery("SELECT * FROM comps;", null);
            ArrayList<String> linhas = new ArrayList<>();

            meuCursor.moveToFirst();
            while (!meuCursor.isAfterLast()) {
                int id = meuCursor.getInt(0);
                String nome = meuCursor.getString(1);
                String atributo3 = meuCursor.getString(2);
                String atributo4 = meuCursor.getString(3);
                String atributo5 = meuCursor.getString(4);
                linhas.add("ID: " + id + ", Nome: " + nome + ", Atributo 3: " + atributo3 + ", Atributo 4: " + atributo4 + ", Atributo 5: " + atributo5);
                meuCursor.moveToNext();
            }

            ArrayAdapter<String> meuAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, linhas);
            listViewDados.setAdapter(meuAdapter);

            meuCursor.close();
            bancoDados.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void inserirDadosTemp() {
        try {
            bancoDados = openOrCreateDatabase("comps", MODE_PRIVATE, null);
            String sql = "INSERT INTO comps (nome, atributo3, atributo4, atributo5) VALUES (?, ?, ?, ?)";
            SQLiteStatement stmt = bancoDados.compileStatement(sql);

            stmt.bindString(1, "coisa 1");
            stmt.bindString(2, "valor atributo 3");
            stmt.bindString(3, "valor atributo 4");
            stmt.bindString(4, "valor atributo 5");
            stmt.execute();

            stmt.bindString(1, "coisa abc");
            stmt.bindString(2, "valor abc atributo 3");
            stmt.bindString(3, "valor abc atributo 4");
            stmt.bindString(4, "valor abc atributo 5");
            stmt.execute();

            stmt.bindString(1, "coisa terceira");
            stmt.bindString(2, "valor terceiro atributo 3");
            stmt.bindString(3, "valor terceiro atributo 4");
            stmt.bindString(4, "valor terceiro atributo 5");
            stmt.execute();

            bancoDados.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
