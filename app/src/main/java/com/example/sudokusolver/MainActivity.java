package com.example.sudokusolver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;

public class MainActivity extends AppCompatActivity {

    TextView textView[][] = new TextView[9][9], clicked;
    TextView numbers[] = new TextView[9];
    char board[][] = new char[9][9];
    boolean freeze, solveClicked, solved;
    boolean rowNotSafe, colNotSafe, blockNotSafe;
    int bI, bJ;
    LottieAnimationView lottieAnimationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

    }

    void init() {
        freeze = solveClicked = solved = false;
        lottieAnimationView = findViewById(R.id.animation_view);

        numbers[0] = findViewById(R.id.enter1);
        numbers[1] = findViewById(R.id.enter2);
        numbers[2] = findViewById(R.id.enter3);
        numbers[3] = findViewById(R.id.enter4);
        numbers[4] = findViewById(R.id.enter5);
        numbers[5] = findViewById(R.id.enter6);
        numbers[6] = findViewById(R.id.enter7);
        numbers[7] = findViewById(R.id.enter8);
        numbers[8] = findViewById(R.id.enter9);

        for (int i = 0; i < 9; i++) {
            numbers[i].setText(Integer.toString(i + 1));
        }

        textView[0][0] = findViewById(R.id.b00);
        textView[0][1] = findViewById(R.id.b01);
        textView[0][2] = findViewById(R.id.b02);
        textView[0][3] = findViewById(R.id.b03);
        textView[0][4] = findViewById(R.id.b04);
        textView[0][5] = findViewById(R.id.b05);
        textView[0][6] = findViewById(R.id.b06);
        textView[0][7] = findViewById(R.id.b07);
        textView[0][8] = findViewById(R.id.b08);

        textView[1][0] = findViewById(R.id.b10);
        textView[1][1] = findViewById(R.id.b11);
        textView[1][2] = findViewById(R.id.b12);
        textView[1][3] = findViewById(R.id.b13);
        textView[1][4] = findViewById(R.id.b14);
        textView[1][5] = findViewById(R.id.b15);
        textView[1][6] = findViewById(R.id.b16);
        textView[1][7] = findViewById(R.id.b17);
        textView[1][8] = findViewById(R.id.b18);

        textView[2][0] = findViewById(R.id.b20);
        textView[2][1] = findViewById(R.id.b21);
        textView[2][2] = findViewById(R.id.b22);
        textView[2][3] = findViewById(R.id.b23);
        textView[2][4] = findViewById(R.id.b24);
        textView[2][5] = findViewById(R.id.b25);
        textView[2][6] = findViewById(R.id.b26);
        textView[2][7] = findViewById(R.id.b27);
        textView[2][8] = findViewById(R.id.b28);

        textView[3][0] = findViewById(R.id.b30);
        textView[3][1] = findViewById(R.id.b31);
        textView[3][2] = findViewById(R.id.b32);
        textView[3][3] = findViewById(R.id.b33);
        textView[3][4] = findViewById(R.id.b34);
        textView[3][5] = findViewById(R.id.b35);
        textView[3][6] = findViewById(R.id.b36);
        textView[3][7] = findViewById(R.id.b37);
        textView[3][8] = findViewById(R.id.b38);

        textView[4][0] = findViewById(R.id.b40);
        textView[4][1] = findViewById(R.id.b41);
        textView[4][2] = findViewById(R.id.b42);
        textView[4][3] = findViewById(R.id.b43);
        textView[4][4] = findViewById(R.id.b44);
        textView[4][5] = findViewById(R.id.b45);
        textView[4][6] = findViewById(R.id.b46);
        textView[4][7] = findViewById(R.id.b47);
        textView[4][8] = findViewById(R.id.b48);

        textView[5][0] = findViewById(R.id.b50);
        textView[5][1] = findViewById(R.id.b51);
        textView[5][2] = findViewById(R.id.b52);
        textView[5][3] = findViewById(R.id.b53);
        textView[5][4] = findViewById(R.id.b54);
        textView[5][5] = findViewById(R.id.b55);
        textView[5][6] = findViewById(R.id.b56);
        textView[5][7] = findViewById(R.id.b57);
        textView[5][8] = findViewById(R.id.b58);

        textView[6][0] = findViewById(R.id.b60);
        textView[6][1] = findViewById(R.id.b61);
        textView[6][2] = findViewById(R.id.b62);
        textView[6][3] = findViewById(R.id.b63);
        textView[6][4] = findViewById(R.id.b64);
        textView[6][5] = findViewById(R.id.b65);
        textView[6][6] = findViewById(R.id.b66);
        textView[6][7] = findViewById(R.id.b67);
        textView[6][8] = findViewById(R.id.b68);

        textView[7][0] = findViewById(R.id.b70);
        textView[7][1] = findViewById(R.id.b71);
        textView[7][2] = findViewById(R.id.b72);
        textView[7][3] = findViewById(R.id.b73);
        textView[7][4] = findViewById(R.id.b74);
        textView[7][5] = findViewById(R.id.b75);
        textView[7][6] = findViewById(R.id.b76);
        textView[7][7] = findViewById(R.id.b77);
        textView[7][8] = findViewById(R.id.b78);

        textView[8][0] = findViewById(R.id.b80);
        textView[8][1] = findViewById(R.id.b81);
        textView[8][2] = findViewById(R.id.b82);
        textView[8][3] = findViewById(R.id.b83);
        textView[8][4] = findViewById(R.id.b84);
        textView[8][5] = findViewById(R.id.b85);
        textView[8][6] = findViewById(R.id.b86);
        textView[8][7] = findViewById(R.id.b87);
        textView[8][8] = findViewById(R.id.b88);

        resetBoard(null);
    }

    public void setVal(View view) //it highlights the row, column, and square block in blue color
    {
        if (freeze || solveClicked || solved)
            return;

        int iLow = bI - bI % 3, jLow = bJ - bJ % 3;
        if (bI >= 0) {
            for (int i = 0; i < 9; i++) {
                textView[bI][i].setBackgroundColor(getResources().getColor(R.color.white));
                textView[i][bJ].setBackgroundColor(getResources().getColor(R.color.white));
                textView[iLow][jLow].setBackgroundColor(getResources().getColor(R.color.white));
                jLow++;
                if ((i + 1) % 3 == 0) {
                    iLow++;
                    jLow -= 3;
                }
            }
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (view == textView[i][j]) {
                    bI = i;
                    bJ = j;
                }
            }
        }

        iLow = bI - bI % 3;
        jLow = bJ - bJ % 3;
        for (int i = 0; i < 9; i++) {
            textView[bI][i].setBackgroundColor(getResources().getColor(R.color.skyBlue));
            textView[i][bJ].setBackgroundColor(getResources().getColor(R.color.skyBlue));
            textView[iLow][jLow].setBackgroundColor(getResources().getColor(R.color.skyBlue));
            jLow++;
            if ((i + 1) % 3 == 0) {
                iLow++;
                jLow -= 3;
            }
        }
        clicked = textView[bI][bJ];
        clicked.setBackgroundColor(getResources().getColor(R.color.skyBlue2));
    }

    public void enterNumber(View view)// it is called when a number button is pressed
    {
        if (freeze || solveClicked || solved) // if a warning is being shown or board has been solved, this button will not work
            return;

        if (bI == -1) {
            emptyBoardWarning();
            return;
        }
        String str = ((TextView) view).getText().toString();
        if (!check(str, bI, bJ)) {
            warning(str, bI, bJ);
            return;
        }

//        if(!solveMini(str, bI, bJ))
//        {
//           freeze = true;
//           textView[bI][bJ].setBackgroundColor(getResources().getColor(R.color.red));
//            Toast.makeText(this, "Can't place " + str + " in Highlighted Block", Toast.LENGTH_SHORT).show();
//            final Handler handler = new Handler();
//            handler.postDelayed(new Runnable() {
//                @Override
//                public void run() {
//                    // Do something after 1s
//                    textView[bI][bJ].setBackgroundColor(getResources().getColor(R.color.skyBlue2));
//                    freeze = false;
//                }
//            }, 2000);
//        }
        else {
            textView[bI][bJ].setText(str);
            board[bI][bJ] = str.charAt(0);
        }

//        for(int i = 0; i < 9; i++)
//        {
//            for(int j = 0; j < 9; j++)
//            {
//                board[i][j] = textView[i][j].getText().toString().charAt(0);
//            }
//        }
    }

    void warning(String str, int bI, int bJ) {// highlights row, column, and block in which a number is entered twice
        freeze = true;
        int iLow = bI - bI % 3, jLow = bJ - bJ % 3;
        //this functions works for the latest clicked block only
        for (int i = 0; i < 9; i++) {
            textView[bI][i].setBackgroundColor(getResources().getColor(R.color.white));
            textView[i][bJ].setBackgroundColor(getResources().getColor(R.color.white));
            textView[iLow][jLow].setBackgroundColor(getResources().getColor(R.color.white));

            jLow++;
            if ((i + 1) % 3 == 0) {
                iLow++;
                jLow -= 3;
            }
        }

        iLow = bI - bI % 3; //reinitializing
        jLow = bJ - bJ % 3;

        for (int i = 0; i < 9; i++)
        {
            if(rowNotSafe)
            {
                textView[bI][i].setBackgroundColor(getResources().getColor(R.color.red));
                textView[bI][i].setTextColor(getResources().getColor(R.color.white));
            }
            if(colNotSafe)
            {
                textView[i][bJ].setBackgroundColor(getResources().getColor(R.color.red));
                textView[i][bJ].setTextColor(getResources().getColor(R.color.white));
            }
            if(blockNotSafe)
            {
                textView[iLow][jLow].setBackgroundColor(getResources().getColor(R.color.red));
                textView[iLow][jLow].setTextColor(getResources().getColor(R.color.white));
            }

            jLow++;
            if ((i + 1) % 3 == 0) {
                iLow++;
                jLow -= 3;
            }
        }
        Toast.makeText(this, str + " Already Exists in a Highlighted Block", Toast.LENGTH_SHORT).show();
        rowNotSafe = colNotSafe = blockNotSafe = false;

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // Do something after 1s
                int iLow = bI - bI % 3, jLow = bJ - bJ % 3;
                for (int i = 0; i < 9; i++) {
                    textView[bI][i].setBackgroundColor(getResources().getColor(R.color.skyBlue));
                    textView[i][bJ].setBackgroundColor(getResources().getColor(R.color.skyBlue));
                    textView[iLow][jLow].setBackgroundColor(getResources().getColor(R.color.skyBlue));
                    textView[bI][i].setTextColor(getResources().getColor(R.color.black));
                    textView[i][bJ].setTextColor(getResources().getColor(R.color.black));
                    textView[iLow][jLow].setTextColor(getResources().getColor(R.color.black));

                    jLow++;
                    if ((i + 1) % 3 == 0) {
                        iLow++;
                        jLow -= 3;
                    }
                }
                textView[bI][bJ].setBackgroundColor(getResources().getColor(R.color.skyBlue2));
                freeze = false;
            }
        }, 2000);

    }

    void emptyBoardWarning() {
        freeze = true;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                textView[i][j].setBackgroundColor(getResources().getColor(R.color.green));
            }
        }
        Toast.makeText(this, "Please Select a Block First!", Toast.LENGTH_SHORT).show();
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // Do something after 1s
                for (int i = 0; i < 9; i++) {
                    for (int j = 0; j < 9; j++) {
                        textView[i][j].setBackgroundColor(getResources().getColor(R.color.white));
                    }
                }
                freeze = false;
            }
        }, 1000);

    }

    public void resetBoard(View view) {
        if (freeze || solveClicked)
            return;

        bI = bJ = -1;
        freeze = solveClicked = solved = false;
        rowNotSafe = colNotSafe = blockNotSafe = false;

        clicked = null;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                board[i][j] = ' ';
                textView[i][j].setText(" ");
                textView[i][j].setTextColor(getResources().getColor(R.color.black));
                textView[i][j].setBackgroundColor(getResources().getColor(R.color.white));
            }
        }
        Button solveBtn = findViewById(R.id.solve);
        solveBtn.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.white)));
        solveBtn.setTextColor(getResources().getColor(R.color.green));
        solveBtn.setText("SOLVE");
    }

    boolean check(String str, int row, int col) {
        //checks if it is safe to put the char at the highlighted block
        int iLow = row - row % 3, jLow = col - col % 3;
        char ch = str.charAt(0);
        if (board[row][col] == ch)
            return true;

        boolean notSafe = false;
        for (int i = 0; i < 9; i++) {

            if (board[row][i] == ch)
            {
                notSafe = rowNotSafe = true;
            }
            if(board[i][col] == ch)
            {
                notSafe = colNotSafe = true;
            }
            if(board[iLow][jLow] == ch)
            {
                notSafe = blockNotSafe = true;
            }

            jLow++;
            if ((i + 1) % 3 == 0) {
                iLow++;
                jLow -= 3;
            }
        }

        if(notSafe)
            return false;

        return true;
    }

    public void solve(View view) {
        if (freeze)
            return;
        if (solved) {
            Toast.makeText(this, "Sudoku Already Solved!", Toast.LENGTH_SHORT).show();
            return;
        }
        solveClicked = true;

        if (!solve()) // the recursive method
        {
            solveClicked = false;
            Toast.makeText(this, "Invalid Sudoku Entries!", Toast.LENGTH_SHORT).show();
            return;
        }

        lottieAnimationView.setVisibility(View.VISIBLE);
        lottieAnimationView.playAnimation();

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // Do something after 5s = 5000ms
                lottieAnimationView.setVisibility(View.INVISIBLE);
            }
        }, 2200);

        if (bI >= 0) {
            int iLow = bI - bI % 3, jLow = bJ - bJ % 3;
            for (int i = 0; i < 9; i++) {
                textView[bI][i].setBackgroundColor(getResources().getColor(R.color.white));
                textView[i][bJ].setBackgroundColor(getResources().getColor(R.color.white));
                textView[iLow][jLow].setBackgroundColor(getResources().getColor(R.color.white));
                jLow++;
                if ((i + 1) % 3 == 0) {
                    iLow++;
                    jLow -= 3;
                }
            }
        }

        solveClicked = false; // these two lines will execute only when the board will be solve
        solved = true;
        Button btn = (Button) view;
        btn.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.green)));
        btn.setTextColor(getResources().getColor(R.color.white));
        btn.setText("SOLVED");

    }

    boolean solve() //the main code for solving
    {
        for (int i = 4, indI = 0; indI < 9; indI++) {
            if ((indI & 1) == 1) //when indI is odd
            {
                i -= indI;
            } else {
                i += indI;
            }

            for (int j = 4, indJ = 0; indJ < 9; indJ++) {
                if ((indJ & 1) == 1) // when indJ is odd
                {
                    j -= indJ;
                } else {
                    j += indJ;
                }
                //Now we are starting from centre of board
                if (board[i][j] == ' ') {
                    //   Log.d("LOG", Integer.toString(i) + "  " + Integer.toString(j));
                    for (char ch = '1'; ch <= '9'; ch++) {
                        if (check(Character.toString(ch), i, j)) {
                            board[i][j] = ch;
                            textView[i][j].setText(Character.toString(ch));
                            textView[i][j].setTextColor(getResources().getColor(R.color.green2));

                            //     pause(10);

                            if (solve())
                                return true;

                            board[i][j] = ' ';
                            textView[i][j].setText(" ");
                            textView[i][j].setTextColor(getResources().getColor(R.color.black));
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    void pause(long timeInMilliSeconds) {

        long timestamp = System.currentTimeMillis();

        do {

        } while (System.currentTimeMillis() < timestamp + timeInMilliSeconds);

    }

    boolean solveMini(String str, int row, int col) //the main code for solving
    {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
//                if(i == row && j == col && board[row][col] != str.charAt(0))
//                {
//                    char temp = board[row][col];
//                    if(check(str, row, col))
//                    {
//                        board[row][col] = str.charAt(0);
//                        if(solveMini(str, row, col))
//                            return true;
//
//                        board[row][col] = temp;
//                    }
//                    return false;
//                }
//                else
                if (board[i][j] == ' ') {
                    for (char ch = '1'; ch <= '9'; ch++) {
                        if (check(Character.toString(ch), i, j)) {
                            board[i][j] = ch;

                            if (solveMini(str, row, col))
                                return true;

                            board[i][j] = ' ';

                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
}