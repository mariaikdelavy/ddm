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
    public final String TRACOLINHA = "tracoLinha";

    public void mudarParaCirculo(){
        modoTraco = TRACOCIRCULO;
    }
    public void mudarParaLivre(){
        modoTraco = TRACOLIVRE;
    }
    public void mudarParaQuadrado(){
        modoTraco = TRACOQUADRADO;
    }
    public void mudarParaLinha(){
        modoTraco = TRACOLINHA;
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
        correntPaint.setAntiAlias(true);
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

        for(int i = 0; i <= listPath.size() - 1; i++){
            canvas.drawPath(listPath.get(i), listPaint.get(i));
        }

        canvas.drawPath(correntPath, correntPaint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event){
        switch(event.getAction()){
            case MotionEvent.ACTION_DOWN:
                x0 = event.getX();
                y0 = event.getY();
                correntPath.moveTo(x0, y0);
                Log.d("coordenadas", x0 + "," + y0);
                break;

            case MotionEvent.ACTION_MOVE:
                float x1 = event.getX();
                float y1 = event.getY();
                Log.d("coordenadas", x1 + "," + y1);

                if(modoTraco.equals(TRACOLIVRE)){
                    correntPath.lineTo(x1, y1);
                }
                else if(modoTraco.equals(TRACOCIRCULO)){
                    correntPath.reset();
                    float dx = x1 - x0;
                    float dy = y1 - y0;
                    float raio = (float) Math.sqrt(dx * dx + dy * dy);
                    correntPath.addCircle(x0, y0, raio, Path.Direction.CW);
                }
                else if(modoTraco.equals(TRACOQUADRADO)){
                    correntPath.reset();
                    correntPath.addRect(
                            Math.min(x0, x1),
                            Math.min(y0, y1),
                            Math.max(x0, x1),
                            Math.max(y0, y1),
                            Path.Direction.CW
                    );
                }
                else if(modoTraco.equals(TRACOLINHA)){
                    correntPath.reset();
                    correntPath.moveTo(x0, y0);
                    correntPath.lineTo(x1, y1);
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