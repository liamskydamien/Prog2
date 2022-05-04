package JUnitTests;

import java.util.NoSuchElementException;

public interface Kellerspeicher extends Speicher {
    public int top() throws NoSuchElementException;
}
