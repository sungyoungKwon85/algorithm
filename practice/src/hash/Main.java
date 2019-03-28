package hash;

public class Main {
    public static void main(String[] args) {
        Marathon marathon = new Marathon();
        String[] participant = {"leo", "kiki", "eden", "eden", "eden", "eden", "eden", "leo", "kiki", "kiki"};
        String[] completion = {"leo", "kiki", "eden", "eden", "eden", "eden", "eden", "leo", "kiki"};
        System.out.println("Marathon result: " + marathon.marathon(participant, completion));



        PhoneBook phoneBook = new PhoneBook();
        String[] arr = {"45123", "812", "81297", "4471", "9999", "451"};
        System.out.println("PhoneBook result: " + phoneBook.solution1(arr));



        Camouflage camouflage = new Camouflage();
        String[][] arr2D = {
            {"yellow_hat", "headgear"},
            {"blue_sunglasses", "eyewear"},
            {"green_turban", "headgear"}
        };
        System.out.println("Camouflage result: " + camouflage.solution(arr2D));
        String[][] arr2D1 = {
            {"yellow_hat", "headgear"},
            {"blue_sunglasses", "headgear"},
            {"green_turban", "headgear"}
        };
        System.out.println("Camouflage result: " + camouflage.solution(arr2D1));
        String[][] arr2D2 = {
            {"yellow_hat", "headgear"},
            {"blue_sunglasses", "eyewear"},
            {"green_turban", "headgear"},
            {"green_turban2", "headgear"}
        };
        System.out.println("Camouflage result: " + camouflage.solution(arr2D2));
        String[][] arr2D3 = {
            {"yellow_hat", "headgear"},
            {"blue_sunglasses", "eyewear"},
            {"green_turban", "headgear"},
            {"green_turban2", "headgear"},
            {"shirt1", "shirt"},
            {"shirt2", "shirt"}
        };
        System.out.println("Camouflage result: " + camouflage.solution(arr2D3));



        Album album = new Album();
        //[classic, pop, classic, classic, pop]	[500, 600, 150, 800, 2500]
//        String[] genres2 = {"classic", "acustic", "pop", "rock", "classic", "classic", "pop", "rock", "rock", "acustic", "kpop"};
//        int[] plays2 =       {500,       1600,    1000,   150,        800,    2500,     900,    1800,   550,    1100,     2900};
//        System.out.println("Album result: " + album.solution(genres2, plays2));
//
//        String[] genres = {"classic", "pop", "rock"};
//        int[] plays =       {500,       600,    1000};
//        System.out.println("Album result: " + album.solution(genres, plays));
//
//        String[] genres1 = {"classic", "rock", "rock", "rock"};
//        int[] plays1 =       {500,       600,    1000,   150};
//        System.out.println("Album result: " + album.solution(genres1, plays1));
//
//        String[] genres3 = {"classic", "classic", "classic"};
//        int[] plays3 =       {500,       600,    1000};
//        System.out.println("Album result: " + album.solution(genres3, plays3));

        String[] genres4 = {"classic"};
        int[] plays4 =       {500};
        System.out.println("Album result: " + album.solution(genres4, plays4));

        String[] genres5 = {"classic", "classic", "classic", "pop", "pop", "pop", "pop"};
        int[] plays5 =       {601,500,800,500,600,800,900};
        System.out.println("Album result: " + album.solution(genres5, plays5));

        String[] genres6 = {"classic", "pop", "rock", "rock", "classic", "pop", "rock", "classic", "pop"};
        int[] plays6 =       {500,      600,   1000,    500,       600,   1000,     700,    300,    1100};
        System.out.println("Album result: " + album.solution(genres6, plays6));
    }

}
