package kodlama.io.rentacar.business.dto.requests.update;

import kodlama.io.rentacar.entities.concretes.enums.State;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCarRequest {
    private int modelId;
    private int modelYear;
    private String plate;
    private double dailyPrice;
    private State state;
}
