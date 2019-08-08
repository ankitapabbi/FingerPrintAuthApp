package com.example.fingerprintauthapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.hardware.fingerprint.FingerprintManagerCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.KeyguardManager;
import android.os.Build;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private FingerprintManagerCompat fingerprintManagerCompat;
    private KeyguardManager keyguardManager;
    TextView txt1;
    ImageView imageFingerPrint;
    TextView txt2;

    @SuppressLint("ServiceCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt1 = (TextView)findViewById(R.id.txt1);
        txt2 = (TextView)findViewById(R.id.txt2);
        imageFingerPrint = (ImageView)findViewById(R.id.imageView);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            fingerprintManagerCompat = (FingerprintManagerCompat)getSystemService(FINGERPRINT_SERVICE);
            keyguardManager = (KeyguardManager)getSystemService(KEYGUARD_SERVICE);
            if (!fingerprintManagerCompat.isHardwareDetected()){
            txt2.setText("FingerPrint scanner not detected in device");
            }   else if (ContextCompat.checkSelfPermission(this, Manifest.permission.USE_FINGERPRINT)!= getPackageManager().PERMISSION_GRANTED){
                txt2.setText("permission not granted to use fingerprint scanner");

            }else if (!keyguardManager.isKeyguardSecure()){
                txt2.setText("add lock to your phone in setting");

            }else if (!fingerprintManagerCompat.hasEnrolledFingerprints()){
                txt2.setText("add atleast one finger print");

            }else {
                txt2.setText("place your finger on scanner");
                FingerPrintHandler fingerPrintHandler = new FingerPrintHandler(this);
        //    fingerPrintHandler.start
            }
        }

    }
}
