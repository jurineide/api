package they.tech.api.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class PizzaDemand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    private Integer quantity;

    @OneToOne
    private Demand demand;

    @OneToOne
    private  Pizza pizza;

    @OneToOne
    private Size size;

    @ManyToMany
    private List<Ingredient> ingredient;


    public PizzaDemand(Long idPizzaDemand){

    }

}
