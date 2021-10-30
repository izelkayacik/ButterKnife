package com.izelkayacik.butterknife;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import butterknife.BindDrawable;
import butterknife.BindString;
import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnLongClick;
import butterknife.OnTextChanged;
import butterknife.OnTouch;

public class MainActivity extends AppCompatActivity {

    //Butter Knife bir View Injector kütüphanesidir
    // bu kütüphane sayesinde ön yüzde kullandığımız
    // android bileşenlerini annotation’lar kullanarak
    // uygulamamızda direkt olarak erişebilmemizi sağlıyor.
    // Aynı zamanda uygulamalarımızda kullandığımız view lere,
    // verdiğimiz tıklanma event lerini de, projemize daha pratik
    // bir şekilde eklememize yardımcı oluyor.
    // Bu kütüphanenin temel amacı
    // kod tekrarını azaltmak ve yazılımcılara
    // daha hızlı ve daha pratik çözümler sunmaktır.

    private static final String TAG = "MainActivity";

    @BindView(R.id.textView)
    TextView textView;

    @BindViews({R.id.firstNameTextView, R.id.lastNameTextView})
    List<TextView> nameTextViews;

    @BindString(R.string.my_string)
    String myString;

    @BindView(R.id.imageView)
    ImageView imageView;

    @BindDrawable(R.drawable.logo)
    Drawable drawable;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        textView.setText("Izel Kayacık");

        textView.setText(myString);

        imageView.setImageDrawable(drawable);

//        String string = getResources().getString(R.string.my_string);

        for (TextView textView: nameTextViews) {
            Log.e(TAG, "onCreate: " + textView.getText() );
        }

//        textView = findViewById(R.id.textView);
//        textView.setText("blah blah blah");

    }

    @OnClick(R.id.button)
    void buttonClick() {
        Toast.makeText(this, "button clicked", Toast.LENGTH_SHORT).show();
    }

    @OnLongClick(R.id.button)
    void onLongClick() {
        Toast.makeText(this, "On Long Click", Toast.LENGTH_SHORT).show();
    }

    @OnTouch({R.id.textView, R.id.firstNameTextView})
    void OnTouch(TextView textView) {
        Toast.makeText(this, "on touch" + textView.getText(), Toast.LENGTH_SHORT).show();
    }
}