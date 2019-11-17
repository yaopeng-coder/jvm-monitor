package cn.hust.jvmmonitor.chapter2;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @program: jvm-monitor
 * @author: yaopeng
 * @create: 2019-11-16 19:31
 **/
@RestController
public class MemoryController {


    /**
     * 演示堆溢出
     */
    @RequestMapping("/heap")
    public void heap(){

        List<User> userList = new ArrayList<>();

        int i  = 0;
        while (true){

            userList.add(new User(i++, UUID.randomUUID().toString()));
        }

    }

    /**
     * 演示元空间溢出
     */
    @RequestMapping("/nonheap")
    public void nonheap(){

        List<Class<?>> classList = new ArrayList<>();

        while(true){
            classList.addAll(Metaspace.createClasses());
        }


    }
}
