package io.github.srcreigh.yopp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import akka.actor.Actor;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.EmptyLocalActorRef;
import akka.actor.Props;

public class AkkaActivity extends Activity {

    private static ActorSystem sSystem = ActorSystem.create("main");
    private ActorRef mActor;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.akka);
        mActor = sSystem.actorOf(Props.create(MyActor.class));
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mActor.tell("sup?", EmptyLocalActorRef.noSender());
            }
        });
    }
}