package ca.campbell.simplecalc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

//  TODO: add buttons & methods for subtract, multiply, divide x
//  TODO: extra input validation: no divide by zero x

//  TODO: add a clear button that will clear the result & input fields x

//  TODO: the hint for the result widget is hard coded, put it in the strings file

public class MainActivity extends AppCompatActivity {
    EditText etNum1, etNum2;
    TextView result;
    double num1, num2;
    boolean valid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // get a handle on the text fields
        etNum1 = (EditText) findViewById(R.id.num1);
        etNum2 = (EditText) findViewById(R.id.num2);
        result = (TextView) findViewById(R.id.result);
    }  //onCreate()

    public boolean validateInput(String num1, String num2){
        if(num1.matches("[0-9]+") && num2.matches("[0-9]+"))
            return true;
        else
            return false;
    }
    // TODO: input validation: set text to show error
    public void addNums(View v) {
        valid = validateInput(etNum1.getText().toString(), etNum2.getText().toString());
        if(valid) {
            num1 = Double.parseDouble(etNum1.getText().toString());
            num2 = Double.parseDouble(etNum2.getText().toString());
            result.setText(Double.toString(num1 + num2));
        }
        else{
            result.setText("Invalid input. Numbers only.");
        }
    }  //addNums()

    public void subNums(View v){
        valid = validateInput(etNum1.getText().toString(), etNum2.getText().toString());
        if(valid) {
            num1 = Double.parseDouble(etNum1.getText().toString());
            num2 = Double.parseDouble(etNum2.getText().toString());
            result.setText(Double.toString(num1 - num2));
        }
        else{
            result.setText("Invalid input. Numbers only.");
        }
    }

    public void mulNums(View v){
        valid = validateInput(etNum1.getText().toString(), etNum2.getText().toString());
        if(valid) {
            num1 = Double.parseDouble(etNum1.getText().toString());
            num2 = Double.parseDouble(etNum2.getText().toString());
            result.setText(Double.toString(num1 * num2));
        }
        else{
            result.setText("Invalid input. Numbers only.");
        }
    }

    public void divNums(View v){
        valid = validateInput(etNum1.getText().toString(), etNum2.getText().toString());
        if(valid) {
            valid = validateZero(etNum2.getText().toString());
            if (valid) {
                num1 = Double.parseDouble(etNum1.getText().toString());
                num2 = Double.parseDouble(etNum2.getText().toString());
                result.setText(Double.toString(num1 / num2));
            }
            else {
                result.setText("Cannot divide by zero.");
            }
        }
        else {
            result.setText("Invalid input. Numbers only.");
        }
    }

    public void clearAll(View v){
        etNum1.setText("");
        etNum2.setText("");
        result.setText("The answer will be here");
    }

    public boolean validateZero(String num2){
        if(num2.equals("0"))
            return false;
        else
            return true;
    }
}