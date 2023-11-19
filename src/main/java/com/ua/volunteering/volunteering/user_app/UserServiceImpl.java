package com.ua.volunteering.volunteering.user_app;

import com.ua.volunteering.volunteering.exception.NotFoundException;
import com.ua.volunteering.volunteering.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements BaseService<User> {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

    @Override
    public User save(User user) { return userRepository.save(user); }

    @Override
    public User update(Long id, User user) {
        User updatedUser = getById(id);
        updatedUser.setName(user.getName());
        updatedUser.setAge(user.getAge());
        updatedUser.setCountry(user.getCountry());
        updatedUser.setRole(user.getRole());
        updatedUser.setExperience(user.getExperience());
        updatedUser.setEnglishLevel(user.getEnglishLevel());
        updatedUser.setSalaryExpectation(user.getSalaryExpectation());
        updatedUser.setLinkToCVorLinkedIn(user.getLinkToCVorLinkedIn());
        return userRepository.save(updatedUser);
    }

    @Override
    public void delete(Long id) {
        userRepository.delete(userRepository.getById(id));
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    public List<User> getAllWithFilters(Country country, Role role, Experience experience, Integer salaryExpectation, EnglishLevel englishLevel) {
        List<User> users =  userRepository.findAllByCountryAndRole(country, role, experience, englishLevel);
        if (salaryExpectation != null){
        return users.stream().filter(i -> i.getSalaryExpectation() >= salaryExpectation).collect(Collectors.toList());}
        else {return users;}

    }
}
