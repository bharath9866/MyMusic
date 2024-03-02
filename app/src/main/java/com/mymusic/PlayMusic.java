package com.mymusic;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class PlayMusic extends AppCompatActivity {
    private boolean isPlaying = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(this);

        setContentView(R.layout.music_layout);

        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.your_status_bar_color)); // Status Bar Color
        window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR); // For Status Bar Icons in Light Color


        Intent intent = getIntent();
        if (intent != null) {
            String title = intent.getStringExtra("songTitle");

            TextView titleTextView = findViewById(R.id.tvSongName);
            Button popBackButton = findViewById(R.id.bPlayMusicBack);
            LinearLayout playerController = findViewById(R.id.llPlayerController);
            ImageButton pauseButton = playerController.findViewById(R.id.ibPauseButton);
            ImageButton playButton = playerController.findViewById(R.id.ibPlayButton);
            ImageButton previousButton = playerController.findViewById(R.id.ibPreviousTrack);
            ImageButton nextButton = playerController.findViewById(R.id.ibNextTrack);

            titleTextView.setText(title);

            popBackButton.setOnClickListener(view -> finish());

            pauseButton.setOnClickListener(view -> {
                pauseButton.setVisibility(View.VISIBLE);
                playButton.setVisibility(View.GONE);
                Toast.makeText(this, "Playing song", Toast.LENGTH_SHORT).show();
            });

            playButton.setOnClickListener(view -> {
                playButton.setVisibility(View.VISIBLE);
                pauseButton.setVisibility(View.GONE);
                Toast.makeText(this, "Song Paused", Toast.LENGTH_SHORT).show();
            });

            nextButton.setOnClickListener(view -> {
                pauseButton.setVisibility(View.VISIBLE);
                playButton.setVisibility(View.GONE);
                Toast.makeText(this, "Playing next song", Toast.LENGTH_SHORT).show();
            });
            previousButton.setOnClickListener(view -> {
                pauseButton.setVisibility(View.VISIBLE);
                playButton.setVisibility(View.GONE);
                Toast.makeText(this, "Playing previous song", Toast.LENGTH_SHORT).show();
            });
        }

    }
}