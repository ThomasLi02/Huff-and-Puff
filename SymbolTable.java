import java.util.Map;

public interface SymbolTable {
    java.lang.Object put(java.lang.Integer integer, STValue stValue);

    STValue get(java.lang.Integer integer);

    boolean containsKey(java.lang.Object o);

    Map<Integer, STValue> getMap();

    int size();

    boolean isEmpty();

    int getCount();

    java.util.SortedSet<java.lang.Integer> keySet();

    void writeFrequencyTable(edu.princeton.cs.algs4.BinaryOut binaryOut);

    java.lang.String toString();
}
