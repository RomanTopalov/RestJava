package ua.servise;



import ua.entity.TaskManager;

import java.util.List;

/**
 * Created by -rom- on 27.05.2017.
 */
public interface TaskManagerService {

    void save(TaskManager taskManager) ;

    List<TaskManager> findAll();

    TaskManager findOne(int id);

    void delete(int id);

    void update(TaskManager taskManager);
}
