package kodlama.io.rentacar.business.concretes;

import kodlama.io.rentacar.business.abstracts.CarService;
import kodlama.io.rentacar.business.abstracts.MaintenanceService;
import kodlama.io.rentacar.business.dto.requests.create.CreateCarRequest;
import kodlama.io.rentacar.business.dto.requests.create.CreateMaintenanceRequest;
import kodlama.io.rentacar.business.dto.requests.update.UpdateCarRequest;
import kodlama.io.rentacar.business.dto.responses.create.CreateCarResponse;
import kodlama.io.rentacar.business.dto.responses.get.GetAllCarsResponse;
import kodlama.io.rentacar.business.dto.responses.get.GetCarResponse;
import kodlama.io.rentacar.business.dto.responses.update.UpdateCarResponse;
import kodlama.io.rentacar.entities.concretes.Car;
import kodlama.io.rentacar.entities.concretes.enums.State;
import kodlama.io.rentacar.repository.abstracts.CarRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CarManager implements CarService {
    private final CarRepository repository;
    private final ModelMapper mapper;
    @Override
    public List<GetAllCarsResponse> getAll(boolean includeMaintenance) {

        List<Car> cars = filterCarsByMaintenanceState(includeMaintenance);
        List<GetAllCarsResponse> response = cars
                .stream()
                .map(car -> mapper.map(car, GetAllCarsResponse.class))
                .toList();

        return response;
    }

    @Override
    public GetCarResponse getById(int id) {
        checkIfCarExistsById(id);
        Car car = repository.findById(id).orElseThrow();
        GetCarResponse response = mapper.map(car,GetCarResponse.class);
        return response;
    }

    @Override
    public CreateCarResponse add(CreateCarRequest request) {
        Car car = mapper.map(request,Car.class);
        car.setId(0);
        car.setState(State.AVAILABLE);
        Car createdCar = repository.save(car);

        CreateCarResponse response = mapper.map(createdCar,CreateCarResponse.class);
        return response;
    }

    @Override
    public UpdateCarResponse update(int id, UpdateCarRequest request) {
        checkIfCarExistsById(id);
        Car car = mapper.map(request,Car.class);
        car.setId(id);
        repository.save(car);

        UpdateCarResponse response = mapper.map(car,UpdateCarResponse.class);
        return response;
    }

    @Override
    public void delete(int id) {
        checkIfCarExistsById(id);
        repository.deleteById(id);
    }

    @Override
    public void changeState(int carId, State state) {
        Car car= repository.findById(carId).orElseThrow();
        car.setState(state);
        repository.save(car);
    }

    private void checkIfCarExistsById(int id){
        if(!repository.existsById(id)) throw new RuntimeException("Böyle bir araba mevcut değil!");
    }

    private List<Car> filterCarsByMaintenanceState(boolean includeMaintenance){
        if(includeMaintenance){
            return repository.findAll();
        }
        return repository.findAllByStateIsNot(State.MAINTENANCE);
    }
}
