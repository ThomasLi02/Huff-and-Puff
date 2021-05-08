public interface Bits {
    int getBits();

    int getSize();

    java.lang.String toString();

    Bits addBit(int i);

    void write(edu.princeton.cs.algs4.BinaryOut binaryOut);
}
