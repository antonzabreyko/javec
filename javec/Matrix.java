package javec;

/** Object representation of a matrix.
 * @author: Anton Zabreyko
 */
import java.util.ArrayList;

public class Matrix<A extends Info> {

    /** ArrayList representation of the matrix. */
    private ArrayList<A[]> mat;
    private int dimension = 0;

    /**Default constructor for matrix, creates an empty matrix. */
    public Matrix() {
        mat = new ArrayList<A[]>();
        dimension = 0;
    }

    /**Attempts to add the vector to the matrix, and returns true or false depending on whether or not it was successful.
     * Its success is dependent on the dimensions lining up. */
    public boolean add(MVector v) {
        if(dimension == 0) {
            mat.add(v);
            return true;
        } else if (dimension == v.dimension) {
            mat.add(v);
            return true;
        }
        return false;
    }

    /**Attempts to add the array to the matrix, and returns true or false depending on whether or not it was successful. */
    public boolean add(A[] arr) {
        MVector<A> v = new MVector<A>(arr);
        return add(v);
    }


}
