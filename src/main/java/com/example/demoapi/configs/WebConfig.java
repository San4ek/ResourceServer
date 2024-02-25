package com.example.demoapi.configs;

import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
@EnableSpringDataWebSupport
public class WebConfig implements WebMvcConfigurer {

    /*@Bean
    public ApplicationRunner dataLoader(IngredientRepository ingrRepo, TacoRepository tacoRepo) {
        return args -> {
            ingrRepo.save(new Ingredient("FLTO", "Flour Tortilla", Ingredient.Type.WRAP));
            ingrRepo.save(new Ingredient("COTO", "Corn Tortilla", Ingredient.Type.WRAP));
            ingrRepo.save(new Ingredient("GRBF", "Ground Beef", Ingredient.Type.PROTEIN));
            ingrRepo.save(new Ingredient("CARN", "Carnitas", Ingredient.Type.PROTEIN));
            ingrRepo.save(new Ingredient("TMTO", "Diced Tomatoes", Ingredient.Type.VEGGIES));
            ingrRepo.save(new Ingredient("LETC", "Lettuce", Ingredient.Type.VEGGIES));
            ingrRepo.save(new Ingredient("CHED", "Cheddar", Ingredient.Type.CHEESE));
            ingrRepo.save(new Ingredient("JACK", "Monterrey Jack", Ingredient.Type.CHEESE));
            ingrRepo.save(new Ingredient("SLSA", "Salsa", Ingredient.Type.SAUCE));
            ingrRepo.save(new Ingredient("SRCR", "Sour Cream", Ingredient.Type.SAUCE));

            List<Ingredient> ingredients= (List<Ingredient>) ingrRepo.findAll();

            Taco taco=new Taco();
            taco.setName("Taco1");
            taco.setIngredients(ingredients);

            tacoRepo.save(taco);
        };
    }*/
}
