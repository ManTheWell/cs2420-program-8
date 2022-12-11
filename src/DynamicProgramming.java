public class DynamicProgramming {
    int[][] table;
    int[] profits;
    int cups;

    /**
     * constructor for DynamicProgramming
     * @param cups - the number of teacups in the set
     * @param profits - the profit list for teacup groups of sizes 1-12
     */
    public DynamicProgramming(int cups, int[] profits) {
        this.cups = cups;
        this.profits = profits;
        fillTable();
    }

    /**
     * creates and populates a table of size cups considering groups of up to 12
     */
    public void fillTable() {
        // table needs to be one bigger than the value of cups
        cups++;
        // define table
        table = new int[13][cups];

        // set the first two rows (top row 0, second row to number of cups
        for (int i = 0;i < table[0].length;i++)  {
            table[1][i] = i;
            table[0][i] = 0;
        }

        // set second column to 1
        for (int i = 1;i < table.length;i++)  table[i][1] = 1;

        // populate the table
        for (int i = 2;i < table.length;i++) {
            for (int j = 2;j < table[i].length;j++) {
                // the row above is the value if we choose not to use val
                int dont = table[i - 1][j];
                int use = 0;

                // value in the same row if we use it
                if (i <= j)  use = profits[i] + table[i][j - i];

                // take the better of the two values
                table[i][j] = Math.max(dont, use);
            }
        }

        // print the resulting table
        printTable();
    }

    /**
     * print the best sum for a given number of cups and the way it's divided
     * @param cups - number of cups
     */
    public void bestSum(int cups) {
        StringBuilder groups = new StringBuilder();
        int row = 12;
        int col = cups;

        for (int remainingCups = cups;remainingCups > 0;) {
            if (table[row][col] != table[row - 1][col]) {
                groups.append(row).append(" ");
                remainingCups -= row;
                col -= row;
            }
            else row--;
        }

        System.out.printf("Best Sum for (%d teacups): $%d %s", cups, table[12][cups], groups.toString());
        System.out.println();
    }

    /**
     * print the table all nice and pretty-like
     */
    public void printTable() {
        System.out.println("Table:");
        for (int[] row : table) {
            // nicely format the table values
            for (int val : row)  System.out.printf("%2d ", val);
            System.out.println();
        }
    }
}
