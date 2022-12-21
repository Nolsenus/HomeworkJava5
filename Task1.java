import java.util.HashMap;
import java.util.LinkedList;

public class Task1 {

    static boolean phoneBookAdd(String name, String number, HashMap<String, LinkedList<String>> phoneBook) {
        if (!checkNumber(number)) {
            return false;
        }
        if (!phoneBook.containsKey(name)) {
            phoneBook.put(name, new LinkedList<>());
        }
        phoneBook.get(name).add(number);
        return true;
    }

    static boolean phoneBookRemove(String name, HashMap<String, LinkedList<String>> phoneBook) {
        LinkedList<String> removed = phoneBook.remove(name);
        return removed != null;
    }

    static boolean phoneBookRemove(String name, String number, HashMap<String, LinkedList<String>> phoneBook) {
        if (!phoneBook.containsKey(name)) {
            return false;
        }
        if (!phoneBook.get(name).contains(number)) {
            return false;
        }
        phoneBook.get(name).remove(number);
        return true;
    }

    static void printPhoneBook(HashMap<String, LinkedList<String>> phoneBook) {
        for (String name : phoneBook.keySet()) {
            System.out.printf("%s - ", name);
            LinkedList<String> nums = phoneBook.get(name);
            if (nums.isEmpty()) {
                System.out.println("Номеров нет.");
            } else {
                System.out.println(String.join(", ", nums));
            }
        }
    }

    static boolean checkNumber(String number) {
        return number.matches("\\+[0-9]{11}");
    }

    public static void main(String[] args) {
        HashMap<String, LinkedList<String>> phoneBook = new HashMap<>();
        String num = "+71234567890";
        String name = "Андрей";
        if (!phoneBookAdd(name, num, phoneBook)) System.out.printf("Указан неправильный номер - %s\n", num);
        else System.out.printf("В контакт %s добавлен номер %s.\n", name, num);
        num = "+70987654321";
        if (!phoneBookAdd(name, num, phoneBook)) System.out.printf("Указан неправильный номер - %s\n", num);
        else System.out.printf("В контакт %s добавлен номер %s.\n", name, num);
        num = "+71234509876";
        name = "Артём";
        if (!phoneBookAdd(name, num, phoneBook)) System.out.printf("Указан неправильный номер - %s\n", num);
        else System.out.printf("В контакт %s добавлен номер %s.\n", name, num);
        num = "+7";
        if (!phoneBookAdd(name, num, phoneBook)) System.out.printf("Указан неправильный номер - %s\n", num);
        else System.out.printf("В контакт %s добавлен номер %s.\n", name, num);
        num = "+70987612345";
        name = "Дмитрий";
        if (!phoneBookAdd(name, num, phoneBook)) System.out.printf("Указан неправильный номер - %s\n", num);
        else System.out.printf("В контакт %s добавлен номер %s.\n", name, num);
        printPhoneBook(phoneBook);
        num = "+70987612345";
        name = "Артём";
        if(!phoneBookRemove(name, num, phoneBook))
            System.out.printf("Не существует контакта %s или в нём нет номера %s\n", name, num);
        else System.out.printf("Из контакта %s удалён номер %s.\n", name, num);
        num = "+71234509876";
        name = "Артём";
        if(!phoneBookRemove(name, num, phoneBook))
            System.out.printf("Не существует контакта %s или в нём нет номера %s\n", name, num);
        else System.out.printf("Из контакта %s удалён номер %s.\n", name, num);
        name = "Дмитрий";
        if(!phoneBookRemove(name, phoneBook))
            System.out.printf("Не существет контакта %s\n", name);
        else System.out.printf("Удалён контакт %s.\n", name);
        printPhoneBook(phoneBook);
    }
}
