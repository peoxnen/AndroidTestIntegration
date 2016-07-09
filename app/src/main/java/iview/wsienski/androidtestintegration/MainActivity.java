package iview.wsienski.androidtestintegration;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button button,button_startSecondActivity, button_login;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (EditText) findViewById(R.id.edit_query);
        button = (Button) findViewById(R.id.button);
        button_startSecondActivity = (Button) findViewById(R.id.button_startSecondActivity);
        button_login = (Button) findViewById(R.id.button_login);
        setBtn(button);
        setBtnStartSecondActivity(button_startSecondActivity);
        setBtnLogin(button_login);

        Bundle inputData = getIntent().getExtras();
        if(inputData!=null) {
            String input = inputData.getString("EXTRA");
            editText.setText(input);
        }
    }

    private void setBtnLogin(Button button_login) {
        button_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(validadeText()){
                    startNewActivity();
                }
            }
        });
    }

    private boolean validadeText() {
        String text = editText.getText().toString();
        if(text== null || text.length()<3){
            editText.setError("Error");
            return false;
        }else{
            return true;
        }
    }

    private void setBtnStartSecondActivity(Button button) {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startNewActivity();
            }
        });
    }

    private void startNewActivity(){
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        startActivity(intent);
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
