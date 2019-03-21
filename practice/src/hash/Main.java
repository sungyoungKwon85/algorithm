package hash;

public class Main {
    public static void main(String[] args) {
        Marathon marathon = new Marathon();
        String[] participant = {"leo", "kiki", "eden", "eden", "eden", "eden", "eden", "leo", "kiki", "kiki"};
        String[] completion = {"leo", "kiki", "eden", "eden", "eden", "eden", "eden", "leo", "kiki"};
        System.out.println("Marathon result: " + marathon.marathon(participant, completion));

        PhoneBook phoneBook = new PhoneBook();
        String[] arr = {"45123", "812", "81297", "4471", "9999", "451"};
        System.out.println(phoneBook.solution1(arr));
    }

}
