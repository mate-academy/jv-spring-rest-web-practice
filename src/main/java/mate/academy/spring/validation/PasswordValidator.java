package mate.academy.spring.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import mate.academy.spring.model.dto.request.UserRequestDto;

public class PasswordValidator implements ConstraintValidator<ValidPassword, UserRequestDto> {
    public static final Pattern VALID_PASSWORD_REGEX =
            Pattern.compile("(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}");

    @Override
    public boolean isValid(UserRequestDto userRequestDto,
                           ConstraintValidatorContext constraintValidatorContext) {
        if (userRequestDto.getPassword() == null || userRequestDto.getRepeatedPassword() == null) {
            return false;
        }
        Matcher matcher = VALID_PASSWORD_REGEX.matcher(userRequestDto.getPassword());
        return matcher.matches()
                && userRequestDto.getPassword().equals(userRequestDto.getRepeatedPassword());
    }
}
