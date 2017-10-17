package educs399.nau.anagram;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class PlayGame extends AppCompatActivity {
    //Initializing widgets from the xml layout
    private Button nextButton;
    private Button quitButton;
    private TextView txtAnagram;
    private EditText txtAnswer;
    private TextView txtScore;
    private TextView txtQuestions;
    private TextView txtTimer;


    //Other Variables
    private int numOfCorrect;   //number of answers correct out of five
    private String level;
    private int index = 0;  //index of current question
    private int numOfTotalQuestions = 5; //this is the total amount of questions in the game

    //set of anagrams
    private Anagram[] anagramSet;

    //constants for transferring constants from one activity to another
    private static final String EXTRA_LEVEL = "level";
    private static final int REQUEST_CODE_SCORE = 1;
    //constants for saving data between screen rotations
    private static final String KEY_INDEX = "index";
    private static final String KEY_NUM_OF_CORRECT = "numOfCorrect";
    private static final String KEY_LEVEL = "level";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_game);

        if(savedInstanceState != null)
        {
            index = savedInstanceState.getInt(KEY_INDEX);
            numOfCorrect = savedInstanceState.getInt(KEY_NUM_OF_CORRECT);
            level = savedInstanceState.getString(KEY_LEVEL);
        }

        txtTimer = (TextView)findViewById(R.id.txt_timer);
        new CountDownTimer(30*1000, 1000){
            public void onTick(long millisUntilFinished)
            {
                if(millisUntilFinished/1000 > 9)
                {
                    txtTimer.setText(String.valueOf("00:" + millisUntilFinished/1000));
                }
                else
                {
                    txtTimer.setText(String.valueOf("00:0" + millisUntilFinished/1000));
                }
            }
            public void onFinish()
            {
                //check if answer is correct
                if(checkAnswer())
                {
                    numOfCorrect++;
                    txtScore.setText("Score: " + numOfCorrect);
                }
                //go to the next anagram
                if(index < anagramSet.length-1)
                {

                    updateAnagram();
                    start();
                }
                //if it's the last question, go to the score activity
                else {
                    Intent intent = Score.newIntent(PlayGame.this, numOfCorrect);
                    startActivityForResult(intent, REQUEST_CODE_SCORE);
                }
            }
        }.start();


        //initializing the answer box
        txtAnswer = (EditText)findViewById(R.id.txt_answer);


        //finding out what level the user picked
        level = getIntent().getStringExtra(EXTRA_LEVEL);

        //now create the question set & answer set depending on level selected
        //question set is easy
        if("easy".equals(level)) {
            anagramSet = new Anagram[]{
                    new Anagram(R.string.easy_quest1, new String[] {"rock"}),
                    new Anagram(R.string.easy_quest2, new String[]{"edit", "tide"}),
                    new Anagram(R.string.easy_quest3, new String[]{"dare", "read"}),
                    new Anagram(R.string.easy_quest4, new String[]{"flow", "wolf"}),
                    new Anagram(R.string.easy_quest5, new String[]{"post", "spot", "stop", "tops"})};
        }
        //question set is hard
        else if("medium".equals(level)) {
            anagramSet = new Anagram[]{
                    new Anagram(R.string.medium_quest1, new String[]{"reverse"}),
                    new Anagram(R.string.medium_quest2, new String[]{"burden", "burned"}),
                    new Anagram(R.string.medium_quest3, new String[]{"review"}),
                    new Anagram(R.string.medium_quest4, new String[]{"salesman"}),
                    new Anagram(R.string.medium_quest5, new String[]{"needless"})};
        }
        //question set is hard
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
//        String anagramStr = ;
        txtAnagram.setText(anagram);

        txtQuestions = (TextView) findViewById(R.id.txt_numQuestions);
        txtQuestions.setText((Integer.toString(index + 1)) + " out of " + numOfTotalQuestions);

        txtScore = (TextView) findViewById(R.id.txt_score);
        txtScore.setText("Score: " + numOfCorrect);

        quitButton = (Button) findViewById(R.id.quit_bttn);
        quitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PlayGame.this, MainActivity.class));
            }
        });


        //This button will either allow the user to go to the next question or go to the score page
        //it's the last question.
        nextButton = (Button)findViewById(R.id.score_bttn);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //check if answer is correct
                if(checkAnswer())
                {
                    numOfCorrect++;
                    txtScore.setText("Score: " + numOfCorrect);
                }
                //go to the next anagram
                if(index < anagramSet.length-1)
                {

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
        if(index >= anagramSet.length)
        {
            txtAnagram.setText("End of Array");
        }
        else {
            int anagram = anagramSet[index].getTextResId();
            txtAnagram.setText(anagram);
            txtQuestions.setText((Integer.toString(index + 1)) + " out of " + numOfTotalQuestions);
        }
        txtAnswer.setText("");
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

    //saves data if the screen is rotated
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);

        //saving data
        savedInstanceState.putInt(KEY_INDEX, index);
        savedInstanceState.putInt(KEY_NUM_OF_CORRECT, numOfCorrect);
        savedInstanceState.putString(KEY_LEVEL, level);
    }

}
