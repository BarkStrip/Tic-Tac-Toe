import java.awt.*;
import javax.swing.*;

public class Main {
  public static void main(String[] args) {
    JFrame frame = new JFrame("Tic Tac Toe");
    frame.setResizable(false);
    JPanel panelContainer = new JPanel();

    CardLayout cardLayout = new CardLayout();
    

    Board board = new Board();
    TicTacToe ticTacToe = new TicTacToe(board, cardLayout, panelContainer);

    Menu menu = new Menu(cardLayout, panelContainer, ticTacToe, frame);
    Settings settings = new Settings(cardLayout, panelContainer, ticTacToe);
    javax.swing.SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        panelContainer.setLayout(cardLayout);

        panelContainer.add(menu.outerMenuScreen, "MENU");
        panelContainer.add(settings.settingsScreen, "SETTINGS");
        panelContainer.add(ticTacToe.ticTacToeScreen, "TICTACTOE");

        frame.add(panelContainer);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setSize(640, 480);
        frame.setResizable(false);
        frame.setVisible(true);
      }
    });
  }
}