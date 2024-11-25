import java.util.ArrayList;

public class Grid<T> {
    private final ArrayList<ArrayList<T>> grid;
    public final int sideLength;
    private static int maxSideLength = 0;

    public Grid(int sideLength, T defaultVal) {
        this.sideLength = sideLength;
        this.grid = new ArrayList<>(sideLength);
        
        if (sideLength > maxSideLength) {
            maxSideLength = sideLength;
        }

        for (int i = 0; i < sideLength; i++) {
            grid.add(new ArrayList<>(sideLength));
            for (int j = 0; j < sideLength; j++) {
                grid.get(i).add(defaultVal);
            }
        }
    }

    public static int maxSideLength() {
        return maxSideLength;
    }

    public T get(int row, int col) {
        return grid.get(row).get(col);
    }

    public void set(int row, int col, T val) {
        grid.get(row).set(col, val);
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (ArrayList<T> row : grid) {
            for (T element : row) {
                str.append(element).append(" ");
            }
            str.append("\n");
        }
        return str.toString();
    }

    public ArrayList<T> diagonal() {
        ArrayList<T> diagonal = new ArrayList<>();
        for (int i = 0; i < sideLength; i++) {
            diagonal.add(grid.get(i).get(i));
        }
        return diagonal;
    }
}
