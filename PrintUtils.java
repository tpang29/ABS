import java.util.Arrays;
import java.util.Scanner;

public class PrintUtils
{
    // Press enter to consume new line and move to next step
    final static Scanner SCANNER = new Scanner(System.in);

    // Print/Formatting constants
    final static String ALGO_OPTIONS = "bci";
    final static String TABLE_FORMAT = "%-25s%-25s%s";
    final static String SWAP_STMT = "swapped %d with %d";
    final static String CMP_STMT = "compare %d with %d";
    final static String HL = "--------------------------------------------------------------------------------------------------------------" ;

    /* Print the current pass header */
    public static void passHeader(int pass, int[] array)
    {
        final String COL_1 = "Comparing";
        final String COL_2 = "Action";
        final String COL_3 = "Array State";

        System.out.printf("Starting pass %d, array is: %s\n", pass, Arrays.toString(array));
        System.out.printf("%s\n", HL);
        String header = String.format(TABLE_FORMAT + "\n", COL_1, COL_2, COL_3);
        System.out.print(header);
        System.out.printf("%s", HL);        
    }

    /* Print the current step: what was compared, action taken, and the state of the integer array */
    public static void step(String compareStmt, String actionStmt, int[] array)
    {
        SCANNER.nextLine();
        String step = String.format(TABLE_FORMAT, compareStmt, actionStmt, Arrays.toString(array));
        System.out.print(step);
    }

    /* Print footer for current pass */
    public static void passFooter(int pass, int[] array)
    {
        SCANNER.nextLine();
        System.out.printf("%s\n", HL);
        System.out.printf("After pass %d, array is: %s\n\n", pass, Arrays.toString(array));
        SCANNER.nextLine();        
    }

    /* Print algorithm details at beginning and end */
    public static void algorithm(boolean before, String name, int[] array)
    {
        System.out.printf("%s %s: %s\n\n", (before ? "Before" : "After"), name, Arrays.toString(array));
    }

    /* Consume a new line and print n number of new lines */
    public static void padding(int n)
    {
        SCANNER.nextLine();

        for (int i = 0; i < n; i++)
        {
            System.out.println();
        }
    }

    /* Generate a compare string for each step */
    public static String compare(int element1, int element2)
    {
        return String.format(CMP_STMT, element1, element2);
    }

    /* Generate an action string for each step */
    public static String action(boolean swapped, int element1, int element2)
    {
        return String.format("%s", swapped ? String.format(SWAP_STMT, element1, element2) : "none");
    }
}