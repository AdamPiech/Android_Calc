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
import java.util.HashSet;
import java.util.Set;

public class Calc extends Activity {

    private TextView calcView;

    private ReversePolishNotation polishNotation;
    private Set<String> messages;
    private boolean dotFlag = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_calc);
        calcView = (TextView)findViewById(R.id.calcView);
        polishNotation = new ReversePolishNotation();
        messages = createMessage();
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

    private Set<String> createMessage() {
        Set<String> messages = new HashSet<>();
        messages.add(" 0 ");
        messages.add("Infinity");
        messages.add("Error");
        return messages;
    }

    private void setText(String text) {
        if (messages.contains(calcView.getText().toString())) {
            calcView.setText("");
        }
        if (!".".equals(text) || dotFlag) {
            if (!(text.matches("[0-9\\.]+") && calcView.getText().toString().matches(".*[0-9\\.]+"))) {
                calcView.setText(calcView.getText().toString() + " " + text);
            } else {
                calcView.setText(calcView.getText().toString() + text);
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
        if (canWriteNumber(calcView.getText().toString())) {
            setText("1");
        }
    }

    public void buttonTwoAction(View view) {
        if (canWriteNumber(calcView.getText().toString())) {
            setText("2");
        }
    }

    public void buttonThreeAction(View view) {
        if (canWriteNumber(calcView.getText().toString())) {
            setText("3");
        }
    }

    public void buttonFourAction(View view) {
        if (canWriteNumber(calcView.getText().toString())) {
            setText("4");
        }
    }

    public void buttonFiveAction(View view) {
        if (canWriteNumber(calcView.getText().toString())) {
            setText("5");
        }
    }

    public void buttonSixAction(View view) {
        if (canWriteNumber(calcView.getText().toString())) {
            setText("6");
        }
    }

    public void buttonSevenAction(View view) {
        if (canWriteNumber(calcView.getText().toString())) {
            setText("7");
        }
    }

    public void buttonEightAction(View view) {
        if (canWriteNumber(calcView.getText().toString())) {
            setText("8");
        }
    }

    public void buttonNineAction(View view) {
        if (canWriteNumber(calcView.getText().toString())) {
            setText("9");
        }
    }

    public void buttonNaughtAction(View view) {
        if (canWriteNumber(calcView.getText().toString())) {
            setText("0");
        }
    }

    public void buttonDotAction(View view) {
        if (canWriteDot(calcView.getText().toString())) {
            setText(".");
        }
    }

    public void buttonPlusAction(View view) {
        if (canWriteOperation(calcView.getText().toString())) {
            setText("+");
        }
    }

    public void buttonMinusAction(View view) {
        if (canWriteOperation(calcView.getText().toString())) {
            setText("-");
        }
    }

    public void buttonMultiplyAction(View view) {
        if (canWriteOperation(calcView.getText().toString())) {
            setText("*");
        }
    }

    public void buttonDivideAction(View view) {
        if (canWriteOperation(calcView.getText().toString())) {
            setText("/");
        }
    }

    public void buttonSINAction(View view) {
        if (canWriteFunction(calcView.getText().toString())) {
            setText("sin (");
        }
    }

    public void buttonCOSAction(View view) {
        if (canWriteFunction(calcView.getText().toString())) {
            setText("cos (");
        }
    }

    public void buttonTANAction(View view) {
        if (canWriteFunction(calcView.getText().toString())) {
            setText("tan (");
        }
    }

    public void buttonLOGAction(View view) {
        if (canWriteFunction(calcView.getText().toString())) {
            setText("log (");
        }
    }

    public void buttonLNAction(View view) {
        if (canWriteFunction(calcView.getText().toString())) {
            setText("ln (");
        }
    }

    public void buttonLeftBracketAction(View view) {
        if (canWriteFunction(calcView.getText().toString())) {
            setText("(");
        }
    }

    public void buttonRightBracketAction(View view) {
        if (canWriteOnlyAfterNumber(calcView.getText().toString())) {
            setText(")");
        }
    }

    public void buttonFactorialAction(View view) {
        if (canWriteOnlyAfterNumber(calcView.getText().toString())) {
            setText("!");
        }
    }

    public void buttonPercentAction(View view) {
        if (canWriteOnlyAfterNumber(calcView.getText().toString())) {
            setText("%");
        }
    }

    public void buttonOppositeNumberAction(View view) {
        if (canWriteOnlyAfterNumber(calcView.getText().toString())) {
            calcView.setText("1 / ( " + calcView.getText().toString() + " )");
        }
    }

    public void buttonSignChangeAction(View view) {
        if (canWriteOnlyAfterNumber(calcView.getText().toString())) {
            calcView.setText("( " + calcView.getText().toString() + " ) * -1");
        }
    }

    public void buttonPowerAction(View view) {
        if (canWriteOperation(calcView.getText().toString())) {
            setText("^");
        }
    }

    public void buttonRootAction(View view) {
        if (canWriteFunction(calcView.getText().toString())) {
            setText("sqrt (");
        }
    }

    public void buttonCleanAction(View view) {
        calcView.setText(" 0 ");
    }

    public void buttonBackAction(View view) {
        if (calcView.getText().length() <= 1) {
            calcView.setText(" 0 ");
        } else {
            calcView.setText(calcView.getText().toString().substring(0, calcView.getText().length() - 1));
            if (calcView.getText().toString().charAt(calcView.getText().toString().length() - 1) == ' ') {
                calcView.setText(calcView.getText().toString().substring(0, calcView.getText().length() - 1));
            }
        }
    }

    public void buttonResultAction(View view) {
        try {
            calcView.setText(polishNotation.countRPN(polishNotation.stringToRPN(calcView.getText().toString())));
        } catch (Exception e) {
            calcView.setText("Error");
        }
    }

    private boolean canWriteNumber(String text) {
        return !text.matches(".*[\\)!%]+");
    }

    private boolean canWriteFunction(String text) {
        return text.matches(".*[\\+\\-\\*/\\^]+") | messages.contains(calcView.getText().toString());
    }

    private boolean canWriteDot(String text) {
        return text.matches(".*[0-9]+");
    }

    private boolean canWriteOperation(String text) {
        return text.matches(".*[0-9\\)!%]+") & !messages.contains(calcView.getText().toString());
    }

    private boolean canWriteOnlyAfterNumber(String text) {
        return text.matches(".*[0-9\\)!%]+");
    }
}
