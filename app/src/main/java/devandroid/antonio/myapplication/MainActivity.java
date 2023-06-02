package devandroid.antonio.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.ktx.Firebase;

public class MainActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;


    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            reload();
        }
    }

    private void reload() {
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText editNome = findViewById(R.id.editTextTextPersonName);
        EditText editSenha = findViewById(R.id.editTextTextPassword);
        Button btnLog = findViewById(R.id.button);
        Button btnRegister = findViewById(R.id.button2);
        mAuth = FirebaseAuth.getInstance();


        btnLog.setOnClickListener(view -> {

            Intent intent = new Intent(this,Tela_Personagens.class);
            startActivity(intent);

        });


        btnRegister.setOnClickListener(view -> {

            Intent intent = new Intent(this,Registro.class);
            startActivity(intent);

        });
    }
}