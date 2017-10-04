package cs399.calculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Calculator extends AppCompatActivity {
    float valueOne, valueTwo;

    //All the buttons for the app
    Button button0, button1, button2, button3, button4, button5, button6,
            button7, button8, button9, buttonAdd, buttonSubtract, buttonDivide, buttonMult,
            buttonEqual, buttonPoint, buttonClear;

    EditText text1;
    TextView inputText, outputText;
    boolean isAddition, isSubtract, isDivision, isMultiply;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        //initializing buttons 0-9
        button0 = (Button) findViewById(R.id.bttn_zero);
        button1 = (Button) findViewById(R.id.bttn_one);
        button2 = (Button) findViewById(R.id.bttn_two);
        button3 = (Button) findViewById(R.id.bttn_three);
        button4 = (Button) findViewById(R.id.bttn_four);
        button5 = (Button) findViewById(R.id.bttn_five);
        button6 = (Button) findViewById(R.id.bttn_six);
        button7 = (Button) findViewById(R.id.bttn_seven);
        button8 = (Button) findViewById(R.id.bttn_eight);
        button9 = (Button) findViewById(R.id.bttn_nine);
        buttonPoint = (Button) findViewById(R.id.bttn_decimal);

        //initializing the math function buttons
        buttonAdd = (Button) findViewById(R.id.bttn_plus);
        buttonSubtract = (Button) findViewById(R.id.bttn_minus);
        buttonDivide = (Button) findViewById(R.id.bttn_divide);
        buttonMult = (Button) findViewById(R.id.bttn_mltply);
        buttonEqual = (Button) findViewById(R.id.bttn_equal);
        buttonClear = (Button) findViewById(R.id.bttn_clear);

        //initializing Textviews for the input & outputs
        inputText = (TextView) findViewById(R.id.str_input_display);
        outputText = (TextView) findViewById(R.id.str_output_display);

        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputText.setText(inputText.getText() + "0");
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputText.setText(inputText.getText() + "1");
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputText.setText(inputText.getText() + "2");
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputText.setText(inputText.getText() + "3");
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputText.setText(inputText.getText() + "4");
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputText.setText(inputText.getText() + "5");
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputText.setText(inputText.getText() + "6");
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputText.setText(inputText.getText() + "7");
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputText.setText(inputText.getText() + "8");
            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputText.setText(inputText.getText() + "9");
            }
        });

        buttonPoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputText.setText(inputText.getText() + ".");
            }
        });

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valueOne = Float.parseFloat();
                inputText.setText(inputText.getText()+ "+");
                isAddition = true;
                //inputText.setText("+");
            }
        });


    }
}
