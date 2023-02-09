package repository;

import domain.Car;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CarRepository {

    private List<Car> cars;
    private Map<String, Integer> nameCount;

    public CarRepository() {
        cars = new ArrayList<>();
        nameCount = new HashMap<>();
    }

    public List<Car> findAll() {
        return Collections.unmodifiableList(cars);
    }

    private int addName(String name) {
        final int INIT_NUMBER = 0;
        if (!nameCount.containsKey(name)) {
            nameCount.put(name, INIT_NUMBER);
            return INIT_NUMBER;
        }
        return nameCount.merge(name, 1, Integer::sum);
    }

    public void add(String name) {
        Car car = new Car(name, addName(name));
        cars.add(car);
    }
}