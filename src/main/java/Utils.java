import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public class Utils {
    public static String generatePageValue(int i) {
        if (i > 26) {
            char first = (char) ('A' + (i / 26));
            char second = (char) ('A' + (i % 26));
            return String.valueOf(first) + second;
        } else {
            char value = (char) ('A' + (i % 26));
            return String.valueOf(value);
        }
    }
    public static ArrayList<Page> generatePages(int length) {
        ArrayList<Page> pages = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            Page page = new Page(i, Utils.generatePageValue(i));
            pages.add(page);
            System.out.println(page);
        }
        return pages;
    }
    public static String[] generateWriteReadOrder(int length) {
        String[] array = new String[length];
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            int randomizedNumber = random.nextInt(2);
            if (randomizedNumber == 0) {
                array[i] = "W";
            } else {
                array[i] = "R";
            }
        }

        return array;
    }
    public static Page[] generatePageReferenceListFromArray(int length, ArrayList<Page> pages, String[] values) {
        Page[] array = new Page[length];
        for (int i = 0; i < length; i++) {
            for (Page page: pages) {
                if (Objects.equals(page.getValue(), values[i])) {
                    array[i] = page;
                }
            }
        }
        return array;
    }
    public static Page[] generatePageReferenceList(int length, ArrayList<Page> pages) {
        Page[] array = new Page[length];
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            int randomizedNumber = random.nextInt(pages.size());
            array[i] = pages.get(randomizedNumber);
        }
        return array;
    }
}
