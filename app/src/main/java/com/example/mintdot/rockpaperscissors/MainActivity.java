package com.example.mintdot.rockpaperscissors;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private int player;
    private int computer;
    private int result;
    private int win;
    private int lose;
    private int draw;

    Game game;

    ImageView playerChoice;
    ImageView computerChoice;

    ImageButton rock;
    ImageButton paper;
    ImageButton scissors;

    TextView resultText;
    TextView ratingText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        win = 0;
        lose = 0;
        draw = 0;

        playerChoice = (ImageView) findViewById(R.id.player_choice);
        computerChoice = (ImageView) findViewById(R.id.computer_choice);

        rock = (ImageButton) findViewById(R.id.Player1);
        paper = (ImageButton) findViewById(R.id.Player2);
        scissors = (ImageButton) findViewById(R.id.Player3);

        resultText = (TextView) findViewById(R.id.result);
        ratingText = (TextView) findViewById(R.id.rating);

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_reset:
                gameReset();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void play(int player) {
        game = new Game(player);
        computer = game.computer();
        playerChoice();
        computerChoice();
        showResult();
        showRating();
    }

    private void playerChoice() {
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

    private void computerChoice() {
        switch (computer) {
            case 0:
                computerChoice.setImageResource(R.drawable.c_rock);
                break;
            case 1:
                computerChoice.setImageResource(R.drawable.c_paper);
                break;
            case 2:
                computerChoice.setImageResource(R.drawable.c_scissors);
                break;
        }
    }

    private void showResult() {
        result = game.compare(computer);
        switch (result) {
            case 0:
                resultText.setText(getResources().getString(R.string.draw));
                draw++;
                break;
            case 1:
                resultText.setText(getResources().getString(R.string.win));
                win++;
                break;
            case 2:
                resultText.setText(getResources().getString(R.string.lose));
                lose++;
                break;
        }
    }

    private void showRating() {
        ratingText.setText(win + "승 " + draw + "무 " + lose + "패");
    }

    private void gameReset() {
        playerChoice.setImageResource(R.drawable.question);
        computerChoice.setImageResource(R.drawable.question);
        resultText.setText(getResources().getString(R.string.result2));
        ratingText.setText(getResources().getString(R.string.rating));
    }

}
