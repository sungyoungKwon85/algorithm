/**
 * Description :
 *
 * @author 권성영/SK Planet (kkwonsy@sk.com)
 * @since 20/03/2019
 */
public class Main {
    public static void main(String[] args) {
        Marathon marathon = new Marathon();
        String[] participant = {"leo", "kiki", "eden", "eden", "eden", "eden", "eden", "leo", "kiki", "kiki"};
        String[] completion = {"leo", "kiki", "eden", "eden", "eden", "eden", "eden", "leo", "kiki"};
        System.out.print(marathon.marathon(participant, completion));
    }

}
