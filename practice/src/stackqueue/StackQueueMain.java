package stackqueue;

/**
 * Description :
 */
public class StackQueueMain {
    public static void main(String[] args) {
//        String str1 = "()(((()())(())()))(())";
//        int stickResult1 = 17;
//        System.out.println("Stick input: " + str1);
//        if (new Stick().solution(str1) == stickResult1) {
//            System.out.println("Stick result is " + stickResult1);
//        } else {
//            System.out.println("Stick result is not correct");
//        }
//
//        System.out.println();
//        System.out.println();
//        System.out.println();
//        System.out.println();
//
//
//        int[] prints1 = {2,1,3,2};
//        int location1 = 2;
//        int printAnswer1 = 1;
//        System.out.println("Printer input: " + prints1);
//        int printResult1 = new Printer().solution2(prints1, location1);
//        if (printResult1 == printAnswer1) {
//            System.out.println("Printer result is " + printResult1);
//        } else {
//            System.out.println("Printer result is not correct, " + printResult1);
//        }
//        int[] prints2 = {1,1,9,1,1,1};
//        int location2 = 0;
//        int printAnswer2 = 5;
//        System.out.println("Printer input: " + prints2);
//        int printResult2 = new Printer().solution2(prints2, location2);
//        if (printResult2 == printAnswer2) {
//            System.out.println("Printer result is " + printAnswer2);
//        } else {
//            System.out.println("Printer result is not correct, " + printResult2);
//        }
//        int[] prints3 = {8,5,1,8,5,1,3,2};
//        int location3 = 5;
//        int printAnswer3 = 8;
//        System.out.println("Printer input: " + prints3);
//        int printResult3 = new Printer().solution2(prints3, location3);
//        if (printResult3 == printAnswer3) {
//            System.out.println("Printer result is " + printResult3);
//        } else {
//            System.out.println("Printer result is not correct, " + printResult3);
//        }
//
//        System.out.println();
//        System.out.println();
//        System.out.println();
//        System.out.println();
//
//
//        int[] trucks1 = {7,4,5,6};
//        int bridge_length1 = 2;
//        int bridge_weight1 = 10;
//        int truck_answer1 = 8;
//        System.out.println("Truck input: " + trucks1);
//        int truckResult1 = new Truck().solution(bridge_length1, bridge_weight1, trucks1);
//        if (truckResult1 == truck_answer1) {
//            System.out.println("Truck result is " + truckResult1);
//        } else {
//            System.out.println("Truck result is not correct, result is " + truckResult1);
//        }
//
//        int[] trucks2 = {7,4,5,6,2};
//        int bridge_length2 = 2;
//        int bridge_weight2 = 10;
//        int truck_answer2 = 7;
//        System.out.println("Truck input: " + trucks2);
//        int truckResult2 = new Truck().solution(bridge_length2, bridge_weight2, trucks2);
//        if (truckResult2 == truck_answer2) {
//            System.out.println("Truck result is " + truckResult2);
//        } else {
//            System.out.println("Truck result is not correct, result is " + truckResult2);
//        }
//
//        int[] trucks3 = {10,10,10,10,10,10,10,10,10,10};
//        int bridge_length3 = 100;
//        int bridge_weight3 = 100;
//        int truck_answer3 = 110;
//        System.out.println("Truck input: " + trucks3);
//        int truckResult3 = new Truck().solution(bridge_length3, bridge_weight3, trucks3);
//        if (truckResult3 == truck_answer3) {
//            System.out.println("Truck result is " + truckResult3);
//        } else {
//            System.out.println("Truck result is not correct, result is " + truckResult3);
//        }
//
//        int[] trucks4 = {9,10,11,10,15,16,13,6,17,20};
//        int bridge_length4 = 10;
//        int bridge_weight4 = 20;
//        int truck_answer4 = 60;
//        System.out.println("Truck input: " + trucks4);
//        int truckResult4 = new Truck().solution(bridge_length4, bridge_weight4, trucks4);
//        if (truckResult4 == truck_answer4) {
//            System.out.println("Truck result is " + truckResult4);
//        } else {
//            System.out.println("Truck result is not correct, result is " + truckResult4);
//        }
//
//        int[] trucks5 = {9,10,13,10,15,16,13,6,17,20};
//        int bridge_length5 = 10;
//        int bridge_weight5 = 20;
//        int truck_answer5 = 70;
//        System.out.println("Truck input: " + trucks5);
//        int truckResult5 = new Truck().solution(bridge_length5, bridge_weight5, trucks5);
//        if (truckResult5 == truck_answer5) {
//            System.out.println("Truck result is " + truckResult5);
//        } else {
//            System.out.println("Truck result is not correct, result is " + truckResult5);
//        }

        int[] progresses1 = {93,30,55};
        int[] speed1 = {1,30,5};
        new Progresses().solution(progresses1, speed1);
        int[] result1 = new Progresses().solution(progresses1, speed1);
        System.out.print("Progresses result1: ");
        for (int i : result1) {
            System.out.print(i + ", ");
        }
        System.out.println();

        int[] progresses2 = {93,30,55};
        int[] speed2 = {1,5,5};
        int[] result2 = new Progresses().solution(progresses2, speed2);
        System.out.print("Progresses result2: ");
        for (int i : result2) {
            System.out.print(i + ", ");
        }
        System.out.println();

        int[] progresses3 = {98,30,55};
        int[] speed3 = {1,30,5};
        int[] result3 = new Progresses().solution(progresses3, speed3);
        System.out.print("Progresses result3: ");
        for (int i : result3) {
            System.out.print(i + ", ");
        }
        System.out.println();

        int[] progresses4 = {98,98,98};
        int[] speed4 = {1,1,1};
        int[] result4 = new Progresses().solution(progresses4, speed4);
        System.out.print("Progresses result4: ");
        for (int i : result4) {
            System.out.print(i + ", ");
        }

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
    }
}
