package com.baker.learning.learningresourceloader.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @description 三种姿势都可以
 * @date 2019/12/6 8:47
 */
public class GetResourceFromContext {

    public static void main(String[] args) {
        ApplicationContext appContext = new ClassPathXmlApplicationContext();

//        File system
        Resource resourceSys = appContext.getResource("file:c:\\testing.txt");

//        URL path
        Resource resourceUrl =
                appContext.getResource("url:http://ip:port/testing.txt");


//        Class path
        Resource resourceClassPath =
                appContext.getResource("classpath:testing.txt");

        try {
            InputStream is = resourceClassPath.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            br.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
