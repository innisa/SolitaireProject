package com.example.innisa.solitaireproject;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;

public class scrnGame extends AppCompatActivity {
    private Deck d;
    private ImageButton imgCardPlay;
    private ImageButton imgCard1;
    private ImageButton imgCard2;
    private ImageButton imgCard3;
    private ImageButton imgCard4;
    private ImageButton imgCard5;
    private ImageButton imgCard6;
    private ImageButton imgCard7;
    private ImageButton imgDeckDiamond;
    private ImageButton imgDeckSpade;
    private ImageButton imgDeckClub;
    private ImageButton imgDeckHeart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrn_game);
        /*Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
        /*
        button.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {
            startActivity(new Intent(MainActivity.this,StandingsActivity.class));
        }
    });
        */

        //create a deck
        d= new Deck();
        imgCardPlay= (ImageButton) findViewById(R.id.imgCardPlay);
        imgCard1= (ImageButton) findViewById(R.id.imgCard1);
        imgCard2= (ImageButton) findViewById(R.id.imgCard2);
        imgCard3= (ImageButton) findViewById(R.id.imgCard3);
        imgCard4= (ImageButton) findViewById(R.id.imgCard4);
        imgCard5= (ImageButton) findViewById(R.id.imgCard5);
        imgCard6= (ImageButton) findViewById(R.id.imgCard6);
        imgCard7= (ImageButton) findViewById(R.id.imgCard7);

        imgDeckDiamond= (ImageButton) findViewById(R.id.imgDeckDiamond) ;
        imgDeckClub=(ImageButton)findViewById(R.id.imgDeckClub);
        imgDeckSpade=(ImageButton)findViewById(R.id.imgDeckSpade);
        imgDeckHeart=(ImageButton)findViewById(R.id.imgDeckHeart);
        //PUT STUFF ON THE LAYOUT
        reset();
            //pick random card - for put down on back(nah just do when turn over)
                            // for 7 put up
                            //for take out of deck

    }

    //reset the app/ run at beginning too
    public void reset(){
        //shuffle the deck
        d.shuffleDeck();

        //pick card from top of deck--
        //pick a random card from the deck, set the image of that card (or do that in the card class) ask mrs kelly
        //TODO decide where set image of card--when doing code or in card class- if in card class will have to change eventually
        //remove that card- set the first image to that cards image
        //ask if can concise the <code></code>

        //set the card picked (doing first cuz easiest to think through)
        //MODULARIZE MORE
        //returns a card , you put in a button
        //am I just setting the images of these cards to imageButtons
        //do I just change what the image of the iamge button is to change it??????//need images
        Card pick= createCard(imgCardPlay);
        Card c1= createCard(imgCard1);
        Card c2= createCard(imgCard2);
        Card c3= createCard(imgCard3);
        Card c4= createCard(imgCard4);
        Card c5= createCard(imgCard5);
        Card c6= createCard(imgCard6);
        Card c7= createCard(imgCard7);

        Card dDiamond= createCard(imgDeckDiamond);
        Card dSpade= createCard(imgDeckSpade);
        Card dClub= createCard(imgDeckClub);
        Card dHeart= createCard(imgDeckHeart);

        //TODO then set the aces ones to blank


    }
    //create a card- pick it randomly from the deck and remove it
    public Card createCard(ImageButton img){
        Card c= d.pickACard();
        c= d.removeCard(c);
        setCardImage(c, img);
        return c;
    }
    //set the image of a imageButton to the card that corresponds to the value of that card
    public void setCardImage(Card c, ImageButton img){
        //set the image of that button according to the rank and suit of the card
        //what else? put this value on card?????????????????????????????????????????????????????????????????????????????????????????????????
        //TODO think about it I even need an image field on the card class // can't I just set the image buttons based on the rank and suit //maybe just use this method//honestly I like that idea better makes more sense
        String s= c.getSuit();
        int r= c.getRank();
        //THEN MAKE A REALLY BIG SWITCH STATEMENT
        //btn.setBackgroundResource(R.drawable.icon);

    }

}
