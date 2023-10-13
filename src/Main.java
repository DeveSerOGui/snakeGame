import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        int tamanhoLargura = 600;
        int tamanhoAltura = 600;

        JFrame frame = new JFrame("SnakeGame");
        frame.setVisible(true);
        frame.setSize(tamanhoLargura, tamanhoAltura);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}