package kodlama.io.rentacar.business.dto.requests.create;

import kodlama.io.rentacar.entities.concretes.State;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateCarRequest {
    private int modelId;
    private String name;
    private State state=State.AVAILABLE;
}
