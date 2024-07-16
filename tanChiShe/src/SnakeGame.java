import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.LinkedList;
import java.util.Random;

public class SnakeGame extends JFrame {
    private static final int BOARD_SIZE = 800;
    private static final int CELL_SIZE = 40;
    private static final int NUM_CELLS = BOARD_SIZE / CELL_SIZE;

    private Snake snake;
    private Apple apple;
    private Timer timer;
    private Image bufferImage;
    private Graphics bufferGraphics;

    public SnakeGame() {
        snake = new Snake();
        apple = new Apple();
        timer = new Timer(100, new GameLoop());

        setTitle("贪吃蛇");
        setSize(BOARD_SIZE, BOARD_SIZE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                handleKeyPress(e);
            }
        });

        // Create double buffer
        bufferImage = createImage(BOARD_SIZE, BOARD_SIZE);
        bufferGraphics = bufferImage.getGraphics();

        timer.start();
    }

    private void handleKeyPress(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode == KeyEvent.VK_UP && snake.getDirection() != Direction.DOWN) {
            snake.setDirection(Direction.UP);
        } else if (keyCode == KeyEvent.VK_DOWN && snake.getDirection() != Direction.UP) {
            snake.setDirection(Direction.DOWN);
        } else if (keyCode == KeyEvent.VK_LEFT && snake.getDirection() != Direction.RIGHT) {
            snake.setDirection(Direction.LEFT);
        } else if (keyCode == KeyEvent.VK_RIGHT && snake.getDirection() != Direction.LEFT) {
            snake.setDirection(Direction.RIGHT);
        }
    }

    private class GameLoop implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            snake.move();
            if (snake.checkCollision()) {
                gameOver();
            }
            if (snake.getHead().equals(apple.getPosition())) {
                snake.grow();
                apple.generateNewPosition();
            }
            repaint();
        }
    }

    private void gameOver() {
        timer.stop();
        JOptionPane.showMessageDialog(this, "游戏结束");
        System.exit(0);
    }

    @Override
    public void paint(Graphics g) {
        bufferGraphics.clearRect(0, 0, BOARD_SIZE, BOARD_SIZE);
        drawGrid(bufferGraphics);
        snake.draw(bufferGraphics);
        apple.draw(bufferGraphics);
        g.drawImage(bufferImage, 0, 0, this);
    }

    private void drawGrid(Graphics g) {
        g.setColor(Color.GRAY);
        for (int i = 0; i < NUM_CELLS; i++) {
            g.drawLine(i * CELL_SIZE, 0, i * CELL_SIZE, BOARD_SIZE);
            g.drawLine(0, i * CELL_SIZE, BOARD_SIZE, i * CELL_SIZE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SnakeGame());
    }

    class Snake {
        private LinkedList<Point> body;
        private Direction direction;

        public Snake() {
            body = new LinkedList<>();
            int startX = NUM_CELLS / 2;
            int startY = NUM_CELLS / 2;
            body.add(new Point(startX, startY));
            body.add(new Point(startX - 1, startY));
            body.add(new Point(startX - 2, startY));
            direction = Direction.RIGHT;
        }

        public Direction getDirection() {
            return direction;
        }

        public void setDirection(Direction direction) {
            this.direction = direction;
        }

        public Point getHead() {
            return body.getFirst();
        }

        public void move() {
            Point newHead = new Point(getHead());
            switch (direction) {
                case UP:
                    newHead.y = (newHead.y - 1 + NUM_CELLS) % NUM_CELLS;
                    break;
                case DOWN:
                    newHead.y = (newHead.y + 1) % NUM_CELLS;
                    break;
                case LEFT:
                    newHead.x = (newHead.x - 1 + NUM_CELLS) % NUM_CELLS;
                    break;
                case RIGHT:
                    newHead.x = (newHead.x + 1) % NUM_CELLS;
                    break;
            }
            body.addFirst(newHead);
            if (body.size() > 1) {
                body.removeLast();
            }
        }

        public void grow() {
            Point newHead = new Point(getHead());
            switch (direction) {
                case UP:
                    newHead.y = (newHead.y - 1 + NUM_CELLS) % NUM_CELLS;
                    break;
                case DOWN:
                    newHead.y = (newHead.y + 1) % NUM_CELLS;
                    break;
                case LEFT:
                    newHead.x = (newHead.x - 1 + NUM_CELLS) % NUM_CELLS;
                    break;
                case RIGHT:
                    newHead.x = (newHead.x + 1) % NUM_CELLS;
                    break;
            }
            body.addFirst(newHead);
        }

        public boolean checkCollision() {
            Point head = getHead();
            for (int i = 1; i < body.size(); i++) {
                if (head.equals(body.get(i))) {
                    return true;  // Hit itself
                }
            }
            return false;
        }

        public void draw(Graphics g) {
            g.setColor(Color.GREEN);
            for (Point bodyPart : body) {
                int x = bodyPart.x * CELL_SIZE;
                int y = bodyPart.y * CELL_SIZE;
                g.fillRect(x, y, CELL_SIZE, CELL_SIZE);
            }
        }
    }

    class Apple {
        private Point position;
        private Random random;

        public Apple() {
            random = new Random();
            generateNewPosition();
        }

        public Point getPosition() {
            return position;
        }

        public void generateNewPosition() {
            int x = random.nextInt(NUM_CELLS);
            int y = random.nextInt(NUM_CELLS);
            position = new Point(x, y);
        }

        public void draw(Graphics g) {
            g.setColor(Color.RED);
            int x = position.x * CELL_SIZE;
            int y = position.y * CELL_SIZE;
            g.fillOval(x, y, CELL_SIZE, CELL_SIZE);
        }
    }

    enum Direction {
        UP,
        DOWN,
        LEFT,
        RIGHT
    }
}
