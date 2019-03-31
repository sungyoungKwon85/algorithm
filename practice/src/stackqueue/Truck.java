package stackqueue;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * Description :
 *
 */
public class Truck {
/*
트럭 여러 대가 강을 가로지르는 일 차선 다리를 정해진 순으로 건너려 합니다.
모든 트럭이 다리를 건너려면 최소 몇 초가 걸리는지 알아내야 합니다.
트럭은 1초에 1만큼 움직이며, 다리 길이는 bridge_length이고 다리는 무게 weight까지 견딥니다.
※ 트럭이 다리에 완전히 오르지 않은 경우, 이 트럭의 무게는 고려하지 않습니다.

예를 들어, 길이가 2이고 10kg 무게를 견디는 다리가 있습니다.
무게가 [7, 4, 5, 6]kg인 트럭이 순서대로 최단 시간 안에 다리를 건너려면 다음과 같이 건너야 합니다.

경과 시간	다리를 지난 트럭	다리를 건너는 트럭	대기 트럭
0	[]	[]	[7,4,5,6]
1~2	[]	[7]	[4,5,6]
3	[7]	[4]	[5,6]
4	[7]	[4,5]	[6]
5	[7,4]	[5]	[6]
6~7	[7,4,5]	[6]	[]
8	[7,4,5,6]	[]	[]
따라서, 모든 트럭이 다리를 지나려면 최소 8초가 걸립니다.

solution 함수의 매개변수로 다리 길이 bridge_length, 다리가 견딜 수 있는 무게 weight,
트럭별 무게 truck_weights가 주어집니다.
이때 모든 트럭이 다리를 건너려면 최소 몇 초가 걸리는지 return 하도록 solution 함수를 완성하세요.

제한 조건
bridge_length는 1 이상 10,000 이하입니다.
weight는 1 이상 10,000 이하입니다.
truck_weights의 길이는 1 이상 10,000 이하입니다.
모든 트럭의 무게는 1 이상 weight 이하입니다.
입출력 예
bridge_length	weight	truck_weights	return
2	10	[7,4,5,6]	8
100	100	[10]	101
100	100	[10,10,10,10,10,10,10,10,10,10]	110
 */


    public int solution(int bridge_length, int weight, int[] truck_weights) {

        int sum = 0;
        int sequence = 0;

        boolean isBiggerRecent = false;

        // 정렬을 한 뒤
        Arrays.sort(truck_weights);

        // 양방향 큐에 넣기
        // !!! Deque의 경우 헤드와 테일 양쪽에 객체를 추가/가져올 수 있는 기능이 추가로 정의되어 있다
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i : truck_weights) {
            queue.offer(i);
        }

        while (!queue.isEmpty()) {
            // 하나 남음
            if (queue.size() == 1) {
                if (queue.poll() <= weight) {
                    sequence++;
                }
            } else {
                // 두개 꺼냄
                int smaller = queue.pollFirst();
                int bigger = queue.pollLast();

                // 큰거가 다리 무게보다 무거우면 버림
                if (bigger > weight) {
                    queue.offerFirst(smaller);
                    continue;
                }

                // 합친게 클 때
                if (bigger+smaller > weight) {
                    // 연결 끊김
                    if (sequence > 0) {
                        sum = sum + bridge_length + sequence + 1;
                        sequence = 1; // 초기화
                    } else {
                        sum = sum + bridge_length + 1;
                        queue.offerFirst(smaller);
                    }

                } else {
                    if (isBiggerRecent) {
                        queue.offerLast(bigger);
                        isBiggerRecent = false;
                    } else {
                        queue.offerFirst(smaller);
                        isBiggerRecent = true;
                    }
                    sequence++;
                }
            }
        }
        sum = sum + sequence + bridge_length;

        return sum;
    }
}























