public interface Algorithm {
    void execute(Memory memory, Page[] pages, String[] operations);
    default void describeStep(String step) {
        System.out.println(step);
    };
}
