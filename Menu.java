import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Menu {
  JPanel menuScreen = new JPanel();
  
  JButton newButton = new JButton("New Game");
  JButton continueButton = new JButton("Continue Game");
  JButton settingsButton = new JButton("Settings");
  JButton exitButton = new JButton("Exit");
  
  GridLayout gridLayout = new GridLayout(4, 1);
  BorderLayout borderLayout = new BorderLayout();
  JPanel outerMenuScreen = new JPanel();
  JLabel title = new JLabel();

  public Menu(CardLayout cardLayout, JPanel panelContainer, TicTacToe ticTacToe, JFrame frame) {
    outerMenuScreen.setLayout(borderLayout);
    menuScreen.setLayout(gridLayout);

    title.setBackground(new Color(100, 200, 250));
    title.setOpaque(true);
    title.setText("Main Menu");
    title.setFont(new Font("Menlo", Font.BOLD, 90));
    title.setHorizontalAlignment(JLabel.CENTER);

    outerMenuScreen.add(title, BorderLayout.NORTH);
    outerMenuScreen.add(menuScreen);

    menuScreen.add(newButton);
    menuScreen.add(continueButton);
    menuScreen.add(settingsButton);
    menuScreen.add(exitButton);

    newButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent arg0) {
        cardLayout.show(panelContainer, "TICTACTOE");
        ticTacToe.board.refresh();
        ticTacToe.draw();
      }
    });

    continueButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent arg0) {
        if (ticTacToe.board.gameOver() == false && ticTacToe.board.getMoves() >= 1) {
          cardLayout.show(panelContainer, "TICTACTOE");
        } else {
          JOptionPane.showMessageDialog(null, "There are no games in progress.");
        }
        
      }
    });

    settingsButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent arg0) {
        cardLayout.show(panelContainer, "SETTINGS");
      }
    });

    exitButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent arg0) {
        frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
      }
    });
  }
}