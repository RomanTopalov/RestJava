package ua.servise;

import ua.entity.Human;

import java.util.List;

/**
 * Created by -rom- on 13.02.2017.
 */
public interface HumanServise {

    void save( Human human);
    List<Human> findAll();
    Human findOne(int id);
    void delete(int id);



}
