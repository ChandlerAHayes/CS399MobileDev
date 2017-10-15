package educs399.nau.anagram;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Score extends AppCompatActivity {
    private Button homePageButton;
    private TextView txtScore;
    private int score;

    //constants
    private static final String EXTRA_SCORE = "score";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);


        homePageButton = (Button)findViewById(R.id.homePage_bttn);
        homePageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Score.this, MainActivity.class));
            }
        });

        //finding out what the score is
        txtScore = (TextView)findViewById(R.id.txt_score);
        score = getIntent().getIntExtra(EXTRA_SCORE, 0);
        txtScore.setText(String.valueOf(score));

    }

    //This is an intent that the PlayGame activity can use
    public static Intent newIntent(Context packageContext, int score)
    {
        Intent intent = new Intent(packageContext, Score.class);
        intent.putExtra(EXTRA_SCORE, score);
        return intent;
    }
}
