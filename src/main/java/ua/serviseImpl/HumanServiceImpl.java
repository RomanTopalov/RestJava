package ua.serviseImpl;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ua.dao.HumanDao;
import ua.entity.Human;
import ua.servise.HumanServise;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by -rom- on 13.02.2017.
 */
@Service
public class HumanServiceImpl implements HumanServise {

    @Autowired
    private HumanDao humanDao;

    @Override
    public void save(Human human, MultipartFile multipartFile) {
        String path = System.getProperty("catalina.home") + "/resources/" + human.getId() + "/"
                + multipartFile.getOriginalFilename();

        human.setPathImage("resources/" + human.getId() + "/" + multipartFile.getOriginalFilename());

        File file = new File(path);

        try {
            file.mkdirs();
            try {
                FileUtils.cleanDirectory(
                        new File(System.getProperty("catalina.home") + "/resources/" + human.getId() + "/"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            multipartFile.transferTo(file);
        } catch (IOException e) {
            System.out.println("error with file");
        }

        humanDao.save(human);
    }

    @Override
    public List<Human> findAll() {
        return humanDao.findAll();
    }

    @Override
    public Human findOne(int id) {
        return humanDao.findOne(id);
    }

    @Override
    public void delete(int id) {
        humanDao.delete(id);
    }

}
