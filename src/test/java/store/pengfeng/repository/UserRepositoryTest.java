package store.pengfeng.repository;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import store.pengfeng.CrmApplicationTests;
import store.pengfeng.domain.User;

import java.util.Calendar;

import static org.junit.Assert.assertNotNull;

/**
 * <pre>
 * Description
 * Copyright:	Copyright (c)2018
 * Author:		shisen
 * Created at:	2018/12/27 18:10
 * </pre>
 */
public class UserRepositoryTest extends CrmApplicationTests {
    @Autowired
    private UserRepository userRepository;

    private Object result;

    @Before
    public void setUp() throws Exception {
        assertNotNull("userRepository 注入失败!!!", userRepository);
    }

    @Test
    public void findByNameTest() {
        result = userRepository.findByName("施森1");
    }

    @Test
    public void saveTest() {
        Calendar instance = Calendar.getInstance();
        instance.set(1994, 1, 2);
        User user = new User().setName("施森").setAge(25).setGender("1").setBirthday(instance.getTime());
        result = userRepository.save(user);
    }

    @After
    public void tearDown() throws Exception {
        assertNotNull(result);
        System.out.println("result.toString() = " + result.toString());
    }
}