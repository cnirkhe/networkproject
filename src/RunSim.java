import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 * Created by Elaine on 11/3/2015.
 */

public class RunSim {
    // I think all we have to update are hosts and flows, the others should always be the
    // same, but easy to fix if I'm wrong.
    // probably want links b/c of dynamic queues or something idk
    // Right now runtimeMillis < 0 means never ending
    public static void run(final ArrayList<Flow> flows, final ArrayList<Host> hosts, final int intervalTimeMillis,
                           final int runtimeMillis) {
        final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        final Runnable updater = new Runnable() {
            public void run() {
                for (Flow f : flows) {
                    f.update(intervalTimeMillis);
                }
                for (Host h : hosts) {
                    h.update(intervalTimeMillis);
                }
            }
        };
        final ScheduledFuture<?> updaterHandle =
                scheduler.scheduleAtFixedRate(updater, 0, intervalTimeMillis, TimeUnit.MILLISECONDS);

        // Stop the scheduler at a specified time if one is input.
        if (runtimeMillis >= 0) {
            scheduler.schedule(new Runnable() {
                public void run() {
                    updaterHandle.cancel(true);
                    scheduler.shutdownNow();
                }
            }, runtimeMillis, TimeUnit.MILLISECONDS);
        }
    }
}
