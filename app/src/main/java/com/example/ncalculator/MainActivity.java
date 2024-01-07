package com.example.ncalculator;


import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

  String prev = "0";

    public void numpress(int a){
        TextView currenttxt= (TextView) findViewById(R.id.calcview);
        if (currenttxt.getText().toString().equals("0")){
            currenttxt.setText(Integer.toString(a));
        }else{
            String temp;
            temp = currenttxt.getText().toString();
            currenttxt.setText(temp+ Integer.toString(a));

        }


    }
    private View.OnClickListener numbers = new View.OnClickListener(){
        public void onClick(View v) {
            numpress(Integer.parseInt(((Button) v).getText().toString()));
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button bu0 = (Button) findViewById(R.id.b0);
        Button bu1 = (Button) findViewById(R.id.b1);
        Button bu2 = (Button) findViewById(R.id.b2);
        Button bu3 = (Button) findViewById(R.id.b3);
        Button bu4 = (Button) findViewById(R.id.b4);
        Button bu5 = (Button) findViewById(R.id.b5);
        Button bu6 = (Button) findViewById(R.id.b6);
        Button bu7 = (Button) findViewById(R.id.b7);
        Button bu8 = (Button) findViewById(R.id.b8);
        Button bu9 = (Button) findViewById(R.id.b9);
        Button buPl = (Button) findViewById(R.id.bplus);
        Button buMi = (Button) findViewById(R.id.bminus);
        Button buEq = (Button) findViewById(R.id.bequa);
        Button buCE = (Button) findViewById(R.id.bCE);
        bu0.setOnClickListener(numbers);
        bu1.setOnClickListener(numbers);
        bu2.setOnClickListener(numbers);
        bu3.setOnClickListener(numbers);
        bu4.setOnClickListener(numbers);
        bu5.setOnClickListener(numbers);
        bu6.setOnClickListener(numbers);
        bu7.setOnClickListener(numbers);
        bu8.setOnClickListener(numbers);
        bu9.setOnClickListener(numbers);


        buPl.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                TextView currentview= (TextView) findViewById(R.id.calcview);
                prev = currentview.getText().toString() + '+';
                currentview.setText("0");
            }
        });


        buMi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView currentview = (TextView) findViewById(R.id.calcview);
                prev = currentview.getText().toString() + '-';
                currentview.setText("0");
            }
        });
        buCE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView currentview = (TextView) findViewById(R.id.calcview);
                if(prev.charAt(prev.length()-1) == '+' || prev.charAt(prev.length()-1) == '-'){
                    currentview.setText(prev.substring(0, prev.length()-1));
                    prev = "0";
                }else{
                    currentview.setText("0");
                    prev = "0";
                }
            }
        });


        buEq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // TextView currentview = (TextView) findViewById(R.id.calcview);
               // currentview.setText(prev);
                    int le = prev.length();

                if(prev != "0"){
                if(prev.charAt(le-1) == '+'){
                    int pre = Integer.parseInt(prev.substring(0, (prev.length()-1)));
                    TextView currentview = (TextView) findViewById(R.id.calcview);
                    int erg = pre + Integer.parseInt(currentview.getText().toString());
                    currentview.setText(Integer.toString(erg));
                }else{
                    int pre = Integer.parseInt(prev.substring(0, (prev.length()-1)));
                    TextView currentview = (TextView) findViewById(R.id.calcview);
                    int erg = pre - Integer.parseInt(currentview.getText().toString());
                    currentview.setText(Integer.toString(erg));
                }
            }
        }});
    }


}

