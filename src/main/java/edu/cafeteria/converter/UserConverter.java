package edu.cafeteria.converter;
 

import edu.cafeteria.DTO.UserDTO; 
import edu.cafeteria.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserConverter implements Converter<User, UserDTO> {

    @Override
    public UserDTO convertToDTO(User user) {
        return new UserDTO(user.getId(), user.getFirstName(), user.getLastName(),
                user.getBirthDate(), user.getEmail(), user.getUserName(), user.getPhone(),user.getPassword(),user.getRole()
                ,user.getEmployeeID(),   user.getStaffID());
    }

    @Override
    public User convertToEntity(UserDTO userDTO) {
        return new User(userDTO.getFirstName(), userDTO.getLastName(), userDTO.getBirthDate(),
                userDTO.getEmail(), userDTO.getUserName(), userDTO.getPassword(), userDTO.getPhone(),userDTO.getRole()
                ,userDTO.getEmployeeID(),   userDTO.getStaffID());
    }
}
