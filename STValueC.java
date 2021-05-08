public class STValueC implements STValue {


    private int frequency;
    private Bits bits;

    public STValueC(int frequency, Bits bits) {
        this.frequency = frequency;
        this.bits = bits;
    }

    public STValueC(int frequency) {
        this.frequency = frequency;
        this.bits = null;
    }

    public Bits getBits() {
        return this.bits;
    }

    public int getFrequency() {
        return this.frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public void setBits(Bits bits) {
        this.bits = bits;
    }

    public String toString() {
        if (bits == null) {
            return "frequency: " + this.getFrequency() + " -- bits: no bit string";
        }
        return "frequency: " + this.getFrequency() + " -- bits: " + bits.toString();

    }
}
