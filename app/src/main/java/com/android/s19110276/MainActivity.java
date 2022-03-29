package com.android.s19110276;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "CalculatorActivity";

    private Calculator mCalculator;

    private EditText mOperandOneEditText;
    private EditText mOperandTwoEditText;

    private TextView mResultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mCalculator = new Calculator();
        mResultTextView = findViewById(R.id.textView_result);
        mOperandOneEditText = findViewById(R.id.txt_operand1);
        mOperandTwoEditText = findViewById(R.id.txt_operand2);
    }

    public void onAdd(View view) {
        compute(Calculator.Operator.ADD);
    }

    public void onSub(View view) {
        compute(Calculator.Operator.SUB);
    }

    public void onMul(View view) {
        compute(Calculator.Operator.MUL);
    }

    public void onDiv(View view) {
        try {
            compute(Calculator.Operator.DIV);
        } catch (IllegalArgumentException iae) {
            Log.e(TAG, "IllegalArgumentException", iae);
            mResultTextView.setText(getString(R.string.computationError));
        }
    }

    public void onExp(View view) {
        compute(Calculator.Operator.EXP);
    }

    public void onFact(View view) {
        compute(Calculator.Operator.FACT);
    }

    public void onLoga(View vie) {
        compute(Calculator.Operator.LOGA);
    }

    private void compute(Calculator.Operator operator) {
        double operandOne;
        double operandTwo = 0;
        try {
            operandOne = getOperand(mOperandOneEditText);
            if (operator != Calculator.Operator.FACT)
                operandTwo = getOperand(mOperandTwoEditText);
        } catch (NumberFormatException nfe) {
            Log.e(TAG, "NumberFormatException", nfe);
            mResultTextView.setText(getString(R.string.computationError));
            return;
        }

        String result;
        switch (operator) {
            case ADD:
                result = String.valueOf(mCalculator.add(operandOne, operandTwo));
                break;
            case SUB:
                result = String.valueOf(mCalculator.sub(operandOne, operandTwo));
                break;
            case MUL:
                result = String.valueOf(mCalculator.mul(operandOne, operandTwo));
                break;
            case DIV:
                result = String.valueOf(mCalculator.div(operandOne, operandTwo));
                break;
            case EXP:
                result = String.valueOf(mCalculator.exp(operandOne, operandTwo));
                break;
            case FACT:
                result = String.valueOf(mCalculator.fact(operandOne));
                break;
            case LOGA:
                result = String.valueOf(mCalculator.loga(operandOne, operandTwo));
                break;
            default:
                result = getString(R.string.computationError);
                break;
        }
        mResultTextView.setText(result);
    }

    private static Double getOperand(EditText operandEditText) {
        String operandText = getOperandText(operandEditText);
        return Double.valueOf(operandText);
    }

    private static String getOperandText(EditText operandEditText) {
        return operandEditText.getText().toString();
    }
}