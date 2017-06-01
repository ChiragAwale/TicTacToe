package com.chiragawale.tictactoe;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button [] btn = new Button[9];
    boolean xOrO = false;
    TextView playerOneWin;
    TextView playerTwoWin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn[0] = (Button) findViewById(R.id.button_1);
        btn[1] = (Button) findViewById(R.id.button_2);
        btn[2] = (Button) findViewById(R.id.button_3);
        btn[3] = (Button) findViewById(R.id.button_4);
        btn[4] = (Button) findViewById(R.id.button_5);
        btn[5] = (Button) findViewById(R.id.button_6);
        btn[6] = (Button) findViewById(R.id.button_7);
        btn[7]= (Button) findViewById(R.id.button_8);
        btn[8] = (Button) findViewById(R.id.button_9);
        playerOneWin = (TextView) findViewById(R.id.player_1_win);
        playerTwoWin = (TextView) findViewById(R.id.player_2_win);
    }
    //Sets the button text to either X or Y according the the value of xOrO which determines player turn
    void set(View view){
        int id = view.getId();
        if(xOrO) {
            btn[(id%10)-1].setText("X");
            btn[(id%10)-1].setClickable(false);
            xOrO = !xOrO;
            checkForWin();
        }else{
            btn[(id%10)-1].setText("O");
            btn[(id%10)-1].setClickable(false);
            xOrO = !xOrO;
            checkForWin();

        }
    }
    //Resets all the texts of the buttons
    void reset_All(View view){
        for(int i = 0; i < 9; i++){
            btn[i].setText(" ");
            btn[i].setClickable(true);
        }

        playerTwoWin.setVisibility(View.INVISIBLE);
        playerOneWin.setVisibility(View.INVISIBLE);
    }
    //Sets all to not clickable to prevent error wins
    void setAllNotClickable(){
        for(int i = 0; i < 9; i++){
            btn[i].setClickable(false);
        }
    }

    void checkForWin(){
        int con = 0;
        //Collects string values of the buttons
        String [] btnString = new String[10];
        for(int i = 0; i < 9; i ++){
            btnString[i+1] =(String) btn[i].getText();
        }
        //Checks for horizontal wins
        for(int h = 0; h < 3; h++) {

            if (btnString[1+h].equals(btnString[4+h]) && btnString[7+h].equals(btnString[4+h])) {
                if (btnString[1+h].equals("X")) {
                    playerOneWin.setVisibility(View.VISIBLE);
                    setAllNotClickable();
                } else if (btnString[1+h].equals("O")){
                    playerTwoWin.setVisibility(View.VISIBLE);
                    setAllNotClickable();
                }
            }
        }
        //Checks for vertical wins
        for(int v = 0; v < 3; v++) {

            if (btnString[1+ con].equals(btnString[2+con]) && btnString[3+con].equals(btnString[2+con])) {
                if (btnString[1+con].equals("X")) {
                    playerOneWin.setVisibility(View.VISIBLE);
                    setAllNotClickable();
                } else if (btnString[1+con].equals("O")){
                    playerTwoWin.setVisibility(View.VISIBLE);
                    setAllNotClickable();
                }
            }
            con = con +3;
        }
        //Checks for diagonal wins
        if(btnString[1].equals(btnString[5]) && btnString[5].equals(btnString[9])){
            if (btnString[1].equals("X")) {
                playerOneWin.setVisibility(View.VISIBLE);
                setAllNotClickable();
            } else if (btnString[1].equals("O")){
                playerTwoWin.setVisibility(View.VISIBLE);
                setAllNotClickable();
            }
        }
        //Checks for diagonal wins
        if(btnString[3].equals(btnString[5]) && btnString[5].equals(btnString[7])){
            if (btnString[3].equals("X")) {
                playerOneWin.setVisibility(View.VISIBLE);
                setAllNotClickable();
            } else if (btnString[3].equals("O")){
                playerTwoWin.setVisibility(View.VISIBLE);
                setAllNotClickable();
            }
        }


    }


}
