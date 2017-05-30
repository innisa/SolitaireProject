package com.example.innisa.solitaireproject;

import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.provider.ContactsContract;
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
    private Card cDiamond;
    private Card cClub;
    private Card cHeart;
    private Card cSpade;//todo see why grey

    private int intClick;
    ///ps when set oe object to another they point to the same card--so like be careful of that Alice

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
    private int wRidgeCount7; //todo dont i use this when moving one deck to another

    private ArrayList<Card> p1;
    private ArrayList<Card> p2;
    private ArrayList<Card> p3;
    private ArrayList<Card> p4;
    private ArrayList<Card> p5;
    private ArrayList<Card> p6;
    private ArrayList<Card> p7;
    private ArrayList<Card> pMove;
    private ArrayList<Card> pDiamond;
    private ArrayList<Card> pHeart;
    private ArrayList<Card> pSpade;
    private ArrayList<Card> pClub;

    private int deckNum=0; //stores number of deck if isDeckClicked is false

    //todo quit button
    //todo quit, when lose, when win, when deck runs  out of cards, when draw a card have to add that card to other deck
    //todo if pile empty and there are red left flip those jaunts
    //todo refresh deck when none
    //todo before test code walk through it all
    //todo win lose make sure on clicks
    //todo watch out for null
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
        //todo method to set these
        //send in each suit image
        pileOnClickListener(imgCard1);
        pileOnClickListener(imgCard2);
        pileOnClickListener(imgCard3);
        pileOnClickListener(imgCard4);
        pileOnClickListener(imgCard5);
        pileOnClickListener(imgCard6);
        pileOnClickListener(imgCard7);

        suitOnClickListener(imgDeckClub);
        suitOnClickListener(imgDeckDiamond);
        suitOnClickListener(imgDeckHeart);
        suitOnClickListener(imgDeckSpade);

    }

    //set the onclick listeners for the piles
    public void pileOnClickListener(ImageButton b){
        b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                imgDeckOnClickListener((ImageButton)findViewById(v.getId()));//caste as button etc//v.getId and save it somewhere as the button
                deckMoveOnClickListener((ImageButton)findViewById(v.getId()));//TODO start here
            }
        });
    }

    //set the onClickListeners for the suit cards
    public void suitOnClickListener(ImageButton b){
        b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                suitOnClickListener((ImageButton)findViewById(v.getId()));//caste as button etc//v.getId and save it somewhere as the button
            }
        });
    }
    //method to check if a deck is already clicked//called when a deck is clicked
//moves one deck to another
    public void deckMoveOnClickListener(ImageButton b){
        //need to store a field, need to store boolean on if a deck has been clicked, and store what deck was clicked
        if(isDeckClick!=true) {
            //save value of first pile
            isDeckClick = true;
            deckClick=btnToCard(b);
            pMove=btnToPile(b);
            intClick=btnToInt(b);
            //maybe have a method to figure out from a card what image to use
            //then here i would just have to save the card /////////////////////
            //gonna save a number cuz I feel like it might help
        }
        else {
            isDeckClick = false;
            //check if can move first pile to the second
            if(deckClick!=null && pMove!=null){
                //check if bottom of first is bellow top of second
                //find bottom card of deck click
                //make methods for piles
                Card cCheck= pMove.get(1); //get card at the bottom of the pile

                //everything to move one pile to the other
                if(cCheck.isBellow(pick)){
                    //move the deck to that deck!-- change the white spaces,change the face card

                    //TODO make sure intMoveTo does not equal intClick
                    //figure out what piles to do, what pile was just clicked
                    int intMoveTo= btnToInt(b);
                    //TECHNICALLY COULD USE BTNTOPILE TO SAVE SPACE BUT IDK IF THAT REALLY WORKS
                    if(intMoveTo==1){
                        //add to pile one the cards from the pile that corresponds to intClick---make a method that takes into 2 arraylists and returns back a new arraylist

                       // if(pMove==2)
                        //edit number of white ridges
                        //TODO IMAGES
                        //TODO i think pmove should work here but I would check
                        p1=combinePiles(p1,pMove);
                    }
                    else if(intMoveTo==2){
                        p2= combinePiles(p2,pMove);
                        wRidgeCount2= p2.size()-1;
                    }
                    else if(intMoveTo==3){
                        p3= combinePiles(p3,pMove);
                        wRidgeCount3= p3.size()-1;
                    }
                    else if(intMoveTo==4){
                        p4= combinePiles(p4,pMove);
                        wRidgeCount4= p4.size()-1;
                    }
                    else if(intMoveTo==5){
                        p5= combinePiles(p5, pMove);
                        wRidgeCount5= p5.size()-1;
                    }
                    else if(intMoveTo==6){
                        p6= combinePiles(p6, pMove);
                        wRidgeCount6= p6.size()-1;
                    }
                    else if(intMoveTo==7){
                        p7=combinePiles(p7, pMove);
                        wRidgeCount7= p7.size()-1;
                    }
                    //todo what do when no red and no card
                    //set first click pile to a drawn card
                    if(intClick==1){
                        p1= new ArrayList<>();
                        //p1.add(createCard(imgCard1)); ADD NEW CARD LATER BC MIGHT LEAVE SLOT EMPTY-IF RED CARD FLIP IF NO RED CARD LEAVE BLANK

                    }//todo is this right????????????? think through if clear the known piles
                    else if(intClick==2){
                        p2=new ArrayList<>();
                        if(rRidgeCount2>0)
                            p2.add(createCard(imgCard2));
                    }
                    //if(intClick==1)
                    else if(intClick==3){
                        p3=new ArrayList<>();
                        if(rRidgeCount3>0)
                            p3.add(createCard(imgCard3));
                    }
                    else if(intClick==4){
                        p4= new ArrayList<>();
                        if(rRidgeCount4>0)
                            p4.add(createCard(imgCard4));
                    }
                    else if(intClick==5){
                        p5=new ArrayList<>();
                        if(rRidgeCount5>0)
                            p5.add(createCard(imgCard5));
                    }
                    else if(intClick==6){
                        p6= new ArrayList<>();
                        if(rRidgeCount6>0)
                            p6.add(createCard(imgCard6));
                    }
                    else if(intClick==7){
                        p7= new ArrayList<>();
                        if(rRidgeCount7>0)
                            p7.add(createCard(imgCard7));
                    }

                    //TODO WHITE RIDGE COUNT

                }
            }
//todo fix code if move play to deck huh

            //move first to second pile (and check if legal)
            //figure out value of bottom of the bottom card
            //When add piles add to array list
        }

        //so i want to be able to click one deck then click another and move the first deck to the second
        //need to store what deck was clicked so that can set the other deck image to that image. and set the other deck card
        //so do I store both? ya

    }
    //check to make sure img play has been clicked
    //when pile clicked see if its corresponding card works w isClickPlay
    //call this in deckMove on Click probably
    public void imgDeckOnClickListener(ImageButton b){
        //check if works out here bc cant access b inside the other class
        Card corrWithImg;
        corrWithImg=btnToCard(b);


        //check to see if the card works
        if(pick.isBellow(corrWithImg)&& isPlayClick){
            //if statement to see what card to change
            //change b to p's image //idk if need if statement or not
            //todo change images make sure this is an onClick
            //maybe modularize
            //can i use a diff method here?
            if(b.equals(imgCard1)) {
                p1.add(pick);//todo figure out where this adds this
                c1 = pick;
            }
            else if(b.equals(imgCard2)) {
                p2.add(pick);
                c2 = pick;
            }
            else if(b.equals(imgCard3)) {
                p3.add(pick);
                c3 = pick;
            }
            else if(b.equals(imgCard4)) {
                p4.add(pick);
                c4 = pick;
            }
            else if(b.equals(imgCard5)) {
                p5.add(pick);
                c5 = pick;
            }
            else if(b.equals(imgCard6)) {
                p5.add(pick);
                c6 = pick;
            }
            else {
                p6.add(pick);
                c7 = pick;
            }

            pick= createCard(imgCardPlay);
            isPlayClick=false;
            //if b==imgcard1 add to wRidgeCount1

            if(b.equals(imgCard1))
                wRidgeCount1+=1;
            else if(b.equals(imgCard2))
                wRidgeCount2+=1;
            else if(b.equals(imgCard3))
                wRidgeCount3+=1;
            else if(b.equals(imgCard4))
                wRidgeCount4+=1;
            else if(b.equals(imgCard5))
                wRidgeCount5+=1;
            else if(b.equals(imgCard6))
                wRidgeCount6+=1;
            else
                wRidgeCount7+=1;

            //todo change image of ridge!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

        }
            //CHANGE THE IMAGE



    }

    //reset the app/ run at beginning too
    public void reset(){
        //shuffle the deck
        d.shuffleDeck();

        //pick card from top of deck--
        //pick a random card from the deck, set the image of that card (or do that in the card class) ask mrs kelly

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
        cDiamond=null;
        cClub=null;
        cHeart=null;
        cSpade=null;
        Card dDiamond= createCard(imgDeckDiamond);
        Card dSpade= createCard(imgDeckSpade);
        Card dClub= createCard(imgDeckClub);
        Card dHeart= createCard(imgDeckHeart);

        isPlayClick=false;
        isDeckClick=false;
        deckClick=null;
        intClick=0;

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

        p1=new ArrayList<>();
        p1.add(c1);
        p2=new ArrayList<>();
        p2.add(c2);
        p3=new ArrayList<>();
        p3.add(c3);
        p4=new ArrayList<>();
        p4.add(c4);
        p5=new ArrayList<>();
        p5.add(c5);
        p6=new ArrayList<>();
        p6.add(c6);
        p7=new ArrayList<>();
        p7.add(c7);
        pMove = null;
        pDiamond= new ArrayList<>();
        pClub= new ArrayList<>();
        pHeart= new ArrayList<>();
        pSpade= new ArrayList<>();

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

    //send in an image button and returns a card
    public Card btnToCard(ImageButton b){
        if(b.equals(imgCard1)) //==
            return c1;
        else if (b.equals(imgCard2))
            return c2;
        else if(b.equals(imgCard3))
            return c3;
        else if(b.equals(imgCard4))
            return c4;
        else if(b.equals(imgCard5))
            return c5;
        else if(b.equals(imgCard6))
            return c6;
        else if(b.equals(imgCard7))
            return c7;
        else
            return null;
    }
    //send in an image button and returns the corresponding pile/arraylist
    public ArrayList<Card> btnToPile(ImageButton b){
        if(b.equals(imgCard1))
            return p1;
        else if(b.equals(imgCard2))
            return p2;
        else if(b.equals(imgCard3))
            return p3;
        else if(b.equals(imgCard4))
            return p4;
        else if(b.equals(imgCard5))
            return p5;
        else if(b.equals(imgCard6))
            return p6;
        else if(b.equals(imgCard7))
            return p7;
        else
            return null;
    }

    //return a number that corresponds with the sent in button
    public int btnToInt(ImageButton b){
        if(b.equals(imgCard1))
            return 1;
        else if(b.equals(imgCard2))
            return 2;
        else if(b.equals(imgCard3))
            return 3;
        else if(b.equals(imgCard4))
            return 4;
        else if(b.equals(imgCard5))
            return 5;
        else if(b.equals(imgCard6))
            return 6;
        else if(b.equals(imgCard7))
            return 7;
        else
            return 0;
    }

    //combines two piles and returns the new pile
    public ArrayList<Card> combinePiles(ArrayList<Card> a, ArrayList<Card> b){
        for(int i=0;i<b.size();i++){
            a.add(b.get(i));
        }
        return a;
    }


    public void moveToSuitOnClick(ImageButton b){ //WHEN WILL I CALL THIS METHOD
        //when click a card--- then click on a suit pile-- check if same suit and one above(think I have a method for this)--if yes then card for that sui pile is now imageplay and change the image--make sure draw a new card
        //if play is an ace can put in any empty hole--//maybe set the card to rank 0
        //when click one pile than a stack-- check against face card-- if yes then the suit is now that card- delete it from the pile and change images

        //when click on pick then a suit card
        Card suitCard;
        suitCard=btnToCard(b);//make sure not null

        //do move deck to suit after first do pile
        //todo img

        //todo put an image for the empty piles so they know which suit goes w which
        //check to see if the card works
        //figure out what card is on the top of the deck clicked

        if(pick.canAddSuitStack(suitCard)&& isPlayClick && suitCard!=null){
            //figure out what suit pile using --from imagebutton
            // in this part  add card to suitpile
                //draw a new card
                //set the suit card to pick !!
                // change images
                //i think thats it for this part
            if(b.equals(imgDeckClub)) {
                pClub.add(pick);
                cClub=pick;
            }
            else if(b.equals(imgDeckDiamond)){
                pDiamond.add(pick);
                cDiamond=pick;
            }
            else if(b.equals(imgDeckHeart)){
                pHeart.add(pick);
                cHeart=pick;
            }
            else if(b.equals(imgDeckSpade)) {
                pSpade.add(pick);
                cSpade=pick;
            }
            pick= createCard(imgCardPlay);
            }
            //for if trying to move an ace
        else if(isPlayClick&&suitCard==null&&pick.getRank()==1){//dont even think i need to check if suitCard is null
            if(b.equals(imgDeckClub)){
                pClub.add(pick);
                cClub=pick;
            }
            else if(b.equals(imgDeckDiamond)){
                pDiamond.add(pick);
                cDiamond=pick;
            }
            else if(b.equals(imgDeckHeart)){
                pHeart.add(pick);
                cHeart= pick;
            }
            else if(b.equals(imgDeckSpade)){
                pSpade.add(pick);
                cSpade=pick;
            }
            pick=createCard(imgCardPlay);

        }
        //for moving a deck
        //if is deck click is false when click on a deck then store in a card field its card card
        //todo gonna have to do onclick or at least part
        //tod keep track of isDeckClick
        if(!isDeckClick){
            isDeckClick = true;
            deckClick=btnToCard(b);
            pMove=btnToPile(b);
            intClick=btnToInt(b); //makesure this workds
        }
        //TODO remove one from the pile!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!make sure I double check this method
        else if(isDeckClick&&deckClick.canAddSuitStack(suitCard)&&suitCard!=null&&deckClick!=null){
            if(b.equals(imgDeckClub)) {
                pClub.add(deckClick);
                cClub=deckClick;
            }
            else if(b.equals(imgDeckDiamond)){
                pDiamond.add(deckClick);
                cDiamond=deckClick;
            }
            else if(b.equals(imgDeckHeart)){
                pHeart.add(deckClick);
                cHeart=deckClick;
            }
            else if(b.equals(imgDeckSpade)) {
                pSpade.add(deckClick);
                cSpade=deckClick;
            }
            //todo so if pile has only one check if other red ridges---if has other stuff in the pile remove white ridge
            //change the image of the pile
            //todo change images
            if(intClick==1)
                c1=createCard(imgCard1);//todo MAKE THIS BLANK and w others check if there are red cards
            else if(intClick==2) {
                if(p2.size()==1&&rRidgeCount2>=1){
                    //take a card from red
                    rRidgeCount2-=1;
                    //change image!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
                    c2= createCard(imgCard2);
                }
                else if(p2.size()==1) {//check if its size would be 1 or 2

                }//make blank
                else if(p2.size()>1){
                    c2 = p2.get(p2.size()-2);//todo check for sure messed this up
                    //remove one card from pile
                    //remove one from white ridges
                    p2.remove(p2.size()-1); //todo for real tho how are the piles organized
                    wRidgeCount2-=1;

                }

            }
            else if(intClick==3){
                if(p3.size()==1 &&rRidgeCount3>=1){
                    rRidgeCount3-=1;
                    c3=createCard(imgCard3);
                }
                else if(p3.size()==1){
                    //make blank
                }
                else if(p3.size()>1){
                    c3= p3.get(p3.size()-2);
                    p3.remove(p3.size()-1);
                    wRidgeCount3-=1;
                }
            }

            else if(intClick==4){
                if(p4.size()==1 && rRidgeCount4>=1){
                    rRidgeCount4-=1;
                    c4= createCard(imgCard4);
                }
                else if(p4.size()==1){
                    //make blank
                }
                else if(p4.size()>1){
                    c4=p4.get(p4.size()-2);
                    p4.remove(p4.size()-1);
                    wRidgeCount4-=1;
                }
            }

            else if(intClick==5){
                if(p5.size()==1&&rRidgeCount5>=1){
                    rRidgeCount5-=1;
                    c5=createCard(imgCard5);
                }
                else if(p5.size()==1){
                    //make blank
                }
                else if(p5.size()>1){
                    c5= p5.get(p5.size()-2);
                    p5.remove(p5.size()-1);
                    wRidgeCount5-=1;
                }
            }
            else if(intClick==6){
                if(p6.size()==1&&rRidgeCount6>=1){
                    rRidgeCount6-=1;
                    c6=createCard(imgCard6);
                }
                else if(p6.size()==1){
                    //blanks
                }
                else if(p6.size()>1){
                    c6= p6.get(p6.size()-2);
                    p6.remove(p6.size()-1);
                    wRidgeCount6-=1;
                }
            }
               // c6=createCard(imgCard6);
            else if(intClick==7) {
                if(p7.size()==1 &&rRidgeCount7>=1){
                    rRidgeCount7-=1;
                    c7=createCard(imgCard7);
                }
                else if(p7.size()==1){
                    //blanks
                }
                else if(p7.size()>1){
                    c7=p7.get(p7.size()-2);
                    p7.remove(p7.size()-1);
                    wRidgeCount7-=1;
                }
            }
        }

    }

}
