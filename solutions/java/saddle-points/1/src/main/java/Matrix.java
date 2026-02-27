import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Matrix {

    private final List<List<Integer>> rows;
    private final List<List<Integer>> columns;
    private final Set<MatrixCoordinate> saddlePoints;

    Matrix(List<List<Integer>> values) {
        this.rows = values;
        this.columns = getColumns();
        this.saddlePoints = findPotentialTrees();
    }

    Set<MatrixCoordinate> getSaddlePoints() {
        return saddlePoints;
    }

    private List<List<Integer>> getColumns() {
        if (rows.isEmpty()) {
            return new ArrayList<>();
        }

        List<List<Integer>> gridColumns = new ArrayList<>();
        int index = 0;

        while (index < rows.getFirst().size()) {
            List<Integer> currentColumn = new ArrayList<>();

            for (List<Integer> row : rows) {
                currentColumn.add(row.get(index));
            }

            gridColumns.add(currentColumn);
            index++;
        }

        return gridColumns;
    }

    private Set<MatrixCoordinate> findPotentialTrees() {
        Set<MatrixCoordinate> saddlePoints = new HashSet<>();

        for (int i = 0; i < rows.size(); i++) {
            int maxRowHeight = Collections.max(rows.get(i));

            for (int j = 0; j < rows.get(i).size(); j++) {
                int minColumnHeight = Collections.min(columns.get(j));

                if (maxRowHeight == minColumnHeight) {
                    saddlePoints.add(new MatrixCoordinate(i + 1, j + 1));
                }
            }
        }

        return saddlePoints;
    }
}
