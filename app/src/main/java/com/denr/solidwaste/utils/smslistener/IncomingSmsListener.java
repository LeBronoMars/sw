package com.denr.solidwaste.utils.smslistener;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;

import org.greenrobot.eventbus.EventBus;

public class IncomingSmsListener extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        if (intent.getAction().equals("android.provider.Telephony.SMS_RECEIVED")) {
            Bundle bundle = intent.getExtras();
            SmsMessage[] messages = null;

            if (bundle != null) {
                try {
                    Object[] pdus = (Object[]) bundle.get("pdus");
                    messages = new SmsMessage[pdus.length];

                    for (int i = 0; i < messages.length; i++) {
                        messages[i] = SmsMessage.createFromPdu((byte[]) pdus[i]);

                        String message = messages[i].getMessageBody();

                        if (message.startsWith("BFP")) {
                            String sender = messages[i].getOriginatingAddress();
                            long timestamp = messages[i].getTimestampMillis();

                            NewlyReceivedSms newlyReceivedSms = new NewlyReceivedSms();
                            newlyReceivedSms.setMessage(message);
                            newlyReceivedSms.setSender(sender);
                            newlyReceivedSms.setTimestamp(timestamp);

                            EventBus.getDefault().post(newlyReceivedSms);
                        }
                    }
                } catch (Exception e) {
                    Log.d("app", "Error in listening of SMS ---> " + e.getMessage());
                }
            }
        }
    }
}