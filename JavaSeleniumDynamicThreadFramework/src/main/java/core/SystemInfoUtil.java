package core;

import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;
import oshi.hardware.GlobalMemory;
import oshi.hardware.HardwareAbstractionLayer;

/**
 * SystemInfoUtil provides static methods to retrieve system performance metrics such as CPU load
 * and memory utilization using the OSHI (Operating System and Hardware Information) library.
 */
public class SystemInfoUtil {

    // Holds the previous CPU tick counts for all CPUs
    private static long[] prevTicks = null;

    /**
     * Calculates and retrieves the system's CPU load between the current and previous ticks.
     * The method waits for a short period to get an accurate measure of the CPU load.
     *
     * @return The CPU load as a percentage.
     */
    public synchronized static double getSystemCpuLoad() {
        try {
            // Wait for a short period to get an accurate measure of the CPU load
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        SystemInfo si = new SystemInfo();
        HardwareAbstractionLayer hal = si.getHardware();
        CentralProcessor processor = hal.getProcessor();

        // Get the current CPU load ticks
        long[] ticks = processor.getSystemCpuLoadTicks();
        double cpuLoad = 0;

        // Calculate the CPU load between the current and previous ticks
        if (prevTicks != null) {
            cpuLoad = processor.getSystemCpuLoadBetweenTicks(prevTicks) * 100;
        }
        prevTicks = ticks;
        return cpuLoad;
    }

    /**
     * Calculates and retrieves the system's memory utilization.
     *
     * @return The memory utilization as a percentage of used memory.
     */
    public synchronized static double getMemoryUtilization() {
        SystemInfo si = new SystemInfo();
        HardwareAbstractionLayer hal = si.getHardware();
        GlobalMemory memory = hal.getMemory();

        // Get the total and available memory
        long totalMemory = memory.getTotal();
        long availableMemory = memory.getAvailable();

        // Calculate the percentage of memory used
        return 100.0 - ((double) availableMemory / (double) totalMemory * 100);
    }
}
