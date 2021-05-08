import edu.princeton.cs.algs4.BinaryIn;
import edu.princeton.cs.algs4.BinaryOut;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

public class SymbolTableC implements SymbolTable {

    private Map<Integer, STValue> st;
    private int count;

    public SymbolTableC(FileReader inputFile) {
        this.st = new HashMap<Integer, STValue>();
        int c = 0;
        try {
            while (c != -1) {
                c = inputFile.read();
                if (c != -1) {
                    if (st.containsKey(c)) {
                        STValue stv = st.get(c);
                        int frequency = stv.getFrequency();
                        st.put(c, new STValueC(frequency + 1));
                    } else
                        st.put(c, new STValueC(1));
                }
            }
            inputFile.close();
        } catch (IOException e) {

        }
    }

    public int getCount() {
        return count;
    }

    public SymbolTableC(BinaryIn inputFile) {
        this.st = new HashMap<Integer, STValue>();
        int n = inputFile.readInt();
        for (int i = 0; i < n; i++) {
            char c = inputFile.readChar();
            int f = inputFile.readInt();
            count += f;
            this.st.put((int) c, new STValueC(f));
        }

    }


    public void writeFrequencyTable(BinaryOut outputFile) {
        outputFile.write(this.size(), 32);
        for (int i = 0; i < 128; i++) {
            if (st.containsKey(i)) {
                char key = (char) i;
                int freq = st.get(i).getFrequency();
                outputFile.write(key, 8);
                outputFile.write(freq, 32);
            }
        }

    }

    public Map<Integer, STValue> getMap() {
        return this.st;
    }

    public boolean containsKey(Object key) {
        return st.containsKey(key);
    }

    public STValue get(Integer key) {
        return st.get(key);
    }

    public boolean isEmpty() {
        return st.isEmpty();
    }

    public Object put(Integer key, STValue value) {
        return st.put(key, value);
    }

    public int size() {
        return st.size();
    }

    public SortedSet<Integer> keySet() {
        SortedSet<Integer> set = new TreeSet<>(st.keySet());
        return set;
    }


    public String toString() {
        return st.toString();
    }
}
