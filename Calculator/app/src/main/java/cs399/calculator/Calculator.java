package cs399.calculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class Calculator extends AppCompatActivity {
    public boolean decimalIsUsed = false;

    //Used arraylist so that multiple equations could be applied
    ArrayList<Double> inputNumberList = new ArrayList<Double>();
    ArrayList<String> operationsList = new ArrayList<String>();
    String currentValue = "";


    //All the buttons for the app
    Button button0, button1, button2, button3, button4, button5, button6,
            button7, button8, button9, buttonAdd, buttonSubtract, buttonDivide, buttonMult,
            buttonEqual, buttonPoint, buttonClear;

    EditText text1;
    TextView inputText, outputText;
    String history; //saves the user input so that values can be cleared.
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
                addNumToCurrentVal(0);
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputText.setText(inputText.getText() + "1");
                addNumToCurrentVal(1);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputText.setText(inputText.getText() + "2");
                addNumToCurrentVal(2);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputText.setText(inputText.getText() + "3");
                addNumToCurrentVal(3);
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputText.setText(inputText.getText() + "4");
                addNumToCurrentVal(4);
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputText.setText(inputText.getText() + "5");
                addNumToCurrentVal(5);
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputText.setText(inputText.getText() + "6");
                addNumToCurrentVal(6);
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputText.setText(inputText.getText() + "7");
                addNumToCurrentVal(7);
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputText.setText(inputText.getText() + "8");
                addNumToCurrentVal(8);
            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputText.setText(inputText.getText() + "9");
                addNumToCurrentVal(9);
            }
        });

        buttonPoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!decimalIsUsed)
                {
                    inputText.setText(inputText.getText() + ".");
                    currentValue += ".";
                }


            }
        });

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //make sure there's at least one value
                if (inputNumberList.isEmpty()) {
                    inputText.setText("There is no value to add");
                }
                //There's a value for the first number but no value for the second number yet
                else {
                    inputText.setText(inputText.getText() + " + ");
                }
            }
        });

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!currentValue.equals(""))
                {
                    //add current number to list of numbers
                    inputNumberList.add(Double.parseDouble(currentValue));
                    currentValue = "";

                    //add + to list of operations
                    operationsList.add("+");
                    inputText.setText(inputText.getText() + "+");


                }
            }
        });

        buttonSubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!currentValue.equals(""))
                {
                    //add current number to list of numbers
                    inputNumberList.add(Double.parseDouble(currentValue));
                    currentValue = "";

                    //add + to list of operations
                    operationsList.add("-");

                    inputText.setText(inputText.getText() + "-");
                }
            }
        });

        buttonMult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!currentValue.equals(""))
                {
                    //add current number to list of numbers
                    inputNumberList.add(Double.parseDouble(currentValue));
                    currentValue = "";

                    //add + to list of operations
                    operationsList.add("*");

                    inputText.setText(inputText.getText() + "*");
                }
                if(currentValue.equals("")){;}
            }
        });

        buttonDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!currentValue.equals("")) {
                    //add current number to list of numbers
                    inputNumberList.add(Double.parseDouble(currentValue));
                    currentValue = "";

                    //add + to list of operations
                    operationsList.add("/");

                    inputText.setText(inputText.getText() + "/");
                }
            }
        });

        buttonEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //add last value to inputNumberList
                inputNumberList.add(Double.parseDouble(currentValue));
                currentValue = "";

                Double result = inputNumberList.get(0);
                int numIndex = 0;
                for(int opIndex=0; opIndex < operationsList.size(); opIndex++)
                {
                    Double valueTwo = inputNumberList.get(opIndex+1);
                    switch(operationsList.get(opIndex)){
                        case "+":
                            result += valueTwo;
                            break;

                        case "-":
                            result -= valueTwo;
                            break;

                        case"*":
                            result *= valueTwo;
                            break;

                        case "/":
                            if(valueTwo.equals(0.0))
                            {
                                inputNumberList.clear();
                                operationsList.clear();
                                inputText.setText("");
                                outputText.setText("");
                                currentValue = "";
                                decimalIsUsed = false;
                                inputText.setText("Cannot Divide by zero");
                                return;
                            }
                            result /= valueTwo;
                            break;
                    }

                    numIndex++;
                }

                //display results
                outputText.setText("= " + result);

                //remove all the numbers and operations that have been used
                inputNumberList.clear();
                inputNumberList.add(result);
                operationsList.clear();

            }
        });

        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputNumberList.clear();
                operationsList.clear();
                inputText.setText("");
                outputText.setText("");
                currentValue = "";
                decimalIsUsed = false;
            }
        });
    }

    //adds the next digit to the current value being typed in
    public void addNumToCurrentVal(int num){
        String numString = String.valueOf(num);
        currentValue += numString;
    }
    public void clearAll()
    {

    }




}
