package com.example.fingerprintauthapp;

import android.accessibilityservice.FingerprintGestureController;
import android.content.Context;
import android.os.CancellationSignal;

import androidx.core.hardware.fingerprint.FingerprintManagerCompat;

public class FingerPrintHandler extends FingerprintManagerCompat.AuthenticationCallback {

    private Context context;
    public FingerPrintHandler(Context context){
        this.context = context;

    }
    public void startAuth(FingerprintManagerCompat fingerprintManagerCompat,FingerprintManagerCompat.CryptoObject cryptoObject){

        CancellationSignal cancellationSignal = new CancellationSignal();

        fingerprintManagerCompat.authenticate(cryptoObject,cancellationSignal, 0,this,null);


    }

}
