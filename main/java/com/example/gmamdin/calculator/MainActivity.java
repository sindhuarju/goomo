package com.example.gmamdin.calculator;

import android.content.Intent;
import android.nfc.Tag;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    private EditText number;
    private EditText number1;
    private Spinner operations;
    private Button button;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        number=(EditText) findViewById(R.id.etNumber1);
        number1=(EditText) findViewById(R.id.etNumber2);
        operations=(Spinner)findViewById(R.id.spinner);
        button=(Button)findViewById(R.id.button);
        toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("Calculator");


        String[] items = new String[]{"+", "-", "*", "/"};
        final ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.items,R.layout.support_simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        operations.setAdapter(adapter);
        operations.setSelection(adapter.getPosition("+"));
        operations.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String selected=adapterView.getItemAtPosition(i).toString();
                //Toast.makeText(adapterView.getContext(),selected,Toast.LENGTH_LONG);
                operations.setSelection(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                operations.setSelection(0);
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                float num=Float.parseFloat(number.getText().toString());
                float num1=Float.parseFloat(number1.getText().toString());
                String option =operations.getSelectedItem().toString();
                String expression="Expression is "+number.getText().toString()+option+number1.getText().toString();
                String result="Result is ";

                        if((number1.getText().toString().equals(""))){
                           // error.setText("Enter a value");
                            Snackbar.make(view,"Enter a value",Snackbar.LENGTH_LONG)
                                    .setAction("Action",null).show();

                        }
                        else if((number.getText().toString().equals(""))){
                            //error.setText("Enter a value");
                            Snackbar.make(view,"Enter a value",Snackbar.LENGTH_LONG)
                                    .setAction("Action",null).show();
                        }
                        else if((option.equals("/")) && ((int)num1==0)){
                            //error.setText("Divison by zero is not allowed");
                            Snackbar.make(view,"Divison by zero is not allowed",Snackbar.LENGTH_LONG)
                                    .setAction("Action",null).show();
                        }
                        else {
                            if(option.equals("+")) {
                                result= result+String.valueOf(num+num1);
                            }
                            else if(option.equals("-")){
                                result = result+String.valueOf(num-num1);
                            }
                            else if(option.equals("*")){
                                result = result+String.valueOf(num*num1);
                            }
                            else{
                                result =result+ String.valueOf(num/num1);
                            }
                            Intent intent=new Intent(MainActivity.this,SecondActivity.class);
                            intent.putExtra("expression",expression);
                            intent.putExtra("output",result);
                            startActivity(intent);
                        }


                }
                catch (Exception e){
                   // error.setText("Enter a valid number");
                    Snackbar.make(view,"Enter a valid number",Snackbar.LENGTH_LONG)
                            .setAction("Action",null).show();

                }
            }
        });

    }

}
