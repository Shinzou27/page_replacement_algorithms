public class Page {
    private int id;
    private String value;
    private int lastTimeUsed;
    private int timeInserted;
    private int bitR;
    private  int bitM;

    public Page(int id, String value) {
        this.id = id;
        this.value = value;
        this.lastTimeUsed = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getLastTimeUsed() {
        return lastTimeUsed;
    }

    public int getTimeInserted() {
        return timeInserted;
    }

    public void setTimeInserted(int timeInserted) {
        this.timeInserted = timeInserted;
    }

    public int getBitR() {
        return bitR;
    }

    public void setBitR(int bitR) {
        this.bitR = bitR;
    }

    public int getBitM() {
        return bitM;
    }

    public void setBitM(int bitM) {
        this.bitM = bitM;
    }

    public void setLastTimeUsed(int lastTimeUsed) {
        this.lastTimeUsed = lastTimeUsed;
    }

    @Override
    public String toString() {
        return "Página " + id + " | " + value;
    }
}
