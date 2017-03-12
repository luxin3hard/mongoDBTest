package com.mongodb;

import java.util.Arrays;
import java.util.Date;
import java.util.List;


import com.mongodb.dao.impl.UserDaoImpl;
import com.mongodb.dao.service.UserDao;
import com.mongodb.model.UserEntity;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.alibaba.fastjson.JSON;

public class ApplicationSpring {

    public static void main(String[] args) {

        System.out.println("Bootstrapping HelloMongo");

        ConfigurableApplicationContext context = null;
        context = new ClassPathXmlApplicationContext("spring/application.xml");

        UserDao userDao = context.getBean(UserDaoImpl.class);
        userDao._test();

        UserEntity entity1 = new UserEntity();
        entity1.setId("5");
        entity1.setAge(1);
        entity1.setBirth(new Date());
        entity1.setPassword("asdfasdf");
        entity1.setRegionName("北京");
        entity1.setWorks(1);

      //  userDao.insert(entity1);
        userDao.update(entity1);

       // userDao.createCollection();

        List<UserEntity> list = userDao.findList(0, 4);
       /* for (UserEntity e : list) {
            System.out.println(JSON.toJSON(e));
        }*/

        list = userDao.findListByAge(1);
        for (UserEntity e : list) {
            System.out.println(JSON.toJSON(e));
        }

        UserEntity e = userDao.findOne("1");
        System.out.println(JSON.toJSON(e));

        e = userDao.findOneByUsername("limingnihao");
        System.out.println(JSON.toJSON(e));

        System.out.println("DONE!");
    }

}
