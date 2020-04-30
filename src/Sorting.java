import java.util.Arrays;

public class Sorting
{
    final static String ALGO_OPTIONS = "bci";

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
            case 'b': Algorithms.bubbleSort(array); break;
            case 'c': Algorithms.bubbleSortOptimized(array); break;
            case 'i': Algorithms.insertionSort(array); break;
            default: System.out.printf("Unexpected option flag: %c\n", option); break;
        }
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

}