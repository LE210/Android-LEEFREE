package net.ricerich.leefree;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        setTitle("엑티비티3");

        TextView text = (TextView) findViewById(R.id.textCenter);
        text.setText("조 선");
        TextView textWelcome = (TextView) findViewById(R.id.textWelcome);
        textWelcome.setText("조선의 궁궐에 온것을 환영하오 낯선이여..");

        ImageView image = (ImageView) findViewById(R.id.image11);
        image.setImageResource(R.drawable.se);

        Button btnD = (Button) findViewById(R.id.btnD);
        btnD.setVisibility(View.INVISIBLE);


        new AlertDialog.Builder(MainActivity3.this)
                .setTitle("??? 등장!!")
                .setMessage("당신의 포탈은 문명5_조선으로 통하는 것이였습니다.\n문제를 맞추고 포탈을 여세요.")
                .show();

        TextView te10 = (TextView) findViewById(R.id.te10);
        TextView te1 = (TextView) findViewById(R.id.te1);
        te1.setBackgroundColor(Color.RED);

        Button btnL = (Button) findViewById(R.id.btnL);
        btnL.setText("왼쪽으로 이동");
        btnL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity3.this, MainActivity5.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);

            }
        });

        Button btnR = (Button) findViewById(R.id.btnR);
        btnR.setText("오른쪽으로 이동");
        btnR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                TextView te2 = (TextView) findViewById(R.id.te2);
//                te2.setBackgroundColor(Color.RED);
//                te2.setText("현재 위치");
//                te2.setTextColor(Color.WHITE);
//                te1.setBackgroundColor(Color.BLACK);
                View view = getLayoutInflater().inflate(R.layout.dialong, null);
                TextView textLine = (TextView) view.findViewById(R.id.textLine);
                ImageView image = (ImageView) view.findViewById(R.id.dialogImage);
                textLine.setBackgroundColor(Color.BLACK);
                new AlertDialog.Builder(MainActivity3.this)
                        .setTitle("오른쪽 포탈로 이동")
                        .setMessage("당신은 추천을 무시하고 오른쪽으로 향합니다..\n포탈을 통과한 당신의 눈앞에 수많은 사람들과 앞에 있는 안대를 낀 사람이 보입니다.\n[당신] : 기침을 함")
                        .setView(view)
                        .setCancelable(false)
                        .setPositiveButton("오른쪽으로", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent = new Intent(MainActivity3.this, MainActivity4.class);
                                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                startActivity(intent);
                            }
                        })
                        .show();
            }
        });

        Button btnMun = (Button) findViewById(R.id.btnMun);
        btnMun.setText("문제 풀기");
        btnMun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View munje = getLayoutInflater().inflate(R.layout.munje, null);
                EditText edtmun = (EditText) munje.findViewById(R.id.edt1);
                new AlertDialog.Builder(MainActivity3.this)
                        .setTitle("문제")
                        .setMessage("짐의 이름을 맞추거라")
                        .setView(munje)
                        .setCancelable(false)
                        .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                String Mun = edtmun.getText().toString();

                                if (Mun.equals("세종대왕")) {
                                    Toast.makeText(getApplicationContext(), "대단한 녀석이군", Toast.LENGTH_SHORT).show();
                                    TextView Good = (TextView) findViewById(R.id.textWelcome);
                                    Good.setText("포탈이 생성되었다네,\n다음으로 넘어가시게나..\n짐은 왼쪽포탈을 추천하다네..");
                                    Good.setTextColor(Color.RED);
                                    btnR.setEnabled(true);
                                    btnL.setEnabled(true);
                                    btnMun.setEnabled(false);
                                    btnMun.setText("포탈 생성");


                                } else {
                                    View view = getLayoutInflater().inflate(R.layout.dialong, null);
                                    new AlertDialog.Builder(MainActivity3.this)
                                            .setTitle("딱한 자로구나...")
                                            .setMessage("돌아가거라")
                                            .setView(view)
                                            .setPositiveButton("OK...", new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialog, int which) {
                                                    Intent intent = new Intent(MainActivity3.this, MainActivity.class);
                                                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                                    startActivity(intent);
                                                }
                                            })
                                            .setCancelable(false)
                                            .show();


                                }
                            }
                        })
                        .show();
            }
        });


        Button btnFinish = (Button) findViewById(R.id.btnD);
        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                te10.setBackgroundColor(Color.RED);
                te10.setText("현재 위치");
                te10.setTextColor(Color.WHITE);

                if (te10.getText().toString() == "현재 위치") {
                    View view = getLayoutInflater().inflate(R.layout.dialong, null);
                    new AlertDialog.Builder(MainActivity3.this)
                            .setTitle("탈출 성공!!")
                            .setMessage("축하합니다")
                            .setView(view)
                            .show();
                }
            }
        });

    }
}