package they.tech.api.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import they.tech.api.models.Pizza;

import java.util.Optional;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class PizzaDTO {
    private Long id;
    private String namePizza;
    private Float base_price;
    private Boolean personalized;
    public PizzaDTO(Long id){
    }
    //construtor que recebe  a entidade Client que será convertido em dto
    public PizzaDTO(Pizza pizza){
        this.id = pizza.getId();
        this.namePizza = pizza.getNamePizza();
        this.base_price = pizza.getBase_price();
        this.personalized = pizza.getPersonalized();
    }

    public PizzaDTO(Optional<Pizza> pizza) {
    }

    //converte ClientDTO para Client
    public static Pizza convert(PizzaDTO pizzaDTO){

        Pizza pizza = new Pizza(pizzaDTO.getId());
        pizza.setId(pizzaDTO.getId());
        pizza.setNamePizza(pizzaDTO.getNamePizza());
        pizza.setBase_price(pizzaDTO.getBase_price());
        pizza.setPersonalized(pizzaDTO.getPersonalized());
        return pizza;
    }

    public Long getId() {
        return id;
    }


}
