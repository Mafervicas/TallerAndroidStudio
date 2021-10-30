package com.example.prueba2;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener  {

    //Inicializar las variables
    View view;
    Button b;
    ImageView imageView;

    //Inicializamos los gestos y textos cambiantes
    private TextView mTextView;
    private GestureDetector gestureDetector;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //RemoveActionBar
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        //Background & TextView
        view = this.getWindow().getDecorView();
        view.setBackgroundResource(R.color.Red);
        mTextView = (TextView) findViewById(R.id.textView);

        //Crear los gestos
        this.gestureDetector = new GestureDetector(this, this);
        gestureDetector.setOnDoubleTapListener(this);

        //ImageView & Botón
        b = (Button) findViewById(R.id.btRainbow);
        imageView = (ImageView) findViewById(R.id.imageView);
        b.setOnClickListener(view -> imageView.setImageResource(R.drawable.arcoiris));


    }

    //Las próximas líneas de código son para que con el click se mande llamar el método
    //Y se genere el cambio de color en el background

    public void WhiteColor(View v){
        view.setBackgroundResource(R.color.White); mTextView.setText("White");;
    }

    public void RedColor(View v){
        view.setBackgroundResource(R.color.Red);mTextView.setText("Hello World!");
    }
    public void YellowColor(View v){
        view.setBackgroundResource(R.color.Yellow); mTextView.setText("Yellow");
    }
    public void BlackColor(View v){
        view.setBackgroundResource(R.color.Black); mTextView.setText("Black");
    }

    public void fade(View view){
        ImageView arcoiris= (ImageView)findViewById(R.id.imageView);
        arcoiris.animate().alpha(0f).setDuration(3000);
    }


    //Esto es para que por cada TouchEvent, se tenga como tal el evento
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        this.gestureDetector.onTouchEvent(event);
        return super.onTouchEvent(event);}


    //Dependiendo el gesto, se cambiará el color
    @Override
    public boolean onSingleTapConfirmed(MotionEvent e) {
        mTextView.setText("Blue");
        view.setBackgroundResource(R.color.Blue);
        return false;
    }

    @Override
    public boolean onDoubleTap(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent e) {
        mTextView.setText("Black");
        view.setBackgroundResource(R.color.Black);
        return false;
    }

    @Override
    public boolean onDown(MotionEvent e) {
        mTextView.setText("Green");
        view.setBackgroundResource(R.color.Green);
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        mTextView.setText("Purple");
        view.setBackgroundResource(R.color.Purple);
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {
        mTextView.setText("Pink");
        view.setBackgroundResource(R.color.Pink);

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        mTextView.setText("");
        view.setBackgroundResource(R.color.White);
        return false;
    }
}