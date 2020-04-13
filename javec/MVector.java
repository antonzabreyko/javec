package javec;

import java.util.ArrayList;

/** Object representation of a vector. Based on an array.
 * @author: Anton Zabreyko
 */

public class MVector<A extends Info>
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

  /** Default constructor that creates an empty vector. */
  public MVector() {
    vec = new Object[0];
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
    if(vec.length == 0) {
      return "";
    }

    String string;
    if(!transpose) {
      string = "[" +vec[0].toString();
      for(int i = 1; i<vec.length; i++) {
        string += "\n " + vec[i].toString();
      }
      string += "]";
    } else {
      string = "[";
      for(int i = 0; i<vec.length-1; i++) {
        string += vec[i].toString() + " ";
      }
      string += vec[vec.length-1].toString() + "]";
    }
    return string;
  }

  /** Returns the dot product of this vector and the given vector other. */
  public A dot(MVector<A> other) {
    if(other.dimension != this.dimension) {
      System.out.println("Invalid Dimensions! Was expecting "+this.dimension+" but got "+other.dimension+".");
      return null;
    } else if(this.dimension == 0) {
      return null;
    }
    A sum = (A)this.get(0).mul(other.get(0));
    for(int i = 1; i<other.dimension; i++) {
      sum = (A)sum.add(this.get(i).mul(other.get(i)));
    }
    return sum;
  }

  public Object[] toArray() {
    Object[] arr = new Object[this.dimension];
    for(int i = 0; i<vec.length; i++) {
      arr[i] = vec[i];
    }
    return arr;
  }

  public ArrayList<A> toArrayList() {
    ArrayList<A> arr = new ArrayList<A>();
    for(int i = 0; i<vec.length; i++) {
      arr.add((A)vec[i]);
    }
    return arr;
  }




}
