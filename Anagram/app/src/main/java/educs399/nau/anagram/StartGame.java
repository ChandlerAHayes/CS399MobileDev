package educs399.nau.anagram;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class StartGame extends AppCompatActivity {
    Button easyButton;
    Button mediumButton;
    Button hardButton;

    private static final int REQUEST_CODE_LEVEL = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_game);

        easyButton = (Button)findViewById(R.id.easyLevel_bttn);
        mediumButton = (Button)findViewById(R.id.mediumLevel_bttn);
        hardButton = (Button)findViewById(R.id.hardLevel_bttn);
        easyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String level = "easy";
                Intent intent = PlayGame.newIntent(StartGame.this, level);
                startActivityForResult(intent, REQUEST_CODE_LEVEL);

            }
        });

        mediumButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String level = "medium";
                Intent intent = PlayGame.newIntent(StartGame.this, level);
                startActivityForResult(intent, REQUEST_CODE_LEVEL);
            }
        });

        hardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String level = "hard";
                Intent intent = PlayGame.newIntent(StartGame.this, level);
                startActivityForResult(intent, REQUEST_CODE_LEVEL);
            }
        });
    }


}
