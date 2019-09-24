package cetf.sam.com.talking;

import android.app.Activity;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements TextToSpeech.OnInitListener {

    private String tag = Activity.class.getSimpleName();
    private EditText et = null;
    private TextToSpeech tts = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et = findViewById(R.id.editText);
        tts = new TextToSpeech(this, this);
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        tts.shutdown();
    }
    public void speakNow(View v) {
        Log.i(tag, "speakNow [" + et.getText().toString() + "]");
        tts.speak(et.getText().toString(), TextToSpeech.QUEUE_FLUSH, null);
    }

    public void onInit(int status) {
        Log.i(tag, "onInit [" + status + "]");
    }

    }

