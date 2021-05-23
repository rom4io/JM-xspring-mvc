package web.Service;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.Model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CarService {

    private List<Car> cars = new ArrayList<>();

    public CarService(){
        cars.add(new Car("Tesla", 2020, "Black"));
        cars.add(new Car("Toyota", 1995, "Blue"));
        cars.add(new Car("Pontiac", 1947, "White"));
        cars.add(new Car("Lada", 1986, "Green"));
        cars.add(new Car("Ford", 2007, "Grey"));
    }

    public List<Car> getAllCars(){
        return cars;
    }

    public List<Car> getCountCars(@RequestParam(value = "count", required = false) Integer count){
        return cars.stream().limit(count).collect(Collectors.toList());
    }
}
