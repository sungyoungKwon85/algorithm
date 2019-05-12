package wb;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution2 {

    public String solution(String S) {

        List<JohnImage> johnImageList = getJohnImageListFromString(S);

        StringBuilder stringBuilder = new StringBuilder();
        for (JohnImage image : johnImageList) {
            stringBuilder.append(image.getCity())
                .append(image.getSequence())
                .append(".")
                .append(image.getExtension())
                .append("\n");
        }
        
        return stringBuilder.toString();
    }

    private List<JohnImage> getJohnImageListFromString(String s) {

        List<JohnImage> johnImageList = new ArrayList<>();

        String[] imageArray = s.split("[\\r\\n]+");
        for (String image : imageArray) {
            String[] infos = image.split(", ");
            String[] nameAndExtension = infos[0].split("\\.");

            JohnImage johnImage = new JohnImage();
            johnImage.setTitle(nameAndExtension[0]);
            johnImage.setExtension(nameAndExtension[1]);
            johnImage.setCity(infos[1]);
            johnImage.setDate(getDateFromString(infos[2]));

            johnImageList.add(johnImage);
        }

        Set<String> citySet = johnImageList.stream()
            .map(image -> image.getCity())
            .collect(Collectors.toSet());

        for (String city : citySet) {
            List<JohnImage> byCityList = johnImageList.stream()
                .filter(image -> image.getCity().equals(city))
                .collect(Collectors.toList());

            Collections.sort(byCityList, Comparator.comparing(JohnImage::getDate));

            for (int i = 0; i < byCityList.size(); i++) {
                byCityList.get(i).setSequence(String.valueOf(i+1));
                for (int j = String.valueOf(i+1).length(); j < String.valueOf(byCityList.size()).length(); j++) {
                    byCityList.get(i).setSequence("0" + byCityList.get(i).getSequence());
                }
            }

        }

        return johnImageList;
    }

    private Date getDateFromString(String stringDate) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            return simpleDateFormat.parse(stringDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return new Date();
    }

    class JohnImage {

        private String sequence;
        private String sequenceString;
        private String title;
        private String city;
        private Date date;
        private String extension;

        public String getSequence() {
            return sequence;
        }
        
        public String getTitle() {
            return title;
        }

        public String getCity() {
            return city;
        }

        public Date getDate() {
            return date;
        }

        public String getExtension() {
            return extension;
        }

        public void setSequence(String sequence) {
            this.sequence = sequence;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public void setDate(Date date) {
            this.date = date;
        }

        public void setExtension(String extension) {
            this.extension = extension;
        }
    }

    public static void main(String[] args) {

        String input=
            "photo.jpg, Warsaw, 2013-09-05 14:08:15\n" +
            "john.png, London, 2015-06-20 15:13:22\n" +
            "myFriends.png, Warsaw, 2013-09-05 14:07:13\n" +
            "Eiffel.jpg, Paris, 2015-07-23 08:03:02\n" +
            "pisatower.jpg, Paris, 2015-07-22 23:59:59\n" +
            "BOB.jpg, London, 2015-08-05 00:02:03\n" +
            "notredame.png, Paris, 2015-09-01 12:00:00\n" +
            "me.jpg, Warsaw, 2013-09-06 15:40:22\n" +
            "a.png, Warsaw, 2016-02-13 13:33:50\n" +
            "b.jpg, Warsaw, 2016-01-02 15:12:22\n" +
            "c.jpg, Warsaw, 2016-01-02 14:34:30\n" +
            "d.jpg, Warsaw, 2016-01-02 15:15:01\n" +
            "e.png, Warsaw, 2016-01-02 09:49:09\n" +
            "f.png, Warsaw, 2016-01-02 10:55:32\n" +
            "g.jpg, Warsaw, 2016-02-29 22:13:11";

        new Solution2().solution(input);

        String output =
            "Warsaw02.jpg\n" +
            "London1.png\n" +
            "Warsaw01.png\n" +
            "Paris2.jpg\n" +
            "Paris1.jpg\n" +
            "London2.jpg\n" +
            "Paris3.png\n" +
            "Warsaw03.jpg\n" +
            "Warsaw09.png\n" +
            "Warsaw07.jpg\n" +
            "Warsaw06.jpg\n" +
            "Warsaw08.jpg\n" +
            "Warsaw04.png\n" +
            "Warsaw05.png\n" +
            "Warsaw10.jpg\n";
    }
}


