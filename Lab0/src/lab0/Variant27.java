package lab0;
import java.time.DayOfWeek;

public class Variant27
{
    public DayOfWeek IntegerTask(int day)
    {
        return DayOfWeek.of((day - 1) % 7 + 1);
    }

    public boolean LogicalExpressionTask(float x, float y)
    {
        return  x < 0;
    }
    public int IfStatementTask(float x)
    {
        int ix = (int)x;
        if (ix < 0) return 0;
        if (ix % 2 == 0) return  1;
        else return -1;
    }
    public float CaseStatementTask(int measurement, float mass)
    {
        switch (measurement)
        {
            //kg
            case 1:
                return mass;
            //milligram
            case 2:
                return mass * (1000f * 1000f);
            //gram
            case 3:
                return mass * 1000f;
            //ton
            case 4:
                return mass / 1000f;
            //centner
            case 5:
                return mass / 100f;
            default:
                return -1;
        }
    }
    public float ForStatementTask(float x, int n)
    {
        float sum = 0;

        for (int i = 1; i <= n; i+=2)
        {
            double xp = Math.pow(x, i);
            int f = Factorial(i - 1)*(i);
            int fodd = FactorialOdd(i-1);
            sum+= fodd * xp / f;
        }

        return sum;
    }
    public int WhileStatementTask(int n)
    {
        int a0 = 1;
        int a1 = 1;
        int k = 2;
        int number = 1;

        while (n != number)
        {
            k++;
            number = a0 + a1;
            a0 = a1;
            a1 = number;
        }

        return k;
    }

    public int MinMaxTask(int N, int[] array)
    {
        int result = 0;
        int length = 1;
        int biggestLength = 0;
        int index = 0;
        int old_value = array[0];

        for (int i = 0; i <= N; i++)
        {
            if(i == N || array[i] != old_value )
            {
                if (length > biggestLength)
                {
                    biggestLength = length;
                    result = index;
                }
                index = i;
                if(i != N) old_value = array[i];
                length = 1;
            }
            else
            {
                length++;
            }
        }

        return result;
    }

    public int ArrayTask(int[] array)
    {
        int prev = array[0];

        for (int i = 1; i < array.length; i++)
        {
            if(array[i] * prev > 0)
            {
                return i;
            }
            prev = array[i];
        }
        return  0;
    }

    public int MatrixTask(int n, int m, int[][] matrix)
    {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++)
        {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < m; j++)
            {
                if(matrix[i][j] < min)
                {
                    min = matrix[i][j];
                }
            }
            if(min > max)
            {
                max = min;
            }
        }
        return max;
    }


    private int Factorial(int n)
    {
        int r = 1;
        for (int i = 1; i <= n; i++)
        {
            if (i % 2 == 0)
                r *= i;
        }
        return r;
    }
    private int FactorialOdd(int n)
    {
        int r = 1;
        for (int i = 1; i <= n; i++)
        {
            if (i % 2 != 0)
                r *= i;
        }
        return r;
    }
}
