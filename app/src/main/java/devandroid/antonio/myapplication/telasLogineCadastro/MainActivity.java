package devandroid.antonio.myapplication.telasLogineCadastro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import devandroid.antonio.myapplication.R;
import devandroid.antonio.myapplication.TelaInicial;
import devandroid.antonio.myapplication.helper.FirebaseHelper;
import devandroid.antonio.myapplication.telaListaePersonagens.TelaComposicoes;
import devandroid.antonio.myapplication.telasLogineCadastro.Registro;

public class MainActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;

    boolean valida;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText editSenha = findViewById(R.id.editTextTextPassword);
        EditText editEmail = findViewById(R.id.editTextTextEmailAddress2);
        Button btnLog = findViewById(R.id.button);
        Button btnRegister = findViewById(R.id.button2);
        mAuth = FirebaseAuth.getInstance();



        btnLog.setOnClickListener(view -> {
            String email = editEmail.getText().toString();
            String senha = editSenha.getText().toString();

            if(email.equals(""))
            {
                valida = false;
                editEmail.requestFocus();
                editEmail.setError("Informe seu email");
            }else
                valida = true;

            if(senha.equals(""))
            {
                valida = false;
                editSenha.requestFocus();
                editSenha.setError("Informe sua senha");
            }else
                valida = true;

            if (valida == true){
                validaLogin(email,senha);
            }


        });


        btnRegister.setOnClickListener(view -> {

            Intent intent = new Intent(this, Registro.class);
            startActivity(intent);

        });
    }

    private void validaLogin(String email, String senha){
        FirebaseHelper.getAuth().signInWithEmailAndPassword(
            email,senha
        ).addOnCompleteListener(task -> {
            if (task.isSuccessful()){
                finish();
                Intent intent = new Intent(this, TelaInicial.class);
                startActivity(intent);
            }else {
                String error = task.getException().getMessage();
                Toast.makeText(this,error,Toast.LENGTH_SHORT).show();
            }
        });
    }


}