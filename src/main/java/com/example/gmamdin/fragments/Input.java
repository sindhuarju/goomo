package com.example.gmamdin.fragments;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.support.v7.widget.Toolbar;

public class Input extends Fragment {
    View views;

    private EditText input1;
    private EditText input2;
    private Spinner operations;
    private Button submit;



    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,  Bundle savedInstanceState) {

        views= inflater.inflate(R.layout.fragment_input, container, false);
        input1=(EditText)views.findViewById(R.id.etinput1);
        input2=(EditText)views.findViewById(R.id.etinput2);
        operations=(Spinner)views.findViewById(R.id.spinner);
        submit=(Button)views.findViewById(R.id.btnsubmit);

        String[] items = new String[]{"+", "-", "*", "/"};
        final ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(views.getContext(),R.array.items,R.layout.support_simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        operations.setAdapter(adapter);
        //operations.setSelection(adapter.getPosition("+"));
        operations.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String selected=adapterView.getItemAtPosition(i).toString();
                operations.setSelection(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                operations.setSelection(0);
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    float num=Float.parseFloat(input1.getText().toString());
                    float num1=Float.parseFloat(input2.getText().toString());
                    String option =operations.getSelectedItem().toString();
                    String expression="Expression is "+input1.getText().toString()+option+input2.getText().toString();
                    String result="Result is ";

                    if((input1.getText().toString().equals(""))){
                        // error.setText("Enter a value");
                        Snackbar.make(views,"Enter a value",Snackbar.LENGTH_LONG)
                                .setAction("Action",null).show();

                    }
                    else if((input1.getText().toString().equals(""))){
                        //error.setText("Enter a value");
                        Snackbar.make(views,"Enter a value",Snackbar.LENGTH_LONG)
                                .setAction("Action",null).show();
                    }
                    else if((option.equals("/")) && ((int)num1==0)){
                        //error.setText("Divison by zero is not allowed");
                        Snackbar.make(views,"Divison by zero is not allowed",Snackbar.LENGTH_LONG)
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
                        Bundle bundle=new Bundle();
                        bundle.putString("Expression",expression);
                        bundle.putString("Result",result);
                        Fragment fragment=new Output();
                        fragment.setArguments(bundle);
                        FragmentManager fm=getFragmentManager();
                        FragmentTransaction ft=fm.beginTransaction();
                        ft.replace(R.id.fragments,fragment);
                        ft.commit();

                    }


                }
                catch (Exception e) {
                    // error.setText("Enter a valid number");
                    Snackbar.make(views, "Enter a valid number", Snackbar.LENGTH_LONG)
                          .setAction("Action", null).show();
                }
            }
        });



        return views;

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
}
