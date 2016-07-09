package iview.wsienski.androidtestintegration;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    Button button;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        textView = (TextView) findViewById(R.id.textview);
        button = (Button) findViewById(R.id.button);
        setBtn(button);

       FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    private void setBtn(Button button) {
        final AsyncTask<String, Void, String> task = new AsyncTask<String, Void, String>() {

            @Override
            protected String doInBackground(String... arg0) {
                return "Actions...";
            }

            @Override
            protected void onPostExecute(String result) {
                textView.setText("test");
            }

        };

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                task.execute("test");
            }
        });


    }

}
