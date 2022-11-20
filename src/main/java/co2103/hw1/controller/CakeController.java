package co2103.hw1.controller;

import co2103.hw1.Hw1Application;
import co2103.hw1.domain.Cafe;
import co2103.hw1.domain.CafeValidator;
import co2103.hw1.domain.Cake;
import co2103.hw1.domain.CakeValidator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;


@Controller
public class CakeController {


    public int getCafeIndex(int cafeId){
        for (int i = 0; i < Hw1Application.cafes.size(); i++) {
            if(cafeId == Hw1Application.cafes.get(i).getId()){
                return i;



            }
        }


        return -1;
    }


    @RequestMapping(value = "/cakes",method = RequestMethod.GET)
    public String showCake(Model model, @RequestParam(value = "cafe") int cafe) {




        model.addAttribute("cakes", Hw1Application.cafes.get(getCafeIndex(cafe)).getCakes());
        model.addAttribute("cafe",cafe);
        return "cakes/list";


    }



    @RequestMapping("/newCake")
    public String newCake(@ModelAttribute Cake cake, Model model, @RequestParam(value = "cafe") int cafe){
        model.addAttribute("cake",cake);
        model.addAttribute("cafe",cafe);
        return "cakes/form";
    }

    @InitBinder
    protected void initBinder(WebDataBinder binder){
        binder.addValidators(new CakeValidator());
    }


    @RequestMapping(value = "/addCake", method = RequestMethod.POST)
    public String addCake(@Valid @ModelAttribute Cake cake, BindingResult result,Model model, @RequestParam(value = "cafe") int cafe){
        if (result.hasErrors()){
            model.addAttribute("cake",cake);
            model.addAttribute("cafe",cafe);
            return "cakes/form";
        }
        List<Cake> cakes = new ArrayList<>();
        for (int i = 0; i < Hw1Application.cafes.size(); i++) {
            cakes.add(Hw1Application.cafes.get(getCafeIndex(cafe)).getCakes().get(i));

        }

        cakes.add(cake);

        Hw1Application.cafes.get(getCafeIndex(cafe)).setCakes(cakes);

        return "redirect:/cafes";
    }




}
