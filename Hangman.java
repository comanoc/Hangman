import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JOptionPane;

import javax.swing.JPanel;
import java.util.ArrayList;
import java.util.Random;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Hangman extends JFrame implements ActionListener{
  JTextField wordDisplay, guessDisplay; // Displays at top
  JButton a, b, c, d, e, f, g, h, i, j, k, l, m, n; // letters
  JButton o, p, q, r, s, t, u, v, w, x, y, z;
  ArrayList<JButton> letterArray = new ArrayList<JButton>();
  Random rand = new Random();

  JButton start, answer;
  int guessesLeft; // Variable to keep tack of guesses
  final int noGuesses = 8; // Constant for number of guesses allowed
  String word; // The word we are trying to guess
  String guessedWord;
  boolean inPlay = false;
  boolean gameOver = false;


  String file_name = "words.txt"; // Dictionary file
  FileLoad dict = new FileLoad(file_name); // class made for loading file
  ArrayList<String> words = dict.load(); // method in class for putting words in array ArrayList

  public Hangman(){
    JPanel letters = new JPanel(new GridLayout(4,7,0,0));
    // Panel for button at buttom half of screen
    a = new JButton("A");
    a.addActionListener(this);
    a.setActionCommand("a");
    letters.add(a);
    letterArray.add(a);

    b = new JButton("B");
    b.addActionListener(this);
    letters.add(b);
    letterArray.add(b);
    b.setActionCommand("b");

    c = new JButton("C");
    c.addActionListener(this);
    letters.add(c);
    letterArray.add(c);
    c.setActionCommand("c");

    d = new JButton("D");
    d.addActionListener(this);
    letters.add(d);
    letterArray.add(d);
    d.setActionCommand("d");

    e = new JButton("E");
    e.addActionListener(this);
    letters.add(e);
    letterArray.add(e);
    e.setActionCommand("e");

    f = new JButton("F");
    f.addActionListener(this);
    letters.add(f);
    letterArray.add(f);
    f.setActionCommand("f");

    g = new JButton("G");
    g.addActionListener(this);
    letters.add(g);
    letterArray.add(g);
    g.setActionCommand("g");

    h = new JButton("H");
    h.addActionListener(this);
    letters.add(h);
    letterArray.add(h);
    h.setActionCommand("h");

    i = new JButton("I");
    i.addActionListener(this);
    letters.add(i);
    letterArray.add(i);
    i.setActionCommand("i");

    j = new JButton("J");
    j.addActionListener(this);
    letters.add(j);
    letterArray.add(j);
    j.setActionCommand("j");

    k = new JButton("K");
    k.addActionListener(this);
    letters.add(k);
    letterArray.add(k);
    k.setActionCommand("k");

    l = new JButton("L");
    l.addActionListener(this);
    letters.add(l);
    letterArray.add(l);
    l.setActionCommand("l");

    m = new JButton("M");
    m.addActionListener(this);
    letters.add(m);
    letterArray.add(m);
    m.setActionCommand("m");

    n = new JButton("N");
    n.addActionListener(this);
    letters.add(n);
    letterArray.add(n);
    n.setActionCommand("n");

    o = new JButton("O");
    o.addActionListener(this);
    letters.add(o);
    letterArray.add(o);
    o.setActionCommand("o");

    p = new JButton("P");
    p.addActionListener(this);
    letters.add(p);
    letterArray.add(p);
    p.setActionCommand("p");

    q = new JButton("Q");
    q.addActionListener(this);
    letters.add(q);
    letterArray.add(q);
    q.setActionCommand("q");

    r = new JButton("R");
    r.addActionListener(this);
    letters.add(r);
    letterArray.add(r);
    r.setActionCommand("r");

    s = new JButton("S");
    s.addActionListener(this);
    letters.add(s);
    letterArray.add(s);
    s.setActionCommand("s");

    t = new JButton("T");
    t.addActionListener(this);
    letters.add(t);
    letterArray.add(t);
    t.setActionCommand("t");

    u = new JButton("U");
    u.addActionListener(this);
    letters.add(u);
    letterArray.add(u);
    u.setActionCommand("u");

    v = new JButton("V");
    v.addActionListener(this);
    letters.add(v);
    letterArray.add(v);
    v.setActionCommand("v");

    w = new JButton("W");
    w.addActionListener(this);
    letters.add(w);
    letterArray.add(w);
    w.setActionCommand("w");

    x = new JButton("X");
    x.addActionListener(this);
    letters.add(x);
    letterArray.add(x);
    x.setActionCommand("x");

    y = new JButton("Y");
    y.addActionListener(this);
    letters.add(y);
    letterArray.add(y);
    y.setActionCommand("y");

    z = new JButton("Z");
    z.addActionListener(this);
    letters.add(z);
    letterArray.add(z);
    z.setActionCommand("z");

    start = new JButton("Start");
    start.addActionListener(this);
    letters.add(start);
    answer = new JButton("Answer");
    answer.addActionListener(this);
    letters.add(answer);

    JPanel guesses = new JPanel(new GridLayout(1, 2, 5, 5));

    guesses.add(new JLabel("Guesses Remaining"));
    guessDisplay = new JTextField(1);
    guesses.add(guessDisplay);

    JPanel topLeft = new JPanel(); //blank panels to center other ones
    JPanel topRight = new JPanel();
    JPanel topMid = new JPanel(new GridLayout(3,1,5,5));

    topMid.add(guesses);
    topMid.add(new JLabel("Word to Guess"));
    wordDisplay = new JTextField(20);
    topMid.add(wordDisplay);

    JPanel top = new JPanel(new GridLayout(1,3,5,5));
    top.add(topLeft);
    top.add(topMid);
    top.add(topRight);

    JPanel panelParent = new JPanel(new GridLayout(2,1,5,5));
    // combine top and bottom half
    panelParent.add(top);
    panelParent.add(letters);

    add(panelParent);
  }
  public static void main(String[] args){

    Hangman frame = new Hangman();

    //Create the frame
    frame.setTitle("Hangman");
    frame.setSize(800, 360);
    frame.setLocationRelativeTo(null);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);


  }
  public void actionPerformed(ActionEvent e){

    if(e.getSource() == start){

      // Getting random word from list of words
      int randPos = rand.nextInt(words.size());

      //Making sure its lowercase
      word = words.get(randPos).toLowerCase();
      wordDisplay.setText("");

      // Setting up the number of Guesses
      guessesLeft = noGuesses;
      guessDisplay.setText(Integer.toString(guessesLeft));

      //Get word length so not checking each time in loop
      int wordLen = word.length();

      //Mask the the word and display it
      for(int i = 0; i < wordLen; i++){
        wordDisplay.setText(wordDisplay.getText() + "*");
      }
      //Variable to store masked word
      guessedWord = wordDisplay.getText();

      // Game is now in play
      inPlay = true;
      gameOver = false;

    }else if((e.getSource() == answer) && (inPlay || gameOver)){
      // Even when game is lost player can click answer to see Answer
      // Won't work until first game has been started
      inPlay = false;
      guessesLeft = 0;
      guessDisplay.setText(Integer.toString(guessesLeft));
      wordDisplay.setText(word);

    }else if(inPlay){
      // Will only check what letter is pressed if game is in play
      if(letterArray.contains(e.getSource())){
        // Check that a letter was pressed and get that letter
        String letterGuessed = e.getActionCommand();

        //Check if letter in word
        int index = word.indexOf(letterGuessed);

        //If letter not in word index = -1
        if(index >= 0)
        {
          do{
            //Update guessed word
            guessedWord = guessedWord.substring(0,index) + letterGuessed
                          + guessedWord.substring(index + 1);
            index = word.indexOf(letterGuessed, index + 1);
            // Keeps going until no more of that letter ie index = -1
          }while(index >= 0);

          //Change display
          wordDisplay.setText(guessedWord);

          //Check if word has been spelled out
          if(guessedWord.equals(word)){
            inPlay = false;
            gameOver = false;
            // Player has won
            JOptionPane.showMessageDialog(null, "You Won!!!!", "Hangman",
                                          JOptionPane.INFORMATION_MESSAGE);
          }
        }else{
          // letter not in word
          guessesLeft--;
          if(guessesLeft < 0){
            // Player has no more guesses so has lost
            inPlay = false;
            gameOver = true;
            JOptionPane.showMessageDialog(null, "You Lose", "Hangman",
                                          JOptionPane.INFORMATION_MESSAGE);
          }else{
            //Update display
            guessDisplay.setText(Integer.toString(guessesLeft));
          }
        }
      }
    }
  }
}
