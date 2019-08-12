package com.denr.solidwaste.ui.welcome;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Handler;
import android.view.animation.DecelerateInterpolator;

import com.denr.solidwaste.BR;
import com.denr.solidwaste.R;
import com.denr.solidwaste.base.BaseActivity;
import com.denr.solidwaste.databinding.ActivityWelcomeBinding;
import com.denr.solidwaste.ui.home.HomeActivity;
import com.denr.solidwaste.ui.home.welcomevideo.WelcomeVideoDialogFragment;

import javax.inject.Inject;

public class WelcomeActivity extends BaseActivity<ActivityWelcomeBinding, WelcomeViewModel>
        implements WelcomeNavigator {

    @Inject
    WelcomeViewModel welcomeViewModel;

    private MediaPlayer mediaPlayer;

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_welcome;
    }

    @Override
    public WelcomeViewModel getViewModel() {
        return welcomeViewModel;
    }

    @Override
    public void onToggleAudio(boolean playAudio) {
        if (null == mediaPlayer) {
            mediaPlayer = MediaPlayer.create(this, R.raw.welcome_audio);

            mediaPlayer.start();

            final int duration = (mediaPlayer.getDuration() / 1000);

            getViewModel().displayAudioDuration(0, duration);

            getViewDataBinding().sbAudio.setMax(duration);

            final Handler handler = new Handler();

            runOnUiThread(new Runnable() {

                @Override
                public void run() {
                    if (null != mediaPlayer) {
                        int currentPos = mediaPlayer.getCurrentPosition() / 1000;

                        getViewModel().displayAudioDuration(currentPos,
                                (mediaPlayer.getDuration() / 1000));

                        ObjectAnimator animation = ObjectAnimator
                                .ofInt(getViewDataBinding().sbAudio, "progress", currentPos);
                        animation.setDuration(500);
                        animation.setInterpolator(new DecelerateInterpolator());
                        animation.start();
                    }
                    handler.postDelayed(this, 1000);
                }
            });

            mediaPlayer.setOnCompletionListener(mp -> {
                mp.seekTo(0);
                getViewModel().resetAudio();
                getViewDataBinding().sbAudio.setProgress(0);
            });
        } else {
            if (mediaPlayer.isPlaying()) {
                mediaPlayer.pause();
            } else {
                mediaPlayer.start();
            }
        }
    }

    @Override
    public void onShowFacebook() {
        openUrlInBrowser("https://www.facebook.com/Philippine-Environment-Connect-687975338272466");
    }

    @Override
    public void onShowTwitter() {
        openUrlInBrowser("https://twitter.com/EMBPhilEnviron1");
    }

    @Override
    public void onShowYoutube() {
        openUrlInBrowser("https://www.youtube.com/channel/UCgqS6v6tWEnK-BEm8awfCgQ");
    }

    @Override
    public void onShowInstagram() {
        openUrlInBrowser("https://www.instagram.com/phil_environment_connect/");
    }

    @Override
    public void onBeginTour() {
        startActivity(new Intent(this, HomeActivity.class));
    }

    @Override
    public void onShowWelcomeVideo() {
        WelcomeVideoDialogFragment fragment = WelcomeVideoDialogFragment.newInstance();
        fragment.show(getSupportFragmentManager(), WelcomeVideoDialogFragment.TAG);
    }

    private void openUrlInBrowser(String url) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(browserIntent);
    }
}
