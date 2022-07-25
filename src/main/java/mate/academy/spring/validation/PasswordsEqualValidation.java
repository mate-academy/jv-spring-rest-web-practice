package mate.academy.spring.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import mate.academy.spring.model.dto.request.UserRequestDto;

public class PasswordsEqualValidation
        implements ConstraintValidator<PasswordsEqualConstraint, UserRequestDto> {

    @Override
    public boolean isValid(UserRequestDto user, ConstraintValidatorContext context) {
        if (user.getPassword() == null) {
            return false;
        }
        return user.getPassword().equals(user.getPasswordRepeat());
    }
}
