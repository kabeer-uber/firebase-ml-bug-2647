package com.kabeer.firebaseml

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.FirebaseApp
import com.google.firebase.ml.modeldownloader.CustomModelDownloadConditions
import com.google.firebase.ml.modeldownloader.DownloadType
import com.google.firebase.ml.modeldownloader.FirebaseModelDownloader


class MainActivity : AppCompatActivity() {
    private  val TAG = "XXMainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate: ")
        setContentView(R.layout.activity_main)
        FirebaseApp.initializeApp(this)

        FirebaseModelDownloader.getInstance()
                .getModel("mv2_100_e47_q_v1", DownloadType.LOCAL_MODEL_UPDATE_IN_BACKGROUND, CustomModelDownloadConditions.Builder().build())
                .addOnSuccessListener { model -> // Download complete. Depending on your app, you could enable the ML
                    Log.d(TAG, "onSuccess() called with: model = $model")
                }
                .addOnFailureListener { failure ->
                    Log.d(TAG, "onFailure() called with: failure = $failure")
                }
    }
}