package co2103.hw1.domain;

import co2103.hw1.Hw1Application;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;



import java.util.Arrays;

public class CafeValidator implements Validator{

    @Override
    public boolean supports(Class<?> clazz){
        return Cafe.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors){
        Cafe cafe = (Cafe) target;
        for (Cafe q : Hw1Application.cafes){
            if (cafe.getId() == q.getId()){
                errors.rejectValue("id", "", "Cafe id already in use");
            }
        }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"name","","Cafe must have a name");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"address","","Cafe must have a address");
    }

}





