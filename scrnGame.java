package com.example.innisa.solitaireproject;

import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;

import java.util.ArrayList;

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
    private boolean isPlayClick;
    private boolean isDeckClick;

    private Card pick;
    private Card c1;
    private Card c2;
    private Card c3;
    private Card c4;
    private Card c5;
    private Card c6;
    private Card c7;
    private Card deckClick;

    //store the number or red ridges for eah pile
   // private int rRidgeCount1;
    private int rRidgeCount2;
    private int rRidgeCount3;
    private int rRidgeCount4;
    private int rRidgeCount5;
    private int rRidgeCount6;
    private int rRidgeCount7;

    //store the number of white ridges for each pile
    private int wRidgeCount1;
    private int wRidgeCount2;
    private int wRidgeCount3;
    private int wRidgeCount4;
    private int wRidgeCount5;
    private int wRidgeCount6;
    private int wRidgeCount7;

    private ArrayList<Card> p1;
    private ArrayList<Card> p2;
    private ArrayList<Card> p3;
    private  ArrayList<Card> p4;
    private ArrayList<Card> p5;
    private ArrayList<Card> p6;
    private ArrayList<Card> p7;
//todo have an arraylist for each pile
    //todo have values for the number of red and white ridges on each pile
    //todo quit button
    //todo tabbed activity
    //todo settings
    //so these arraylists- should I make it a deck-- need one for each imgCard --change them when move play to a pile or when move decks
    //when initialize--in reset I guess //should also probably be fields
//    Card dDiamond= createCard(imgDeckDiamond);
//    Card dSpade= createCard(imgDeckSpade);
//    Card dClub= createCard(imgDeckClub);
//    Card dHeart= createCard(imgDeckHeart);
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

        //when imgCardPlay is clickedchange a variable to see if anything else is changed
        //maybe if time when clicked take the borders off the image
        imgCardPlay.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //isPlayClick= true; //reminder when anything else is clicked change this
                if (isPlayClick == true)
                    isPlayClick = false;
                else
                    isPlayClick = true;
            }
        });

        //set the onclickListeners for each deck
        imgCard1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                imgDeckOnClickListener(imgCard1);
                //TODO ADD ANOTHER METHOD, IF CLICK DECK FIRST THEN ANOTHER DECK
            }
        });
        //todo- if this deck already clicked, change the variable

    }

    //method to check if a deck is already clicked//called when a deck is clicked
    public void deckMoveOnClickListener(ImageButton b){
        //need to store a field, need to store boolean on if a deck has been clicked, and store what deck was clicked
        if(isDeckClick==true) {//is this right
            //save value of first pile
            isDeckClick = false;
            //set the deck image and store the image from the image button
//            int idOfBtn= b.getId();
//            Image firstClickImg= idOfBtn.setImageResou
            Drawable d =b.getBackground();
            Image firstClickImg= null;
            //img.setBackgroundDrawable
//            firstClickImg.setImage
            //need to figure our why classes of image are not coming up or how to declare a image
        }
        else {
            isDeckClick = true;
            //WHAT DO I SET GET CLUB TO
            //check if can move first pile to the second
            //check if bottom card of first pile is bellow top card of second pile
            //do i figure this out on my own or make a list--proabbly list
            //move first to second pile (and check if legal)
            //figure out value of bottom of the bottom card
            //When add piles add to array list
        }
        //TODO TMRW START HERE
        //so i want to be able to click one deck then click another and move the first deck to the second
        //need to store what deck was clicked so that can set the other deck image to that image. and set the other deck card
        //so do I store both? ya

    }
    //check to make sure img play has been clicked
    //when pile clicked see if its corresponding card works w isClickPlay
    public void imgDeckOnClickListener(ImageButton b){
        //check if works out here bc cant access b inside the other class
        Card corrWithImg;
        if(b==imgCard1)
            corrWithImg=c1;
        else if(b==imgCard2)
            corrWithImg=c2;
        else if(b==imgCard3)
            corrWithImg=c3;
        else if(b==imgCard4)
            corrWithImg=c4;
        else if(b==imgCard5)
            corrWithImg=c5;
        else if(b==imgCard6)
            corrWithImg=c6;
        else
            corrWithImg=c7;

        //check to see if the card works
        if(pick.isBellow(corrWithImg)&& isPlayClick){
            //if statement to see what card to change
            //change b to p's image //idk if need if statement or not
            //todo change images make sure this is an onClick
            //maybe modularize
            if(b==imgCard1) {
                p1.add(pick);//todo figure out where this adds this
                c1 = pick;
            }
            else if(b==imgCard2) {
                p2.add(pick);
                c2 = pick;
            }
            else if(b==imgCard3) {
                p3.add(pick);
                c3 = pick;
            }
            else if(b==imgCard4) {
                c4 = pick;
            }
            else if(b==imgCard5) {
                c5 = pick;
            }
            else if(b==imgCard6) {
                c6 = pick;
            }
            else {
                c7 = pick;
            }

            pick= createCard(imgCardPlay);
            isPlayClick=false;
            //todo add ridge--if statement o figure out what pile in, then add ridge to that pile
            //if b==imgcard1 add to wRidgeCount1
            //todo modularizee this i think
            if(b==imgCard1)
                wRidgeCount1+=1;
            else if(b==imgCard2)
                wRidgeCount2+=1;
            else if(b==imgCard3)
                wRidgeCount3+=1;
            else if(b==imgCard4)
                wRidgeCount4+=1;
            else if(b==imgCard5)
                wRidgeCount5+=1;
            else if(b==imgCard6)
                wRidgeCount6+=1;
            else
                wRidgeCount7+=1;


            //TODO start here
        }
            //CHANGE THE IMAGE



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

         pick= createCard(imgCardPlay);
         c1= createCard(imgCard1);
         c2= createCard(imgCard2);
         c3= createCard(imgCard3);
         c4= createCard(imgCard4);
         c5= createCard(imgCard5);
         c6= createCard(imgCard6);
         c7= createCard(imgCard7);

        Card dDiamond= createCard(imgDeckDiamond);
        Card dSpade= createCard(imgDeckSpade);
        Card dClub= createCard(imgDeckClub);
        Card dHeart= createCard(imgDeckHeart);

        isPlayClick=false;
        isDeckClick=false;

        //TODO then set the aces ones to blank
        //TODO reset ridge images
        rRidgeCount2=1;
        rRidgeCount3=2;
        rRidgeCount4=3;
        rRidgeCount5=4;
        rRidgeCount6=5;
        rRidgeCount7=6;

        wRidgeCount1=0;
        wRidgeCount2=0;
        wRidgeCount3=0;
        wRidgeCount4=0;
        wRidgeCount5=0;
        wRidgeCount6=0;
        wRidgeCount7=0;

        p1=new ArrayList<Card>();
        p1.add(c1);
        p2=new ArrayList<Card>();
        p2.add(c2);
        p3=new ArrayList<Card>();
        p3.add(c3);
        p4=new ArrayList<Card>();
        p4.add(c4);
        p5=new ArrayList<Card>();
        p5.add(c5);
        p6=new ArrayList<Card>();
        p6.add(c6);
        p7=new ArrayList<Card>();
        p7.add(c7);

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
