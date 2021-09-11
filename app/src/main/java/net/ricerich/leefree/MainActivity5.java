package net.ricerich.leefree;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity5 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        setTitle("액티비티 5");

        TextView textcen = (TextView) findViewById(R.id.textCenter);
        textcen.setText("선택의 장소");

        ImageView imageView = (ImageView) findViewById(R.id.image11);
        imageView.setImageResource(R.drawable.road3);

        TextView viewWelcome = (TextView) findViewById(R.id.textWelcome);
        viewWelcome.setText("당신은 세개의 포탈 앞에 섰습니다.\n한곳은 휘슬소리가 들리고 있고," +
                "\n한곳은 파도소리가 나며\n 나머지 한곳은 아무소리도 들리지 않습니다.");

        Button btnMun = (Button) findViewById(R.id.btnMun);
        btnMun.setText("어느쪽으로 향하시겠습니까?");
        btnMun.setEnabled(false);

        Button btnL = (Button) findViewById(R.id.btnL);
        btnL.setEnabled(true);
        btnL.setText("휘슬 소리가 나는 곳");
        btnL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View view = getLayoutInflater().inflate(R.layout.dialong,null);
                ImageView imageView1 = (ImageView) view.findViewById(R.id.dialogImage);
                new AlertDialog.Builder(MainActivity5.this)
                        .setTitle("휘슬 소리가 나는 곳")
                        .setMessage("이쪽 포탈로 들어가시겠습니까??")
                        .setView(view)
                        .setPositiveButton("가자!", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                View view = getLayoutInflater().inflate(R.layout.dialong,null);
                                ImageView imageView1 = (ImageView) view.findViewById(R.id.dialogImage);
                                imageView1.setImageResource(R.drawable.red);
                                new AlertDialog.Builder(MainActivity5.this)
                                        .setTitle("퇴장")
                                        .setMessage("당신은 축구경기장에 난입했습니다!\n퇴장")
                                        .setView(view)
                                        .setCancelable(false)
                                        .setPositiveButton("...", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                Intent intent = new Intent(MainActivity5.this,MainActivity.class);
                                                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                                startActivity(intent);
                                            }
                                        })
                                        .show();
                            }
                        })
                        .setNegativeButton("다시 생각해보자", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        })
                        .show();
            }
        });

        Button btnR = (Button) findViewById(R.id.btnR);
        btnR.setText("파도소리가 나는 곳");
        btnR.setEnabled(true);
        btnR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View view = getLayoutInflater().inflate(R.layout.dialong,null);
                new AlertDialog.Builder(MainActivity5.this)
                        .setTitle("파도 소리가 나는 곳")
                        .setMessage("이쪽 포탈로 들어가시겠습니까?")
                        .setView(view)
                        .setPositiveButton("가자", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                View view = getLayoutInflater().inflate(R.layout.dialong,null);
                                ImageView imageView1 = (ImageView) view.findViewById(R.id.dialogImage);
                                imageView1.setImageResource(R.drawable.sha);
                                new AlertDialog.Builder(MainActivity5.this)
                                        .setTitle("사망")
                                        .setMessage("당신은 바다에 떨어졌습니다.\n당신의 근처에는 상어무리가 있었고,\n상어에게 먹혔습니다.")
                                        .setView(view)
                                        .setPositiveButton("...", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                Intent intent = new Intent(MainActivity5.this,MainActivity.class);
                                                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                                startActivity(intent);
                                            }
                                        })
                                        .setCancelable(false)
                                        .show();
                            }
                        })
                        .setNegativeButton("다시한번 생각을", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        })
                        .show();
            }
        });

        Button btnD = (Button) findViewById(R.id.btnD);
        btnD.setText("아무소리도 나지 않는 곳");
        btnD.setEnabled(true);
        btnD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View view = getLayoutInflater().inflate(R.layout.dialong,null);
                new AlertDialog.Builder(MainActivity5.this)
                        .setTitle("아무소리도 나지 않는 곳")
                        .setMessage("이쪽 포탈로 향하시겠습니까?")
                        .setView(view)
                        .setPositiveButton("가자", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                View view = getLayoutInflater().inflate(R.layout.dialong,null);
                                ImageView imageView1 = (ImageView) view.findViewById(R.id.dialogImage);
                                imageView1.setImageResource(R.drawable.home);
                                new AlertDialog.Builder(MainActivity5.this)
                                        .setTitle("집")
                                        .setMessage("축하합니다.\n당신은 무사히 집에 도착했습니다.\n당신은 안도감을 느끼며 대문을 엽니다..")
                                        .setView(view)
                                        .setCancelable(false)
                                        .setPositiveButton("문을 열다", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                Intent intent = new Intent(MainActivity5.this,MainActivity.class);
                                                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                                startActivity(intent);
                                            }
                                        })
                                        .show();
                            }
                        })
                        .setNegativeButton("다시 한번 생각을", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        })
                        .show();
            }
        });

    }
}