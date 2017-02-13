package ua.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.entity.Human;

/**
 * Created by -rom- on 13.02.2017.
 */
public interface HumanDao extends JpaRepository<Human, Integer> {
}
