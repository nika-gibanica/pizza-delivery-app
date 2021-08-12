package com.agency04.sbss.pizza;

import com.agency04.sbss.pizza.service.PizzeriaOneService;
import com.agency04.sbss.pizza.service.PizzeriaService;
import org.springframework.context.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan("com.agency04.sbss.pizza.*")
@PropertySource("classpath:application.properties")
public class PizzaConfig {

    @Bean
    public PizzeriaOneService pizzeriaOne(){
        return new PizzeriaOneService();
    }
}
