package com.example.cv1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import android.util.Patterns.EMAIL_ADDRESS

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val FULLNAME = findViewById<View>(R.id.Fullname) as EditText;
        val EMAIL = findViewById<View>(R.id.Email) as EditText;
        val AGE = findViewById<View>(R.id.Age) as EditText;
        val seekBarANDROID = findViewById<View>(R.id.seekBarANDROID) as SeekBar;
        val seekBarIOS = findViewById<View>(R.id.seekBarIOS) as SeekBar;
        val seekBarFLUTTER = findViewById<View>(R.id.seekBarFLUTTER) as SeekBar;
        val RG = findViewById<RadioGroup>(R.id.RG) as RadioGroup;
        val homme = findViewById<RadioButton>(R.id.homme) as RadioButton;
        val femme = findViewById<RadioButton>(R.id.femme) as RadioButton;

        val reset = findViewById<Button>(R.id.Reset) as Button;
        val next = findViewById<Button>(R.id.NEXT) as Button;



        reset.setOnClickListener{
            FULLNAME.setText("");
            EMAIL.setText("");
            AGE.setText("");
            RG.clearCheck();
            homme.setChecked(true);
            seekBarANDROID.setProgress(0);
            seekBarIOS.setProgress(0);
            seekBarFLUTTER.setProgress(0);
        }
        next.setOnClickListener{
            if (FULLNAME.text.toString()=="" || AGE.text.toString()=="" || EMAIL.text.toString()=="" )
            {
                Toast.makeText(this,"please fill all the inputs",Toast.LENGTH_LONG).show();
            }
            else {
                val str = EMAIL.text.toString();
                if (!android.util.Patterns.EMAIL_ADDRESS.matcher(str).matches())
                {
                    Toast.makeText(this,"please write a proper email",Toast.LENGTH_LONG).show();
                }
                else
                {
                    if (seekBarANDROID.progress >= 80 && seekBarANDROID.progress>=seekBarIOS.progress && seekBarANDROID.progress>=seekBarFLUTTER.progress )
                    {
                        Toast.makeText(this,"Vous êtes excellent en\n" +
                                "ANDROID",Toast.LENGTH_LONG).show();
                    }
                    else if (seekBarIOS.progress >= 80 && seekBarIOS.progress>=seekBarANDROID.progress && seekBarIOS.progress>=seekBarFLUTTER.progress )
                    {
                        Toast.makeText(this,"Vous êtes excellent en\n" +
                                "IOS",Toast.LENGTH_LONG).show();
                    }
                    else if (seekBarFLUTTER.progress >= 80 && seekBarFLUTTER.progress>=seekBarANDROID.progress && seekBarFLUTTER.progress>=seekBarIOS.progress )
                    {
                        Toast.makeText(this,"Vous êtes excellent en\n" +
                                "FLUTTER",Toast.LENGTH_LONG).show();
                    }
                    else if (seekBarANDROID.progress >= 30 && seekBarFLUTTER.progress >= 30 && seekBarIOS.progress >= 30 )
                    {
                        Toast.makeText(this,"Vous avez de bons skills !"
                               ,Toast.LENGTH_LONG).show();
                    }
                    else
                    {
                        Toast.makeText(this,"Vous devez\n" +
                                "travailler vos skills",Toast.LENGTH_LONG).show();
                    }
                }
            }

        }
    }
}