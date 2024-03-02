package com.mymusic;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mymusic.model.MusicModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MusicAdapter.OnItemClickListener {

    List<MusicModel> musicList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(this);

        setContentView(R.layout.activity_main);

        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.your_status_bar_color)); // Status Bar Color
        window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR); // For Status Bar Icons in Light Color

        ViewCompat.setOnApplyWindowInsetsListener(
                findViewById(R.id.main), (v, insets) -> {
                    Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
                    v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
                    return insets;
                }
        );

        musicList.add(new MusicModel("Shape of you", "Ed Sheeran"));
        musicList.add(new MusicModel("Happier", "Marshmello"));
        musicList.add(new MusicModel("Closer", "Chainsmokers"));
        musicList.add(new MusicModel("Baby", "Justin Bieber"));
        musicList.add(new MusicModel("Despacito", "Luis Fonsi"));
        musicList.add(new MusicModel("Alone", "Marshmello"));
        musicList.add(new MusicModel("On my way", "Alan Walker"));
        musicList.add(new MusicModel("Someone Like You", "Adele"));
        musicList.add(new MusicModel("Blinding Lights", "The Weeknd"));
        musicList.add(new MusicModel("Dance Monkey", "Tones and I"));
        musicList.add(new MusicModel("Senorita", "Shawn Mendes, Camila Cabello"));
        musicList.add(new MusicModel("Uptown Funk", "Mark Ronson ft. Bruno Mars"));
        musicList.add(new MusicModel("Don't Start Now", "Dua Lipa"));
        musicList.add(new MusicModel("Wrecking Ball", "Miley Cyrus"));
        musicList.add(new MusicModel("Perfect", "Ed Sheeran"));
        musicList.add(new MusicModel("Bad Guy", "Billie Eilish"));
        musicList.add(new MusicModel("Radioactive", "Imagine Dragons"));
        musicList.add(new MusicModel("Sugar", "Maroon 5"));
        musicList.add(new MusicModel("Rolling in the Deep", "Adele"));
        musicList.add(new MusicModel("Stressed Out", "Twenty One Pilots"));
        musicList.add(new MusicModel("Shake It Off", "Taylor Swift"));
        musicList.add(new MusicModel("Can't Stop the Feeling!", "Justin Timberlake"));
        musicList.add(new MusicModel("Believer", "Imagine Dragons"));
        musicList.add(new MusicModel("Love Yourself", "Justin Bieber"));
        musicList.add(new MusicModel("Let Her Go", "Passenger"));
        musicList.add(new MusicModel("Roar", "Katy Perry"));
        musicList.add(new MusicModel("Firework", "Katy Perry"));
        musicList.add(new MusicModel("Hello", "Adele"));
        musicList.add(new MusicModel("Counting Stars", "OneRepublic"));
        musicList.add(new MusicModel("All of Me", "John Legend"));
        musicList.add(new MusicModel("Love Story", "Taylor Swift"));
        musicList.add(new MusicModel("Cheap Thrills", "Sia"));
        musicList.add(new MusicModel("Havana", "Camila Cabello"));

        RecyclerView recyclerView = findViewById(R.id.rcMusicScrollList);
        MusicAdapter musicAdapter = new MusicAdapter(this, musicList);
        musicAdapter.setOnItemClickListener(this);
        recyclerView.setAdapter(musicAdapter);

    }

    @Override
    public void navigateToPlayMusic(MusicModel music) {
        Intent intent = new Intent(this, PlayMusic.class);
        intent.putExtra("songTitle", music.getTitle());
        startActivity(intent);
    }
}