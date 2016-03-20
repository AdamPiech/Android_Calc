package com.calculator.adampiech.calculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Calc extends Activity {

    TextView calcView;
    TextView resultView;

    Button buttonOne;
    Button buttonTwo;
    Button buttonThree;

    Button buttonClean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_calc);

        calcView = (TextView)findViewById(R.id.calcView);
        resultView = (TextView)findViewById(R.id.resultView);

        buttonOne = (Button)findViewById(R.id.buttonOne);
        buttonTwo = (Button)findViewById(R.id.buttonTwo);
        buttonThree = (Button)findViewById(R.id.buttonThree);

        buttonClean = (Button)findViewById(R.id.buttonClean);

        buttonOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ("0".equals(calcView.getText().toString())) {
                    calcView.setText("");
                    resultView.setText("");
                }
                calcView.setText(calcView.getText().toString() +  buttonOne.getText().toString());
                resultView.setText(resultView.getText().toString() + buttonOne.getText().toString());
            }
        });

        buttonTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ("0".equals(calcView.getText().toString())) {
                    calcView.setText("");
                    resultView.setText("");
                }
                calcView.setText(calcView.getText().toString() +  buttonTwo.getText().toString());
                resultView.setText(resultView.getText().toString() + buttonTwo.getText().toString());
            }
        });

        buttonThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ("0".equals(calcView.getText().toString())) {
                    calcView.setText("");
                    resultView.setText("");
                }
                calcView.setText(calcView.getText().toString() +  buttonThree.getText().toString());
                resultView.setText(resultView.getText().toString() + buttonThree.getText().toString());
            }
        });

        buttonClean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calcView.setText("0");
                resultView.setText("0");
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_calculator, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_basic_calc) {
            setContentView(R.layout.activity_basic_calc);
            return true;
        }
        if (id == R.id.action_scientific_calc) {
            setContentView(R.layout.activity_scientific_calc);
            return true;
        }
        if (id == R.id.action_about) {
            setContentView(R.layout.activity_about_app);
            return true;
        }
        if (id == R.id.action_exit) {
            finish();
            System.exit(0);
        }
        return super.onOptionsItemSelected(item);
    }
}
