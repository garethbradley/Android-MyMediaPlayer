package com.komamitsu.android.videoplayer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;


public class UrlInputActivity extends Activity {
    private static final String TAG = UrlInputActivity.class.getSimpleName();

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.url_input);
        final EditText url = (EditText) findViewById(R.id.url);
        url.setText("http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4");
        Button submitBtn = (Button) findViewById(R.id.submit);
        submitBtn.setOnClickListener(new OnClickListener() {
          @Override
          public void onClick(View v) {
            String urlText = url.getText().toString();
            if (urlText.length() > 0) {
              Intent intent = new Intent(UrlInputActivity.this, MediaPlayerVideoActivity.class);
              intent.putExtra("url", url.getText().toString());
              intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
              startActivity(intent);
            }
          }
        });
    }
}