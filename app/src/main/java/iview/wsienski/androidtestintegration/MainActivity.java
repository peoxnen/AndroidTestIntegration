package iview.wsienski.androidtestintegration;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText editText = (EditText) findViewById(R.id.edit_query);
        Button button = (Button) findViewById(R.id.button);
        Button button_startSecondActivity = (Button) findViewById(R.id.button_startSecondActivity);
        setBtn(button);
        setBtnStartSecondActivity(button_startSecondActivity);

        Bundle inputData = getIntent().getExtras();
        if(inputData!=null) {
            String input = inputData.getString("EXTRA");
            editText.setText(input);
        }
    }

    private void setBtnStartSecondActivity(Button button) {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });
    }

    private void setBtn(Button button) {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "clicked",Toast.LENGTH_LONG).show();
            }
        });
    }
}
