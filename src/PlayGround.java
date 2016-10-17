import java.util.Random;


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

    public void generate() {
        Block b;
        do {
            b = getBlock();
        } while (!b.born());
    }

    private Block getBlock() {
        Random r = new Random();
        return blocks[r.nextInt(blocks.length)][r.nextInt(blocks.length)];
    }

    public void move(int direction) {
        if (direction == LEFT) {
            moveLeft();
        } else if (direction == RIGHT) {
            moveRight();
        } else if (direction == UP) {
            moveUp();
        } else if (direction == DOWN) {
            moveDown();
        }
    }

    private void moveLeft() {
        for (int i = 0; i < blocks.length; i++)
            solveRow(blocks[i]);
    }

    private void moveRight() {
        for (int i = blocks.length - 1; i >= 0; i--)
            reverseSolveRow(blocks[i]);
    }

    private void moveUp() {
        Block[] arr = new Block[blocks.length];

        for (int i = 0; i < blocks.length; i++) {
            for (int j = 0; j < blocks[i].length; j++) {
                arr[j] = blocks[j][i];
            }
            solveRow(arr);
        }
    }

    private void moveDown() {
        Block[] arr = new Block[blocks.length];

        for (int i = 0; i < blocks.length; i++) {
            for (int j = 0; j < blocks[i].length; j++) {
                arr[j] = blocks[j][i];
            }
            reverseSolveRow(arr);
        }
    }

    public void print() {
        for (int i = 0; i < blocks.length; i++) {
            for (int j = 0; j < blocks[i].length; j++) {
                System.out.print(blocks[i][j] + " ");
            }
            System.out.println("");
        }
    }

    private void solveRow(Block[] bs) {
        for (int i = 0; i < bs.length; i++) {
            for (int k = 0; k < i; k++) {
                if (bs[k].getValue() == 0) {
                    bs[k].swapValue(bs[i]);
                    break;
                } else if (bs[k].sameValue(bs[i])) {
                    bs[k].mergeValue(bs[i]);
                    break;
                }
            }
        }
    }

    private void reverseSolveRow(Block[] bs) {
        for (int i = bs.length - 1; i >= 0; i--) {
            for (int k = bs.length - 1; k > i; k--) {
                if (bs[k].getValue() == 0) {
                    bs[k].swapValue(bs[i]);
                    break;
                } else if (bs[k].sameValue(bs[i])) {
                    bs[k].mergeValue(bs[i]);
                    break;
                }
            }
        }
    }

    public boolean gameFinished() {
        return false;
    }
}