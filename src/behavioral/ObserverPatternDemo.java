package behavioral;

import java.util.*;

interface Observer {
    void update(float temperature);
}

class WeatherStation {
    private List<Observer> observers = new ArrayList<>();
    private float temperature;

    public void addObserver(Observer obs) { observers.add(obs); }
    public void removeObserver(Observer obs) { observers.remove(obs); }

    public void setTemperature(float temp) {
        this.temperature = temp;
        notifyObservers();
    }

    private void notifyObservers() {
        for (Observer obs : observers) {
            obs.update(temperature);
        }
    }
}

class PhoneDisplay implements Observer {
    private String name;
    public PhoneDisplay(String name) { this.name = name; }
    public void update(float temperature) {
        System.out.println(name + " shows temperature: " + temperature + "°C");
    }
}

public class ObserverPatternDemo {
    public static void main(String[] args) {
        WeatherStation station = new WeatherStation();
        Observer phone1 = new PhoneDisplay("Phone1");
        Observer phone2 = new PhoneDisplay("Phone2");

        station.addObserver(phone1);
        station.addObserver(phone2);

        station.setTemperature(25);
        station.setTemperature(30);
    }
}
