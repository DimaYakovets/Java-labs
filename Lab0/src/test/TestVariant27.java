package test;

import lab0.Variant27;
import static org.testng.Assert.assertEquals;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.DayOfWeek;

public class TestVariant27
{
    @Test(dataProvider = "IntegerInput")
    public void IntegerTaskTest(int day, DayOfWeek dayfoweek)
    {
        assertEquals(new Variant27().IntegerTask(day), dayfoweek);
    }
    @DataProvider
    public Object[][] IntegerInput()
    {
        return new Object[][]
        {
            {  5, DayOfWeek.FRIDAY },
            {  7, DayOfWeek.SUNDAY },
            { 21, DayOfWeek.SUNDAY },
            { 24, DayOfWeek.WEDNESDAY },
        };
    }
    //------------------------------------------------------------------------------------------------------------------
    @Test(dataProvider = "LogicalInput")
    public void LogicalExpressionTaskText(float x, float y, boolean quadrant)
    {
        assertEquals(new Variant27().LogicalExpressionTask(x, y), quadrant);
    }
    @DataProvider
    public Object[][] LogicalInput()
    {
        return new Object[][]
        {
            {  0, 0, false },
            {  4, 0, false },
            { -4, 0, true  },
            { -1, 0, true  },
        };
    }
    //------------------------------------------------------------------------------------------------------------------
    @Test(dataProvider = "IfInput")
    public void IfStatementTaskTest(float x, float y)
    {
        assertEquals(new Variant27().IfStatementTask(x), y);
    }
    @DataProvider
    public Object[][] IfInput()
    {
        return new Object[][]
        {
            {  5, -1 },
            {  4,  1 },
            { -4,  0 },
            { -1,  0 }
        };
    }
    //------------------------------------------------------------------------------------------------------------------
    @Test(dataProvider = "CaseInput")
    public void CaseStatementTaskTest(int measurement, float mass, float result)
    {
        assertEquals(new Variant27().CaseStatementTask(measurement, mass), result, 0.000001f);
    }
    @DataProvider
    public Object[][] CaseInput()
    {
        return new Object[][]
        {
            {  1,  1000f, 1000f         },
            {  2,  1000f, 1000_000_000f },
            {  3,  1000f, 1000_000f     },
            {  4,  1000f, 1f            },
            {  5,  1000f, 10f           },
        };
    }
    //------------------------------------------------------------------------------------------------------------------
    @Test(dataProvider = "ForInput")
    public void ForStatementTaskTest(float x, int n, float result)
    {
        assertEquals(new Variant27().ForStatementTask(x, n), result, 0.00001f);
    }
    @DataProvider
    public Object[][] ForInput()
    {
        return new Object[][]
        {
            { 0.5f, 15, 0.5235987f },
            { 0.2f, 9 , 0.2013579f },
        };
    }
    //------------------------------------------------------------------------------------------------------------------
    @Test(dataProvider = "WhileInput")
    public void WhileStatementTaskTest(int fnum, int k)
    {
        assertEquals(new Variant27().WhileStatementTask(fnum), k);
    }
    @DataProvider
    public Object[][] WhileInput()
    {
        return new Object[][]
        {
            { 1,  2 },
            { 8,  6 },
            { 13, 7 },
        };
    }
    //------------------------------------------------------------------------------------------------------------------
    @Test(dataProvider = "MinMaxInput")
    public void MinMaxTaskTaskTest(int n, int[] array, int index)
    {
        assertEquals(new Variant27().MinMaxTask(n, array), index);
    }
    @DataProvider
    public Object[][] MinMaxInput()
    {
        return new Object[][]
        {
            { 8,  new int[] { 1, 1, 1, 0, 0, 0, 0, 0 }, 3 },
            { 5,  new int[] { 0, 0, 0, 1, 0 }, 0 }
        };
    }
    //------------------------------------------------------------------------------------------------------------------
    @Test(dataProvider = "ArrayInput")
    public void ArrayTaskTest(int[] array, int index)
    {
        assertEquals(new Variant27().ArrayTask(array), index);
    }
    @DataProvider
    public Object[][] ArrayInput()
    {
        return new Object[][]
        {
            { new int[] { 1, -2, 3, -4, 5, -6, 7, -8, 9, -10 }, 0 },
            { new int[] { 1, -2, 3, 4, 5, -6, 7, -8, 9, -10 }, 3 }
        };
    }
    //------------------------------------------------------------------------------------------------------------------
    @Test(dataProvider = "MatrixInput")
    public void MatrixTaskTest(int n, int m, int[][] matrix, int answer)
    {
        assertEquals(new Variant27().MatrixTask(n, m, matrix), answer);
    }
    @DataProvider
    public Object[][] MatrixInput()
    {
        return new Object[][]
        {
            { 2, 2, new int[][] { { 3, 6 }, { 5, 8 } }, 5 },
            { 2, 3, new int[][] { { 3, 6, 2 }, { 5, 8, 1 } }, 2 }
        };
    }
}
