package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddPlayers extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_players);

        final EditText player1=findViewById(R.id.player1);
        final EditText player2=findViewById(R.id.player2);
        final Button startgame=findViewById(R.id.startgame);

        startgame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String player1name= player1.getText().toString();
                final String player2name= player2.getText().toString();

                if(player1name.isEmpty() || player2name.isEmpty())
                {
                    Toast.makeText(AddPlayers.this, "Please Enter Player Names ", Toast.LENGTH_LONG).show();
                }
                else
                {
                    Intent intent=new Intent(AddPlayers.this, MainActivity.class);
                    intent.putExtra("playerone",player1name);
                    intent.putExtra("playertwo",player2name);
                    startActivity(intent);
                }
            }
        });
    }
}