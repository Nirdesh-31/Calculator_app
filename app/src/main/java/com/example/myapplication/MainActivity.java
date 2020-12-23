package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

//import com.faendir.rhino_android.RhinoAndroidHelper;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

public class MainActivity extends AppCompatActivity {

    Button btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btnPlus,btnMinus,btnDivide,btnMultiply,btnClear,btnEquals,btnBrackets,btnPercent,btnDot;
    TextView input,output;
    String process;
    boolean check=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn0=(Button) findViewById(R.id.btn0);
        btn1=(Button) findViewById(R.id.btn1);
        btn2=(Button) findViewById(R.id.btn2);
        btn3=(Button) findViewById(R.id.btn3);
        btn4=(Button) findViewById(R.id.btn4);
        btn5=(Button) findViewById(R.id.btn5);
        btn6=(Button) findViewById(R.id.btn6);
        btn7=(Button) findViewById(R.id.btn7);
        btn8=(Button) findViewById(R.id.btn8);
        btn9=(Button) findViewById(R.id.btn9);
        btnPercent=(Button) findViewById(R.id.btnPercent);
        btnPlus=(Button) findViewById(R.id.btnPlus);
        btnMinus=(Button) findViewById(R.id.btnMinus);
        btnMultiply=(Button) findViewById(R.id.btnMultiply);
        btnDivide=(Button) findViewById(R.id.btnDivide);
        btnDot=(Button) findViewById(R.id.btnDot);
        btnBrackets=(Button) findViewById(R.id.btnBracket);
        btnEquals=(Button) findViewById(R.id.btnEquals);
        btnClear=(Button) findViewById(R.id.btnClear);

        input=(TextView)findViewById(R.id.input);
        output=(TextView)findViewById(R.id.output);

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText("");
                output.setText("");
                check=false;
            }
        });

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process=input.getText().toString();
                input.setText(process+"0");
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process=input.getText().toString();
                input.setText(process+"1");
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process=input.getText().toString();
                input.setText(process+"2");
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process=input.getText().toString();
                input.setText(process+"3");
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process=input.getText().toString();
                input.setText(process+"4");
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process=input.getText().toString();
                input.setText(process+"5");
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process=input.getText().toString();
                input.setText(process+"6");
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process=input.getText().toString();
                input.setText(process+"7");
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process=input.getText().toString();
                input.setText(process+"8");
            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process=input.getText().toString();
                input.setText(process+"9");
            }
        });

        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process=input.getText().toString();
                input.setText(process+"+");
            }
        });

        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process=input.getText().toString();
                input.setText(process+"-");
            }
        });

        btnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process=input.getText().toString();
                input.setText(process+"÷");
            }
        });

        btnMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process=input.getText().toString();
                input.setText(process+"X");
            }
        });

        btnDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process=input.getText().toString();
                input.setText(process+".");
            }
        });

        btnPercent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process=input.getText().toString();
                input.setText(process+"%");
            }
        });

        btnBrackets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(check==true) {
                    process = input.getText().toString();
                    input.setText(process + ")");
                    check=false;
                }
                else
                {
                    process = input.getText().toString();
                    input.setText(process + "(");
                    check=true;
                }

            }
        });

        btnEquals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check=false;
                process=input.getText().toString();
                String fans="";

                if(process.isEmpty())
                {
                    fans="0.0";
                }
                else {
                    process = process.replaceAll("X", "*");
                    process = process.replaceAll("%", "/100");
                    process = process.replaceAll("÷", "/");

                    Context rhino = Context.enter();

                    rhino.setOptimizationLevel(-1);

                     fans = "";

                    try {
                        Scriptable script = rhino.initStandardObjects();
                        fans = rhino.evaluateString(script, process, "javascript", 1, null).toString();
                    } catch (Exception e) {
                        fans = "0";
                    }
                }

                output.setText(fans);
            }
        });
    }
}
