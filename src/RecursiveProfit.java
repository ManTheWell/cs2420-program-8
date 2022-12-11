public class RecursiveProfit {
    /**
     *
     * @param cupsRemaining - the size of the remaining
     * @param soFar
     * @param current
     */
    public void printSets(int cupsRemaining, String soFar, int current) {
        // no cups left
        if (cupsRemaining < 0)  return;
        // there will be negative cups left if we use current
        if (current > cupsRemaining)  {
            System.out.println("1 ".repeat(cupsRemaining) + soFar);
            return;
        }

        // use current
        printSets(cupsRemaining - current, soFar + current + " ", current);

        // do not use current
        printSets(cupsRemaining, soFar, current + 1);
    }
}
