import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Settings {
  JPanel settingsScreen = new JPanel();
  JPanel playerXPanel = new JPanel();
  JPanel playerOPanel = new JPanel();
  BorderLayout borderLayout = new BorderLayout();
  GridLayout gridLayout = new GridLayout(3, 1);

  JPanel optionsPanel = new JPanel();

  JButton okButton = new JButton("OK");

  JLabel playerXLabel = new JLabel();
  JTextField playerXTextField = new JTextField("X");

  JLabel playerOLabel = new JLabel();
  JTextField playerOTextField = new JTextField("O");

  JCheckBox playAgainstComputerCheckBox = new JCheckBox("Play against the Computer?");
  
  public Settings(CardLayout cardLayout, JPanel panelContainer, TicTacToe ticTacToe) {
    settingsScreen.setLayout(new BorderLayout());

    optionsPanel.setLayout(gridLayout);


    playerXPanel.setLayout(borderLayout);
    playerXPanel.add(playerXLabel, BorderLayout.WEST);
    playerXPanel.add(playerXTextField, BorderLayout.CENTER);

    playerOPanel.setLayout(new BorderLayout());
    playerOPanel.add(playerOLabel, BorderLayout.WEST);
    playerOPanel.add(playerOTextField, BorderLayout.CENTER);

    optionsPanel.add(playerXPanel);
    optionsPanel.add(playerOPanel);
    optionsPanel.add(playAgainstComputerCheckBox);

    settingsScreen.add(optionsPanel, BorderLayout.NORTH);
    settingsScreen.add(okButton, BorderLayout.SOUTH);

    playerXLabel.setText("Change Player 1 (X) Name: ");
    playerXLabel.setFont(new Font("Menlo", Font.BOLD, 20));
    playerXTextField.setFont(new Font("Menlo", Font.BOLD, 20));

    playerOLabel.setText("Change Player 2 (O) Name: ");
    playerOLabel.setFont(new Font("Menlo", Font.BOLD, 20));
    playerOTextField.setFont(new Font("Menlo", Font.BOLD, 20));

    playAgainstComputerCheckBox.setFont(new Font("Menlo", Font.BOLD, 20));

    okButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent arg0) {
        if (playerXTextField.getText().isEmpty() || playerOTextField.getText().isEmpty() ||playerXTextField.getText().equals(playerOTextField.getText())) {
          JOptionPane.showMessageDialog(null, "Usernames cannot be empty or the same.");
        } else {
          cardLayout.show(panelContainer, "MENU");
        }
        
        ticTacToe.player1 = playerXTextField.getText();
        ticTacToe.player2 = playerOTextField.getText();
        ticTacToe.playAgainstComputer = playAgainstComputerCheckBox.isSelected();
        if (ticTacToe.playAgainstComputer == true) {
          ticTacToe.board.refresh();
          ticTacToe.draw();
        }
        ticTacToe.draw();
      }
    });
  }
}