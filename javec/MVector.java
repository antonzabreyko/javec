package javec;

/** Object representation of a vector. Based on an array.
 * @author: Anton Zabreyko
 */

public class MVector<A>
{
  /** Object representation of a vector. Based on an array. */

  private Object[] vec;
  private boolean transpose;

  /** Constructor that takes in an arbitrary number of args and sets up a vector. */
  public MVector(A... args)
  {
    vec = new Object[args.length];
    transpose = false;

    for(int i = 0; i<args.length; i++) {
      vec[i] = args[i];
    }
  }

  /**Alternative constructor that takes in both arbitrary number of args and a variable determining whether or not the
   * vector is transposed.
   */
  public MVector(boolean transpose, A... args) {

    vec = new Object[args.length];
    this.transpose = transpose;

    for(int i = 0; i<args.length; i++) {
      vec[i] = args[i];
    }

  }

  /** Returns value at INDEX. */
  public A get(int index) {
    return (A)vec[index];
  }

  /** Changes the transpose of the vector. */
  private void setTranspose() {
    transpose = !transpose;
  }
}
