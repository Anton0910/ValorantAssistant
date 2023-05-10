package devandroid.antonio.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class Registro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        EditText editNome = findViewById(R.id.editTextTextPersonName);
        EditText editSenha = findViewById(R.id.editTextTextPassword);
        EditText editSenhaConfirmar = findViewById(R.id.editTextTextPassword3);
        Button btnRegister = findViewById(R.id.button);
        Button btnVoltar = findViewById(R.id.button2);

        btnRegister.setOnClickListener(view -> {
            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);
        });

        btnVoltar.setOnClickListener(view -> {
            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);
        });
    }
}