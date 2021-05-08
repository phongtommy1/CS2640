package com.example.cs2640project;

import android.app.Service;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.IBinder;

import androidx.annotation.Nullable;

//THIS CLASS WILL HANDLE ABRUPT CLOSURES OF THE APP (like closing the app by swiping up)
public class ClosingService extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    //the method for when the current task is removed (after user closes app by swiping up)
    @Override
    public void onTaskRemoved(Intent rootIntent) {
        super.onTaskRemoved(rootIntent);  //superclass method

        // Destroy the service
        stopSelf();

        if(!MainActivity.gameAudio.isPlaying())  //if the audio is not playing in MainActivity
        {
            MainActivity.audioButton.setChecked(false);  //set the toggle button to checked(false) so that when the user reopens the app, music will be OFF and they can toggle music back ON
        }
    }


}