package SelfAssesment1;

public class Problem2
{
    public static void main(String[] args)
    {  
        int nValues = 50;

        PrimeLoop:
        for(int i = 2; i <= nValues; i++)
        {
            int limit = (int)Math.sqrt(i);
            for (int j = 2; j <= limit; j++)
            {
                if (i % j == 0)
                {
                    continue PrimeLoop;
                }
            
            }
            System.out.println(i);
        }
    }
}

/*  output is:
2
3
5
7
11
13
17
19
23
29
31
37
41
43
47
*/
