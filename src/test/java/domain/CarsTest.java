package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
public class CarsTest {
    @Test
    @DisplayName("자동차 이름 목록을 통해 자동차 목록을 포함한 일급객체를 만든다.")
    void createCars(){
        List<Name> names = List.of(new Name("pond"),new Name("poby"));
        CarNameCatalog carNameCatalog = new CarNameCatalog(names);

        Cars cars = Cars.from(carNameCatalog);

        assertInstanceOf(Cars.class,cars);
        cars.getValue().forEach(car -> assertInstanceOf(Car.class,car));

    }

}