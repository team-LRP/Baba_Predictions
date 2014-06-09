package com.lrp.babapredictions;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.VideoView;


public class MainActivity extends Activity {



    EditText question;
    TextView txt;
    Button button;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        question = (EditText) findViewById(R.id.editText);
        txt = (TextView)findViewById(R.id.textView);
        final VideoView videoView = (VideoView)findViewById(R.id.videoView);
        videoView.setVisibility(videoView.INVISIBLE);
        final String f = "android.resource://" + getPackageName() + "/" + R.raw.video;

        button = (Button) findViewById(R.id.a);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                //delay in ms
                int DELAY = 1700;

                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(getApplicationContext(), OutputSongs.class);
                        startActivity(intent);
                    }
                }, DELAY);

                videoView.setVisibility(videoView.VISIBLE);


                videoView.setVideoURI(Uri.parse(f));
                videoView.start();


            }


        });




        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Baba Instructions !");
        builder.setMessage("Ask any question of your choice about the future, to be answered in Yes/No ");
        builder.setPositiveButton("Okay", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                dialog.dismiss();
            }
        });

        builder.show();




    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
