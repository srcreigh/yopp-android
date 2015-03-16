package io.github.srcreigh.yopp;

import android.util.Log;

import akka.actor.Props;
import akka.actor.UntypedActor;

public class MyActor extends UntypedActor {
    private static final String TAG = "MyActor";

    @Override
    public void onReceive(Object message) throws Exception {
        Log.d(TAG, "received message: " + message);
        getSender().tell("ok", getSelf());
    }
}
