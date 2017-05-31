package ua.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.entity.TaskManager;


/**
 * Created by -rom- on 27.05.2017.
 */
public interface TaskManagerDao extends JpaRepository<TaskManager, Integer> {
}
