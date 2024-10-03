import java.util.ArrayList;
import java.util.List;

interface Observer {
    void update(String item);
}

class StockObserver implements Observer {
    private String name;

    public StockObserver(String name) {
        this.name = name;
    }

    @Override
    public void update(String item) {
        System.out.println("Notificacao para " + name + ": O item " + item + " esta agora disponivel!");
    }
}

class ItemNotifier {
    private List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void notifyObservers(String item) {
        for (Observer observer : observers) {
            observer.update(item);
        }
    }

    public void itemBackInStock(String item) {
        notifyObservers(item);
    }
}