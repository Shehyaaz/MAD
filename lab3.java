//Main Activity
package com.example.application1_mj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    EditText e1,e2;
    Button bt;
    Spinner s;
    String [] dept_array={"CSE","ISE","ECE","MECH","CIVIL"};
    String name,reg,dept;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        e1=(EditText) findViewById(R.id.edit2);
        e2=(EditText) findViewById(R.id.edit3);
        bt=(Button) findViewById(R.id.button);
        s=(Spinner) findViewById(R.id.spinner);

        ArrayAdapter adapter=new ArrayAdapter(MainActivity.this,android.R.layout.simple_spinner_item,dept_array);
        s.setAdapter(adapter);

        bt.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                name=e1.getText().toString();
                reg=e2.getText().toString();
                dept=s.getSelectedItem().toString();

                Intent i=new Intent(MainActivity.this,Main2Activity.class);

                i.putExtra("name_key",name);
                i.putExtra("reg_key",reg);
                i.putExtra("dept_key",dept);

                startActivity(i);
            }
        });
    }
}


//Main2 Activity
package com.example.application1_mj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    TextView t1,t2,t3;
    String name,reg,dept;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        t1=(TextView)findViewById(R.id.textView);
        t2=(TextView)findViewById(R.id.textView2);
        t3=(TextView)findViewById(R.id.textView3);

        Intent i=getIntent();
        name=i.getStringExtra("name_key");
        reg=i.getStringExtra("reg_key");
        dept=i.getStringExtra("dept_key");

        t1.setText(name);
        t2.setText(reg);
        t3.setText(dept);
    }
}
