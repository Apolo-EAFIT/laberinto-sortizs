import java.util.Scanner;
public class Laberinto
{
    static char Laberinto[][];
    static int wall = 0;
    static int N = 0;

    public static void main (String [ ] args)
    {
        Fill();
        Marcar(N-1,N-1);
        Marcar(0,0);
        Result();
    }

    public static void Fill()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("");
        int n = sc.nextInt();
        N = n;
        char Matriz[][] = new char[n][n];
        if(n >= 3 && n <= 33)
        {
            for (int x = 0; x < Matriz.length; ++x) {
                for (int y = 0; y < Matriz[x].length; ++y) {
                    String str = sc.next();
                    for(int z = 0; z < n; ++z)
                    {
                        char c = str.charAt(z);
                        if((c == '.') || (c == '#'))
                        {
                            Matriz[x][y] = c;
                        }
                        else
                        {
                            System.out.println("Entrada no valida");
                        }
                        ++y;
                    }
                }
            }
            Laberinto = Matriz;
        }
    }

    public static void Marcar(int x,int y)
    {
        Laberinto[x][y] = ',';
        if(x+1 != N && Laberinto[x+1][y] == '.'){
            Marcar(x+1,y);
        }
        if(x-1 != -1 && Laberinto[x-1][y] == '.'){
            Marcar(x-1,y);
        }
        if(y+1 != N && Laberinto[x][y+1] == '.'){
            Marcar(x,y+1);
        }
        if(y-1 != -1 && Laberinto[x][y-1] == '.'){
            Marcar(x,y-1);
        }
    }

    public static void Result()
    {
        for(int x = 0; x < Laberinto.length; ++x)
        {
            for(int y = 0; y < Laberinto[x].length; ++y)
            {
                if (Laberinto[x][y] == ',')
                {
                    if(((x+1) == N) || (Laberinto[x+1][y] == '#'))
                    {
                        ++wall;
                    }
                    if(((x-1) == -1) || (Laberinto[x-1][y] == '#'))
                    {
                        ++wall;
                    }
                    if(((y+1) == N) || (Laberinto[x][y+1] == '#'))
                    {
                        ++wall;
                    }
                    if(((y-1) == -1) || (Laberinto[x][y-1] == '#'))
                    {
                        ++wall;
                    }
                }
            }
        }
        System.out.println((wall-4)*9);
    }
}
