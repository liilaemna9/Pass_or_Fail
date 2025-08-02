package com.noobbros.yt;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 🎵 Initialize and start background music
        mediaPlayer = MediaPlayer.create(this, R.raw.background_music);
        mediaPlayer.setLooping(true); // Loop the music
        mediaPlayer.start();

        setupSubjectButton(R.id.btnEnglish, "english");
        setupSubjectButton(R.id.btnMathes, "mathes");
        setupSubjectButton(R.id.btnPhysics, "physics");
        setupSubjectButton(R.id.btnChemistry, "chemistry");
        setupSubjectButton(R.id.btnIntelligence, "intelligence");
        setupSubjectButton(R.id.btnVerbal, "verbal");
        setupSubjectButton(R.id.btnNonVerbal, "nonverbal");
        setupSubjectButton(R.id.btnComingSoon, "comingsoon");
    }

    private void setupSubjectButton(int id, final String subject) {
        Button button = findViewById(id);
        button.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					Intent intent = new Intent(MainActivity.this, SubjectWebViewActivity.class);
					intent.putExtra("subject", subject);
					startActivity(intent);
				}
			});
    }

    @Override
    protected void onDestroy() {
        // 🛑 Release music resources when activity is destroyed
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
        super.onDestroy();
    }
}
