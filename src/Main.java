import javax.swing.*;

public class Main {
    public static void main(String[] args) throws Exception {
        int tamanhoLargura = 600;
        int tamanhoAltura = tamanhoLargura;

        JFrame frame = new JFrame("SnakeGame");
        frame.setVisible(true);
        frame.setSize(tamanhoLargura, tamanhoAltura);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        SnakeGame snakeGame = new SnakeGame(tamanhoLargura, tamanhoAltura);
        frame.add(snakeGame);
        frame.pack();
        snakeGame.requestFocus();
    }
}