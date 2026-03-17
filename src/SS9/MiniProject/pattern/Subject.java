package SS9.MiniProject.pattern;

public interface Subject {
    void register(Observer o);
    void remove(Observer o);
    void notifyObservers();
}