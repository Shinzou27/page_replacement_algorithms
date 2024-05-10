import java.util.HashMap;
import java.util.Map;

public class Aging implements Algorithm {
    private Map<Page, Integer> counters = new HashMap<>();
    private int time = 0;
    private static final int N = 50; 

    @Override
    public void execute(Memory memory, Page[] pages, String[] operations) {
        for (String operation : operations) {
            time++;
            for (Page page : pages) {
                if (operation.equals(page.getValue())) {
                    if (memory.has(page)) {
                        page.setBitR(1);
                    } else {
                        Page pageToReplace = findPageToReplace();
                        memory.replace(pageToReplace, page, time);
                        counters.put(page, 128); 
                    }
                }
            }

            // Periodically update counters
            if (time % N == 0) {
                for (Page page : memory.getMemory()) { 
                    int counter = counters.get(page);
                    counter = (counter >> 1) + (128 * page.getBitR());
                    counters.put(page, counter);
                    page.setBitR(0);
                }
            }
        }
    }

    private Page findPageToReplace() {
        Page pageToReplace = null;
        int minCounter = Integer.MAX_VALUE;

        for (Map.Entry<Page, Integer> entry : counters.entrySet()) {
            if (entry.getValue() < minCounter) {
                minCounter = entry.getValue();
                pageToReplace = entry.getKey();
            }
        }

        return pageToReplace;
    }
}