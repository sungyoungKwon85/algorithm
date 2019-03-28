package hash;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Description :
 *
 * @author 권성영/SK Planet (kkwonsy@sk.com)
 * @since 28/03/2019
 */
public class Album {
//스트리밍 사이트에서 장르 별로 가장 많이 재생된 노래를 두 개씩 모아 베스트 앨범을 출시하려 합니다. 노래는 고유 번호로 구분하며, 노래를 수록하는 기준은 다음과 같습니다.
//
//속한 노래가 많이 재생된 장르를 먼저 수록합니다.
//장르 내에서 많이 재생된 노래를 먼저 수록합니다.
//장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록합니다.
//노래의 장르를 나타내는 문자열 배열 genres와 노래별 재생 횟수를 나타내는 정수 배열 plays가 주어질 때, 베스트 앨범에 들어갈 노래의 고유 번호를 순서대로 return 하도록 solution 함수를 완성하세요.
//
//제한사항
//genres[i]는 고유번호가 i인 노래의 장르입니다.
//plays[i]는 고유번호가 i인 노래가 재생된 횟수입니다.
//genres와 plays의 길이는 같으며, 이는 1 이상 10,000 이하입니다.
//장르 종류는 100개 미만입니다.
//장르에 속한 곡이 하나라면, 하나의 곡만 선택합니다.
//모든 장르는 재생된 횟수가 다릅니다.

//입출력 예
//genres	plays	return
//[classic, pop, classic, classic, pop]	[500, 600, 150, 800, 2500]	[4, 1, 3, 0]

    public int[] solution(String[] genres, int[] plays) {
        // ***** TreeMap은 Key 기준으로 정렬하는 거임


        // <종류, 최대수>
        Map<String, Integer> hm = new HashMap<>();
        for (int i=0; i<plays.length; i++) {
            Integer count = hm.get(genres[i]);
            if (count == null || count == 0) {
                hm.put(genres[i], plays[i]);
            } else {
                if (count < plays[i]) {
                    hm.put(genres[i], plays[i]);
                }
            }
        }
        // 내림차순 정렬
        List<String> orderedList = hm.keySet().stream().collect(Collectors.toList());

        // ***** 익명 클래스
//        Collections.sort(genreList, new Comparator<String>() {
//            @Override
//            public int compare(String genre1, String genre2) {
//                Integer compare1 = hm.get(genre1);
//                Integer compare2 = hm.get(genre2);
//                return compare1.compareTo(compare2);
//            }
//        });
        // ***** 커스텀이라 이건 못씀
//        Collections.sort(genreList, (genre1, genre2) -> genre1.compareTo(genre2));
//        Collections.sort(genreList, String::compareTo);

        // ***** 람다로 표현
        Collections.sort(orderedList, (genre1, genre2) -> {
            Integer compare1 = hm.get(genre1);
            Integer compare2 = hm.get(genre2);
            return compare2.compareTo(compare1);
        });


        // map <genre,list of genre' index>
        Map<String, List<Integer>> hm1 = new HashMap<>();
        for (int i=0; i<plays.length; i++) {

            List<Integer> indexes = hm1.get(genres[i]);
            if (indexes == null || indexes.size() == 0) {
                indexes = new ArrayList<>();
                indexes.add(i);
                hm1.put(genres[i], indexes);
            } else {
                // save only two
                if (indexes.size() == 1) {
                    int preIndex = indexes.get(0);
                    if (plays[preIndex] < plays[i]) {
                        indexes.remove(0);
                        indexes.add(i);
                        indexes.add(preIndex);
                    } else {
                        indexes.add(i);
                    }

                    hm1.put(genres[i], indexes);
                } else if (indexes.size() == 2) {
                    int preIndex1 = indexes.get(0);
                    int preIndex2 = indexes.get(1);
                    if (plays[preIndex1] < plays[i]) {
                        indexes.clear();
                        indexes.add(i);
                        indexes.add(preIndex1);
                    } else if (plays[preIndex2] < plays[i]) {
                        indexes.remove(1);
                        indexes.add(i);
                    }
                }
            }
        }

        // return variable
        int[] result = new int[hm.size()*2];

        int i = 0;
        for (String genre : orderedList) {
            result[i] = hm1.get(genre).get(0);
            if (hm1.get(genre).size() == 2) {
                result[i + 1] = hm1.get(genre).get(1);
                i+=2;
            } else {
                i++;
            }

        }

        return result;



        // <index, count>
        // ***** AtomicInteger: 인덱스 찾기가 어려워 얘를 사용했다.
        // ***** boxed(): int, long, double 요소를 Integer, Long, Double 요소로 박싱해서 Stream 생성
//        AtomicInteger index1 = new AtomicInteger();
//        List<Integer> indexList = Arrays.stream(plays).boxed().collect(Collectors.toList());
//        Map<Integer, Integer> hm2 = indexList.stream()
//            .collect(Collectors.toMap(e -> index1.getAndIncrement(), Function.identity())); // ***** 그대로 적용할땐 얘

        // <index, genre>
//        AtomicInteger index2 = new AtomicInteger();
//        List<String> genreList = Arrays.stream(genres).collect(Collectors.toList());
//        Map<Integer, String> hm3 = genreList.stream()
//            .collect(Collectors.toMap(e -> index2.getAndIncrement(), Function.identity()));

    }






    // 정렬하는거 ㄴ까지 해야 함.
    // 다른 방법이 나을것 같아 중지함
//    public int[] solution2(String[] genres, int[] plays) {
//        Map<String, List<Integer>> hm1 = new HashMap<>();
//
//        // map <genre,list of genre' index>
//        for (int i=0; i<plays.length; i++) {
//
//            List<Integer> indexes = hm1.get(genres[i]);
//            if (indexes == null || indexes.size() == 0) {
//                indexes = new ArrayList<>();
//                indexes.add(i);
//                hm1.put(genres[i], indexes);
//            } else {
//                // save only two
//                if (indexes.size() == 1) {
//                    int preIndex = indexes.get(0);
//                    if (plays[preIndex] < plays[i]) {
//                        indexes.remove(0);
//                        indexes.add(i);
//                        indexes.add(preIndex);
//                    } else {
//                        indexes.add(i);
//                    }
//
//                    hm1.put(genres[i], indexes);
//                } else if (indexes.size() == 2) {
//                    int preIndex1 = indexes.get(0);
//                    int preIndex2 = indexes.get(1);
//                    if (plays[preIndex1] < plays[i]) {
//                        indexes.clear();
//                        indexes.add(i);
//                        indexes.add(preIndex1);
//                    } else if (plays[preIndex2] < plays[i]) {
//                        indexes.remove(1);
//                        indexes.add(i);
//                    }
//                }
//            }
//        }
//
//        // result array
//        int[] result = new int[hm1.size()*2];
//
//        // order
//        List<String> ordered = new ArrayList<>();
//
////        for (String genre : hm1.keySet()) {
////            if (hm1.get(genre).get(0))
////        }
//
//
//
//        int i = 0;
//        for (String genre : ordered) {
//            result[i] = hm1.get(genre).get(0);
//            if (hm1.get(genre).size() == 2)
//                result[i+1] = hm1.get(genre).get(1);
//
//            i+=2;
//        }
//        return result;
//
//    }





}
