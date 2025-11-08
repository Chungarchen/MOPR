package com.example.baitap01;

import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // 🔹 Khai báo biến giao diện (View)
    EditText edtNumbers;
    Button btnProcess;
    TextView txtChan, txtLe;
    EditText edtInput;
    Button btnProcess5;
    TextView txtResult5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Ẩn thanh tiêu đề
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);

//         BÀI 4
        edtNumbers = findViewById(R.id.edtNumbers);
        btnProcess = findViewById(R.id.btnProcess);
        txtChan = findViewById(R.id.txtChan);
        txtLe = findViewById(R.id.txtLe);

        // Xử lý khi bấm nút
        btnProcess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String input = edtNumbers.getText().toString().trim();

                if (input.isEmpty()) {
                    Toast.makeText(MainActivity.this,
                            "Vui lòng nhập mảng số!", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Tách các phần tử bằng dấu cách
                String[] parts = input.split("\\s+");
                ArrayList<Integer> numbers = new ArrayList<>();

                try {
                    for (String s : parts) {
                        numbers.add(Integer.parseInt(s));
                    }
                } catch (NumberFormatException e) {
                    Toast.makeText(MainActivity.this,
                            "Chuỗi chứa ký tự không hợp lệ!", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Phân loại chẵn / lẻ
                ArrayList<Integer> soChan = new ArrayList<>();
                ArrayList<Integer> soLe = new ArrayList<>();

                for (int n : numbers) {
                    if (n % 2 == 0)
                        soChan.add(n);
                    else
                        soLe.add(n);
                }

                // Hiển thị kết quả lên giao diện
                txtChan.setText("Số chẵn: " + soChan.toString());
                txtLe.setText("Số lẻ: " + soLe.toString());

                // In ra Logcat (nếu muốn xem ở console)
                Log.d("Bai4", "Số chẵn: " + soChan);
                Log.d("Bai4", "Số lẻ: " + soLe);
            }
        });

//        BÀI 5
        edtInput = findViewById(R.id.edtInput);
        btnProcess5 = findViewById(R.id.btnProcess5);
        txtResult5 = findViewById(R.id.txtResult5);

        btnProcess5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String input = edtInput.getText().toString().trim();

                if (input.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Vui lòng nhập chuỗi!", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Hiển thị chuỗi gốc lên TextView
                txtResult5.setText("Chuỗi gốc: " + input);

                // Đảo ngược chuỗi theo từ
                String[] words = input.split("\\s+");
                StringBuilder reversed = new StringBuilder();
                for (int i = words.length - 1; i >= 0; i--) {
                    reversed.append(words[i]);
                    if (i != 0) reversed.append(" ");
                }

                // In hoa toàn bộ
                String reversedUpper = reversed.toString().toUpperCase();

                // Hiển thị bằng Toast
                Toast.makeText(MainActivity.this, reversedUpper, Toast.LENGTH_LONG).show();
                Log.d("Bai5", "Chuỗi đảo ngược: " + reversedUpper);
            }
        });
    }
}
