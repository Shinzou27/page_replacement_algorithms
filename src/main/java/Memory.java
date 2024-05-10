import java.util.ArrayList;

public class Memory {
    private ArrayList<Page> pages;
    private int capacity;

    public Memory(int capacity) {
        this.capacity = capacity;
        this.pages = new ArrayList<>();
    }

    public ArrayList<Page> getMemory() {
        return this.pages;
    }
    public void replace(Page enterPage, Page exitPage, int time) {
        int index = pages.indexOf(exitPage);
        this.insert(enterPage, index, time);
        this.remove(exitPage);
    }

    public void replaceClock(Page oldPage, Page newPage, int time) {
        int index = pages.indexOf(oldPage);
        if (index != -1) {
            pages.set(index, newPage);
        } else {
            // Se a página antiga não estiver na lista, remove a primeira página e adiciona a nova página
            pages.remove(0);
            pages.add(newPage);
        }
    }
    public void insert(Page page, int time) {
        this.pages.add(page);
        System.out.println(time);
        page.setTimeInserted(time);
    }
    public void insert(Page page, int index, int time) {
        this.pages.add(index, page);
        page.setTimeInserted(time);
    }
    public void remove(Page page) {
        this.pages.remove(page);
    }
    public boolean has(Page page) {
        return this.pages.contains(page);
    }
    public boolean isFull() {
        return this.pages.size() == this.capacity;
    }
    public Page getLastUsedPage() {
        Page toReturnPage = null;
        for (Page page: pages) {
            if (toReturnPage == null) {
                toReturnPage = page;
            } else if (toReturnPage.getLastTimeUsed() > page.getLastTimeUsed()) {
                toReturnPage = page;
            }
        }
        return toReturnPage;
    }
    public Page getPageAt(int index) {
        return pages.get(index);
    }

    public Page getOldestPage() {
        Page toReturnPage = null;
        for (Page page: pages) {
            if (toReturnPage == null) {
                toReturnPage = page;
            } else if (toReturnPage.getTimeInserted() > page.getTimeInserted()) {
                toReturnPage = page;
            }
        }
        return toReturnPage;
    }
    public Page getLeastReferencedPage() {
        Page toReturnPage = null;
        for (Page page: pages) {
            if (toReturnPage == null) {
                toReturnPage = page;
            } else if (toReturnPage.getTimesUsed() > page.getTimesUsed()) {
                toReturnPage = page;
            }
        }
        return toReturnPage;
    }
    public void cleanStorage() {
        this.pages.clear();
    }
    public void storageState() {
        for (Page page: this.pages) {
            System.out.print(page.getValue() + " | ");
        }
        System.out.println();
    }

    public int getCapacity() {
        return capacity;
    }
}
