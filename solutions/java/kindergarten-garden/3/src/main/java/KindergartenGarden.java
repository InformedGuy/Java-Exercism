import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class KindergartenGarden {

    private String[] rows;

    private List<String> students = Arrays.asList("Alice", "Bob", "Charlie", "David", "Eve", "Fred", "Ginny", "Harriet", "Ileana", "Joseph", "Kincaid", "Larry");

    KindergartenGarden(String garden) {
        rows = garden.split("\n");
    }

    List<Plant> getPlantsOfStudent(String student) {
        int studentIndex = students.indexOf(student);
        List<Plant> studentPlants = new ArrayList<>();

        for (String row : rows) {
            studentPlants.add(Plant.getPlant(row.charAt(studentIndex * 2)));
            studentPlants.add(Plant.getPlant(row.charAt(studentIndex * 2 + 1)));
        }

        return studentPlants;
    }

}
