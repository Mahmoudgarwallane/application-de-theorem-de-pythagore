package com.example.android.theorem_de_pythagore;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class MainActivity3 extends AppCompatActivity {
    EditText numéro1;
    EditText numéro2;
    EditText numéro3;
    TextView show;
    Button verifier;

    Double numberone;
    Double numbertwo;
    Double numberthree;
    Double number1;
    Double number2;
    Double number3;
    Double result;
    String textToShow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        numéro1 =(EditText)findViewById(R.id.numéro1);
        numéro2 =(EditText)findViewById(R.id.numéro2);
        numéro3 =(EditText)findViewById(R.id.numéro3);
        show =(TextView) findViewById(R.id.show);
        verifier =(Button) findViewById(R.id.verifier);

        verifier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    number1 = Double.parseDouble(numéro1.getText().toString());
                    number2 = Double.parseDouble(numéro2.getText().toString());
                    number3 = Double.parseDouble(numéro3.getText().toString());
                    reciproque(number1,number2,number3);
                }catch (Exception x){
                    Toast.makeText(getBaseContext(), R.string.enter_un_nombre, Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
    public void reciproque(double number1, double number2, double number3){
        //List<Double> nums = Arrays.asList(number1, number2, number3);
        List<Double> nums = new LinkedList<Double>();
        nums.add(number1);
        nums.add(number2);
        nums.add(number3);
        numberone = Collections.max(nums);
        numbertwo = Collections.min(nums);
        nums.remove(numberone);
        nums.remove(numbertwo);
        numberthree = Double.parseDouble(String.valueOf(nums.get(0)));
        numberthree = Math.pow(numberthree,2);
        numbertwo = Math.pow(numbertwo,2);
        result = numbertwo+numberthree;
        result = Math.sqrt(result);

        if (result.equals(numberone)){
            textToShow = (getString(R.string.ce_triangle_est_rectangle)) ;
            show.setText(textToShow);
        }else{
            textToShow = (getString(R.string.pas_rectangle));
            show.setText(textToShow);
        }



    }
}