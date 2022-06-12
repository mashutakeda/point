/**
 * This class will hold all the recursive methods.
 *
 * @author Mashu Takeda mtakeda9
 * @version 1
 */
public class Recursion {
    /**
     * Method that sorts the array in ascending lexicographical order through merge sort method.
     * This method is recursive.
     * @param someArray the input array
     * @return sorted String array in ascending lexicographical order
     */
    public static String[] mergeSort(String[] someArray) {
        if (someArray.length > 1) {
            String[] leftArray = RecursionUtils.copyOfRange(someArray, 0, someArray.length / 2);
            String[] rightArray = RecursionUtils.copyOfRange(someArray, someArray.length / 2, someArray.length);
            return RecursionUtils.merge(mergeSort(leftArray), mergeSort(rightArray));
        }
        return someArray;
    }

    /**
     * Method that takes apart all the elements in the given array and
     * sorts it in an ascending lexicographical order.
     * This method is recursive.
     * @param someArray the input array
     * @return String array in an ascending lexicographical order
     */
    public static String[] mergeAll(String[][] someArray) {
        String[] tempArray = someArray[0];
        if (someArray.length > 1) {
            for (int i = 1; i < someArray.length; i++) {
                tempArray = RecursionUtils.merge(tempArray, someArray[i]);
            }
        }
        return tempArray;

    }

    /**
     * Method that counts the number of duplicate items in the given array.
     * This method is recursive.
     * @param someArray the input array
     * @return int representing number of duplicate items in the given array.
     */
    public static int countDuplicates(String[] someArray) {
        if (someArray.length > 1) {
            if (someArray[0] == someArray[1]) {
                return (1 + countDuplicates(RecursionUtils.copyOfRange(someArray, 1, someArray.length)));
            } else {
                return countDuplicates(RecursionUtils.copyOfRange(someArray, 1, someArray.length));
            }
        }
        return 0;
    }

    /**
     * Method that checks whether the input String is a palindrome.
     * This method is recursive.
     * @param someString the input string
     * @return boolean representing whether the input String is a palindrome.
     */
    public static boolean verifyPalindrome(String someString) {
        if (someString == null) {
            return false;
        }
        if (someString.length() <= 1) {
            return true;
        }
        someString = someString.toLowerCase();
        if (someString.charAt(0) == someString.charAt(someString.length() - 1)) {
            return verifyPalindrome(someString.substring(1, someString.length() - 1));
        }
        return false;
    }


    /**
     * Method that counts the number of points that are strictly within the circle.
     * This method calls a recursive helper method, numInteriorPointsHelper.
     * @param somePoint the input Point array with a set of points
     * @param someInt an int representing radius of the circle
     * @return an int representing the number of points that are strictly within the circle
     */
    public static int numInteriorPoints(Point[] somePoint, int someInt) {
        return numInteriorPointsHelper(somePoint, someInt, 0);
    }

    /**
     * Helper method for numInteriorPoints.
     * This method is recursive.
     * Counts the number of points that are strictly within the circle.
     * @param somePoint Point array representing set of points to test
     * @param someInt int representing the radius of the circle
     * @param i int representing number of elements in the Point array
     * @return an int representing the number of points that are strictly within the circle
     */
    public static int numInteriorPointsHelper(Point[] somePoint, int someInt, int i) {
        if (i == somePoint.length || somePoint == null) {
            return 0;
        } else {
            int temp = somePoint[i].getX() * somePoint[i].getX() + somePoint[i].getY() * somePoint[i].getY();
            if (temp < someInt * someInt) {
                return (1 + numInteriorPointsHelper(somePoint, someInt, ++i));
            } else {
                return (numInteriorPointsHelper(somePoint, someInt, ++i));
            }
        }
    }

}