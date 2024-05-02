public class LRU implements Algorithm {
    private int pageFaults = 0;
    @Override
    public void execute(Memory memory, Page[] pages, String[] operations) {
        memory.cleanStorage();
        for (int i = 0; i < operations.length; i++) {
            Page page = pages[i];
            if (!memory.has(page)) {
                this.pageFaults++;
                if (memory.isFull()) {
                    Page lastUsed = memory.getLastUsedPage();
                    memory.replace(page, lastUsed, i);
                    this.describeStep("A página " + page.getValue() + " foi inserida no lugar da página " + lastUsed.getValue() + ".");
                } else {
                    memory.insert(page, i);
                    this.describeStep("A página " + page.getValue() + " foi inserida em uma posição livre da memória.");
                }
            } else {
                this.describeStep("Página " + page.getValue() + " está na memória.");
            }
            page.setLastTimeUsed(i);
            memory.storageState();
        }
        System.out.println("Total de faltas de página: " + this.pageFaults);
    }
}
