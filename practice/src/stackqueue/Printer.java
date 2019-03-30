package stackqueue;

import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Printer {
/*
일반적인 프린터는 인쇄 요청이 들어온 순서대로 인쇄합니다. 그렇기 때문에 중요한 문서가 나중에 인쇄될 수 있습니다.
이런 문제를 보완하기 위해 중요도가 높은 문서를 먼저 인쇄하는 프린터를 개발했습니다.
이 새롭게 개발한 프린터는 아래와 같은 방식으로 인쇄 작업을 수행합니다.

1. 인쇄 대기목록의 가장 앞에 있는 문서(J)를 대기목록에서 꺼냅니다.
2. 나머지 인쇄 대기목록에서 J보다 중요도가 높은 문서가 한 개라도 존재하면 J를 대기목록의 가장 마지막에 넣습니다.
3. 그렇지 않으면 J를 인쇄합니다.
예를 들어, 4개의 문서(A, B, C, D)가 순서대로 인쇄 대기목록에 있고 중요도가 2 1 3 2 라면 C D A B 순으로 인쇄하게 됩니다.

내가 인쇄를 요청한 문서가 몇 번째로 인쇄되는지 알고 싶습니다. 위의 예에서 C는 1번째로, A는 3번째로 인쇄됩니다.

현재 대기목록에 있는 문서의 중요도가 순서대로 담긴 배열 priorities와
내가 인쇄를 요청한 문서가 현재 대기목록의 어떤 위치에 있는지를 알려주는 location이 매개변수로 주어질 때,
내가 인쇄를 요청한 문서가 몇 번째로 인쇄되는지 return 하도록 solution 함수를 작성해주세요.

제한사항
현재 대기목록에는 1개 이상 100개 이하의 문서가 있습니다.
인쇄 작업의 중요도는 1~9로 표현하며 숫자가 클수록 중요하다는 뜻입니다.
location은 0 이상 (현재 대기목록에 있는 작업 수 - 1) 이하의 값을 가지며 대기목록의 가장 앞에 있으면 0, 두 번째에 있으면 1로 표현합니다.
입출력 예
priorities	location	return
[2, 1, 3, 2]	2	1
[1, 1, 9, 1, 1, 1]	0	5
 */


    public int solution2(int[] priorities, int location) {

        int count = 0;

        // 일단 집어 넣음
        List<Integer> list = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int i : priorities) {
            queue.offer(i);
            list.add(i);
        }


        // 큐에서 하나씩 꺼냄
        while (!queue.isEmpty()) {

            int priority1 = queue.poll();
            count++;
            location--;

            // 꺼낸건 리스트에서도 삭제
            list.remove(0);

            // 더 큰게 있는지 봄
            boolean hasBiggerOne = list.stream().anyMatch(e -> e > priority1);

            if (hasBiggerOne) {
                // 뒤로 밈
                list.add(priority1);
                queue.offer(priority1);
                count--;

                // 민 얘가 찾는 얘면 그 인덱스를 수정함
                if (-1 == location) {
                    location = queue.size()-1;
                }
            }

            // 꺼낸 녀석이면 정답
            if (!hasBiggerOne && -1 == location) {
                return count;
            }
        }

        return count;
    }


    public int solution(int[] priorities, int location) {

        // 우선순위 큐는 먼저 들어간 데이터가 나오는 일반적인 구조가 아닌
        // 우선순위를 지정하여 그 값이 가장 높은 데이터가 가장 먼저 나온다 .
        // 우선순위는 Comparable이나 Comparator를 이용하여 구현해주면 되고,
        // (그러므로 우선순위의 값은 여러 값들의 조합으로 해도 된다.)


        // !! 이슈: queue에 넣을때마다 비교를 하게 됨.
        // !!     문제에서 원하는대로 들어가지 않음.
        Queue<Priority> queue = new PriorityQueue<>();
        for (int i=0; i<priorities.length; i++) {
            queue.offer(new Priority(i, priorities[i]));
        }

        int count = 0;
        while (!queue.isEmpty()) {
            count++;
            int index = queue.poll().getIndex();
            if (location == index) {
                return count;
            }
        }
        return count;
    }


    // 우선순위 Queue의 요소가 되려면 Comparable이 구현되어야 한다.
    private class Priority implements Comparable {
        private int index;
        private int priority;

        Priority(int index, int priority) {
            this.setIndex(index);
            this.setPriority(priority);
        }


        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public int getPriority() {
            return priority;
        }

        public void setPriority(int priority) {
            this.priority = priority;
        }

        @Override
        public int compareTo(Object target) {
            if (this.getPriority() < ((Priority)target).getPriority()) {
                return 1;
            } else if (this.getPriority() > ((Priority)target).getPriority()) {
                return -1;
            } else {
                if (this.getIndex() > ((Priority) target).getIndex()) {
                    return 1;
                } else {
                    return -1;
                }

            }
        }
    }

}
