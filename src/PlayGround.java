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
        }
    }

    private void moveLeft() {
        for (int i = 0; i < blocks.length; i++) {
            for(int j = 0; j < blocks[i].length; j++) {
                if (blocks[i][j].getValue() == 0) continue;
                // 找到非空的block，移动或合并。
                for (int k = 0; k < j; k++) {
                    if (blocks[i][k].getValue() == 0) {
                        blocks[i][k].swapValue(blocks[i][j]);
                        break;
                    } else if (blocks[i][k].sameValue(blocks[i][j])) {
                        blocks[i][k].mergeValue(blocks[i][j]);
                        break;
                    }
                }
            }
        }
    }

    private void moveRight() {
        for (int i = blocks.length - 1; i >= 0; i--) {
            for(int j = blocks[i].length - 1; j >= 0; j--) {
                if (blocks[i][j].getValue() == 0) continue;
                // 找到非空的block，移动或合并。
                for (int k = blocks.length - 1; k > j; k--) {
                    if (blocks[i][k].getValue() == 0) {
                        blocks[i][k].swapValue(blocks[i][j]);
                        break;
                    } else if (blocks[i][k].sameValue(blocks[i][j])) {
                        blocks[i][k].mergeValue(blocks[i][j]);
                        break;
                    }
                }
            }
        }
    }

    private void moveUp() {
        for (int i = 0; i < blocks.length; i++) {
            for (int j = 0; j < blocks[i].length; j++) {
                if (blocks[j][i].getValue() == 0) continue;
                // 找到非空的block，移动或合并。
                for (int k = 0; k < j; k++) {
                    if (blocks[k][i].getValue() == 0) {
                        blocks[k][i].swapValue(blocks[j][i]);
                        break;
                    } else if (blocks[k][i].sameValue(blocks[j][i])) {
                        blocks[k][i].mergeValue(blocks[j][i]);
                        break;
                    }
                }
            }
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

    public boolean gameFinished() {
        return false;
    }
}