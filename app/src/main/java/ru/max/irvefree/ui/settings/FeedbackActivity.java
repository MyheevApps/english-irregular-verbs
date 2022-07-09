package ru.max.irvefree.ui.settings;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import ru.max.irvefree.R;

public class FeedbackActivity extends AppCompatActivity {
    private EditText edit1, edit2;
    private Button btnSendMessage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        ActionBar actionBar;
        actionBar = getSupportActionBar();

        actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.action_bar_gradient));
        getSupportActionBar().setTitle("Написать разработчикам");
        //Возвратная кнопка
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        edit1 = (EditText) findViewById(R.id.edit1);
        edit2 = (EditText) findViewById(R.id.edit2);
        btnSendMessage = (Button) findViewById(R.id.btnSendMessage);

        btnSendMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent send = new Intent(Intent.ACTION_SEND);
                send.setType("massage/html");
                send.putExtra(Intent.EXTRA_EMAIL, new String[] {"worthyhelper117@gmail.com"});
                send.putExtra(Intent.EXTRA_SUBJECT, "Отзыв на приложение IRVE(free)");
                send.putExtra(Intent.EXTRA_TEXT,"Имя: " +edit1.getText() + "\n Сообщение: " + edit2.getText());
                try {
                    startActivity(Intent.createChooser(send, "Выберите почту : "));
                }
                catch (android.content.ActivityNotFoundException ex)
                {
                    Toast.makeText(FeedbackActivity.this, "Не найден Email клиент", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
