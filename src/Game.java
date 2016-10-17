import java.util.Scanner;

class Block {
    private int value;

    public Block() {
        value = 0;
    }

    @Override
    public String toString() {
        return "" + value;
    }
}

class PlayGround {
    public static final int UP = 1;
    public static final int DOWN = 2;
    public static final int RIGHT = 3;
    public static final int LEFT = 4;

    private Block[][] blocks;

    public PlayGround(int width, int height) {
        blocks = new Block[width][height];

        for (int i = 0; i < blocks.length; i++) {
            for (int j = 0; j < blocks[i].length; j++) {
                blocks[i][j] = new Block();
            }
        }
    }

    public PlayGround() {
        this(4, 4);
    }

    public void move(int direction) {
        
    }

    public void print() {
        for (int i = 0; i < blocks.length; i++) {
            for (int j = 0; j < blocks[i].length; j++) {
                System.out.print(blocks[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public boolean gameFinished() {
        return false;
    }
}

public class Game {
    public static void main(String[] args) {
        String input;
        System.out.println("2048 game.");
        PlayGround playGround = new PlayGround();
        playGround.print();
        do {
            System.out.println("Please enter a direction: up, down, left, right");
            Scanner in = new Scanner(System.in);
            input = in.nextLine();
            if ("u".equalsIgnoreCase(input)) {
                playGround.move(PlayGround.UP);
                playGround.print();
            } else if ("d".equalsIgnoreCase(input)) {
                playGround.move(PlayGround.DOWN);
                playGround.print();
            } else if ("r".equalsIgnoreCase(input)) {
                playGround.move(PlayGround.RIGHT);
                playGround.print();
            } else if ("l".equalsIgnoreCase(input)) {
                playGround.move(PlayGround.LEFT);
                playGround.print();
            } else if ("reset".equalsIgnoreCase(input)) {
                System.out.println("Game reset!");
//                playGround.reset();
//                playGround.print();
            } else {
                System.out.println("Input not recognized");
            }
        } while (!playGround.gameFinished());
    }
}

