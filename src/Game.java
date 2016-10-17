import java.util.Random;
import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        String input;
        int direction;
        System.out.println("2048 game.");
        PlayGround playGround = new PlayGround();
        playGround.generate();
        playGround.print();
        do {
            System.out.println("Please enter a direction: u, d, l, r");
            Scanner in = new Scanner(System.in);
            input = in.nextLine();
            if ("u".equalsIgnoreCase(input)) {
                direction = PlayGround.UP;
            } else if ("d".equalsIgnoreCase(input)) {
                direction = PlayGround.DOWN;
            } else if ("r".equalsIgnoreCase(input)) {
                direction = PlayGround.RIGHT;
            } else if ("l".equalsIgnoreCase(input)) {
                direction = PlayGround.LEFT;
            } else {
                direction = -1;
                System.out.println("Input not recognized");
            }
            if (direction > -1) {
                playGround.move(direction);
                playGround.generate();
                playGround.print();
            }
        } while (!playGround.gameFinished());
    }
}

