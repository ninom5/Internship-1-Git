import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        System.out.println("Enter the max num of length of chars: ");
        int m = sc.nextInt();
        System.out.println("Enter the max length of line: ");
        int n = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter text: ");
        String text;

        while (true)
        {
            text = sc.nextLine();
            if (text.isEmpty())
                break;
            sb.append(text).append(" ");
        }
        String[] words = sb.toString().split(" ");
        sb.delete(0, sb.length());
        for(String word : words)
        {
            int temp;
            if(sb.isEmpty())
                temp = 0;
            else
                temp = 1;
            if(sb.length() + word.length() + temp <= m)
            {
                if(temp == 1)
                    sb.append(" ");
                sb.append(word);
            }
            else
            {
                printLine(sb.toString(), n);
                sb.delete(0, sb.length());
                sb.append(word);
            }
        }
        if(sb.length() > 0)
            printLine(sb.toString(), n);
    }
    public static void printLine(String line, int n) {
        int k = (n - line.length()) / 2; //broj praznina za dodat prije linije
        for(int i = 0; i < k; i++)
            System.out.print(" ");
        System.out.print(line);
        System.out.println();
    }
}