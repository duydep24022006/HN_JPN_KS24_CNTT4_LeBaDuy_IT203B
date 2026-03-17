package COMMAND_OBSERVER_B4;

public interface Subject {
    void attach(Observer o);// dko thiet bi theo doi

    void detach(Observer o);// huy dki

    void notifyObservers(); // tbao tat ca thiet bi

}
