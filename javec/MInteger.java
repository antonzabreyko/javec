package javec;

public class MInteger implements Info<Integer> {

    private int value;

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
}
