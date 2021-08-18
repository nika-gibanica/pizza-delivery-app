package com.agency04.sbss.pizza;

import com.agency04.sbss.pizza.service.PizzeriaOneService;
import com.agency04.sbss.pizza.service.PizzeriaService;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan("com.agency04.sbss.pizza.*")
@PropertySource("classpath:application.properties")
public class PizzaConfig {

    @Bean
    public PizzeriaOneService pizzeriaOne(){
        return new PizzeriaOneService();
    }
}
