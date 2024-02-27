
public class Main
{
    public static void main(String[] args)
    {
        // Step 1
        System.out.println("Hello World!");
        // Step 2
        String[] languages = {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};
        // Step 3
        int n = (int) (Math.random() * 1_000_000);
        // Step 4
        int result = n * 3;
        result += Integer.parseInt("10101", 2);
        result += Integer.parseInt("FF", 16);
        result *= 6;
        // Step 5
        int newres = result;
        while (newres > 9)
        {
            int sum = 0;
            while (newres > 0)
            {
                sum += newres % 10;
                newres /= 10;
            }
            newres = sum;
        }
        // Step 6
        System.out.println("Willy-nilly, this semester I will learn " + languages[newres]);
    }
}