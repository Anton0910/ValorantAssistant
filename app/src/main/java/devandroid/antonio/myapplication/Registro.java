package devandroid.antonio.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;

import devandroid.antonio.myapplication.helper.FirebaseHelper;


public class Registro extends AppCompatActivity {
    boolean valida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        EditText editNome = findViewById(R.id.editTextTextPersonName);
        EditText editSenha = findViewById(R.id.editTextTextPassword);
        EditText editEmail = findViewById(R.id.editTextTextEmailAddress);
        EditText editSenhaConfirmar = findViewById(R.id.editTextTextPassword3);
        Button btnRegister = findViewById(R.id.button);
        Button btnVoltar = findViewById(R.id.button2);







        btnRegister.setOnClickListener(view -> {
            String nome = editNome.getText().toString();
            String email = editEmail.getText().toString();
            String password = editSenha.getText().toString();
            String Confirmpassword = editSenhaConfirmar.getText().toString();

           if(nome.equals(""))
           {
               valida = false;
               editNome.requestFocus();
               editNome.setError("Informe seu nome");
           }else
               valida = true;

            if(email.equals(""))
            {
                valida = false;
                editEmail.requestFocus();
                editEmail.setError("Informe seu email");
            }else
                valida = true;

            if(password.equals(""))
            {
                valida = false;
                editSenha.requestFocus();
                editSenha.setError("Informe sua senha");
            }else
                valida = true;






            if (valida == true){
                Usuario usuario = new Usuario();
                usuario.setNome(nome);
                usuario.setEmail(email);
                usuario.setSenha(password);

                salvarCadastro(usuario);
                Intent intent = new Intent(this,MainActivity.class);
                startActivity(intent);
            }

        });

        btnVoltar.setOnClickListener(view -> {
            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);
        });
    }


    private void salvarCadastro(Usuario usuario){
        FirebaseHelper.getAuth().createUserWithEmailAndPassword(
                usuario.getEmail(),usuario.getSenha()//FAZ O CADASTRO DO USUARIO
        ).addOnCompleteListener(task -> {
            if(task.isSuccessful()){//SE DER TUDO CERO RETORNA O RESULTADO DAS INFORMAÇOES
                // GERADAS NO FIREBASE
                String id = task.getResult().getUser().getUid();
                usuario.setId(id);
            }
        });

    }
}