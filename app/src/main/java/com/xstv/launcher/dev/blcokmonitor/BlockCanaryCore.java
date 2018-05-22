
package com.xstv.launcher.dev.blcokmonitor;

import android.os.Looper;

import java.util.ArrayList;

public class BlockCanaryCore {

    public LooperPrinter mainLooperPrinter;
    public ThreadStackSampler threadStackSampler;
    public CpuSampler cpuSampler;

    private static BlockCanaryCore sInstance;
    private static IBlockCanaryContext sBlockCanaryContext;

    private OnBlockEventInterceptor mOnBlockEventInterceptor;

    public BlockCanaryCore() {
        threadStackSampler = new ThreadStackSampler(Looper.getMainLooper().getThread(),
                sBlockCanaryContext.getConfigDumpIntervalMillis());
        cpuSampler = new CpuSampler(sBlockCanaryContext.getConfigDumpIntervalMillis());

        setMainLooperPrinter(new LooperPrinter(new BlockListener() {

            @Override
            public void onBlockEvent(long realTimeStart, long realTimeEnd,
                    long threadTimeStart, long threadTimeEnd) {
                // Get recent thread-stack entries and cpu usage
                ArrayList<String> threadStackEntries = threadStackSampler
                        .getThreadStackEntries(realTimeStart, realTimeEnd);
                // Log.d("BlockCanary", "threadStackEntries: " + threadStackEntries.size());
                if (!threadStackEntries.isEmpty()) {
                    Block block = Block.newInstance()
                            .setMainThreadTimeCost(realTimeStart, realTimeEnd, threadTimeStart, threadTimeEnd)
                            .setCpuBusyFlag(cpuSampler.isCpuBusy(realTimeStart, realTimeEnd))
                            .setRecentCpuRate(cpuSampler.getCpuRateInfo())
                            .setThreadStackEntries(threadStackEntries)
                            .flushString();
                    LogWriter.saveLooperLog(block.toString());

                    if (getContext().isNeedDisplay() && mOnBlockEventInterceptor != null) {
                        mOnBlockEventInterceptor.onBlockEvent(getContext().getContext(), block.timeStart);
                    }
                }
            }
        }, getContext().getConfigBlockThreshold()));
        LogWriter.cleanOldFiles();
    }

    /**
     * Get BlockCanaryCore singleton
     * 
     * @return BlockCanaryCore instance
     */
    public static BlockCanaryCore get() {
        if (sInstance == null) {
            synchronized (BlockCanaryCore.class) {
                if (sInstance == null) {
                    sInstance = new BlockCanaryCore();
                }
            }
        }
        return sInstance;
    }

    /**
     * set {@link IBlockCanaryContext} implementation
     * 
     * @param blockCanaryContext blockCanaryContext
     */
    public static void setIBlockCanaryContext(IBlockCanaryContext blockCanaryContext) {
        sBlockCanaryContext = blockCanaryContext;
    }

    public static IBlockCanaryContext getContext() {
        return sBlockCanaryContext;
    }

    public void setOnBlockEventInterceptor(OnBlockEventInterceptor onBlockEventInterceptor) {
        mOnBlockEventInterceptor = onBlockEventInterceptor;
    }

    public void setMainLooperPrinter(LooperPrinter looperPrinter) {
        mainLooperPrinter = looperPrinter;
    }

    /**
     * Because postDelayed maybe cause more delay than MonitorEnv.get().getConfigBlockThreshold() it maybe cause can not get Thread Task info when notify block event. So, is it be better to make delay
     * time < MonitorEnv.get().getConfigBlockThreshold(), such as MonitorEnv.get().getConfigBlockThreshold() * 0.8f OR MonitorEnv.get().getConfigBlockThreshold() - 20 ?
     * 
     * @return sample delay
     */
    long getSampleDelay() {
        return (long) (BlockCanaryCore.getContext().getConfigBlockThreshold() * 0.8f);
    }
}
