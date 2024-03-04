
class Main
{
    public static void main(String[] args)
    {
        WheelGraph graf = new WheelGraph();
        int nrNoduri = 5;
        int[][] matrice = graf.makeMatrix(nrNoduri);
        graf.displayMatrix(matrice);
        int numarTotalCicluri = ((nrNoduri-2)*(nrNoduri-1)+1);
        System.out.println("Numarul total de cicluri este : "+numarTotalCicluri);
    }

}

class WheelGraph
{
    public int[][] makeMatrix(int n)
    {
        int[][] matrix = new int[n][n];

        for (int i = 1; i < n; i++)
        {
            matrix[0][i] = 1;
            matrix[i][0] = 1;
        }
        for (int i = 1; i < n - 1; i++)
        {
            matrix[i][i + 1] = 1;
            matrix[i + 1][i] = 1;
        }
        matrix[n - 1][1] = 1;
        matrix[1][n - 1] = 1;
        return matrix;
    }
    public void displayMatrix(int[][] matrix)
    {
        System.out.println("Matricea de adiacenta:");
        for (int[] row : matrix)
        {
            for (int value : row)
            {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}
