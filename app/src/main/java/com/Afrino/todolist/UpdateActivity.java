package com.Afrino.todolist;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class UpdateActivity extends AppCompatActivity {

    EditText editTextUpdatedTask;
    Button btnUpdateTask, btnDeleteTask;
    DBHelper dbHelper;
    int taskId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        editTextUpdatedTask = findViewById(R.id.editTextUpdatedTask);
        btnUpdateTask = findViewById(R.id.btnUpdateTask);
        btnDeleteTask = findViewById(R.id.btnDeleteTask);

        dbHelper = new DBHelper(this);

        taskId = getIntent().getIntExtra("TASK_ID", -1);

        if (taskId == -1) {
            Toast.makeText(this, "Error: Tugas Tidak Ditemukan!", Toast.LENGTH_SHORT).show();
            finish();
        }

        String task = dbHelper.getTask(taskId);
        editTextUpdatedTask.setText(task);

        btnUpdateTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String updatedTask = editTextUpdatedTask.getText().toString().trim();
                if (!updatedTask.isEmpty()) {
                    dbHelper.updateTask(taskId, updatedTask);
                    Toast.makeText(UpdateActivity.this, "Tugas Sudah Terupdate!", Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    Toast.makeText(UpdateActivity.this, "Masukan Tugas Anda!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnDeleteTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbHelper.deleteTask(taskId);
                Toast.makeText(UpdateActivity.this, "Tugas Berhasil Dihapus!", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}
