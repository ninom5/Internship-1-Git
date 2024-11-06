import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter array of numbers separated by space: ");
        String line = sc.nextLine();
        int[] array = new int[line.split(" ").length];
        for(int i = 0; i < array.length; i++)
        {
            array[i] = Integer.parseInt(line.split(" ")[i]);
        }
        System.out.println("Permutations of the array: ");
        permutation(array, 0);
    }
    public static void permutation(int[] array, int index)
    {
        if(index == array.length) //ako smo dosli do kraja niza ispisujemo ga
        {
            for(int num : array)
                System.out.print(num + " ");
            System.out.println();
            return;
        }

        for(int i = index; i < array.length; i++)
        {
            swap(array, index, i);
            permutation(array, index + 1);
            swap(array, index, i);
        }
    }
    public static void swap(int []array, int index, int i)
    {
        int temp = array[index];
        array[index] = array[i];
        array[i] = temp;
    }
}