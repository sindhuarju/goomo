package com.example.gmamdin.fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class Output extends Fragment {

    View view;
    TextView expression;
    TextView result;
    Button share;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view= inflater.inflate(R.layout.fragment_output, container, false);

        expression=(TextView)view.findViewById(R.id.tvExpression);
        result=(TextView)view.findViewById(R.id.tvResult);
        share=(Button)view.findViewById(R.id.btnShare);

        expression.setText(getArguments().getString("Expression"));
        result.setText(getArguments().getString("Result"));
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_TEXT,expression+"\n"+result);
                startActivity(Intent.createChooser(intent, "You can share via"));
            }
        });


        return view;
    }
}
