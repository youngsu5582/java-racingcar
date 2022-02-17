package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.controller.GameController;
import racingcar.util.FixedNumberGenerator;
import racingcar.util.NumberGenerator;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest {
    private final GameController gameController = new GameController();

    @Test
    @DisplayName("자동차 이름이 5자 이상인 경우 예외처리")
    void exceededMaxCarNameLengthException() {
        String name = "qwerty";
        assertThatThrownBy(() -> new Car(new Name(name)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("5자 이하");
    }

    @Test
    @DisplayName("자동차 객체 생성")
    void createCarObject() {
        List<Name> actual = Stream.of("bom", "sun")
                .map(Name::new)
                .collect(Collectors.toList());

        Cars cars = gameController.initCars(actual);
        List<Name> expected = cars.getCars().stream()
                .map(Car::getName)
                .collect(Collectors.toList());

        assertThat(expected).isEqualTo(actual);
    }

    @ParameterizedTest
    @DisplayName("특정 값을 통한 자동차 비전진 확인")
    @ValueSource(ints = {0, 1, 2, 3})
    void notMoveTest(int num) {
        NumberGenerator numberGenerator = new FixedNumberGenerator(num);
        Car car = new Car(new Name("sun"));
        car.move(numberGenerator);
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @ParameterizedTest
    @DisplayName("특정 값을 통한 자동차 전진 확인")
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void moveTest(int num) {
        NumberGenerator numberGenerator = new FixedNumberGenerator(num);
        Car car = new Car(new Name("sun"));
        car.move(numberGenerator);
        assertThat(car.getPosition()).isEqualTo(1);
    }
}