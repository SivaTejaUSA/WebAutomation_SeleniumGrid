package core;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Manages the execution of tasks in a thread pool with a limited number of permits to control the concurrency.
 * It ensures that no more than a specified number of tasks run concurrently.
 */
public class DynamicThreadManager {

    // Semaphore limiting the number of concurrent tasks to 5
    private static final Semaphore semaphore = new Semaphore(5);
    // Cached thread pool for task execution
    private static  ExecutorService executor = Executors.newCachedThreadPool();

    /**
     * Submits a task for execution in a controlled concurrency environment.
     * Before running the task, it checks system CPU and memory load to make decisions on task execution.
     * If the system load is too high, it waits and retries execution.
     * 
     * @param testCaseName The name of the test case, used for informational purposes.
     * @param methodName The name of the method to be executed in the task.
     * @param task The task to be executed, encapsulated in a Runnable object.
     */
    public static void submitTask(String testCaseName, String methodName, Runnable task) {
        executor.submit(() -> {
            try {
                semaphore.acquire();  // Acquire a permit
                
                boolean taskExecuted = false;
                while (!taskExecuted) {
                    // Check CPU and Memory load before running the task
                    double cpuLoad = SystemInfoUtil.getSystemCpuLoad();
                    double memoryUtilization = SystemInfoUtil.getMemoryUtilization();
                    System.out.println("cpuLoad:  " + cpuLoad);
                    System.out.println("memoryUtilization:  " + memoryUtilization);

                    if (cpuLoad < 80 && memoryUtilization < 95) {
                        task.run();
                        taskExecuted = true;
                    } else if (cpuLoad >= 80 || memoryUtilization >= 95) {
                        Thread.sleep(5000);
                        System.out.println("high cpu and memoryUtilization, waiting for 5 seconds");
                    }
                }

            } catch (InterruptedException e) {
                // Handle the exception
                e.printStackTrace();
            } finally {
                semaphore.release();  // Release the permit
            }
        });
    }
    
    /**
     * Shuts down the ExecutorService, stopping all actively executing tasks and halting the processing of waiting tasks.
     */
    public static void shutdown() {
        executor.shutdown();  // Shutdown the executor
    }
}
