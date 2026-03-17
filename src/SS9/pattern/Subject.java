package SS9.pattern;

public interface Subject {
    void register(Observer o);
    void remove(Observer o);
    void notifyObservers();
}