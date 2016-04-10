package com.calculator.adampiech.calculator;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.NumberFormat;

public class Calc extends Activity {

    private TextView calcView;
    private boolean dotFlag = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_calc);
        calcView = (TextView)findViewById(R.id.calcView);
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
            calcView = (TextView)findViewById(R.id.calcView);
            return true;
        }
        if (id == R.id.action_scientific_calc) {
            setContentView(R.layout.activity_scientific_calc);
            calcView = (TextView)findViewById(R.id.calcView);
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

    private void setText (String text) {
        if ("0".equals(calcView.getText().toString())) {
            calcView.setText("");
        }
        if (!".".equals(text) || dotFlag) {
            if ((calcView.getText().length() <= 30 || !calcView.getText().toString().matches(".*[0-9]+"))
                    && (text.matches("[0-9]+") || calcView.getText().toString().matches(".*[0-9]+"))) {
                if (!(text.matches("[0-9\\.]+") && calcView.getText().toString().matches(".*[0-9\\.]+"))) {
                    calcView.setText(calcView.getText().toString() + " " + text);
                } else {
                    calcView.setText(calcView.getText().toString() + text);
                }
            }
        }
        if (".".equals(text)) {
            dotFlag = false;
        }
        if (!text.matches("[0-9\\.]+")) {
            dotFlag = true;
        }
    }

    public void buttonOneAction(View view) {
        setText("1");
    }

    public void buttonTwoAction(View view) {
        setText("2");
    }

    public void buttonThreeAction(View view) {
        setText("3");
    }

    public void buttonFourAction(View view) {
        setText("4");
    }

    public void buttonFiveAction(View view) {
        setText("5");
    }

    public void buttonSixAction(View view) {
        setText("6");
    }

    public void buttonSevenAction(View view) {
        setText("7");
    }

    public void buttonEightAction(View view) {
        setText("8");
    }

    public void buttonNineAction(View view) {
        setText("9");
    }

    public void buttonNaughtAction(View view) {
        setText("0");
    }

    public void buttonDotAction(View view) {
        setText(".");
    }

    public void buttonPlusAction(View view) {
        setText("+");
    }

    public void buttonMinusAction(View view) {
        setText("-");
    }

    public void buttonMultiplyAction(View view) {
        setText("*");
    }

    public void buttonDivideAction(View view) {
        setText("/");
    }

    public void buttonSINAction(View view) {
        setText("sin(");
    }

    public void buttonCOSAction(View view) {
        setText("cos(");
    }

    public void buttonTANAction(View view) {
        setText("tan(");
    }

    public void buttonLOGAction(View view) {
        setText("log(");
    }

    public void buttonLNAction(View view) {
        setText("ln(");
    }

    public void buttonLeftBracketAction(View view) {
        setText("(");
    }

    public void buttonRightBracketAction(View view) {
        setText(")");
    }

    public void buttonFactorialAction(View view) {
        setText("!");
    }

    public void buttonPercentAction(View view) {
        setText("%");
    }

    public void buttonOppositeNumberAction(View view) {
        calcView.setText("1 / ( " + calcView.getText().toString() + " )");
    }

    public void buttonSignChangeAction(View view) {
        calcView.setText("- 1 * ( " + calcView.getText().toString() + " )");
    }

    public void buttonPowerAction(View view) {
        setText("^");
    }

    public void buttonRootAction(View view) {
        setText("sqr (");
    }

    public void buttonCleanAction(View view) {
        calcView.setText("0");
    }

    public void buttonBackAction(View view) {
        if (calcView.getText().length() <= 1) {
            calcView.setText("0");
        } else {
            calcView.setText(calcView.getText().toString().substring(0, calcView.getText().length() - 1));
        }
    }

    public void buttonResultAction(View view) {
        ReversePolishNotation polishNotation = new ReversePolishNotation();
        Log.d("#########",polishNotation.stringToRPN(calcView.getText().toString()));
        calcView.setText(polishNotation.countRPN(polishNotation.stringToRPN(calcView.getText().toString())));
    }

}
