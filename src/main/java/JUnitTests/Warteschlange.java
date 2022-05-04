package JUnitTests;

import java.util.NoSuchElementException;

public interface Warteschlange extends Speicher{
    public int front() throws NoSuchElementException;
}
