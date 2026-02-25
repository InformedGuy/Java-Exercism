import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class KindergartenGarden {

    private final Map<String, List<Plant>> studentPlants = new HashMap<>();

    KindergartenGarden(String garden) {
        List<String> students = Arrays.asList("Alice", "Bob", "Charlie", "David", "Eve", "Fred", "Ginny", "Harriet", "Ileana", "Joseph", "Kincaid", "Larry");

        String[] rows = garden.split("\n");
        String first = rows[0];
        String second = rows[1];

        for (int i = 0; i < first.length(); i += 2) {
            String plants = first.substring(i, i + 2) + second.substring(i, i + 2);
            List<Plant> currentPlants = new ArrayList<>();

            for (char plant : plants.toCharArray()) {
                currentPlants.add(Plant.getPlant(plant));
            }

            studentPlants.put(students.get(i / 2), currentPlants);
        }
    }

    List<Plant> getPlantsOfStudent(String student) {
        return studentPlants.get(student);
    }

}
