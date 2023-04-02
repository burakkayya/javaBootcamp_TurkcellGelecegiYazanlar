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
import kodlama.io.rentacar.entities.concretes.Maintenance;
import kodlama.io.rentacar.entities.concretes.State;
import kodlama.io.rentacar.repository.abstracts.CarRepository;
import kodlama.io.rentacar.repository.abstracts.MaintenanceRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CarManager implements CarService {
    CarRepository carRepository;
    MaintenanceService maintenanceService;
    ModelMapper mapper;
    @Override
    public List<GetAllCarsResponse> getAll() {
        List<Car> cars= carRepository.findAll();
        List<GetAllCarsResponse> responses = cars
                .stream()
                .map(car -> mapper.map(car,GetAllCarsResponse.class))
                .toList();
        return responses;
    }

    @Override
    public GetCarResponse getById(int id) {
        checkIfCarExistsById(id);
        Car car = carRepository.findById(id).orElseThrow();
        GetCarResponse response = mapper.map(car,GetCarResponse.class);
        return response;
    }

    @Override
    public CreateCarResponse add(CreateCarRequest request) {
        checkIfCarExistByName(request.getName());
        Car car = mapper.map(request,Car.class);
        car.setId(0);
        Car createdCar = carRepository.save(car);

        CreateCarResponse response = mapper.map(createdCar,CreateCarResponse.class);
        return response;
    }

    @Override
    public UpdateCarResponse update(int id, UpdateCarRequest request) {
        checkIfCarExistsById(id);
        Car car = mapper.map(request,Car.class);
        car.setId(id);
        carRepository.save(car);

        UpdateCarResponse response = mapper.map(car,UpdateCarResponse.class);
        return response;
    }

    @Override
    public void delete(int id) {
        checkIfCarExistsById(id);
        carRepository.deleteById(id);
    }

    @Override
    public UpdateCarResponse sendToService(int carId) {
        Car car = carRepository.findById(carId).orElseThrow();

        if(car.getState().toString()=="AVAILABLE") {
            CreateMaintenanceRequest request = new CreateMaintenanceRequest(carId);
            maintenanceService.add(request);
            car.setState(State.MAINTENANCE);
            UpdateCarResponse response = mapper.map(car,UpdateCarResponse.class);
            return response;
        }
        else{
            throw new RuntimeException("Araç bakıma gönderilemez!");
        }
    }

    @Override
    public UpdateCarResponse getBackFromService(int carId) {

        return null;
    }

    private void checkIfCarExistByName(String name){
        if(carRepository.existsByNameIgnoreCase(name)) throw new RuntimeException("Böyle bir araba sistemde kayıtlı!");
    }

    private void checkIfCarExistsById(int id){
        if(!carRepository.existsById(id)) throw new RuntimeException("Böyle bir araba mevcut değil!");
    }
}
