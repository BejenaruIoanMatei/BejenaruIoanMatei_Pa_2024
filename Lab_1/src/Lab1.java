
//Homework
public class Lab1
{
    public static void main(String[] args)
    {
        if(args.length != 3)
        {
            System.out.println("Corect e: java Lab1 val1 val2 valk ");
            return;
        }

        int a, b;
        int k;

        try
        {
            a = Integer.parseInt(args[0]);
            b = Integer.parseInt(args[1]);
            k = Integer.parseInt(args[2]);

            //System.out.println(a+" "+b+" "+k);
            if (k <= 0)
            {
                System.out.println("alege un k > 0");
                return;
            }

            if(a > b)
            {
                System.out.println("alege un interval corect");
                return;
            }

        }catch(Exception e)
        {
            System.out.println("eroare la input ");
            return;
        }

        long startTime = System.nanoTime();

        Calcul numere = new Calcul();
        numere.reductibil(a,b,k);

        long endTime = System.nanoTime();
        long durata = endTime-startTime;

        System.out.println("Running time : " + durata + " nanosec");
    }
}

class Calcul
{
    public void reductibil(int a , int b , int k)
    {
        StringBuilder numbers = new StringBuilder("Identified numbers : ");
        for(int i = a; i<=b;i++)
        {
            int aux = i;
            while(aux >=10)
            {
                int suma = 0;
                int aux2 = aux;
                while (aux2 > 0)
                {
                    int c = aux2 % 10;
                    suma += c * c;
                    aux2 /= 10;
                }
                aux = suma;
            }
            if(aux == k)
            {
                numbers.append(i).append(" ");
            }
        }

        System.out.println(numbers);
    }
}