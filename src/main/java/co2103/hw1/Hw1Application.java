package co2103.hw1;

import co2103.hw1.domain.Cafe;
import co2103.hw1.domain.Cake;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class Hw1Application {

    static Cake cake1=new Cake();
    static Cake cake2=new Cake();
    static Cafe cafe = new Cafe();
    public static List<Cafe> cafes = new ArrayList<>();

    public static void main(String[] args) {


        cake1.setName("sponge cake");
        cake1.setDescription("sponge");
        cake1.setIngredients("sponge");
        cake1.setAmount(18);
        cake2.setName("chocolate cake");
        cake2.setDescription("choc");
        cake2.setIngredients("chocolate");
        cake2.setAmount(30);
        cafe.setId(1);
        cafe.setName("cake box");
        cafe.setAddress("11, generic road");
        cafe.setCakes(Arrays.asList(cake1,cake2));

        cafes.add(cafe);

        SpringApplication.run(Hw1Application.class, args);
    }

}










