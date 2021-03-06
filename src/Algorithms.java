import java.util.Scanner;
import java.util.Arrays;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;

public class Algorithms
{
    final static String STMT = "%s %d with %d";
    /*
        Bubble Sort algorith, non-optimized
    */
    public static void bubbleSort(int[] array)
    {
        final String VERB = "swap";
        final String NAME = "bubble sort";
        PrintUtils.algorithm(true, NAME, array);

        boolean swapped = false;
        int pass = 0;

        for (int i = 0; i < array.length - 1; i++)
        {   
            pass = i + 1;
            PrintUtils.passHeader(pass, array);

            // We can make an optimization to the LCC by considering the value of i
            for (int j = 0; j < array.length - 1; j++)
            {   
                // utility variables for step summary 
                swapped = false;
                String compareStmt = PrintUtils.compare(array[j], array[j + 1]);
                
                // swap if a pair of adjacent numbers is in decreasing order 
                if (array[j] > array[j + 1])
                {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }

                // Create action for this step
                String actionStmt = PrintUtils.action(swapped, VERB, array[j + 1], array[j]);

                // Print summary for this step
                PrintUtils.step(compareStmt, actionStmt, array);
            }

            PrintUtils.passFooter(pass, array);
        }

        PrintUtils.algorithm(false, NAME, array);
    }

    /*
        Bubble Sort algorithm, optimized

        - early termination if a pass without any swaps is detected
        - since each pass places the largest element at the rear, the
            inner loop is reduced by 1 for each subsequent pass
    */
    public static void bubbleSortOptimized(int[] array)
    {
        final String VERB = "swap";
        final String NAME = "bubble sort optimized";
        PrintUtils.algorithm(true, NAME, array);

        boolean swapped = false;
        boolean isSorted = false;
        int pass = 0;

        for (int i = 0; i < array.length - 1; i++)
        {   
            pass = i + 1;
            PrintUtils.passHeader(pass, array);
            isSorted = false;

            // We can make an optimization to the LCC by considering the value of i
            for (int j = 0; j < array.length - i - 1; j++)
            {   
                // utility variables for step summary 
                swapped = false;
                String compareStmt = PrintUtils.compare(array[j], array[j + 1]);
                
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
                String actionStmt = PrintUtils.action(swapped, VERB, array[j + 1], array[j]);
                PrintUtils.step(compareStmt, actionStmt, array);
            }

            PrintUtils.passFooter(pass, array);

            if (isSorted)
            {
                break;
            }

        }

        PrintUtils.algorithm(false, NAME, array);
    }

    // /*
    //     Insertion Sort algorithm

    //     - terminate early if a comparison is made where no swap need occur
    //     - this prevents us from making unnecessary comparisons to elements
    //         we know to be <=
    // */
    public static void insertionSort(int[] array)
    {
        final String VERB = "replace";
        final String NAME = "insertion sort";
        PrintUtils.algorithm(true, NAME, array);

        boolean swapped = false;
        int j = 0;
        int current = 0;

        for (int i = 1; i < array.length; i++)
        {   
            PrintUtils.passHeader(i, array);
            j = i;
            current = array[j];
            swapped = false;

            // If current is less than adjacent (left) shift elements over
            while (j > 0 && current < array[j - 1])
            {
                swapped = true;
                String compareStmt = PrintUtils.compare(current, array[j - 1]);
                String actionStmt = PrintUtils.action(swapped, VERB, array[j], array[j - 1]);
                array[j] = array[j - 1];
                
                PrintUtils.step(compareStmt, actionStmt, array);

                // Check next element to the left
                j--;
            }
            
            String actionStmt = PrintUtils.action(swapped, VERB, array[j], current);
            
            array[j] = current;
            PrintUtils.step("found insert position", actionStmt, array);

            PrintUtils.passFooter(i, array);
        }

        PrintUtils.algorithm(false, NAME, array);
    }
}