import edu.princeton.cs.algs4.BinaryIn;

import java.io.FileWriter;
import java.io.IOException;

public class Puff {
    private java.lang.String[] args;

    public Puff(java.lang.String[] strings) {
        this.args = strings;
    }

    private void go() {
        FileIO file = new FileIOC(this.args);
        BinaryIn input = file.openBinaryInputFile(this.args[0]);
        if (input.readInt(16) != 0x0bc0) {
            System.out.println("error: wrong file");
        } else {
            FileWriter output = file.openOutputFile();
            SymbolTableC table = new SymbolTableC(input);
            HuffmanTree hct = new HuffmanTreeC(table);
            HuffmanTree top = new HuffmanTreeC(table);
            try {
                int count = table.getCount(); // number of characters total
                int bit = input.readInt(1);
                while (count != 0) {
                    while (!top.isLeaf()) {
                        if (bit == 0) top = top.getLeft();
                        if (bit == 1) top = top.getRight();
                        bit = input.readInt(1);
                    }
                    System.out.print(top.getSymbol());
                    output.write(top.getSymbol());
                    count--;
                    top = hct;
                }
                output.close();
            } catch (IOException e) {


            }


        }

    }

    public static void main(java.lang.String[] strings) {
        Puff runner = new Puff(strings);
        runner.go();
    }
}
