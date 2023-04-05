package kodlama.io.rentacar.business.dto.responses.create;

import kodlama.io.rentacar.entities.concretes.enums.State;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateCarResponse {

    private int id;
    private int modelId;
    private int modelYear;
    private String plate;
    private double dailyPrice;
    private State state;
}
