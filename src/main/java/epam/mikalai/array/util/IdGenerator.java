package epam.mikalai.array.util;

public class IdGenerator {
    private static int currentId;
    public static int increment() {
        return ++currentId;
    }
}
