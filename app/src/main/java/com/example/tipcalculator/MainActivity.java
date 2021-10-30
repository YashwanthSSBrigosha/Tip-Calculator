package com.example.tipcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText bill;
    TextView percentage,tip,total;



    public void decrement(View view){
        bill = (EditText) findViewById(R.id.txtBill);
        percentage = (TextView) findViewById(R.id.txtPercentage);
        tip = (TextView) findViewById(R.id.txtTip);
        total = (TextView) findViewById(R.id.txtTotal);

        String billString = String.valueOf(bill.getText());
        String percentageString = String.valueOf(percentage.getText());

        billString = billString.replace("$","");
        percentageString = percentageString.replace("%","");

        double billDouble = Double.parseDouble(billString);
        int percentageInt = Integer.parseInt(percentageString);

        if (percentageInt>0){
            percentageInt-=10;
            percentage.setText(percentageInt+"%");
            double otherTip=(billDouble*percentageInt)/100;
            tip.setText("$"+otherTip);
            total.setText("$"+(otherTip+billDouble));
        }
        else{
            Toast.makeText(this, "It cannot be lower than 0%", Toast.LENGTH_SHORT).show();
        }


    }

    public void increment(View view){
        bill = (EditText) findViewById(R.id.txtBill);
        percentage = (TextView) findViewById(R.id.txtPercentage);
        tip = (TextView) findViewById(R.id.txtTip);
        total = (TextView) findViewById(R.id.txtTotal);

        String billString = String.valueOf(bill.getText());
        String percentageString = String.valueOf(percentage.getText());

        billString = billString.replace("$","");
        percentageString = percentageString.replace("%","");

        double billDouble = Double.parseDouble(billString);
        int percentageInt = Integer.parseInt(percentageString);

        if (percentageInt<100){
            percentageInt+=10;
            percentage.setText(percentageInt+"%");
            double otherTip=(billDouble*percentageInt)/100;
            tip.setText("$"+otherTip);
            total.setText("$"+(otherTip+billDouble));

        }
        else{
            Toast.makeText(this, "It cannot be lower than 0%", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bill = (EditText) findViewById(R.id.txtBill);
        percentage = (TextView) findViewById(R.id.txtPercentage);
        tip = (TextView) findViewById(R.id.txtTip);
        total = (TextView) findViewById(R.id.txtTotal);



        bill.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (bill.getText().toString().isEmpty()){
                    bill.setText("0");
                }

                String billString = String.valueOf(bill.getText());
                String percentageString = String.valueOf(percentage.getText());
                String tipString = String.valueOf(tip.getText());
                String totalString = String.valueOf(total.getText());

                billString = billString.replace("$","");
                percentageString = percentageString.replace("%","");
                tipString = tipString.replace("$","");
                totalString = totalString.replace("$","");

                double billDouble = Double.parseDouble(billString);
                int percentageInt = Integer.parseInt(percentageString);
                double tipDouble = Double.parseDouble(tipString);
                double totalDouble = Double.parseDouble(totalString);

                double otherTip=(billDouble*percentageInt)/100;
                tip.setText("$"+otherTip);
                total.setText("$"+(otherTip+billDouble));

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
}