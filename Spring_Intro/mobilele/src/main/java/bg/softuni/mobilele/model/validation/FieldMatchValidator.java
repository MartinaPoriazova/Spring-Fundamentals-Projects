package bg.softuni.mobilele.model.validation;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.PropertyAccessorFactory;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class FieldMatchValidator implements ConstraintValidator<FieldMatch, Object>  {


    private String firstPassword;
    private String secondConfirmPassword;
    private String message;

    @Override
    public void initialize(FieldMatch constraintAnnotation) {
        this.firstPassword = constraintAnnotation.firstPassword();
        this.secondConfirmPassword = constraintAnnotation.secondConfirmPassword();
        this.message = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        BeanWrapper beanWrapper = PropertyAccessorFactory.
                forBeanPropertyAccess(value);

        Object firstValue = beanWrapper.getPropertyValue(this.firstPassword);
        Object secondValue = beanWrapper.getPropertyValue(this.secondConfirmPassword);

        boolean valid;

        if (firstValue == null) {
            valid = secondValue == null;
        } else {
            valid = firstValue.equals(secondValue);
        }

        if (!valid) {
            context.
                    buildConstraintViolationWithTemplate(message).
                    addPropertyNode(secondConfirmPassword).
                    addConstraintViolation().
                    disableDefaultConstraintViolation();
        }
        return valid;
    }

}