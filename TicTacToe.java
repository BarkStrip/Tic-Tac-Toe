import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.concurrent.ThreadLocalRandom;

public class TicTacToe implements ActionListener {
  int turnCounter = 0;
  Board board;
  JPanel ticTacToeScreen = new JPanel();

  boolean playAgainstComputer = false;

  JPanel buttonPanel = new JPanel();
  JButton[] button = new JButton[9];
  JPanel titlePanel = new JPanel();
  JLabel title = new JLabel();
  JPanel menuPanel = new JPanel();
  JButton mainMenuButton = new JButton("Main Menu");
  JButton restartButton = new JButton("Restart Game");

  String player1 = "X";
  String player2 = "O";



  TicTacToe(Board board, CardLayout cardLayout, JPanel panelContainer) {
    this.board = board;

    titlePanel.setLayout(new GridLayout(1,2));
    titlePanel.setBounds(0, 0, 650, 75);
    titlePanel.setBackground(new Color(100, 200, 250));

    title.setText(board.getMoves() % 2 == 0 ? player1 + "'s Turn" : player2 + "'s Turn");
    title.setFont(new Font("Menlo", Font.BOLD, 45));
    title.setHorizontalAlignment(JLabel.CENTER);
    
    buttonPanel.setLayout(new GridLayout(3, 3));
    buttonPanel.setBackground(new Color(120, 200, 250));

    for (int i = 0 ; i < 9 ; i++) {
      button[i] = new JButton();
      buttonPanel.add(button[i]);
      button[i].setFont(new Font("Menlo",Font.BOLD,120));
      button[i].setFocusable(false);
      button[i].addActionListener(this);
    }

    titlePanel.add(title);
    menuPanel.setLayout(new GridLayout(1,2));
    menuPanel.add(mainMenuButton);
    menuPanel.add(restartButton);

    mainMenuButton.setPreferredSize(new Dimension(640, 32));
    ticTacToeScreen = new JPanel(new BorderLayout());
    ticTacToeScreen.add(titlePanel, BorderLayout.NORTH);
    ticTacToeScreen.add(buttonPanel, BorderLayout.CENTER);
    ticTacToeScreen.add(menuPanel, BorderLayout.SOUTH);

    mainMenuButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent arg0) {
        cardLayout.show(panelContainer, "MENU");
      }
    });

    restartButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent arg0) {
        board.refresh();
        draw();
      }
    });
    
    draw();
  }

  public void draw() {
    int i = 0, j = 0, k = 0;
    String player = "";

    title.setText(board.getMoves() % 2 == 0 ? player1 + "'s Turn" : player2 + "'s Turn");

    if (board.gameOver()) {
      //System.out.println("Game Over!");
      if (board.getWinner() == 1) {
        //System.out.println("The Winner is X!");
        title.setText(player1 + " Wins!");
      } else if (board.getWinner() == 2) {
        //System.out.println("The Winner is O!");
        title.setText(player2 + " Wins!");
      } else {
        //System.out.println("Its a Tie!");
        title.setText("Tie!");
      }
    }

    //board.print();

    while (i < 9) {
      if (board.getBoard()[j][k] == 1) {
        player = "X";
      } else if (board.getBoard()[j][k] == 2) {
        player = "O";
      } else {
        player = "";
      }

      button[i].setText(player);

      i++;
      j = i / 3;
      k = i-((i/3)*3);
    }
  }

  public void actionPerformed(ActionEvent e) {
    for (int i = 0; i < 9; i++) {
      if (e.getSource() == button[i] && board.getBoard()[i/3][i-((i/3)*3)] == 0 && board.gameOver() == false) {
        board.update(i/3, i-((i/3)*3));
        
        //Play against the computer
        if (board.gameOver() == false && playAgainstComputer == true) {
          int c = ThreadLocalRandom.current().nextInt(0, 3);
          int r = ThreadLocalRandom.current().nextInt(0, 3);

          while (board.getBoard()[c][r] != 0 && board.getMoves() != 9) {
            c = ThreadLocalRandom.current().nextInt(0, 3);
            r = ThreadLocalRandom.current().nextInt(0, 3);
          }
          board.update(c, r);
        }
        

        
        //System.out.println(board.getMoves());
      }
    }
  
    draw();
  }
}