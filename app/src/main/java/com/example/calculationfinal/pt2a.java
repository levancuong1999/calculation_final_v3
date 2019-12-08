package com.example.calculationfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class pt2a extends AppCompatActivity  {
    private EditText edit_a,edit_b,edit_c,edit_a1,edit_b1,edit_c1;
    private TextView tv_res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pt2a);
        edit_a = findViewById(R.id.edt_a);
        edit_b = findViewById(R.id.edt_b);
        edit_c = findViewById(R.id.edt_c);
        edit_a1 = findViewById(R.id.edt_a1);
        edit_b1 = findViewById(R.id.edt_b1);
        edit_c1 = findViewById(R.id.edt_c1);
        tv_res=findViewById(R.id.tv_result);

    }

    public void onClickDelete(View v) {
        edit_a.setText("");
        edit_b.setText("");
        edit_c.setText("");
        edit_a1.setText("");
        edit_b1.setText("");
        edit_c1.setText("");
        tv_res.setText("");
    }
    public void onClickResult(View v) {
        Double a,b,c, a1,b1,c1,D,Dx,Dy,x,y;
        a=Double.parseDouble(edit_a.getText().toString());
        b=Double.parseDouble(edit_b.getText().toString());
        c=Double.parseDouble(edit_c.getText().toString());
        a1=Double.parseDouble(edit_a1.getText().toString());
        b1=Double.parseDouble(edit_b1.getText().toString());
        c1=Double.parseDouble(edit_c1.getText().toString());

        D = a * b1 - a1 * b;
        Dx = c * b1 - c1 * b;
        Dy = a * c1 - a1 * c;
        if (D == 0) {
            if (Dx == 0 && Dy == 0) {
                tv_res.setText("hpt vsn");
            }
            else {
                tv_res.setText("hpt vn");
            }
        }
        else {
            x = Dx / D;
            y = Dy / D;
            tv_res.setText("x ="+ x +"\n"+ "y ="+y);
        }
    }
    public void back(View v) {
        Intent i =new Intent( pt2a.this,Menu.class);
        startActivity(i);
    }
}