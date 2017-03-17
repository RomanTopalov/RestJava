package ua.servise;

import org.springframework.web.multipart.MultipartFile;
import ua.entity.Human;

import java.util.List;

/**
 * Created by -rom- on 13.02.2017.
 */
public interface HumanServise {

    void save( Human human , MultipartFile multipartFile);
    List<Human> findAll();
    Human findOne(int id);
    void delete(int id);


}
