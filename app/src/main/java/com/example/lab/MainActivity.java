package com.example.lab;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.RadioButton;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText ed_name;
    private TextView tv_text, tv_name, tv_winner, tv_mmora, tv_cmora;
    private RadioButton btn_scissor, btn_stone, btn_paper;
    private Button btn_mora;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 連結 xml 的元件
        ed_name = findViewById(R.id.ed_name);
        tv_text = findViewById(R.id.tv_text);
        tv_name = findViewById(R.id.tv_name);
        tv_winner = findViewById(R.id.tv_winner);
        tv_mmora = findViewById(R.id.tv_mmora);
        tv_cmora = findViewById(R.id.tv_cmora);
        btn_scissor = findViewById(R.id.btn_scissor);
        btn_stone = findViewById(R.id.btn_stone);
        btn_paper = findViewById(R.id.btn_paper);
        btn_mora = findViewById(R.id.btn_mora);

        btn_mora.setOnClickListener(view -> {
            // 判斷字串是否是空白，如果是，則要求用戶輸入姓名
            if (ed_name.length() < 1) {
                tv_text.setText("請輸入玩家姓名");
            } else {
                tv_name.setText(String.format("名字\n%s", ed_name.getText().toString()));

                if (btn_scissor.isChecked()) {
                    tv_mmora.setText("我方出拳\n剪刀");
                } else if (btn_stone.isChecked()) {
                    tv_mmora.setText("我方出拳\n石頭");
                } else if (btn_paper.isChecked()) {
                    tv_mmora.setText("我方出拳\n布");
                }
            }

            // 使用亂數產生電腦出拳，值為 0 ~ 2。
            // (Math.random()會產生 0 ~ 1 之間且不含 1 的亂數。)
            int computer_random = (int) (Math.random() * 3);

            // 顯示電腦出拳
            if (computer_random == 0) {
                tv_cmora.setText("電腦出拳\n剪刀");
            } else if (computer_random == 1) {
                tv_cmora.setText("電腦出拳\n石頭");
            } else if (computer_random == 2) {
                tv_cmora.setText("電腦出拳\n布");
            }

            // 判斷勝負
            if ((btn_scissor.isChecked() && computer_random == 2) || (btn_stone.isChecked() && computer_random == 0) || (btn_paper.isChecked() && computer_random == 1)) {
                String tmp = "勝利者\n" + ed_name.getText().toString();
                tv_winner.setText(tmp);
                tv_text.setText("恭喜您獲勝了！！！");
            } else if ((btn_scissor.isChecked() && computer_random == 1) || (btn_stone.isChecked() && computer_random == 2) || (btn_paper.isChecked() && computer_random == 0)) {
                tv_winner.setText("勝利者\n電腦");
                tv_text.setText("可惜，電腦獲勝了！");
            } else {
                tv_winner.setText("勝利者\n平手");
                tv_text.setText("平局，再試一次！");
            }
        });
    }
}