import java.util.PriorityQueue;
import java.util.TreeMap;

public class HuffmanTreeC implements HuffmanTree {
    private int weight;
    private char symbol;
    private HuffmanTree left;
    private HuffmanTree right;

    public int getWeight() {
        return this.weight;
    }

    public char getSymbol() {
        return this.symbol;
    }

    public HuffmanTree getLeft() {
        return this.left;
    }

    public HuffmanTree getRight() {
        return this.right;
    }

    public boolean isLeaf() {
        return this.symbol != '*';
    }

    public HuffmanTreeC(char symbol, int frequency) {
        this.weight = frequency;
        this.symbol = symbol;
        this.left = null;
        this.right = null;
    }

    public HuffmanTreeC(int weight, HuffmanTree left, HuffmanTree right) {
        this.weight = weight;
        this.symbol = '*';
        this.left = left;
        this.right = right;
    }


    //https://www.baeldung.com/java-hashmap-sort --> for sorting HashMap using TreeMap reference
    public HuffmanTreeC(SymbolTable symbolTable) {
        TreeMap<Integer, STValue> sorted = new TreeMap<>();
        sorted.putAll(symbolTable.getMap());
        PriorityQueue<HuffmanTreeC> huffTree = new PriorityQueue<HuffmanTreeC>();
        sorted.forEach((key, val) -> {
            char symbol = (char) ((int) key);
            int frequency = val.getFrequency();
            HuffmanTreeC node = new HuffmanTreeC(symbol, frequency);
            huffTree.add(node);

        });
        while (huffTree.size() > 1) {
            HuffmanTree t1 = huffTree.poll();
            HuffmanTree t2 = huffTree.poll();
            huffTree.add(new HuffmanTreeC(t1.getWeight() + t2.getWeight(), t1, t2));
        }
        //initializing instance variables
        HuffmanTree finalTree = huffTree.poll();
        this.weight = finalTree.getWeight();
        this.symbol = finalTree.getSymbol();
        this.left = finalTree.getLeft();
        this.right = finalTree.getRight();
    }

    public void computeBitCodes(SymbolTable symbolTable, Bits bits) {
        if (!this.isLeaf()) {
            this.left.computeBitCodes(symbolTable, bits.addBit(0));
            this.right.computeBitCodes(symbolTable, bits.addBit(1));
        } else {
            Integer key = (int) this.symbol;
            STValue val = symbolTable.get(key);
            val.setBits(bits);
        }
    }

    public String toString() {
        if (this.isLeaf())
            return this.getSymbol() + "" + this.getWeight();
        return this.weight + "(" + this.left.toString() + ", " + this.right.toString() + ")";
    }


    public int compareTo(HuffmanTree other) {
        if (this.getWeight() < other.getWeight()) {
            return -1;
        } else {
            return 1;
        }
    }
}
