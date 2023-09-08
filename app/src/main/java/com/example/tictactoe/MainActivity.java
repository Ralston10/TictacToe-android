package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private final List<int[]> combinationList=new ArrayList<>();

    private int[] boxPositions={0,0,0,0,0,0,0,0,0};

    private int playerTurn=1;
    private int totalSelectedBoxes=1;

    TextView playerone,playertwo;
    ImageView i1,i2,i3,i4,i5,i6,i7,i8,i9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playerone = findViewById(R.id.playerone);
        playertwo = findViewById(R.id.playertwo);

        i1 = findViewById(R.id.image1);
        i2 = findViewById(R.id.image2);
        i3 = findViewById(R.id.image3);
        i4 = findViewById(R.id.image4);
        i5 = findViewById(R.id.image5);
        i6 = findViewById(R.id.image6);
        i7 = findViewById(R.id.image7);
        i8 = findViewById(R.id.image8);
        i9 = findViewById(R.id.image9);

        combinationList.add(new int[]{0, 1, 2});
        combinationList.add(new int[]{3, 4, 5});
        combinationList.add(new int[]{6, 7, 8});
        combinationList.add(new int[]{0, 3, 6});
        combinationList.add(new int[]{1, 4, 7});
        combinationList.add(new int[]{2, 5, 8});
        combinationList.add(new int[]{2, 4, 6});
        combinationList.add(new int[]{0, 4, 8});

        final String player1name = getIntent().getStringExtra("playerone");
        final String player2name = getIntent().getStringExtra("playertwo");

        playerone.setText(player1name);
        playertwo.setText(player2name);

        i1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isBoxSelectable(0)) {
                    performAction((ImageView)view,0);
                }

            }
        });

        i2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (isBoxSelectable(1)) {
                    performAction((ImageView)view,1);
                }

            }
        });
        i3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isBoxSelectable(2)) {
                    performAction((ImageView)view,2);
                }

            }
        });
        i4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isBoxSelectable(3)) {
                    performAction((ImageView)view,3);

                }

            }
        });
        i5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isBoxSelectable(4)) {
                    performAction((ImageView)view,4);

                }

            }
        });
        i6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isBoxSelectable(5)) {
                    performAction((ImageView)view,5);

                }

            }
        });
        i7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isBoxSelectable(6)) {
                    performAction((ImageView)view,6);

                }

            }
        });
        i8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isBoxSelectable(7)) {
                    performAction((ImageView)view,7);

                }

            }
        });
        i9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isBoxSelectable(8)) {
                    performAction((ImageView)view,8);

                }

            }
        });
    }

        private void performAction(ImageView imageView,int selectedBoxPosition)
        {
            boxPositions[selectedBoxPosition] = playerTurn;
            if (playerTurn == 1) {
                imageView.setImageResource(R.drawable.xicon);
                if (checkPlayerWin()) {
                    WinDialog winDialog = new WinDialog(MainActivity.this, playerone.getText().toString() + " has won the match", MainActivity.this);
                    winDialog.setCancelable(false);
                    winDialog.show();
                } else if (totalSelectedBoxes == 9) {
                    WinDialog winDialog = new WinDialog(MainActivity.this, "It is a draw", MainActivity.this);
                    winDialog.setCancelable(false);
                    winDialog.show();

                } else {
                    changePlayerTurn(2);
                    totalSelectedBoxes++;
                }

            } else {
                imageView.setImageResource(R.drawable.zero);
                if (checkPlayerWin()) {
                    WinDialog winDialog = new WinDialog(MainActivity.this, playertwo.getText().toString() + " has won the match", MainActivity.this);
                    winDialog.setCancelable(false);
                    winDialog.show();
                } else if (selectedBoxPosition == 9) {
                    WinDialog winDialog = new WinDialog(MainActivity.this, "It is a draw", MainActivity.this);
                    winDialog.setCancelable(false);
                    winDialog.show();
                } else {
                    changePlayerTurn(1);
                    totalSelectedBoxes++;
                }
            }
        }


        private void changePlayerTurn(int currentPlayerTurn)
        {
            playerTurn=currentPlayerTurn;

            if(playerTurn==1)
            {
                //Toast.makeText(this, "Hi", Toast.LENGTH_SHORT).show();
            }
            else
            {
                //Toast.makeText(this, "Bye", Toast.LENGTH_SHORT).show();
            }
        }

        private boolean checkPlayerWin()
        {
            boolean response=false;
            for(int i=0;i<combinationList.size();i++)
            {
                final int[]combination=combinationList.get(i);

                if(boxPositions[combination[0]]==playerTurn&&boxPositions[combination[1]]==playerTurn&&boxPositions[combination[2]]==playerTurn)
                {
                    response=true;

                }
            }
            return response;
        }

        private boolean isBoxSelectable(int boxPosition)
        {
            boolean response=false;
            if(boxPositions[boxPosition]==0)
            {
                response=true;
            }
            return response;
        }



    public void restartMatch()
    {
        boxPositions=new int[]{0,0,0,0,0,0,0,0,0};

        playerTurn=1;
        totalSelectedBoxes=1;
        i1.setImageResource(R.drawable.purple);
        i2.setImageResource(R.drawable.purple);
        i3.setImageResource(R.drawable.purple);
        i4.setImageResource(R.drawable.purple);
        i5.setImageResource(R.drawable.purple);
        i6.setImageResource(R.drawable.purple);
        i7.setImageResource(R.drawable.purple);
        i8.setImageResource(R.drawable.purple);
        i9.setImageResource(R.drawable.purple);
    }
}