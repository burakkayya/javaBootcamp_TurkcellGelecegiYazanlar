package kodlama.io.rentacar.business.dto.responses.create;

import kodlama.io.rentacar.entities.concretes.State;
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
    private String name;
    private State state;
}
