package devandroid.antonio.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;


public class mapas extends AppCompatActivity {

    ImageView img;

    int drawable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapas);
        img = findViewById(R.id.imageView4);
        drawable = R.drawable.img_3;
        img.setImageResource(drawable);
    }
}