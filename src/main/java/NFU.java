public class NFU implements Algorithm{
    private int pageFaults = 0;
    @Override
    public void execute(Memory memory, Page[] pages, String[] operations) {
        memory.cleanStorage();
        for (int i = 0; i < operations.length; i++) {
            Page page = pages[i];
            page.setTimesUsed(page.getTimesUsed()+1);
            if (!memory.has(page)) {
                this.pageFaults++;
                if (memory.isFull()) {
                    Page leastReferencedPage = memory.getLeastReferencedPage();
                    this.describeStep("A página " + page.getValue() + " foi inserida no lugar da página " + leastReferencedPage.getValue() + ".");
                    memory.replace(page, leastReferencedPage, i);
                } else {
                    memory.insert(page, i);
                    this.describeStep("A página " + page.getValue() + " foi inserida em uma posição livre da memória.");
                }
            } else {
                this.describeStep("Página " + page.getValue() + " está na memória.");
            }
            memory.storageState();
        }
        System.out.println("Total de faltas de página: " + this.pageFaults);
    }
}
