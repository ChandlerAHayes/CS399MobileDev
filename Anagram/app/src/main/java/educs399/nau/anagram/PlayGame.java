package educs399.nau.anagram;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class PlayGame extends AppCompatActivity {
    //Initializing widgets from the xml layout
    private Button nextButton;
    private TextView txtAnagram;
    private EditText txtAnswer;

    //Other Variables
    private int numOfCorrect;   //number of answers correct out of five
    private String level;
    private int index = 0;  //index of current question

    //set of questions & answers
    private Anagram[] anagramSet;

    //constants
    private static final String EXTRA_LEVEL = "level";
    private static final int REQUEST_CODE_SCORE = 1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_game);

        txtAnswer = (EditText)findViewById(R.id.txt_answer);

        //finding out what level the user picked
        level = getIntent().getStringExtra(EXTRA_LEVEL);

        //now create the question set & answer set depending on level selected
        //question set
        if("easy".equals(level))
        anagramSet = new Anagram[]{
                new Anagram(R.string.easy_quest1, new String[] {"rock"}),
                new Anagram(R.string.easy_quest2, new String[]{"edit", "tide"}),
                new Anagram(R.string.easy_quest3, new String[]{"dare", "read"}),
                new Anagram(R.string.easy_quest4, new String[]{"flow", "wolf"}),
                new Anagram(R.string.easy_quest5, new String[]{"post", "spot", "stop", "tops"})};
        else if("medium".equals(level)) {
            anagramSet = new Anagram[]{
                    new Anagram(R.string.medium_quest1, new String[]{"reverse"}),
                    new Anagram(R.string.medium_quest2, new String[]{"burden", "burned"}),
                    new Anagram(R.string.medium_quest3, new String[]{"review"}),
                    new Anagram(R.string.medium_quest4, new String[]{"salesman"}),
                    new Anagram(R.string.medium_quest5, new String[]{"needless"})};
        }
        //level is hard
        else
        {
            anagramSet = new Anagram[]{
                    new Anagram(R.string.hard_quest1, new String[]{"bad credit"}),
                    new Anagram(R.string.hard_quest2, new String[]{"dirty room"}),
                    new Anagram(R.string.hard_quest3, new String[]{"worth tea"}),
                    new Anagram(R.string.hard_quest4, new String[]{"elegant man"}),
                    new Anagram(R.string.hard_quest5, new String[]{"the classroom"})};
        }

        //initializing the first question
        txtAnagram = (TextView) findViewById(R.id.txt_anagram);
        int anagram = anagramSet[index].getTextResId();
        txtAnagram.setText(anagram);



        nextButton = (Button)findViewById(R.id.score_bttn);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //go to the next anagram
                if(index < anagramSet.length-1)
                {
                    if(checkAnswer())
                    {
                        numOfCorrect++;
                        numOfCorrect = numOfCorrect + 1 - 1;
                    }
                    updateAnagram();
                }
                //if it's the last question, go to the score activity
                else {
                    Intent intent = Score.newIntent(PlayGame.this, numOfCorrect);
                    startActivityForResult(intent, REQUEST_CODE_SCORE);
                }
            }
        });
    }

    //update the question to the next question
    public void updateAnagram(){
        index++;
        int anagram = anagramSet[index].getTextResId();
        txtAnagram.setText(anagram);
    }

    //checks if the answer is correct
    public boolean checkAnswer()
    {
        Boolean isAnswerCorrect = false;
        //get user's answer
        String userAnswer = txtAnswer.getText().toString();
        userAnswer = userAnswer.toLowerCase();
        userAnswer = userAnswer.trim();

        String[] answers = anagramSet[index].getAnswer();
        int answerSetLength = answers.length;
        for(int i=0; i<answerSetLength; i++)
        {
            Boolean xxx = userAnswer.equals(answers[i]);
            i = i + 1 - 1;
            if(userAnswer.equals(answers[i]))
            {
                isAnswerCorrect = true;
            }
        }
        return isAnswerCorrect;
    }

    //This is an intent that the StartGame activity can use
    public static Intent newIntent(Context packageContext, String level)
    {
        Intent intent = new Intent(packageContext, PlayGame.class);
        intent.putExtra(EXTRA_LEVEL, level);
        return intent;
    }
}
