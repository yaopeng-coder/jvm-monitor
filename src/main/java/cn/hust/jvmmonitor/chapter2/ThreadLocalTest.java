package cn.hust.jvmmonitor.chapter2;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @program: jvm-monitor
 * @author: yaopeng
 * @create: 2019-12-03 17:18
 **/
@RestController
public class ThreadLocalTest {


    final static ThreadLocal<Byte[]> localVariable = new ThreadLocal<Byte[]>();//声明本地变量

    @RequestMapping(value = "/test0")
    public String test0(HttpServletRequest request) {
        new Thread() {
            public void run() {
                localVariable.set(new Byte[4096*1024]);// 为线程添加变量
                try {
                    Thread.sleep(2000);//延迟线程生命周期，使得在其他线程调用set时，避免回收已经失去引用的key的value
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }
        }.start();
        return "success";
    }
}
