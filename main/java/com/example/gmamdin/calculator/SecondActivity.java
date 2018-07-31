package com.example.gmamdin.calculator;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class SecondActivity extends AppCompatActivity {
    private TextView exp;
    private TextView output;
    private Button share;
    private String expression;
    private String out;
    private Toolbar toolbar1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        exp=(TextView)findViewById(R.id.tvExp);
        output=(TextView)findViewById(R.id.textView4);
        share=(Button) findViewById(R.id.button2);
        toolbar1=(Toolbar)findViewById(R.id.toolbar1);
        toolbar1.setTitle("Calculator");

        Bundle bundle=getIntent().getExtras();
        expression=bundle.getString("expression");
        out=bundle.getString("output");
        exp.setText(expression);
        output.setText(out);


        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_TEXT,expression+"\n"+out);
                startActivity(Intent.createChooser(intent, "You can share via"));

            }
        });

    }

}
