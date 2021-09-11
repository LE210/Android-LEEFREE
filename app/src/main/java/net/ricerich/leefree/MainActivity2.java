package net.ricerich.leefree;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        setTitle("갈림길1");

        ImageView road = (ImageView) findViewById(R.id.image11);
        road.setImageResource(R.drawable.road);

        TextView center = (TextView) findViewById(R.id.textCenter);
        center.setText("갈림길 도착");

        TextView ex = (TextView) findViewById(R.id.textWelcome);
        ex.setText("당신은 갈림길에 도착했습니다.\n 왼쪽의 포탈은 밝은 태양 빛이 나고 오른쪽은 어두컴컴합니다.\n어느쪽으로 향하시겠습니까?");

        Button btnD = (Button) findViewById(R.id.btnD);
        btnD.setVisibility(View.INVISIBLE);

        Button btnMun = (Button) findViewById(R.id.btnMun);
        btnMun.setEnabled(false);
        btnMun.setText("아래 버튼을 눌려 선택하세요.");

        Button btnL = (Button) findViewById(R.id.btnL);
        btnL.setText("왼쪽");
        btnL.setEnabled(true);
        btnL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View view = getLayoutInflater().inflate(R.layout.dialong,null);
                TextView textLine = (TextView) view.findViewById(R.id.textLine);
                textLine.setBackgroundColor(Color.BLACK);
                ImageView image = (ImageView) view.findViewById(R.id.dialogImage);
                image.setImageResource(R.drawable.fire);
                new AlertDialog.Builder(MainActivity2.this)
                        .setTitle("사망")
                        .setMessage("그 포탈은 너무 뜨거웠습니다...")
                        .setIcon(R.drawable.fire)
                        .setCancelable(false)
                        .setView(view)
                        .setPositiveButton("goodbye", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent = new Intent(MainActivity2.this, MainActivity.class);
                                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                startActivity(intent);
                            }
                        })
                        .show();
            }
        });

        Button btnR = (Button) findViewById(R.id.btnR);
        btnR.setText("오른쪽");
        btnR.setEnabled(true);
        btnR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View view = getLayoutInflater().inflate(R.layout.dialong,null);
                TextView textLine = (TextView) view.findViewById(R.id.textLine);
                textLine.setBackgroundColor(Color.BLUE);
                ImageView image = (ImageView) view.findViewById(R.id.dialogImage);

                new AlertDialog.Builder(MainActivity2.this)
                        .setTitle("생존")
                        .setMessage("어두움은 잠시뿐, 곧 밝은 길이 나타났습니다.")
                        .setIcon(R.drawable.goodjob)
                        .setCancelable(false)
                        .setView(view)
                        .setPositiveButton("다음으로", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent = new Intent(MainActivity2.this,MainActivity3.class);
                                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                startActivity(intent);
                            }
                        })
                        .show();

            }
        });
    }
}