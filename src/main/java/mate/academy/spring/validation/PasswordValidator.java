package mate.academy.spring.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import mate.academy.spring.model.dto.request.UserRegistrationDto;

public class PasswordValidator implements ConstraintValidator<ValidPassword, UserRegistrationDto> {
    private static final String PASSWORD_PATTERN = "^(?=.*[0-9])"
            + "(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,20}$";

    @Override
    public boolean isValid(UserRegistrationDto dto, ConstraintValidatorContext context) {
        if (!dto.getPassword().equals(dto.getRepeatPassword())) {
            return false;
        }
        Pattern pattern = Pattern.compile(PASSWORD_PATTERN);
        Matcher matcher = pattern.matcher(dto.getPassword());
        return matcher.matches();
    }
}
