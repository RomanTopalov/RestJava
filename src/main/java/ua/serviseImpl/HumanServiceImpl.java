package ua.serviseImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.dao.HumanDao;
import ua.entity.Human;
import ua.servise.HumanServise;

import java.util.List;

/**
 * Created by -rom- on 13.02.2017.
 */
@Service
public class HumanServiceImpl implements HumanServise {

    @Autowired
    private HumanDao humanDao;
    @Override
    public void save(Human human) {
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
