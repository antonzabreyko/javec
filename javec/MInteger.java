package javec;

/** Implementation of Info interface for Integers. Value is the stored integer, and addition, multiplication,
 * and division follow from Integer behavior.
 * */
public class MInteger implements Info<Integer> {

    /** Stores the value of the int. */
    private int value;

    /** Default constructor representing a value of 0. */
    public MInteger() {
        this.value = 0;
    }

    /** Constructor for the MInteger class. Takes in the integer it represents. */
    public MInteger(int value) {
        this.value = value;
    }

    @Override
    public Integer get() {
        return value;
    }

    @Override
    public Info<Integer> add(Info<Integer> a) {
        try {
            MInteger other = (MInteger)a;
            return new MInteger(this.value + other.value);
        }
        catch (ClassCastException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Info<Integer> mul(Info<Integer> a) {
        try {
            MInteger other = (MInteger)a;
            return new MInteger(this.value * other.value);
        }
        catch (ClassCastException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public String toString() {
        return this.value+"";
    }

    @Override
    public double doubleDiv(Info<Integer> a) {
        try {
            MInteger other = (MInteger)a;
            return this.value/a.get();
        }
        catch (ClassCastException e) {
            System.out.println(e.getMessage());
            return -1;
        }
    }

    @Override
    public MInteger div(Info<Integer> a) {
        return new MInteger((int)doubleDiv(a));
    }
}
