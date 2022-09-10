package com.example.cuocduakithu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView tvDiem;
    ImageButton ibPlay;
    CheckBox cb1,cb2,cb3;
    SeekBar sb1,sb2,sb3;
    int soDiem=100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AnhXa();

        DisableSeekBar();

        tvDiem.setText(soDiem+"");

        CountDownTimer countDownTimer=new CountDownTimer(60000,30) {
            @Override
            public void onTick(long l) {
                int number=2;
                Random random= new Random();
                int one=random.nextInt(number);
                int two=random.nextInt(number);
                int three=random.nextInt(number);

                if (sb1.getProgress()>=sb1.getMax()){
                    this.cancel();
                    ibPlay.setVisibility(View.VISIBLE);
                    Toast.makeText(MainActivity.this,"MOTOR 1 WIN",Toast.LENGTH_SHORT).show();

                    if(cb1.isChecked()){
                        soDiem+=10;
                        Toast.makeText(MainActivity.this, "Chinh Xac", Toast.LENGTH_SHORT).show();
                    }else{
                        soDiem-=10;
                        Toast.makeText(MainActivity.this, "Sai Roi", Toast.LENGTH_SHORT).show();
                    }tvDiem.setText(soDiem+"");
                    EnableCheckBox();
                }
                if (sb2.getProgress()>=sb2.getMax()){
                    this.cancel();
                    ibPlay.setVisibility(View.VISIBLE);
                    Toast.makeText(MainActivity.this, "MOTOR 2 WIN", Toast.LENGTH_SHORT).show();

                    if(cb2.isChecked()){
                        soDiem+=10;
                        Toast.makeText(MainActivity.this, "Chinh Xac", Toast.LENGTH_SHORT).show();
                    }else{
                        soDiem-=10;
                        Toast.makeText(MainActivity.this, "Sai Roi", Toast.LENGTH_SHORT).show();
                    }tvDiem.setText(soDiem+"");
                    EnableCheckBox();
                }
                if (sb3.getProgress()>=sb3.getMax()){
                    this.cancel();
                    ibPlay.setVisibility(View.VISIBLE);
                    Toast.makeText(MainActivity.this, "MOTOR 3 WIN", Toast.LENGTH_SHORT).show();

                    if(cb3.isChecked()){
                        soDiem+=10;
                        Toast.makeText(MainActivity.this, "Chinh Xac", Toast.LENGTH_SHORT).show();
                    }else{
                        soDiem-=10;
                        Toast.makeText(MainActivity.this, "Sai Roi", Toast.LENGTH_SHORT).show();
                    }tvDiem.setText(soDiem+"");
                    EnableCheckBox();
                }

                sb1.setProgress(sb1.getProgress()+one);
                sb2.setProgress(sb2.getProgress()+two);
                sb3.setProgress(sb3.getProgress()+three);
            }

            @Override
            public void onFinish() {

            }
        };
        ibPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cb1.isChecked() || cb2.isChecked()){
                    sb1.setProgress(0);
                    sb2.setProgress(0);
                    sb3.setProgress(0);
                
                ibPlay.setVisibility(View.INVISIBLE);
                countDownTimer.start();

                DisableCheckBox();
                }else{
                    Toast.makeText(MainActivity.this, "VUI LONG DAT CUOC", Toast.LENGTH_SHORT).show();
                }
            }
        });

        cb1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    cb2.setChecked(false);
                    cb3.setChecked(false);
                }
            }
        });
        cb2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    cb1.setChecked(false);
                    cb3.setChecked(false);
            }
        });
        cb3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    cb1.setChecked(false);
                    cb2.setChecked(false);

            }
        });
    }

    private void EnableCheckBox(){
        cb1.setEnabled(true);
        cb2.setEnabled(true);
        cb3.setEnabled(true);
    }

    private void DisableCheckBox(){
        cb1.setEnabled(false);
        cb2.setEnabled(false);
        cb3.setEnabled(false);
    }

    private void DisableSeekBar(){
        sb1.setEnabled(false);
        sb2.setEnabled(false);
        sb3.setEnabled(false);
    }
    private void AnhXa(){
        tvDiem = (TextView) findViewById(R.id.textviewDiem);
        ibPlay =(ImageButton) findViewById(R.id.imagebuttonPlay);
        cb1=(CheckBox) findViewById(R.id.checkbox1);
        cb2=(CheckBox) findViewById(R.id.checkbox2);
        cb3=(CheckBox) findViewById(R.id.checkbox3);
        sb1=(SeekBar) findViewById(R.id.seekbar1);
        sb2=(SeekBar) findViewById(R.id.seekbar2);
        sb3=(SeekBar) findViewById(R.id.seekbar3);
    }
}