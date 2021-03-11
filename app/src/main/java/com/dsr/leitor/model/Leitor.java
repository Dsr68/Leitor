package com.dsr.leitor.model;

import android.hardware.Camera;
import android.util.Log;

public class Leitor implements Camera.FaceDetectionListener{
    @Override
    public void onFaceDetection(Camera.Face[] faces, Camera camera) {
        if(faces.length > 0){
            Log.d("Face Detection", "face detected " + faces.length +"\n" +
                    "Face 1 location X: " + faces[0].rect.centerX() +
                    " Y: " + faces[0].rect.centerY() + "\n Centro da boca "+ faces[0].mouth +"\n"
                    + "Centro do olho esquerdo " + faces[0].leftEye + "\n"
                    + "Centro do olho direito " + faces[0].rightEye + "\n" +
                    "Nível de precisão " + faces[0].score
                    );

        }
    }
}
