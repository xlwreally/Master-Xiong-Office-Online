package com.Microsoft.日常测试;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * @author 熊立伟
 * @version 1.0
 * @date 2019/11/30 16:11
 */
public class 多线程  {
    public static void main(String[] args) {
        List<FutureTask<Object>> futureTasks=new ArrayList<>();
        for(Integer i=0;i<10;i++){
            Mytask myTask=new Mytask(i.toString(), i.toString());
            futureTasks.add(new FutureTask<>(myTask));
        }

        //创建线程池后，依次的提交任务，执行
        ExecutorService executorService= Executors.newCachedThreadPool();
        for(FutureTask<Object> futureTask:futureTasks){
            executorService.submit(futureTask);
        }
        executorService.shutdown();

        //根据任务数，依次的去获取任务返回的结果，这里获取结果时会依次返回，若前一个没返回，则会等待，阻塞
        for(Integer i=0;i<10;i++){
            try {
                String flag=(String)futureTasks.get(i).get();
                System.out.println(flag);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}
