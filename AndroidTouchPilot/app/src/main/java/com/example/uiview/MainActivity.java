package com.example.uiview;

import android.annotation.SuppressLint;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.core.view.GestureDetectorCompat;

public class MainActivity extends AppCompatActivity implements GestureDetector.OnGestureListener,
    GestureDetector.OnDoubleTapListener {

  private static final String GESTURE_TAG = "Gestures";
  private static final String LISTENER_TAG = "Listener";
  private GestureDetectorCompat mDetector;
  private boolean is_pressed = false;
  private int clickCnt = 0;
  private int listenerCnt = 0;

  @SuppressLint("ClickableViewAccessibility")
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    // Instantiate the gesture detector with the
    // application context and an implementation of
    // GestureDetector.OnGestureListener
    mDetector = new GestureDetectorCompat(this, this);
    // Set the gesture detector as the double tap
    // listener.
    mDetector.setOnDoubleTapListener(this);

    ImageView imageView = findViewById(R.id.imageView);
    imageView.setOnLongClickListener(v -> {
      is_pressed = true;
      Log.i(LISTENER_TAG, "Long click started");
      return true;
    });
    imageView.setOnTouchListener((v, event) -> {
      if (event.getAction() == MotionEvent.ACTION_UP) {
        if (is_pressed) {
          is_pressed = false;
          Log.i(LISTENER_TAG, "Long click ended");
        }
      }
      Log.i(LISTENER_TAG, "listener is entered" + listenerCnt++ + ", " + MotionEvent.actionToString(event.getAction()));
      // return false so that default handler can be invoked.
      return false;
    });
  }

  public void onImageViewClicked(View v) {
    Log.i(LISTENER_TAG, "Image view is clicked" + clickCnt++);
  }

  @Override
  public boolean onTouchEvent(MotionEvent event) {
    if (this.mDetector.onTouchEvent(event)) {
      return true;
    }
    return super.onTouchEvent(event);
  }

  @Override
  public boolean onDown(MotionEvent event) {
    Log.i(GESTURE_TAG, "onDown: " + event.toString());
    return true;
  }

  @Override
  public boolean onFling(MotionEvent event1, MotionEvent event2, float velocityX, float velocityY) {
    Log.i(GESTURE_TAG, "onFling: " + event1.toString() + event2.toString());
    return true;
  }

  @Override
  public void onLongPress(MotionEvent event) {
    Log.i(GESTURE_TAG, "onLongPress: " + event.toString());
  }

  @Override
  public boolean onScroll(MotionEvent event1, MotionEvent event2, float distanceX, float distanceY) {
    Log.i(GESTURE_TAG, "onScroll: " + event1.toString() + event2.toString());
    return true;
  }

  @Override
  public void onShowPress(MotionEvent event) {
    Log.i(GESTURE_TAG, "onShowPress: " + event.toString());
  }

  @Override
  public boolean onSingleTapUp(MotionEvent event) {
    Log.i(GESTURE_TAG, "onSingleTapUp: " + event.toString());
    return true;
  }

  @Override
  public boolean onDoubleTap(MotionEvent event) {
    Log.i(GESTURE_TAG, "onDoubleTap: " + event.toString());
    return true;
  }

  @Override
  public boolean onDoubleTapEvent(MotionEvent event) {
    Log.i(GESTURE_TAG, "onDoubleTapEvent: " + event.toString());
    return true;
  }

  @Override
  public boolean onSingleTapConfirmed(MotionEvent event) {
    Log.i(GESTURE_TAG, "onSingleTapConfirmed: " + event.toString());
    return true;
  }
}