package co2103.hw1.domain;



import co2103.hw1.Hw1Application;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;



import java.util.Arrays;
import java.util.Locale;

public class CakeValidator implements Validator{

    @Override
    public boolean supports(Class<?> clazz){
        return Cake.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors){

        Cake cake = (Cake) target;
        String ingr = cake.getIngredients().toLowerCase(Locale.ROOT);
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"name","","Cake must have a name");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"description","","Cake must have a description");
        if (!((ingr.equals("sugar")) || (ingr.equals("butter"))|| (ingr.equals("flour")))){
            errors.rejectValue("ingredients", "", "Cake ingredients incorrect");
        }
        if (0 > cake.getAmount()){
            errors.rejectValue("amount", "", "Must have at least one cake");
        }
        if (cake.getAmount() >15){
            errors.rejectValue("amount", "", "Must have less than 16 cakes");
        }
    }

}






