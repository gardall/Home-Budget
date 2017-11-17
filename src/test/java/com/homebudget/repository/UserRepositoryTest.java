package com.homebudget.repository;

import com.homebudget.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    UserRepository userRepository;

    @Test
    public void findByUsername() throws Exception {
        //Given
        User someone = new User();
        someone.setUsername("John");
        entityManager.persist(someone);
        entityManager.flush();

        //When
        User found = userRepository.findByUsername(someone.getUsername());

        //Then
        assertEquals(found.getUsername(),someone.getUsername());

    }

}