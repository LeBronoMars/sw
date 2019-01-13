package com.denr.solidwaste.ui.welcome;

import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;

import com.denr.solidwaste.base.BaseViewModel;

public class WelcomeViewModel extends BaseViewModel<WelcomeNavigator> {

    private ObservableBoolean isAudioPlaying;

    private ObservableField<String> duration;

    public WelcomeViewModel() {
        this.isAudioPlaying = new ObservableBoolean(false);
        this.duration = new ObservableField<>("00:00 / 00:00");
    }

    public void onToggleAudioPlay() {
        isAudioPlaying.set(!isAudioPlaying.get());
        getNavigator().onToggleAudio(isAudioPlaying.get());
    }

    public void resetAudio() {
        isAudioPlaying.set(false);
    }

    public ObservableBoolean getIsAudioPlaying() {
        return isAudioPlaying;
    }

    public ObservableField<String> getDuration() {
        return duration;
    }

    public void displayAudioDuration(int current, int duration) {
        this.duration.set(String.format("00:%s / 00:%s", current, duration));
    }
}
