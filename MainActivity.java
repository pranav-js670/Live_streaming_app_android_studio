package com.example.livestreaming;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.os.Build;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        long appID = 2139348720;
        String appSign = "dc3f83c9b9d7990c16bc9415c2ef9c563d32eb3afa1eddb138a58c0862f91ba8";

        String userID = Build.MANUFACTURER + "_" + generateUserID();
        String userName = userID + "_Name";
        String liveID = "test_live_id";

        findViewById(R.id.start_live).setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, LiveActivity.class);
            intent.putExtra("host", true);
            intent.putExtra("appID", appID);
            intent.putExtra("appSign", appSign);
            intent.putExtra("userID", userID);
            intent.putExtra("userName", userName);
            intent.putExtra("liveID", liveID);
            startActivity(intent);
        });
        findViewById(R.id.watch_live).setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, LiveActivity.class);
            intent.putExtra("appID", appID);
            intent.putExtra("appSign", appSign);
            intent.putExtra("userID", userID);
            intent.putExtra("userName", userName);
            intent.putExtra("liveID", liveID);
            startActivity(intent);
        });

    }

    private String generateUserID() {
        StringBuilder builder = new StringBuilder();
        Random random = new Random();
        while (builder.length() < 5) {
            int nextInt = random.nextInt(10);
            if (builder.length() == 0 && nextInt == 0) {
                continue;
            }
            builder.append(nextInt);
        }
        return builder.toString();
    }
    }
