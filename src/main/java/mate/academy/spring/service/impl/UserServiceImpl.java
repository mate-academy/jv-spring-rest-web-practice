package mate.academy.spring.service.impl;

import java.util.Optional;
import mate.academy.spring.dao.UserDao;
import mate.academy.spring.mapper.impl.response.UserResponseMapper;
import mate.academy.spring.model.User;
import mate.academy.spring.model.dto.response.UserResponseDto;
import mate.academy.spring.service.UserService;
import mate.academy.spring.util.HashUtil;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserDao userDao;
    private final UserResponseMapper userResponseMapper;

    public UserServiceImpl(UserDao userDao, UserResponseMapper userResponseMapper) {
        this.userDao = userDao;
        this.userResponseMapper = userResponseMapper;
    }

    @Override
    public User add(User user) {
        user.setSalt(HashUtil.getSalt());
        user.setPassword(HashUtil.hashPassword(user.getPassword(), user.getSalt()));
        return userDao.add(user);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userDao.findByEmail(email);
    }

    public UserResponseDto getByEmail(String email) {
        return userResponseMapper.toDto(findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Can not get user by email: " + email)));
    }

    @Override
    public User get(Long id) {
        return userDao.get(id).get();
    }
}
