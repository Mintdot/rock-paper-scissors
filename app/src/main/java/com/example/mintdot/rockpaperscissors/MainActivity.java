package com.example.mintdot.rockpaperscissors;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private int player;
    private int computer;
    private int result;

    Game game;

    ImageView playerChoice;
    ImageView computerChoice;

    ImageButton rock;
    ImageButton paper;
    ImageButton scissors;

    TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playerChoice = (ImageView) findViewById(R.id.player_choice);
        computerChoice = (ImageView) findViewById(R.id.computer_choice);

        rock = (ImageButton) findViewById(R.id.Player1);
        paper = (ImageButton) findViewById(R.id.Player2);
        scissors = (ImageButton) findViewById(R.id.Player3);

        resultText = (TextView) findViewById(R.id.result);

        rock.setOnClickListener(new ImageButton.OnClickListener() {
            @Override
            public void onClick(View v) {
                player = 0;
                play(player);
            }
        });

        paper.setOnClickListener(new ImageButton.OnClickListener() {
            @Override
            public void onClick(View v) {
                player = 1;
                play(player);
            }
        });

        scissors.setOnClickListener(new ImageButton.OnClickListener() {
            @Override
            public void onClick(View v) {
                player = 2;
                play(player);
            }
        });

    }

    public void play(int player) {
        game = new Game(player);
        computer = game.computer();
        playerChoice();
        computerChoice();
        message();
    }

    public void playerChoice() {
        switch (player) {
            case 0:
                playerChoice.setImageResource(R.drawable.p_rock);
                break;
            case 1:
                playerChoice.setImageResource(R.drawable.p_paper);
                break;
            case 2:
                playerChoice.setImageResource(R.drawable.p_scissors);
                break;
        }
    }

    public void computerChoice() {
        switch (computer) {
            case 0:
                computerChoice.setImageResource(R.drawable.p_rock);
                break;
            case 1:
                computerChoice.setImageResource(R.drawable.p_paper);
                break;
            case 2:
                computerChoice.setImageResource(R.drawable.p_scissors);
                break;
        }
    }

    public void message() {
        result = game.compare(computer);
        switch (result) {
            case 0:
                resultText.setText(getResources().getString(R.string.draw));
                break;
            case 1:
                resultText.setText(getResources().getString(R.string.win));
                break;
            case 2:
                resultText.setText(getResources().getString(R.string.lose));
                break;
        }
    }

}
