package ua.servise;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.data.repository.query.Param;
import org.springframework.web.multipart.MultipartFile;
import ua.entity.User;


public interface UserService {

    void save(User user) throws Exception;

    List<User> findAll();

    User findOne(int id);

    void delete(int id);


//for email
    User findByUUID(String uuid);

  
    void update(User user);

    

    
    
}
