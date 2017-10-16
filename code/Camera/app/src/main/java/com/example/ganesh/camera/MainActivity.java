package com.example.ganesh.camera;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageInfo;
import android.provider.MediaStore;
import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.Button;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    static final int REQUEST_IMAGE_CAPTURE=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button=(Button)findViewById(R.id.cameraButton);

        if(!hasCamera()){
            button.setEnabled(false);
        }
    }

    private Boolean hasCamera(){
        return getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_ANY);
    }

    public void cameraButtonClicked(View v){
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent,REQUEST_IMAGE_CAPTURE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==REQUEST_IMAGE_CAPTURE && resultCode==RESULT_OK){
            Bundle extras=data.getExtras();
            Bitmap image=(Bitmap)extras.get("data");
            ImageView imageView=(ImageView)findViewById(R.id.imageView);
            imageView.setImageBitmap(image);

        }
    }
}
