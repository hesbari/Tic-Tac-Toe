package com.f19.tictacdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    /*
    * 0 is player yellow or nought
    * 1 is player red or cross
    * */
    private int player = 0;

    /*
    * initial state of the game
    * */
    private int[] gameState = {-1, -1, -1, -1, -1, -1, -1, -1, -1};

    /*
    * winning positions
    * */
    int[][] winningPositions = {{0,1,2}, {3,4,5}, {6,7,8}, {0,3,6}, {1,4,7}, {2,5,8}, {0,4,8}, {2,4,6}};

    // boolean value to check the game
    boolean isActive = true;

    public void dropImage(View v) {
        ImageView imageView = (ImageView) v;
        int state = Integer.valueOf(imageView.getTag().toString());
        if (gameState[state] == -1 && isActive) {
            gameState[state] = player;
            imageView.setTranslationY(-2000);
            if (player == 0) {
//                imageView.setImageResource(R.drawable.yellow);
                imageView.setImageResource(R.drawable.nought);
                player = 1;
            } else {
//                imageView.setImageResource(R.drawable.red);
                imageView.setImageResource(R.drawable.cross);
                player = 0;
            }

            imageView.animate().translationYBy(2000).setDuration(300);
            for (int[] winningPosition : winningPositions) {
                if (gameState[winningPosition[0]] == gameState[winningPosition[1]] &&
                        gameState[winningPosition[1]] == gameState[winningPosition[2]] &&
                        gameState[winningPosition[0]] != -1) {
                    // we have a winner
                    isActive = false;
//                    String winner = (player == 0) ? "Red" : "Yellow";
                    String winner = (player == 0) ? "Cross" : "Nought";
                    Toast.makeText(this, "The winner is " + winner, Toast.LENGTH_SHORT).show();

                }
            }
        }

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
