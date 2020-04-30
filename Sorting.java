import java.util.Scanner;
import java.util.Arrays;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;

public class Sorting
{
    // Press enter to consume new line and move to next step
    final static Scanner SCANNER = new Scanner(System.in);

    // Print/Formatting constants
    final static String ALGO_OPTIONS = "bci";
    final static String TABLE_FORMAT = "%-25s%-25s%s";
    final static String SWAP_STMT = "swapped %d with %d";
    final static String CMP_STMT = "compare %d with %d";
    final static String HL = "--------------------------------------------------------------------------------------------------------------" ;

    public static void main(String[] args)
    {

        // Exit with status code 1 if one or fewer arguments provided
        if (args.length <= 1)
        {
            System.out.println("Usage: java Sorting -option [integer1, ..., integerN]");
            System.exit(1);
        }

        char option = getOpt(args[0], ALGO_OPTIONS);

        // Exit with status code 2 if invalid option provided
        if (option == '?')
        {
            StringBuilder optionList = new StringBuilder(ALGO_OPTIONS.length() + ALGO_OPTIONS.length() - 1);
            optionList.append(ALGO_OPTIONS.charAt(0));
            for (int i = 1; i < ALGO_OPTIONS.length(); i++)
            {
                optionList.append("|" + ALGO_OPTIONS.charAt(i));
            }
            System.out.printf("Use option: [%s]\n", optionList.toString());
            System.exit(2);            
        }

        // Exit with status code 3 if non-integer value provided
        args = Arrays.copyOfRange(args, 1, args.length);

        for (String input : args)
        {
            if (!isNumber(input))
            {
                System.out.printf("Use integers as arguments: '%s' is not an integer.\n", input);
                System.exit(3);
            }
        }

        // Declare integer array
        int[] array = new int[args.length];

        // Cast arguments as primitive integers
        castArguments(args, array);

        // Run specified sorting algorithm
        sort(option, array);        
    }

    /* Choose sorting algorithm based on user option */
    private static void sort(char option, int[] array)
    {
        switch (option)
        {
            case 'b': bubbleSort(array); break;
            case 'c': bubbleSortOptimized(array); break;
            case 'i': insertionSort(array); break;
            default: System.out.printf("Unexpected option flag: %c\n", option); break;
        }
    }

    /*
        SORTING ALGORITHMS
        - bubble sort
        - bubble sort, optimized
        - insertion sort
    */

    /* Bubble Sort algorith, non-optimized */
    private static void bubbleSort(int[] array)
    {
        final String NAME = "bubble sort";
        printAlgorithm(true, NAME, array);

        boolean swapped = false;
        int pass = 0;

        for (int i = 0; i < array.length - 1; i++)
        {   
            pass = i + 1;
            printPassHeader(pass, array);

            // We can make an optimization to the LCC by considering the value of i
            for (int j = 0; j < array.length - 1; j++)
            {   
                // utility variables for step summary 
                swapped = false;
                String compareStmt = String.format(CMP_STMT, array[j], array[j + 1]);
                
                // swap if a pair of adjacent numbers is in decreasing order 
                if (array[j] > array[j + 1])
                {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }

                // Print summary for this step
                String actionStmt = String.format("%s", swapped ? String.format(SWAP_STMT, array[j + 1], array[j]) : "none");
                printStep(compareStmt, actionStmt, array);
            }

            printPassFooter(pass, array);
        }

        printAlgorithm(false, NAME, array);
    }

    /* Bubble Sort algorithm, optimized */
    private static void bubbleSortOptimized(int[] array)
    {
        final String NAME = "bubble sort optimized";
        printAlgorithm(true, NAME, array);

        boolean swapped = false;
        boolean isSorted = false;
        int pass = 0;

        for (int i = 0; i < array.length - 1; i++)
        {   
            pass = i + 1;
            printPassHeader(pass, array);
            isSorted = true;

            // We can make an optimization to the LCC by considering the value of i
            for (int j = 0; j < array.length - i - 1; j++)
            {   
                // utility variables for step summary 
                swapped = false;
                String compareStmt = String.format(CMP_STMT, array[j], array[j + 1]);
                
                // swap if a pair of adjacent numbers is in decreasing order 
                if (array[j] > array[j + 1])
                {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                    isSorted = false;
                }

                // Print summary for this step
                String actionStmt = String.format("%s", swapped ? String.format(SWAP_STMT, array[j + 1], array[j]) : "none");
                printStep(compareStmt, actionStmt, array);
            }

            if (isSorted)
            {
                printPadding(1);
                break;
            }

            printPassFooter(pass, array);
        }

        printAlgorithm(false, NAME, array);
    }

    /* Insertion Sort algorithm */
    private static void insertionSort(int[] array)
    {
        final String NAME = "insertion sort";
        printAlgorithm(true, NAME, array);

        boolean swapped = false;
        int pass = 0;

        for (int i = 1; i < array.length; i++)
        {   
            pass = i;
            printPassHeader(pass, array);

            for (int j = i; j > 0; j--)
            {   
                // utility variables for step summary 
                swapped = false;
                String compareStmt = String.format(CMP_STMT, array[j], array[j - 1]);
                
                // if element on the right is greater than adjacent element on the left
                if (array[j] < array[j - 1])
                {
                    int temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                    swapped = true;
                }

                // Print summary for this step
                String actionStmt = String.format("%s", swapped ? String.format(SWAP_STMT, array[j], array[j - 1]) : "none");
                printStep(compareStmt, actionStmt, array);
            }

            printPassFooter(pass, array);
        }

        printAlgorithm(false, NAME, array);
    }

    /*
        INPUT UTILITY METHODS
    */
    
    /* Parse the user option. Rejects '-' and '--' and only accepts 
    valid algorithm options specified in the options string */
    private static char getOpt(String option, String options)
    {
        final char UNDEF = '?';
        if (option.length() <= 1 || option.equals("-") || option.equals("--"))
        {
            return UNDEF;
        }

        if (options.contains(option.substring(1)))
        {
            return option.charAt(1);
        }
        else
        {
            return UNDEF;
        }
    }

    /* Cast integers from String to int */
    private static void castArguments(String[] source, int[] target)
    {
        for (int i = 0; i < source.length; i++)
        {
            target[i] = Integer.parseInt(source[i]);   
        }
    }

    /* 
        DFA that accepts integers

        Start   (0, int, 3)
        Start   (0, -, 1)
                (1, int, 3)
                (1, -, 2)
                (2, -, 2)
                (2, int, 2)
        Final   (3, int, 3)
        Final   (3, -, 2)
    */
    private static boolean isNumber(String s)
    {
        if (s.length() == 0)
        {
            return false;
        }

        int state = 0;
        
        char[] chars = s.toCharArray();

        for (char c : chars)
        {
            // beginning of negative number found at the start of the input
            if (state == 0 && c == '-')
            {
                state = 1;
            }
            // integer > 9 or < -9 is typed
            else if (state != 2 && Character.isDigit(c))
            {
                state = 3;
            }
            // negative found in incorrect place or non-digit character entered
            else
            {
                state = 2;
            }
        }
        
        return state == 3;
    }

    /*
        PRINTING HELPER METHODS 
    */

    /* Print the current pass header */
    private static void printPassHeader(int pass, int[] array)
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
    private static void printStep(String compareStmt, String actionStmt, int[] arrayState)
    {
        SCANNER.nextLine();
        String step = String.format(TABLE_FORMAT, compareStmt, actionStmt, Arrays.toString(arrayState));
        System.out.print(step);
    }

    /* Print footer for current pass */
    private static void printPassFooter(int pass, int[] array)
    {
        SCANNER.nextLine();
        System.out.printf("%s\n", HL);
        System.out.printf("After pass %d, array is: %s\n\n", pass, Arrays.toString(array));
        SCANNER.nextLine();        
    }

    /* Print algorithm details at beginning and end */
    private static void printAlgorithm(boolean before, String name, int[] array)
    {
        System.out.printf("%s %s: %s\n\n", (before ? "Before" : "After"), name, Arrays.toString(array));
    }

    private static void printPadding(int n)
    {
        SCANNER.nextLine();

        for (int i = 0; i < n; i++)
        {
            System.out.println();
        }
    }
}