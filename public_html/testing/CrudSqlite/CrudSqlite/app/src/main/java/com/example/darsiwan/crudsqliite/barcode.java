package com.example.darsiwan.crudsqliite;
import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class barcode extends AppCompatActivity implements ZXingScannerView.ResultHandler {


    private ZXingScannerView mScannerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA);
        mScannerView = new ZXingScannerView(this);
        setContentView(mScannerView);
    }
    @Override
    public void onResume() {
        super.onResume();
        mScannerView.setResultHandler(this);
        mScannerView.startCamera();
    }

    @Override
    public void onPause() {
        super.onPause();
        mScannerView.stopCamera();
    }

    @Override
    public void handleResult(Result rawResult) {
        Log.v("TAG", rawResult.getText()); // Prints scan results
        Log.v("TAG", rawResult.getBarcodeFormat().toString());
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Scan Result");
        builder.setMessage(rawResult.getText());
        AlertDialog alert1 = builder.create();
        //alert1.show();
        Toast.makeText(getApplicationContext(), "Code " + rawResult.getText(), Toast.LENGTH_LONG).show();
//        Intent i = new Intent(getApplicationContext(), LihatBiodata.class);
//        i.putExtra("tn", rawResult.getText());
//        startActivity(i);

        Intent intent = new Intent(getApplicationContext(), LihatBiodata.class);
        intent.putExtra("tn", rawResult.getText());
        startActivity(intent);
        //mScannerView.resumeCameraPreview(this);
    }
}
