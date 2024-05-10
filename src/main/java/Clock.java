import java.util.List;

public class Clock implements Algorithm {
    private int pageFaults = 0;
    private int pointer = 0;

    @Override
    public void execute(Memory memory, Page[] pages, String[] operations) {
        memory.cleanStorage();
        for (int i = 0; i < operations.length; i++) {
            Page page = pages[i];
            if (!memory.has(page)) {
                this.pageFaults++;
                if (memory.isFull()) {
                    // Encontra a página mais antiga sem referência
                    while (true) {
                        if (pages[pointer].getBitR() == 0) {
                            break;
                        } else {
                            pages[pointer].setBitR(0);
                            pointer = (pointer + 1) % pages.length;
                        }
                    }
                    Page oldestPage = pages[pointer];
                    this.describeStep("A página " + page.getValue() + " foi inserida no lugar da página " + oldestPage.getValue() + ".");
                    memory.replaceClock(oldestPage, page, i);
                    pointer = (pointer + 1) % pages.length;
                } else {
                    memory.insert(page, i);
                    this.describeStep("A página " + page.getValue() + " foi inserida em uma posição livre da memória.");
                }
            } else {
                // Atualiza o bit de referência da página
                page.setBitR(1);
                this.describeStep("Página " + page.getValue() + " está na memória.");
            }
            memory.storageState();
        }
        System.out.println("Total de faltas de página: " + this.pageFaults);
    }
}
