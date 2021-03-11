package com.dsr.leitor;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Camera;
import android.os.Bundle;
import android.widget.FrameLayout;

import com.dsr.leitor.model.Leitor;
import com.dsr.leitor.model.Visualizacao;

public class MainActivity extends AppCompatActivity {
    private Camera mCamera;
    private Visualizacao mPreview;

    public static Camera getCameraInstance(){
        Camera c = null;
        try {
            c = Camera.open(1); // attempt to get a Camera instance
            c.setFaceDetectionListener(new Leitor());
            return c;
        }
        catch (Exception e){
            // Camera is not available (in use or does not exist)
            return c;
        }

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create an instance of Camera
        mCamera = getCameraInstance();

        // Create our Preview view and set it as the content of our activity.
        mPreview = new Visualizacao(this, mCamera);
        FrameLayout preview = (FrameLayout) findViewById(R.id.camera_preview);
        preview.addView(mPreview);
    }

}