package devandroid.antonio.myapplication.classes;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import devandroid.antonio.myapplication.R;

public class AdapterPersonagens extends RecyclerView.Adapter<AdapterPersonagens.MyviewHolder> {
    private List <Personagens> personagensList;

    private Onclick onclick;

    public AdapterPersonagens(List<Personagens> personagensList, Onclick onclick) {
        this.personagensList = personagensList;
        this.onclick = onclick;
    }

    public interface Onclick{
        void onClickListerner(Personagens personagens);
    }

    @NonNull
    @Override
    //passa o layout que vai ser exibido no recycler view
    public MyviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView =
                LayoutInflater.from(parent.getContext()).inflate(R.layout.item_personagens,parent
                        ,false);
        return new MyviewHolder(itemView);
    }

    @Override
    //Configura as informaçoes da classe , passa cada elemento que vai ter em uma linha
    public void onBindViewHolder(@NonNull MyviewHolder holder, int position) {
        Personagens personagens = personagensList.get(position);
        holder.textNome.setText(personagens.getNome());

        holder.itemView.setOnClickListener(view -> onclick.onClickListerner(personagens) );
    }

    @Override
    //Retorna a quantidade de itens que temos na nossa lista
    public int getItemCount() {
        return personagensList.size();
    }

    //Configura quais elementos vai ter na listagem, Ex: textView, Imageview
    static class MyviewHolder extends RecyclerView.ViewHolder{

        TextView textNome;

       public MyviewHolder(@NonNull View itemView) {
           super(itemView);
           textNome = itemView.findViewById(R.id.text_nome);
       }
   }
}
