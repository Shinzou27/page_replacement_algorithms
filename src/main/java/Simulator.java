import java.util.ArrayList;

public class Simulator {
    public static void main(String[] args) {
        int operationLength = 50;
        int memoryCapacity = 5;
        int pageAmount = 10;
        String[] mockValues = {"B","E","F","F","B","G","C","A","B","A","C","D","D","J","C","F","I","D","H","D","E","B","D","D","E","G","D","A","C","J","J","H","H","E","B","G","G","F","H","B","G","C","D","D","C","A","A","A","D","I"};


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
        fifo.execute(memory, mockPagesToBeReferenced, operations);
        lru.execute(memory, mockPagesToBeReferenced, operations);
    }
}
