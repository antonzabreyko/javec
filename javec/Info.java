package javec;

/**Wrapper object meant to be implemented according to specifications in order to be utilized in MVector.
 * @author: Anton Zabreyko
 * */
public interface Info<A> {

    /** Method that allows retrieval of stored value. */
    public A get();

    /** Method that allows adding of values. */
    public A add(A a);

    /** Method that allows multiplication of values. */
    public A mul(A a);
}
