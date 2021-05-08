import edu.princeton.cs.algs4.BinaryOut;

public class BitsC implements Bits {

    private int bits;
    private int count;


    public BitsC(int i, int i1) {
        this.bits = i;
        this.count = i1;
    }

    public int getBits() {
        return bits;
    }

    public int getSize() {
        return count;
    }

    public Bits addBit(int bit) {
        int x = this.getBits() * 2 + bit;
        return new BitsC(x, this.getSize() + 1);
    }

    public void write(BinaryOut outFile) {
        outFile.write(this.getBits(), this.getSize());
    }

    public String toString() {
        String str = "";
        int bC = this.bits;
        for (int i = 0; i < this.count; i++) {
            if (bC % 2 == 0) {
                str = str + "0";
            } else {
                str = str + "1";
            }
            bC = bC / 2;
        }
        // reverse the string
        String bitString = "";
        for (int j = str.length() - 1; j >= 0; j--) {
            bitString = bitString + str.charAt(j);
        }
        return bitString;

    }
}


