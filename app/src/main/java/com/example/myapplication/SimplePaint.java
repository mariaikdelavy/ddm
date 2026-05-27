package com.example.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.graphics.Path;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;


public class SimplePaint extends View {

    Path correntPath;
    Paint correntPaint;
    ArrayList<Path> listPath;
    ArrayList<Paint> listPaint;
    String modoTraco = "tracolivre";
    public final String TRACOLIVRE = "tracoLivre";
    public final String TRACOCIRCULO = "tracoCirculo";
    public final String TRACOQUADRADO = "tracoQuadrado";
    public void mudarParaCirculo(){
        modoTraco = TRACOCIRCULO;
    }
    public void mudarParaLivre(){
        modoTraco = TRACOLIVRE;
    }
    public void mudarParaQuadrado(){
        modoTraco = TRACOQUADRADO
    }

    float x0, y0;

    public SimplePaint(Context context){
        super(context);
        init();
    }

    public SimplePaint(Context context, @Nullable AttributeSet attrs){
        super(context, attrs);
        init();
    }

    public SimplePaint(Context context, @Nullable AttributeSet attrs, int defStyleAttr){
        super(context, attrs, defStyleAttr);
        init();
    }

    public void init(){
        modoTraco = TRACOLIVRE;
        correntPath = new Path();
        correntPaint = new Paint();
        correntPaint.setColor(Color.BLACK);
        correntPaint.setStrokeWidth(10);
        correntPaint.setStyle(Paint.Style.STROKE);
        listPath = new ArrayList<>();
        listPaint = new ArrayList<>();
    }

    public void mudaCor(int color){
        correntPaint.setColor(color);
    }

    public void addCamada(){
        listPaint.add(correntPaint);
        listPath.add(correntPath);
        correntPaint = new Paint(correntPaint);
        correntPath = new Path();
    }

    @Override
    protected void onDraw(@NonNull Canvas canvas){
        super.onDraw(canvas);
        canvas.drawPath(correntPath, correntPaint);

        for(int i =0; i <= listPath.size() - 1; i++){
            canvas.drawPath(listPath.get(i), listPaint.get(i));

        }
    }
    @Override
    public boolean onTouchEvent(MotionEvent event){
        switch(event.getAction()){
            case MotionEvent.ACTION_DOWN:
                x0=event.getX(); y0=event.getY();
                correntPath.lineTo(event.getX(),event.getY());
                Log.d("coordenadas", Float.toString(event.getX()) + Float.toString(event.getY()));

                break;
            case MotionEvent.ACTION_MOVE:
                Log.d("coordenadas", Float.toString(event.getX()) + Float.toString(event.getY()));
                if(modoTraco.equals(TRACOLIVRE)){
                    correntPath.lineTo(event.getX(), event.getY());
                }
                if(modoTraco.equals(TRACOCIRCULO)){
                    Double f = (double) ((event.getX() - x0) * (event.getX() - x0));
                    Double raio = Math.sqrt(f);
                    correntPath.addCircle((x0, y0));
                    //mPath.addCircle(x0,y0,100,Path.Direction.CCW

                }


                break;
            case MotionEvent.ACTION_UP:
                addCamada();
                break;
        }
        invalidate();
        return true;
    }
}
