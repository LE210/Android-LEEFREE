package net.ricerich.leefree;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Welcome to Portal");

        TextView textStart = (TextView) findViewById(R.id.textStart);
        textStart.setText("포탈 세계에 오신 것을 환영합니다.");

        TextView textWel = (TextView) findViewById(R.id.textMain);
        textWel.setText("세상에는 설명할 수 없는 일이 많죠...\n당신은 일과를 마치고 당신의 집 대문을 열었습니다.\n단지 그뿐이죠, 행운을 빕니다.");

        Button btnStart = (Button) findViewById(R.id.btnStart);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }
}