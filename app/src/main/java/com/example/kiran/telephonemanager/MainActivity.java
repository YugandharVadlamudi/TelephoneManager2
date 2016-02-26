package com.example.kiran.telephonemanager;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView tv=(TextView)findViewById(R.id.tv_hello);
        TelephonyManager  tm=(TelephonyManager)getSystemService(Context.TELEPHONY_SERVICE);
        StringBuilder s=new StringBuilder("Result::");
        s.append(tm.getDeviceId().toString());
        if(Build.VERSION.SDK_INT==Build.VERSION_CODES.KITKAT)
        {
            s.append("\n devise version name is KitKat");
        }
        else
        {
            s.append("\n devise version name is not KitKat");
        }
        int simState=tm.getSimState();
        switch (simState)
        {
            case TelephonyManager.SIM_STATE_ABSENT:s.append("\n simSatat is abset");break;
            case TelephonyManager.SIM_STATE_UNKNOWN:s.append("\n simSatat is unknown");break;
        }
        /*Checking Connective manager*/
        ConnectivityManager cm=(ConnectivityManager)getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo ni=cm.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        if(ni.isConnected())
        {
            s.append("\n connected to wifiy type is wify");
        }
        else
        {
            s.append("\n not connected to wifiy type and not  wify");
        }
        s.append("\n simSatat"+tm.getSimState());
        tv.setText(s);

    }
}
