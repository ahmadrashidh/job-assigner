import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;

interface JobAssignment {

    int NO_OF_WORKERS = 3;

    Map<Integer, ArrayList<Integer>> assignJobs(int[] jobs, boolean toSortAscending);

    default void sortJobs(int[] jobs, boolean sortAscending) {
        Arrays.sort(jobs, 0, jobs.length);
        if (!sortAscending) {
            Collections.reverse(Arrays.asList(jobs));
        }
    }

}
