package org.springboot.lab.rabbitmq;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springboot.lab.rabbitmq.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class AsyncDemoServiceTest {

    @Autowired
    private DemoService demoService;

    @Test
    public void task01() {
        long now = System.currentTimeMillis();
        log.info("[task01][开始执行]");

        // 顺序执行，一共消耗 15 秒左右
        // 都在主线程中执行
        demoService.execute01();
        demoService.execute02();

        log.info("[task01][结束执行，消耗时长 {} 毫秒]", System.currentTimeMillis() - now);
    }

    @Test
    public void task02() {
        long now = System.currentTimeMillis();
        log.info("[task02][开始执行]");

        // 异步执行，所以主线程只消耗 27 毫秒左右。注意，实际这两个方法，并没有执行完成。
        // 都在异步的线程池中，进行执行
        demoService.execute01Async();
        demoService.execute02Async();

        log.info("[task02][结束执行，消耗时长 {} 毫秒]", System.currentTimeMillis() - now);
    }
    
    @Test
    public void task03() throws ExecutionException, InterruptedException {
        long now = System.currentTimeMillis();
        log.info("[task03][开始执行]");

        // <1> 执行任务
        // 这两个异步调用的逻辑，可以并行执行。
        Future<Integer> execute01Result = demoService.execute01AsyncWithFuture();
        Future<Integer> execute02Result = demoService.execute02AsyncWithFuture();
        // <2> 阻塞等待结果
        execute01Result.get();
        execute02Result.get();

        log.info("[task03][结束执行，消耗时长 {} 毫秒]", System.currentTimeMillis() - now);
    }

}
