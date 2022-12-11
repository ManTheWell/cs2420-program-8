import java.util.function.DoubleUnaryOperator;

public class Assn8 {
    public static void main(String[] args) {
        System.out.println("Part 1 - possible combinations for a set of 10 teacups using recursion:");
        RecursiveProfit r = new RecursiveProfit();
        r.printSets(10, "", 1);

        System.out.println();
        System.out.println("Part 2 - Dynamic Programming:");
        System.out.println("Set 1");
        DynamicProgramming set1 = new DynamicProgramming(24, new int[]{0, 1, 3, 5, 9, 10, 15, 17, 18, 19, 22, 25, 27});
        for (int i = 1;i <= 24;i++)  set1.bestSum(i);

        System.out.println();
        System.out.println("Set 2");
        DynamicProgramming set2 = new DynamicProgramming(24, new int[]{0, 2, 5, 8, 9, 10, 15, 19, 23, 24, 29, 30, 32});
        for (int i = 1;i <= 24;i++)  set2.bestSum(i);
    }
}
