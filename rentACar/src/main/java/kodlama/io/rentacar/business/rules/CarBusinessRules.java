package kodlama.io.rentacar.business.rules;

import kodlama.io.rentacar.common.constants.Messages;
import kodlama.io.rentacar.core.exceptions.BusinessException;
import kodlama.io.rentacar.repository.abstracts.CarRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.MethodArgumentNotValidException;

@AllArgsConstructor
@Service
public class CarBusinessRules {
    private final CarRepository repository;
    public void checkIfCarExistsById(int id){
        if(!repository.existsById(id)) throw new BusinessException(Messages.Car.NotExists);
    }

    public void checkIfCarExistsByPlate(String plate){
        throw new BusinessException(Messages.Car.PlateExists);
    }
}
