package javec;

/** Object representation of a vector. Based on an array.
 * @author: Anton Zabreyko
 */

public class MVector<A>
{
  /** Object representation of a vector. Based on an array. */

  private Object[] vec;

  /** Constructor that takes in an arbitrary number of args and sets up a vector. */
  public MVector(A... args)
  {
    vec = new Object[args.length];

    for(int i = 0; i<args.length; i++) {
      vec[i] = args[i];
    }
  }
}
