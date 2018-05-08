package audio.wayne.me.androidaudio;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import audio.wayne.me.androidaudio.audio.AudioCapture;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mRecordBtn;
    private Button mStopBtn;

    private AudioCapture mAudioCapture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        mRecordBtn = findViewById(R.id.record_button);
        mRecordBtn.setOnClickListener(this);

        mStopBtn = findViewById(R.id.stop_button);
        mStopBtn.setOnClickListener(this);
    }

    private void init() {
        mAudioCapture = new AudioCapture();
    }

    @Override
    public void onClick(View v) {
        if (v == mRecordBtn) {
            mAudioCapture.startCapture();
            mRecordBtn.setEnabled(false);
        } else if (v == mStopBtn) {
            mAudioCapture.stopCapture();
            mRecordBtn.setEnabled(true);
        }
    }
}
