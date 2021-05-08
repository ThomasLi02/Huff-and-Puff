import edu.princeton.cs.algs4.BinaryOut;

import java.io.FileReader;
import java.io.IOException;

public class Huff {

    public static final int MAGIC_NUMBER = 0x0bc0;
    private final String[] args;

    public Huff(String[] args) {
        this.args = args;
    }

    private void go() {
        SymbolTable table;

        FileIO file = new FileIOC(this.args);
        FileReader input = file.openInputFile(this.args[0]);

        table = new SymbolTableC(input);

        HuffmanTree tree = new HuffmanTreeC(table);

        BitsC startingBit = new BitsC(0, 0);
        tree.computeBitCodes(table, startingBit);

        BinaryOut output = file.openBinaryOutputFile();

        output.write(MAGIC_NUMBER, 16);

        table.writeFrequencyTable(output);

        input = file.openInputFile(this.args[0]);
        try {
            int character = input.read();
            while (character != -1) {
                STValue val = table.get(character);
                Bits bits = val.getBits();
                bits.write(output);
                character = input.read();
            }
            input.close();
        } catch (IOException e) {


        }
        output.flush();
        output.close();
    }

    public static void main(String[] args) {
        Huff runner = new Huff(args);
        runner.go();
    }

}
