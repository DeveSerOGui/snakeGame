import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;

public class SnakeGame extends JPanel implements ActionListener, KeyListener{

    private class Tile{
        int x;
        int y;

        Tile(int x, int y){
            this.x = x;
            this.y =y;
        }
    }

    int larguraBorda;
    int alturaBorda;
    int tileSize = 25;

    //Snake
    Tile snakeHead;
    ArrayList<Tile> snakeBody;

    //Food
    Tile food;
    Random random;

    //Logica
    Timer gameLoop;
    int velocidadeX;
    int velocidadeY;

    SnakeGame(int larguraBorda, int alturaBorda){
        this.larguraBorda = larguraBorda;
        this.alturaBorda = alturaBorda;
        setPreferredSize(new Dimension(larguraBorda, alturaBorda));
        setBackground(Color.black);
        addKeyListener(this);
        setFocusable(true);

        snakeHead = new Tile(5,5);
        snakeBody = new ArrayList<Tile>();

        food = new Tile(10,10);
        random = new Random();
        placeFood();

        velocidadeX = 0;
        velocidadeY = 1;

        gameLoop = new Timer(100, this);
        gameLoop.start();
    }

    public void colorirComponente(Graphics g){
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g){
        //Linha
        for (int i = 0; i < larguraBorda/tileSize; i++){
            g.drawLine(i * tileSize, 0, i*tileSize, alturaBorda);
            g.drawLine(0, i * tileSize, larguraBorda, i * tileSize);
        }
        //Food
        g.setColor(Color.red);
        g.fillRect(food.x * tileSize, food.y * tileSize, tileSize, tileSize);

        //Snake Head
        g.setColor(Color.green);
        g.fillRect(snakeHead.x * tileSize, snakeHead.y * tileSize, tileSize, tileSize);

        //Snake Body
        for(int i = 0; i < snakeBody.size(); i++){
            Tile snakePart = snakeBody.get(i);
            g.fillRect(snakePart.x * tileSize, snakePart.y * tileSize, tileSize, tileSize );
        }
    }

    public void placeFood(){
        food.x = random.nextInt(larguraBorda/tileSize);
        food.y = random.nextInt(alturaBorda/tileSize);
    }

    public boolean coisao(Tile tile1, Tile tile2){
        return  tile1.x == tile2.x && tile1.y == tile2.y;
    }

    public void move(){

        if(coisao(snakeHead, food)){
            snakeBody.add(new Tile(food.x, food.y));
            placeFood();
        }
        snakeHead.x += velocidadeX;
        snakeHead.y += velocidadeY;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        move();
        repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP && velocidadeY != 1){
            velocidadeY = -1;
            velocidadeX = 0;
        }
        else if(e.getKeyCode() == KeyEvent.VK_DOWN && velocidadeY != -1){
            velocidadeY = 1;
            velocidadeX = 0;
        }
        else if(e.getKeyCode() == KeyEvent.VK_LEFT && velocidadeX != 1){
            velocidadeY = 0;
            velocidadeX = -1;
        }
        else if(e.getKeyCode() == KeyEvent.VK_RIGHT && velocidadeX != -1){
            velocidadeY = 0;
            velocidadeX = 1;
        }
    }

    //Não será necessário
    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {}
}
