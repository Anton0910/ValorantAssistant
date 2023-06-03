package devandroid.antonio.myapplication.classes;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import devandroid.antonio.myapplication.helper.FirebaseHelper;

public class Usuario {

    private String id;

    private String nome;

    private String email;

    private String senha;

    public String getId() {
        return id;
    }

    public Usuario() {

        DatabaseReference reference = FirebaseHelper.getDatabaseReference();
        this.setId(reference.push().getKey()); //Gera um id unico para a pessoa e retorna ele,
        // toda vez q instanciar um objeto Usuario, o proprio construtor irá gerar um id
    }

    public void salvarPessoa(){
        //Retorna o nó principal do banco de dados
        DatabaseReference reference = FirebaseHelper.getDatabaseReference()
                .child("usuarios")
                .child(FirebaseHelper.getIdFirebase());


        reference.setValue(this);//Salva todos os atributos no banco de dados
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
