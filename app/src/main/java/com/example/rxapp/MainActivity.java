package com.example.rxapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName() ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Observer<String> animalsObserver = getAnimalsObserver();

        Observable<String> animalsObservable = getAnimalObservable();

        animalsObservable
                .subscribeOn(Schedulers.io())//do job on io thread which is not cpu intensive
                .observeOn(AndroidSchedulers.mainThread()) //receive data on main thread / ui thread
                .subscribe(animalsObserver); //subscription or registration


    }

    private Observable<String> getAnimalObservable() {
        return  Observable.just("Ant", "Bee", "Cat", "Dog", "Fox");

    }

    private Observer<String> getAnimalsObserver() {
        return  new Observer<String>() {

            @Override
            public void onSubscribe(Disposable d) {
                Log.d(TAG, "onSubscribe");

            }

            @Override
            public void onNext(String s) {  //s from observable
                Log.d(TAG, "Name: " + s);

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {
                Log.d(TAG, "All items are emitted/sent!");


            }
        };
    }
}
