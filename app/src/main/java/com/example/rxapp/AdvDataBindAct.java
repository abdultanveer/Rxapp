package com.example.rxapp;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;

import com.example.rxapp.data.AndroidVersion;
import com.example.rxapp.databinding.ActivityAdvDataBindBinding;

import java.util.Timer;
import java.util.TimerTask;

public class AdvDataBindAct extends AppCompatActivity {
    ActivityAdvDataBindBinding binding;

   // ActivityMainBinding binding;
    Timer timer;
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_adv_data_bind);

        AndroidVersion androidVersion = new AndroidVersion(R.mipmap.ic_launcher, "Android MarshMallow", "Android 6.0");
        binding.setData(androidVersion);


       /* binding.imageView.setImageResource(androidVersion.getImage());
        binding.name.setText(androidVersion.getName());
        binding.summary.setText(androidVersion.getSummary());*/

        timer= new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        if (i == 0) {
                            AndroidVersion androidVersion = new AndroidVersion(R.mipmap.ic_launcher_round, "Android Lollipop", "Android 5.0");
                            binding.setData(androidVersion);
                            /* binding.imageView.setImageResource(androidVersion.getImage());
                            binding.name.setText(androidVersion.getName());
                            binding.summary.setText(androidVersion.getSummary());
*/
                            i=1;

                        } else {

                            i=0;
                            AndroidVersion androidVersion = new AndroidVersion(R.mipmap.ic_launcher, "Android MarshMallow", "Android 6.0");

                            binding.setData(androidVersion);
                           /* binding.imageView.setImageResource(androidVersion.getImage());
                            binding.name.setText(androidVersion.getName());
                            binding.summary.setText(androidVersion.getSummary());*/

                        }
                    }
                });
            }
        }, 3000, 3000);
    }


    @BindingAdapter({"android:src"})
    public static void setImageViewResource(ImageView imageView, int resource) {//to,from
        imageView.setImageResource(resource);
    }



}
