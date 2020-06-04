package javec;

/** Special exception for JaVec-related errors.
 * @author Anton A. Zabreyko
 */
public class LinAlgException extends Exception {

    /** Default constructor with no message. */
    LinAlgException() {
        super();
    }

    /** Exception that does have an error message. */
    LinAlgException(String message) {
        super(message);
    }
}
