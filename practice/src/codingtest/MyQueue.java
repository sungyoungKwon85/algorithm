package codingtest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

/**
 * Description :
 */
public class MyQueue {

    private LinkedList<String> list;
    private int capacity;

    public MyQueue(int capacity) {
        list = new LinkedList<>();
        this.capacity = capacity;
    }

    public boolean offer(String element) {
        if (list.size() == capacity) {
            return false;
        } else {
            list.add(element);
            return true;
        }
    }

    public String pull() {
        if (list == null || list.size() == 0) {
            return null;
        } else {
            String content = list.get(0);
            list.remove(0);
            return content;
        }
    }

    public int getSize() {
        return list.size();
    }

    /*
    OFFER hello
    OFFER world
    OFFER !
    TAKE
    SIZE
     */
    public static void main (String[] args) throws java.lang.Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] array = input.split(" ");
        if (array == null || array.length != 2) {
            return;
        }
        int numberOfCommand = Integer.parseInt(array[0]);
        int capacityOfQueue = Integer.parseInt(array[1]);

        MyQueue queue = new MyQueue(capacityOfQueue);

        for (int i=0; i<numberOfCommand; i++) {
            String some = br.readLine();

            String[] someArray = some.split(" ");
            if (someArray == null || someArray.length == 0) {
                return;
            }

            String command = someArray[0];
            if ("OFFER".equals(command)) {
                if (someArray.length == 1) {
                    continue;
                }
                String content = someArray[1];
                if (queue.offer(content)) {
                    System.out.println("true");
                } else {
                    System.out.println("false");
                }

            } else if ("TAKE".equals(command)) {
                System.out.println(queue.pull());
            } else if ("SIZE".equals(command)) {
                System.out.println(queue.getSize());
            }
        }
    }
}
