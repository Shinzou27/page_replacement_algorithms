import java.util.ArrayList;

public class Simulator {
    public static void main(String[] args) {
        int operationLength = 50;
        int memoryCapacity = 5;
        int pageAmount = 10;
        String[] mockValues = {"F","I","J","G","I","B","C","F","C","B","E","A","G","E","C","C","G","I","F","E","D","G","I","A","B","I","A","H","B","E","B","H","J","C","F","G","G","E","G","D","J","J","C","I","E","H","B","B","C","I"};

        Algorithm fifo = new FIFO();
        Algorithm lru = new LRU();
        Algorithm nfu = new NFU();
        Algorithm clock = new Clock();
        Algorithm aging = new Aging();

        Memory memory = new Memory(memoryCapacity);
        ArrayList<Page> pages = Utils.generatePages(pageAmount);
        String[] operations = Utils.generateWriteReadOrder(operationLength);
        Page[] pagesToBeReferenced = Utils.generatePageReferenceList(operationLength, pages);
        Page[] mockPagesToBeReferenced = Utils.generatePageReferenceListFromArray(operationLength, pages, mockValues);


//        for (String op:
//             operations) {
//            System.out.print(op + " ");
//        }
//        System.out.println();
//        for (Page pg:
//                pagesToBeReferenced) {
//            System.out.print(pg.getValue() + " ");
//        }
//        fifo.execute(memory, mockPagesToBeReferenced, operations);
//        lru.execute(memory, mockPagesToBeReferenced, operations);
//        nfu.execute(memory, mockPagesToBeReferenced, operations);
        clock.execute(memory, mockPagesToBeReferenced, operations);
    }
}
