package com.example.cs408lab1a;

import static com.example.cs408lab1a.Weapon.*;

import androidx.appcompat.app.AppCompatActivity;

import android.media.metrics.PlaybackErrorEvent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button weapon_1;
    private Button weapon_2;
    private Button weapon_3;
    private Weapon weapon;
    private Weapon enemyWeapon;

    private TextView welcomeText;
    private TextView scoreText;
    private TextView playerWeap;
    private TextView compWeap;
    private TextView roundText;

    private Random weaponSelect = new Random();
    private int weaponChosen;
    private int playerScore = 0;
    private int compScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        weapon_1 = findViewById(R.id.weapon_1);
        weapon_2 = findViewById(R.id.weapon_2);
        weapon_3 = findViewById(R.id.weapon_3);

        weapon_1.setText(weapon.ROCK.toString());
        weapon_2.setText(weapon.PAPER.toString());
        weapon_3.setText(weapon.SCISSORS.toString());

        playerWeap = findViewById(R.id.playerWeap);
        compWeap = findViewById(R.id.compWeap);

        roundText = findViewById(R.id.roundText);
        welcomeText = findViewById(R.id.welcomeText);
        welcomeText.setText("Welcome to Rock-Paper-Scissors!\nPlease choose your weapon:");

        scoreText = findViewById(R.id.scoreText);
        scoreText.setText(new StringBuilder().append("Player: ").append(playerScore).append(", Computer: ").append(compScore).toString());
        playerWeap.setText("Player's Weapon:");
        compWeap.setText("Computer's Weapon:");
        roundText.setText("");


        findViewById(R.id.weapon_1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                weapon = ROCK;
                playerWeap.setText("Player's Weapon: Rock");
                weaponChosen = weaponSelect.nextInt(2);
                rollWeapon();
            }
        });

        findViewById(R.id.weapon_2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                weapon = PAPER;
                playerWeap.setText("Player's Weapon: Paper");
                weaponChosen = weaponSelect.nextInt(2);
                rollWeapon();
            }
        });

        findViewById(R.id.weapon_3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                weapon = SCISSORS;
                playerWeap.setText("Player's Weapon: Scissors");
                weaponChosen = weaponSelect.nextInt(2);
                rollWeapon();
            }
        });

    }

    private void rollWeapon() {
        if (weaponChosen == 0) {
            enemyWeapon = Weapon.ROCK;
            compWeap.setText("Computer's Weapon: Rock");
        }
        if (weaponChosen == 1) {
            enemyWeapon = Weapon.PAPER;
            compWeap.setText("Computer's Weapon: Paper");
        }
        if (weaponChosen == 2) {
            enemyWeapon = Weapon.SCISSORS;
            compWeap.setText("Computer's Weapon: Scissors");
        }

        if (weapon == Weapon.ROCK) {
            if (enemyWeapon == Weapon.ROCK) {
                roundText.setText("Tie!");
            }
            if (enemyWeapon == Weapon.PAPER) {
                roundText.setText("Computer wins... Paper covers rock!");
                ++compScore;
            }
            if (enemyWeapon == Weapon.SCISSORS) {
                roundText.setText("Player wins... Rock blunts scissors!");
                ++playerScore;
            }

        }
        if (weapon == Weapon.PAPER) {
            if (enemyWeapon == Weapon.ROCK) {
                roundText.setText("Player wins... Paper covers rock!");
                ++playerScore;
            }
            if (enemyWeapon == Weapon.PAPER) {
                roundText.setText("Tie!");
            }
            if (enemyWeapon == Weapon.SCISSORS) {
                roundText.setText("Computer wins... Scissors cuts paper!");
                ++compScore;
            }

        }
        if (weapon == Weapon.SCISSORS) {
            if (enemyWeapon == Weapon.ROCK) {
                roundText.setText("Computer wins... Rock blunts scissors!");
                ++compScore;
            }
            if (enemyWeapon == Weapon.PAPER) {
                roundText.setText("Player wins... Scissors cuts paper!");
                ++playerScore;
            }
            if (enemyWeapon == Weapon.SCISSORS) {
                roundText.setText("Tie!");
            }
        }
        scoreText.setText(new StringBuilder().append("Player: ").append(playerScore).append(", Computer: ").append(compScore).toString());
    }
}