package com.example.calculationfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
public class ptb2 extends AppCompatActivity {

    EditText edtA,edtB,edtC;
    ListView listView;
    ArrayList<String> arrayList;
    ArrayAdapter<String> arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ptb2);
        edtA=findViewById(R.id.edt_a);
        edtB=findViewById(R.id.edt_b);
        edtC=findViewById(R.id.edt_c);
        listView=findViewById(R.id.lv_lv);
        arrayList =new ArrayList<String>();
        arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,arrayList);
        listView.setAdapter(arrayAdapter);
    }

    public void clickOK(View v) {
        //kiem tra la so
        int count=0;
        if((!checkIsNumber(edtA.getText().toString())||(!checkIsNumber(edtB.getText().toString())||(!checkIsNumber(edtC.getText().toString()))))){
            Toast.makeText(ptb2.this,"nhap sai kieu du lieu",Toast.LENGTH_LONG).show();
            count++;
        }
        //kiem tra nhap
        if(!checkInput(edtA.getText().toString(),edtB.getText().toString(),edtC.getText().toString())) {
            Toast.makeText(ptb2.this,"chua nhap du du lieu",Toast.LENGTH_LONG).show();
            count++;
        }
        if(count==0) {
            String a, b, c;
            double x1, x2;
            a = edtA.getText().toString();
            if (Integer.parseInt(edtB.getText().toString()) >= 0) {
                b = "+" + edtB.getText().toString();
            } else {
                b = edtB.getText().toString();
            }
            if (Integer.parseInt(edtC.getText().toString()) >= 0) {
                c = "+" + edtC.getText().toString();
            } else {
                c = edtC.getText().toString();
            }
            String temp = a + "x^2" + b + "x" + c + "=0";
            double dental = Math.pow(Integer.parseInt(edtB.getText().toString()), 2) - 4 * Integer.parseInt(a) * Integer.parseInt(edtC.getText().toString());
            if (dental > 0) {
                x1 = ((-1) * Integer.parseInt(edtB.getText().toString()) + Math.sqrt(dental)) / (2 * Integer.parseInt(a));
                x2 = ((-1) * Integer.parseInt(edtB.getText().toString()) - Math.sqrt(dental)) / (2 * Integer.parseInt(a));
                temp = temp + "     " + "pt 2n0" + "\n" + "x1=" + x1 + "    " + "x2=" + x2;
            } else {
                if (dental == 0) {
                    x1 = ((-1) * Integer.parseInt(edtB.getText().toString())) / (2 * Integer.parseInt(a));
                    temp = temp + "     " + "pt 1n0 kep" + "\n" + "x1=x2=" + x1;
                } else {
                    temp = temp + "         " + "pt vo n0";
                }
            }
            arrayList.add(0,temp);
            arrayAdapter.notifyDataSetChanged();
        }
    }
    boolean checkIsNumber(String string) {
        char[] arr=string.toCharArray();
        if(string.length()==1) {
            if( (arr[0]>='0' && arr[0]<='9')) {
                return true;
            }
            return false;
        }
        for(int i=1;i<arr.length;i++) {
            if(arr[0]=='-'|| (arr[0]>='0' && arr[0]<='9')) {
                if(arr[i]<'0' || arr[i]>'9') {
                    return false;
                }
            }else {
                return false;
            }

        }
        return true;
    }
    boolean checkInput(String a,String b,String c) {
        if(a.length()==0||b.length()==0||c.length()==0) {
            return false;
        }
        return true;
    }
    public void deleteAll() {
        arrayList.clear();
        arrayAdapter.notifyDataSetChanged();
    }
    public void clickDelete(View v) {
        edtA.setText("");
        edtB.setText("");
        edtC.setText("");
        deleteAll();

    }
    public void Exit_menu(View v) {
        Intent i = new Intent(ptb2.this, Menu.class);
        startActivity(i);
    }
}
