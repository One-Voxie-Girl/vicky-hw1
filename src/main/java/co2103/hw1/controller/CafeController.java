package co2103.hw1.controller;

import co2103.hw1.Hw1Application;
import co2103.hw1.domain.Cafe;
import co2103.hw1.domain.CafeValidator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class CafeController {
    public Cafe cafe;


    @RequestMapping("/cafes")
    public String showCafe(Model model) {
        model.addAttribute("cafes",Hw1Application.cafes);
        return "cafes/list";
    }

    @InitBinder
    protected void initBinder(WebDataBinder binder){
        binder.addValidators(new CafeValidator());
    }


    @RequestMapping("/newCafe")
    public String newCafe(@ModelAttribute Cafe cafe, Model model){

        model.addAttribute("cafe",cafe);
        return "cafes/form";
    }

    @RequestMapping(value = "/addCafe", method = RequestMethod.POST)
    public String addCafe(@Valid @ModelAttribute Cafe cafe,BindingResult result,Model model){
        if (result.hasErrors()){
            model.addAttribute("cafe",cafe);
            return "cafes/form";
        }
        Hw1Application.cafes.add(cafe);
        return "redirect:/cafes";
    }





}
