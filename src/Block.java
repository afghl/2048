import java.util.Random;

public class Block {
    private int value;

    public Block() {
        this.value = 0;
    }

    public boolean born() {
        if (value != 0) return false;
        value = new Random().nextInt(2) * 2 + 2;
        return true;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void swapValue(Block other) {
        int t;
        t = this.value;
        setValue(other.value);
        other.setValue(t);
    }

    public boolean sameValue(Block other) {
        return value == other.getValue();
    }

    public void mergeValue(Block other) {
        if (!sameValue(other)) return;

        value = value * 2;
        other.setValue(0);
    }

    @Override
    public String toString() {
        return "" + value;
    }
}