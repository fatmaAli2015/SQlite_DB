package com.example.fatmaali.sqlite_db;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by Fatma Ali on 08/09/2017.
 */

public class checkInternetConnection {
    private Context context;

    public checkInternetConnection(Context context) {
        this.context = context;
    }

    public boolean isConnectionToInternet() {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager != null) {
            NetworkInfo info = connectivityManager.getActiveNetworkInfo();
            if (info != null && info.isConnected()) {
                return true;
            }
        }
        return false;
    }
}
