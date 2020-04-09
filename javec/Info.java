package javec;

/**Wrapper object meant to be implemented according to specifications in order to be utilized in MVector.
 * @author: Anton Zabreyko
 * */
public interface Info<A> {

    /** Method that allows retrieval of stored value. */
    public A get();

    /** Method that allows adding of values. */
    public Info<A> add(Info<A> a);

    /** Method that allows multiplication of values. */
    public Info<A> mul(Info<A> a);

    /**Method that allows division resulting in doubles of the values. */
    public double doubleDiv(Info<A> a);

    /**Method that allows division resulting in another value of the same type. */
    public Info<A> div(Info<A> a);
}
