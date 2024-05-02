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
    public void insert(Page page, int time) {
        this.pages.add(page);
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
    public void cleanStorage() {
        this.pages.clear();
    }
    public void storageState() {
        for (Page page: this.pages) {
            System.out.print(page.getValue() + " | ");
        }
        System.out.println();
    }
}
