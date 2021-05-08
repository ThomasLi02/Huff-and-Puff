public interface HuffmanTree extends java.lang.Comparable<HuffmanTree> {
    int getWeight();

    char getSymbol();

    HuffmanTree getLeft();

    HuffmanTree getRight();

    boolean isLeaf();


    void computeBitCodes(SymbolTable symbolTable, Bits bits);

    java.lang.String toString();
}
