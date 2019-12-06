package com.baker.learning.learnresourceloader.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @description
 * @date 2019/12/6 8:57
 */
@RestController
public class GetResourceFromBean {

    @Autowired
    LoaderService loaderService;

    @GetMapping("/resource")
    public String getResource() {
//        Class path
        Resource resourceClassPath =
                loaderService.getResource("classpath:testing.txt");

        StringBuffer stringBuffer = new StringBuffer();
        try {
            InputStream is = resourceClassPath.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                stringBuffer.append(line).append(";");
            }
            br.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuffer.toString();
    }
}
