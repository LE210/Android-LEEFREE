package net.ricerich.leefree;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        setTitle("액티비티4");

        TextView textcen = (TextView) findViewById(R.id.textCenter);
        textcen.setText("궁예");
        TextView textWelcome = (TextView) findViewById(R.id.textWelcome);
        textWelcome.setText("\"누가 기침소리를 내었어?\n지금 니놈이 기침을 하였느냐?\"\n[궁예의 연설중에 당신이 기침을 했습니다.\n버튼을 눌려 대답을 하세요.]");
        ImageView imageViewe = (ImageView) findViewById(R.id.image11);
        imageViewe.setImageResource(R.drawable.goong);

        Button btnD = (Button) findViewById(R.id.btnD);
        btnD.setVisibility(View.INVISIBLE);
        Button btnMun = (Button) findViewById(R.id.btnMun);
        btnMun.setEnabled(false);
        btnMun.setText("아래 버튼을 눌려 대답을 하세요");

        View view = getLayoutInflater().inflate(R.layout.dialong,null);
        ImageView image = (ImageView) view.findViewById(R.id.dialogImage);
        new AlertDialog.Builder(MainActivity4.this)
                .setTitle("???")
                .setMessage("누구인가?")
                .setView(view)
                .show();

        Button btnL = (Button) findViewById(R.id.btnL);
        btnL.setEnabled(true);
        btnL.setText("예");
        btnL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View view = getLayoutInflater().inflate(R.layout.dialong,null);
                ImageView image = (ImageView) view.findViewById(R.id.dialogImage);
                image.setImageResource(R.drawable.cul);
                new AlertDialog.Builder(MainActivity4.this)
                        .setTitle("마구니가 끼었구나...")
                        .setMessage("저놈을 때려죽여라!\n당신은 철퇴에 맞아 사망하였습니다.")
                        .setCancelable(false)
                        .setPositiveButton("goobbye", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent = new Intent(MainActivity4.this,MainActivity.class);
                                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                startActivity(intent);
                            }
                        })
                        .setView(view)
                        .show();
            }
        });

        Button btnR = (Button) findViewById(R.id.btnR);
        btnR.setEnabled(true);
        btnR.setText("아니요");
        btnR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View view1 = getLayoutInflater().inflate(R.layout.dialong,null);
                ImageView imageView = (ImageView) view1.findViewById(R.id.dialogImage);
                imageView.setImageResource(R.drawable.cul);
                new AlertDialog.Builder(MainActivity4.this)
                        .setTitle("관심법 발동")
                        .setMessage("당신은 궁예의 관심법에 의해 거짓말이 들통났습니다.\n사망")
                        .setCancelable(false)
                        .setPositiveButton("goodbye", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent = new Intent(MainActivity4.this,MainActivity.class);
                                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                startActivity(intent);
                            }
                        })
                        .setView(view1)
                        .show();
            }
        });

    }
}