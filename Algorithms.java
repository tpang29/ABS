import java.util.Scanner;
import java.util.Arrays;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;

public class Algorithms
{
    /*
        Bubble Sort algorith, non-optimized
    */
    public static void bubbleSort(int[] array)
    {
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
                String actionStmt = PrintUtils.action(swapped, array[j + 1], array[j]);

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
        final String NAME = "bubble sort optimized";
        PrintUtils.algorithm(true, NAME, array);

        boolean swapped = false;
        boolean isSorted = false;
        int pass = 0;

        for (int i = 0; i < array.length - 1; i++)
        {   
            pass = i + 1;
            PrintUtils.passHeader(pass, array);
            isSorted = true;

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
                String actionStmt = PrintUtils.action(swapped, array[j + 1], array[j]);
                PrintUtils.step(compareStmt, actionStmt, array);
            }

            if (isSorted)
            {
                PrintUtils.padding(1);
                break;
            }

            PrintUtils.passFooter(pass, array);
        }

        PrintUtils.algorithm(false, NAME, array);
    }

    /*
        Insertion Sort algorithm
    */
    public static void insertionSort(int[] array)
    {
        final String NAME = "insertion sort";
        PrintUtils.algorithm(true, NAME, array);

        boolean swapped = false;
        int pass = 0;

        for (int i = 1; i < array.length; i++)
        {   
            pass = i;
            PrintUtils.passHeader(pass, array);

            for (int j = i; j > 0; j--)
            {   
                // utility variables for step summary 
                swapped = false;
                String compareStmt = PrintUtils.compare(array[j], array[j - 1]);
                
                // if element on the right is greater than adjacent element on the left
                if (array[j] < array[j - 1])
                {
                    int temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                    swapped = true;
                }
                
                // Print summary for this step
                String actionStmt = PrintUtils.action(swapped, array[j], array[j - 1]);
                PrintUtils.step(compareStmt, actionStmt, array);

                if (!swapped)
                {
                    break;
                }
            }

            PrintUtils.passFooter(pass, array);
        }

        PrintUtils.algorithm(false, NAME, array);
    }
}