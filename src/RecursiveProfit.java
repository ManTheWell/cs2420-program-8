public class RecursiveProfit {
    /**
     *
     * @param cupsRemaining - the size of the remaining
     * @param soFar
     * @param current
     */
    public void printSets(int cupsRemaining, String soFar, int current) {
        // there will be negative cups left if we use current
        if (cupsRemaining == 0)  {
            System.out.println("1 ".repeat(cupsRemaining) + soFar);
            return;
        }

        // no cups left
        if (cupsRemaining < 0 || current > cupsRemaining)  return;

        // use current
        printSets(cupsRemaining - current, soFar + current + " ", current);

        // do not use current
        printSets(cupsRemaining, soFar, current + 1);
    }
}
