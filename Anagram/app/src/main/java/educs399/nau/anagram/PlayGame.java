package educs399.nau.anagram;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PlayGame extends AppCompatActivity {
    Button easyButton;
    Button mediumButton;
    Button hardButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_game);
        easyButton = (Button)findViewById(R.id.easyLevel_bttn);
        mediumButton = (Button)findViewById(R.id.mediumLevel_bttn);
        hardButton = (Button)findViewById(R.id.hardLevel_bttn);
        easyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PlayGame.this, StartGame.class));
            }
        });

        mediumButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PlayGame.this, StartGame.class));
            }
        });

        hardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PlayGame.this, StartGame.class));
            }
        });
    }
}
