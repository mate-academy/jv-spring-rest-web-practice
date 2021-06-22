package mate.academy.spring.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import mate.academy.spring.model.dto.request.UserRequestDto;

public class PasswordMatchValidator implements ConstraintValidator<PasswordMatch, UserRequestDto> {
    @Override
    public boolean isValid(UserRequestDto userRequestDto,
                           ConstraintValidatorContext constraintValidatorContext) {
        return userRequestDto.getPassword().equals(userRequestDto.getRepeatPassword());
    }
}
