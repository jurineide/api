 package they.tech.api.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Demand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String open_demand;

    @OneToOne
    private Client client;

    @OneToOne
    private Batch batch;

    @OneToOne
    private DrinkDemand drinkDemand;

    public Demand(Long idDemand){

    }

}
