package ua.serviseImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.dao.TaskManagerDao;
import ua.entity.TaskManager;
import ua.servise.TaskManagerService;

import java.util.List;

/**
 * Created by -rom- on 27.05.2017.
 */
@Service
public class TaskManagerServictImpl implements TaskManagerService{

    @Autowired
    private TaskManagerDao taskManagerDao;
    @Override
    public void save(TaskManager taskManager) {
        taskManagerDao.save(taskManager);
    }

    @Override
    public List<TaskManager> findAll() {
        return taskManagerDao.findAll();
    }

    @Override
    public TaskManager findOne(int id) {
        return taskManagerDao.findOne(id);
    }

    @Override
    public void delete(int id) {
        taskManagerDao.delete(id);

    }

    @Override
    public void update(TaskManager taskManager) {
        taskManagerDao.save(taskManager);

    }
}
