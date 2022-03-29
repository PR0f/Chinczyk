package com.example.chinczyk;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;


public class MainActivity extends AppCompatActivity {

    ImageButton button;
    int liczbaLosowaKostkowan = 0;
    ArrayList<ImageButton> pathRed;
    ArrayList<ImageButton> pathGreen;

    ArrayList<ImageButton> baseRed;
    ArrayList<ImageButton> baseBlue;
    ArrayList<ImageButton> baseYellow;
    ArrayList<ImageButton> baseGreen;

    ArrayList<ImageButton> pawnReds;
    ArrayList<ImageButton> pawnGreen;

    int []tableGreen;
    int []tableRed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TableLayout tableLayout = findViewById(R.id.table);
        init();
        button = findViewById(R.id.kostkaBtn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random random = new Random();
                liczbaLosowaKostkowan = random.nextInt(20)+10;
                int lLosowa = random.nextInt(6)+1;
                choosePawn(pawnGreen, baseGreen,lLosowa, false);
                rzucanieKoscia();

            }
        });

    }

    public static int pxToDp(int px) {
        return (int) (px / Resources.getSystem().getDisplayMetrics().density);
    }

    void rzucanieKoscia()
    {

        final Handler handler = new Handler(Looper.getMainLooper());
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                liczbaLosowaKostkowan--;
                Random kostkaRandom = new Random();
                int lLosowa = kostkaRandom.nextInt(6)+1;
                switch(lLosowa)
                {
                    case 1:
                        button.setImageResource(R.drawable.kostka1);
                        break;
                    case 2:
                        button.setImageResource(R.drawable.kostka2);
                        break;
                    case 3:
                        button.setImageResource(R.drawable.kostka3);
                        break;
                    case 4:
                        button.setImageResource(R.drawable.kostka4);
                        break;
                    case 5:
                        button.setImageResource(R.drawable.kostka5);
                        break;
                    case 6:
                        button.setImageResource(R.drawable.kostka6);
                        break;
                }

                if(liczbaLosowaKostkowan>0)
                    rzucanieKoscia();
                else {
                    //choosePawn(6);
                    choosePawn(pawnReds,baseRed,lLosowa, true);
                }
            }
        }, 10);

    }

    void init()
    {
        pathRed = new ArrayList<>();
        pathGreen = new ArrayList<>();

        baseRed = new ArrayList<>();
        baseBlue = new ArrayList<>();
        baseYellow = new ArrayList<>();
        baseGreen = new ArrayList<>();

        pawnReds = new ArrayList<>();
        pawnGreen = new ArrayList<>();

        tableRed = new int[]{R.id.ImageButton101, R.id.ImageButton102, R.id.ImageButton105, R.id.ImageButton106};
        int []tableBlue = {R.id.ImageButton103, R.id.ImageButton104, R.id.ImageButton107, R.id.ImageButton108};
        int []tableYellow = {R.id.ImageButton109, R.id.ImageButton110, R.id.ImageButton113, R.id.ImageButton114};
        tableGreen = new int[]{R.id.ImageButton111, R.id.ImageButton112, R.id.ImageButton115, R.id.ImageButton116};
        int []table = {
                R.id.ImageButton13, R.id.ImageButton14, R.id.ImageButton15, R.id.ImageButton16,
                R.id.ImageButton17,
                R.id.ImageButton10, R.id.ImageButton7, R.id.ImageButton4, R.id.ImageButton1,
                                                                            R.id.ImageButton2,
                R.id.ImageButton3, R.id.ImageButton6, R.id.ImageButton9, R.id.ImageButton12,
                R.id.ImageButton19,
                R.id.ImageButton20, R.id.ImageButton21, R.id.ImageButton22, R.id.ImageButton23,
                                                                            R.id.ImageButton34,
                R.id.ImageButton45, R.id.ImageButton44, R.id.ImageButton43, R.id.ImageButton42,
                R.id.ImageButton41,
                R.id.ImageButton48, R.id.ImageButton51, R.id.ImageButton54, R.id.ImageButton57,
                                                                            R.id.ImageButton56,
                R.id.ImageButton55, R.id.ImageButton52, R.id.ImageButton49, R.id.ImageButton46,
                R.id.ImageButton39,
                R.id.ImageButton38, R.id.ImageButton37,  R.id.ImageButton36, R.id.ImageButton35,
                                                                            R.id.ImageButton24,
                R.id.ImageButton25,R.id.ImageButton26,R.id.ImageButton27,R.id.ImageButton28,

        };

        int []tableG = {
                R.id.ImageButton45, R.id.ImageButton44, R.id.ImageButton43, R.id.ImageButton42,
                R.id.ImageButton41,
                R.id.ImageButton48, R.id.ImageButton51, R.id.ImageButton54, R.id.ImageButton57,
                R.id.ImageButton56,
                R.id.ImageButton55, R.id.ImageButton52, R.id.ImageButton49, R.id.ImageButton46,
                R.id.ImageButton39,
                R.id.ImageButton38, R.id.ImageButton37,  R.id.ImageButton36, R.id.ImageButton35,
                R.id.ImageButton24,
                R.id.ImageButton13, R.id.ImageButton14, R.id.ImageButton15, R.id.ImageButton16,
                R.id.ImageButton17,
                R.id.ImageButton10, R.id.ImageButton7, R.id.ImageButton4, R.id.ImageButton1,
                R.id.ImageButton2,
                R.id.ImageButton3, R.id.ImageButton6, R.id.ImageButton9, R.id.ImageButton12,
                R.id.ImageButton19,
                R.id.ImageButton20, R.id.ImageButton21, R.id.ImageButton22, R.id.ImageButton23,
                R.id.ImageButton34,
                R.id.ImageButton33,R.id.ImageButton32,R.id.ImageButton31,R.id.ImageButton30,

        };

        for(int i=0; i<table.length; i++) {
            pathRed.add(findViewById(table[i]));
        }

        for(int i=0; i<tableG.length; i++) {
            pathGreen.add(findViewById(tableG[i]));
        }

        for(int i=0; i<tableRed.length; i++) {
            baseRed.add(findViewById(tableRed[i]));
        }

        for(int i=0; i<tableBlue.length; i++) {
            ImageButton imageButton = findViewById(tableBlue[i]);
            baseBlue.add(imageButton);
        }

        for(int i=0; i<tableYellow.length; i++) {
            ImageButton imageButton = findViewById(tableYellow[i]);
            baseYellow.add(imageButton);
        }

        for(int i=0; i<tableGreen.length; i++) {
            ImageButton imageButton = findViewById(tableGreen[i]);
            baseGreen.add(imageButton);
        }


    }

    void collision(ImageButton pawn, boolean isPlayer)
    {
        if(isPlayer)
        {
            for (int i = 0; i < pawnGreen.size(); i++) {
                if (pawnGreen.get(i).getId() == pawn.getId()) {

                    if(pawn.getId() != R.id.ImageButton13 && pawn.getId() != R.id.ImageButton3 &&
                            pawn.getId() != R.id.ImageButton45 && pawn.getId() != R.id.ImageButton55) {
                        for (int j = 0; j < tableGreen.length; j++) {
                            ImageButton imageButton = findViewById(tableGreen[j]);
                            if (!baseGreen.contains(imageButton)) {
                                baseGreen.add(imageButton);
                                imageButton.setImageResource(R.drawable.pawng);
                                break;
                            }
                        }
                        pawnGreen.remove(i);
                    }

                }
            }
        }
        else
        {
            for (int i = 0; i < pawnReds.size(); i++) {
                if (pawnReds.get(i).getId() == pawn.getId()) {

                    if(pawn.getId() != R.id.ImageButton13 && pawn.getId() != R.id.ImageButton3 &&
                            pawn.getId() != R.id.ImageButton45 && pawn.getId() != R.id.ImageButton55) {
                        for (int j = 0; j < tableRed.length; j++) {
                            ImageButton imageButton = findViewById(tableRed[j]);
                            if (!baseRed.contains(imageButton)) {
                                baseRed.add(imageButton);
                                imageButton.setImageResource(R.drawable.pawnr);
                                break;
                            }
                        }
                        pawnReds.remove(i);
                    }

                }
            }
        }
    }

    void pawnInterpolationAnimation(ArrayList<ImageButton> pawnColor,ImageButton pawn, ImageButton positionChanger,int positions, boolean isPlayer)
    {

        if(positions==-1) {
            pawnColor.set(pawnColor.indexOf(pawn),positionChanger);

            pawnColor.remove(positionChanger);
            if(isPlayer)
                pathRed.remove(pathRed.size()-1);
            else
                pathGreen.remove(pathGreen.size()-1);

            if(pawnReds.size() == 0 && baseRed.size() == 0)
                Toast.makeText(getApplicationContext(), "WIN", Toast.LENGTH_SHORT).show();
            if(pawnGreen.size() == 0 && baseGreen.size() == 0)
                Toast.makeText(getApplicationContext(), "LOSE", Toast.LENGTH_SHORT).show();

        }
        else if(positions>0)
        {
            final Handler handler = new Handler(Looper.getMainLooper());
            ImageButton finalPawn = pawn;
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {

                    final int from;
                    if(isPlayer)
                        from = pathRed.indexOf(positionChanger);
                    else
                        from = pathGreen.indexOf(positionChanger);

                    int jump = from + 1;



                    if(isPlayer)
                        pathRed.get(jump).setImageResource(R.drawable.pawnr);
                    else
                        pathGreen.get(jump).setImageResource(R.drawable.pawng);

                    boolean clearBehind = true;

                    boolean isRed = false;
                    for (int i = 0; i < pawnGreen.size(); i++) {
                        if (pawnGreen.indexOf(pawn) != i) {
                            if (pawnGreen.get(i).getId() == positionChanger.getId()) {
                                clearBehind = false;
                                isRed = false;
                            }
                        }

                    }
                    for (int i = 0; i < pawnReds.size(); i++) {
                        if (pawnReds.indexOf(pawn) != i) {
                            if (pawnReds.get(i).getId() == positionChanger.getId()) {
                                clearBehind = false;
                                isRed = true;
                            }
                        }

                    }



                    if (clearBehind)
                        positionChanger.setImageDrawable(null);
                    else{
                        if(isRed)
                            positionChanger.setImageResource(R.drawable.pawnr);
                        else
                            positionChanger.setImageResource(R.drawable.pawng);
                    }

                    if(isPlayer) {
                        if (jump < pathRed.size() - 1) {
                            pawnInterpolationAnimation(pawnColor, finalPawn, pathRed.get(jump), positions - 1, isPlayer);
                        } else {
                            jump = pathRed.size() - 1;
                            pawnInterpolationAnimation(pawnColor, finalPawn, pathRed.get(jump), -1, isPlayer);
                        }
                    }
                    else
                    {
                        if (jump < pathGreen.size() - 1) {
                            pawnInterpolationAnimation(pawnColor, finalPawn, pathGreen.get(jump), positions - 1, isPlayer);
                        } else {
                            jump = pathGreen.size() - 1;
                            pawnInterpolationAnimation(pawnColor, finalPawn, pathGreen.get(jump), -1, isPlayer);
                        }
                    }

                }
            }, 15);

        }else{
            collision(positionChanger, isPlayer);
            pawnColor.set(pawnColor.indexOf(pawn),positionChanger);
        }


    }

    void pickBasePawn(ArrayList<ImageButton> pawnColor, ArrayList<ImageButton> baseColor, boolean isPlayer)
    {
        if(isPlayer) {
            Toast.makeText(getBaseContext(), "wybierz pionka", Toast.LENGTH_SHORT).show();
            for (int i = 0; i < baseColor.size(); i++) {
                int finalI = i;
                baseColor.get(i).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ImageButton imageButton = findViewById(R.id.ImageButton13);
                        pawnColor.add(imageButton);
                        pawnColor.get(pawnColor.size() - 1).setImageResource(R.drawable.pawnr);
                        baseColor.get(finalI).setImageDrawable(null);
                        for (int j = 0; j < baseColor.size(); j++) {
                            baseColor.get(j).setOnClickListener(null);
                        }
                        baseColor.remove(finalI);

                    }
                });
            }

        }else{

            Random random = new Random();
            int lLosowa = random.nextInt(baseColor.size());
            ImageButton imageButton = findViewById(R.id.ImageButton45);
            pawnColor.add(imageButton);
            pawnColor.get(pawnColor.size() - 1).setImageResource(R.drawable.pawng);
            baseColor.get(lLosowa).setImageDrawable(null);
            for (int j = 0; j < baseColor.size(); j++) {
                baseColor.get(j).setOnClickListener(null);
            }
            baseColor.remove(lLosowa);
        }

    }

    void makeMove(ArrayList<ImageButton> pawnColor, ImageButton imageButton, int numberOfMoves, boolean isPlayer)
    {
        if(imageButton !=null) {
            if (isPlayer) {
                if (numberOfMoves < pathRed.size() - pathRed.indexOf(imageButton))
                    pawnInterpolationAnimation(pawnColor, imageButton, imageButton, numberOfMoves, isPlayer);
            }
            else
            {
                if (numberOfMoves < pathGreen.size() - pathGreen.indexOf(imageButton))
                    pawnInterpolationAnimation(pawnColor, imageButton, imageButton, numberOfMoves, isPlayer);
            }
        }

    }

    void choosePawn(ArrayList<ImageButton> pawnColor, ArrayList<ImageButton> baseColor, int numberOfMoves, boolean isPlayer)
    {
        if(numberOfMoves!=6) {
            if (pawnColor.size() == 0)
                makeMove(pawnColor,null, numberOfMoves, isPlayer);
            else if (pawnColor.size() == 1) {
                makeMove(pawnColor,pawnColor.get(0), numberOfMoves, isPlayer);
            } else {
                if(isPlayer) {
                    for (int i = 0; i < pawnColor.size(); i++) {
                        int finalI = i;
                        pawnColor.get(i).setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                makeMove(pawnColor, pawnColor.get(finalI), numberOfMoves, isPlayer);
                                for (int j = 0; j < pawnColor.size(); j++) {
                                    pawnColor.get(j).setOnClickListener(null);
                                }
                            }
                        });
                    }
                }
                else{
                    Random random = new Random();
                    int lLosowa = random.nextInt(pawnColor.size());
                    makeMove(pawnColor, pawnColor.get(lLosowa), numberOfMoves, isPlayer);

                }
            }
        }else{
            if (pawnColor.size() == 0)
                pickBasePawn(pawnColor, baseColor, isPlayer);
            else{
                pawnSpawnOrMove(pawnColor,baseColor,numberOfMoves, isPlayer);
            }
        }


    }

    void pawnSpawnOrMove(ArrayList<ImageButton> pawnColor, ArrayList<ImageButton> baseColor, int numberOfMoves, boolean isPlayer){
        if(isPlayer) {
            for (int i = 0; i < pawnColor.size(); i++) {
                int finalI = i;
                pawnColor.get(i).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        makeMove(pawnColor, pawnColor.get(finalI), numberOfMoves, isPlayer);
                        for (int j = 0; j < pawnColor.size(); j++) {
                            pawnColor.get(j).setOnClickListener(null);
                        }
                        for (int j = 0; j < baseColor.size(); j++) {
                            baseColor.get(j).setOnClickListener(null);
                        }
                    }
                });
            }
            for (int i = 0; i < baseColor.size(); i++) {
                int finalI = i;
                baseColor.get(i).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ImageButton imageButton;
                        imageButton = findViewById(R.id.ImageButton13);
                        pawnColor.add(imageButton);
                        pawnColor.get(pawnColor.size() - 1).setImageResource(R.drawable.pawnr);
                        baseColor.get(finalI).setImageDrawable(null);
                        for (int j = 0; j < baseColor.size(); j++) {
                            baseColor.get(j).setOnClickListener(null);
                        }
                        for (int j = 0; j < pawnColor.size(); j++) {
                            pawnColor.get(j).setOnClickListener(null);
                        }
                        baseColor.remove(finalI);

                    }
                });
            }
        }else{

            Random random = new Random();
            int choosePawnSpawnOrMove = random.nextInt(2);

            if(baseGreen.size() == 0)
                choosePawnSpawnOrMove=0;

            if(choosePawnSpawnOrMove == 0) {
                int lLosowa = random.nextInt(pawnColor.size());
                makeMove(pawnColor, pawnColor.get(lLosowa), numberOfMoves, isPlayer);
            }
            else
            {
                int lLosowa = random.nextInt(baseGreen.size());
                ImageButton imageButton = findViewById(R.id.ImageButton45);
                pawnColor.add(imageButton);
                pawnColor.get(pawnColor.size() - 1).setImageResource(R.drawable.pawng);
                baseColor.get(lLosowa).setImageDrawable(null);
                baseColor.remove(lLosowa);
            }

        }
    }

}