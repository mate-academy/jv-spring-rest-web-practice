package mate.academy.spring.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import mate.academy.spring.model.dto.request.RegisterRequestDto;

public class PasswordValidator implements
        ConstraintValidator<Password, Object> {
    @Override
    public boolean isValid(Object user,
                           ConstraintValidatorContext constraintValidatorContext) {
        RegisterRequestDto requestDto = (RegisterRequestDto) user;
        return requestDto.getPassword().equals(requestDto.getRepeatPassword());
    }
}
