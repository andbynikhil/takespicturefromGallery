package com.example.takepicturefromgallery;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ImageView imageView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=findViewById(R.id.button);
        imageView=findViewById(R.id.image);
         button.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             //set action
             Intent igallery=new Intent(Intent.ACTION_PICK);
             // open all picker application
             igallery.setData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
             startActivityForResult(igallery,1000);

         }
     });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode==RESULT_OK){
            if(requestCode==1000){
                imageView.setImageURI(data.getData());
            }

        }
        else{
            Toast.makeText(this,"something went worng",Toast.LENGTH_LONG);
        }

    }
}