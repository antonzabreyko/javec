package javec;

/** Object representation of a vector. Based on an array.
 * @author: Anton Zabreyko
 */

public class MVector<A>
{
  /** Object array that stores the values. */
  private Object[] vec;

  /** Boolean that controls whether or not the vector is transposed. Default(false) is column. */
  private boolean transpose;

  /** Int representing the dimension of the vector. */
  public int dimension;

  /** Constructor that takes in an arbitrary number of args and sets up a vector. */
  public MVector(A... args)
  {
    vec = new Object[args.length];
    transpose = false;
    dimension = args.length;

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
    dimension = args.length;

    for(int i = 0; i<args.length; i++) {
      vec[i] = args[i];
    }
  }

  /** Returns value at INDEX. */
  public A get(int index) {
    return (A)vec[index];
  }

  /** Changes the transpose of the vector. */
  public void transpose() {
    transpose = !transpose;
  }

  /**Prints out the vector. */
  public String toString() {
    String string = "[";
    if(!transpose) {
      for(int i = 0; i<vec.length-1; i++) {
        string += vec[i] + "\n";
      }
      string += vec[vec.length-1] + "]";
    } else {
      for(int i = 0; i<vec.length-1; i++) {
        string += vec[i] + " ";
      }
      string += "]";
    }
    return string;
  }
}
