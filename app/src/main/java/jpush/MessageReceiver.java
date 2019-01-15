package jpush;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;

import cn.jpush.android.api.JPushInterface;

public class MessageReceiver extends BroadcastReceiver {
    private static final String TAG = "MessageReceiver";
    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (!TextUtils.isEmpty(action)) {
            switch (action) {
                case JPushInterface.ACTION_MESSAGE_RECEIVED:
                    Log.d(TAG, "onReceive: ACTION_MESSAGE_RECEIVED");
                    break;
                case JPushInterface.ACTION_NOTIFICATION_RECEIVED:
                    Log.d(TAG, "onReceive: ACTION_NOTIFICATION_RECEIVED");
                    break;
                case JPushInterface.ACTION_NOTIFICATION_OPENED:
                    Log.d(TAG, "onReceive: ACTION_NOTIFICATION_OPENED");
                    break;
                case JPushInterface.ACTION_CONNECTION_CHANGE:
                    Log.d(TAG, "onReceive: ACTION_CONNECTION_CHANGE");
                    break;
            }
        }
    }
}
