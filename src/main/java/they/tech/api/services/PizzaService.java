package they.tech.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import they.tech.api.dtos.PizzaDTO;
import they.tech.api.models.Pizza;
import they.tech.api.repositories.PizzaRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PizzaService {
    @Autowired
    private PizzaRepository pizzaRepository;

    public PizzaDTO save(PizzaDTO dto) {
      Pizza pizza = PizzaDTO.convert(dto);
        pizza = this.pizzaRepository.save(pizza);
      return new PizzaDTO(pizza);
    }

    public List<PizzaDTO> findAll() {
        List<Pizza>pizza = this.pizzaRepository.findAll();
        return pizza.stream().map(PizzaDTO::new).collect(Collectors.toList());
    }

    public String deleteById(Long id) {
        PizzaDTO dto = findByID(id);
        this.pizzaRepository.deleteById(id);
        return ("A pixxa de Id " + dto.getId() + " foi excluída");
    }

    public PizzaDTO findByID(Long id) {
        Optional<Pizza> pizza = this.pizzaRepository.findById(id);
        if(pizza.isEmpty()){
            throw new RuntimeException("Cliente não encontrado");
        }else{
            return new PizzaDTO(pizza.get());
        }
    }

    public PizzaDTO updateById(Long id, PizzaDTO dto) {
        this.findByID(id);
        Pizza pizza = PizzaDTO.convert(dto);
        pizza.setId(id);
        this.pizzaRepository.save(pizza);
        return new PizzaDTO(pizza);
    }
}
