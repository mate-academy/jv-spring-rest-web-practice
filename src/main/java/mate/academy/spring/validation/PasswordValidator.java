package mate.academy.spring.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import mate.academy.spring.model.dto.request.UserRequestDto;

public class PasswordValidator implements ConstraintValidator<PasswordValidation, UserRequestDto> {

    private static final String PASSWORD_PATTERN = "^[0-9a-zA-Z.@#$%^&!\t]{8,}$";

    @Override
    public boolean isValid(UserRequestDto userRequestDto,
                           ConstraintValidatorContext constraintValidatorContext) {
        if (userRequestDto.getPassword() == null || userRequestDto.getRepeatPassword() == null
                || !userRequestDto.getPassword().equals(userRequestDto.getRepeatPassword())) {
            return false;
        }
        Pattern pattern = Pattern.compile(PASSWORD_PATTERN);
        Matcher matcher = pattern.matcher(userRequestDto.getPassword());
        return matcher.matches();
    }
}
