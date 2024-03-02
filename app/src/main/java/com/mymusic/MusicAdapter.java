package com.mymusic;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.mymusic.model.MusicModel;
import java.util.List;

public class MusicAdapter extends RecyclerView.Adapter<MusicAdapter.MusicViewHolder> {
    private List<MusicModel> musicList;
    private OnItemClickListener listener;

    public MusicAdapter(Context context, List<MusicModel> musicList) {
        this.musicList = musicList;
    }

    @NonNull
    @Override
    public MusicViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.muisc_card_item, parent, false);
        return new MusicViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull MusicViewHolder holder, int position) {

        TextView playPauseText;

        MusicModel musicTrack = musicList.get(position);
        holder.trackTitle.setText(musicTrack.getTitle());
        holder.trackArtist.setText(musicTrack.getArtist());
        holder.playMusicButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.navigateToPlayMusic(musicTrack);
            }
        });
    }

    @Override
    public int getItemCount() {
        return musicList.size();
    }
    public static class MusicViewHolder extends RecyclerView.ViewHolder {
        TextView trackTitle;
        TextView trackArtist;
        Button playMusicButton;
        public MusicViewHolder(@NonNull View itemView) {
            super(itemView);
            trackTitle = itemView.findViewById(R.id.titleTV);
            trackArtist = itemView.findViewById(R.id.artistTV);
            playMusicButton = itemView.findViewById(R.id.bPlayButton);
        }

    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public interface OnItemClickListener {
        void navigateToPlayMusic(MusicModel music);
    }

}
