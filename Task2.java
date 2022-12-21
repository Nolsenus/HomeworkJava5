import java.util.Map;
import java.util.HashMap;
import java.util.LinkedList;

public class Task2 {

    static HashMap<String, Integer> frequencyMap(LinkedList<String> employees) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String fullName : employees) {
            String name = fullName.split(" ")[0];
            map.putIfAbsent(name, 0);
            map.put(name, map.get(name) + 1);
        }
        return map;
    }

    static LinkedList<Map.Entry<String, Integer>> sortedEntries(HashMap<String, Integer> map) {
        LinkedList<Map.Entry<String, Integer>> result = new LinkedList<>(map.entrySet());
        Map.Entry<String, Integer> temp;
        for (int i = 0; i < result.size() - 1; i++) {
            for (int j = i + 1; j < result.size(); j++) {
                if (result.get(j).getValue() > result.get(i).getValue()) {
                    temp = result.get(j);
                    result.set(j, result.get(i));
                    result.set(i, temp);
                }
            }
        }
        return result;
    }

    static void printEntries(LinkedList<Map.Entry<String, Integer>> entries) {
        for (Map.Entry<String, Integer> entry : entries) {
            System.out.printf("%s - %d\n", entry.getKey(), entry.getValue());
        }
    }

    public static void main(String[] args) {
        LinkedList<String> employees = new LinkedList<>();
        employees.add("Иван Иванов");
        employees.add("Иван Петров");
        employees.add("Иван Алексеев");
        employees.add("Иван Сидоров");
        employees.add("Иван Иванчук");
        employees.add("Иван Иваненко");
        employees.add("Пётр Иванов");
        employees.add("Пётр Петров");
        employees.add("Дмитрий Иванов");
        employees.add("Алексей Иванов");
        employees.add("Алексей Алексеев");
        employees.add("Олег Иванов");
        employees.add("Олег Петров");
        employees.add("Олег Сидоров");
        HashMap<String, Integer> map = frequencyMap(employees);
        printEntries(sortedEntries(map));
    }
}
