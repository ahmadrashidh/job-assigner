import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class JobAssignerTest {

    JobAssigner jobAssignment = new JobAssigner();

    @Test
    void emptyArray_shouldReturn_emptyArrayList() {

        int[] jobs = new int[0];

        Map<Integer, ArrayList<Integer>> result = jobAssignment.assignJobs(jobs, true);

        assertTrue(result.isEmpty());
    }


    @Test
    void nullInput_shouldReturn_emptyArrayList() {
        Map<Integer, ArrayList<Integer>> result = jobAssignment.assignJobs(null, true);

        assertTrue(result.isEmpty());
    }

    @Test
    void validInput_shouldReturn_optimumWorkerJobMap() {

        int[] jobs = {12, 10, 5, 5};

        Map<Integer, ArrayList<Integer>> result = jobAssignment.assignJobs(jobs, true);
        Map<Integer, ArrayList<Integer>> expectedResult = new HashMap<>();
        expectedResult.put(1, new ArrayList<>(Arrays.asList(5, 5)));
        expectedResult.put(2, new ArrayList<>(Arrays.asList(10)));
        expectedResult.put(3, new ArrayList<>(Arrays.asList(12)));

        assertEquals(expectedResult, result);

    }

    @Test
    void descendingValidInput_shouldReturn_desiredOptimumWorkerJobMap() {
        int[] jobs = {12, 10, 5, 5};

        Map<Integer, ArrayList<Integer>> result = jobAssignment.assignJobs(jobs, false);
        Map<Integer, ArrayList<Integer>> expectedResult = new HashMap<>();
        expectedResult.put(1, new ArrayList<>(Arrays.asList(5, 5)));
        expectedResult.put(2, new ArrayList<>(Arrays.asList(10)));
        expectedResult.put(3, new ArrayList<>(Arrays.asList(12)));

        assertEquals(expectedResult, result);
    }


    @Test
    void ascendingSorted13Input_shouldReturn_optimumWorkerJobMap() {
        int[] jobs = {234, 250, 400, 525, 545, 120, 120, 100, 699, 121, 120, 50, 302};

        Map<Integer, ArrayList<Integer>> result = jobAssignment.assignJobs(jobs, true);
        Map<Integer, ArrayList<Integer>> expectedResult = new HashMap<>();
        expectedResult.put(1, new ArrayList<>(Arrays.asList(5, 5)));
        expectedResult.put(2, new ArrayList<>(Arrays.asList(10)));
        expectedResult.put(3, new ArrayList<>(Arrays.asList(12)));

        assertEquals(expectedResult, result);

    }

    @Test
    void descendingSorted13Input_shouldReturn_optimumWorkerJobMap() {

        int[] jobs = {234, 250, 400, 525, 545, 120, 120, 100, 699, 121, 120, 50, 302};

        Map<Integer, ArrayList<Integer>> result = jobAssignment.assignJobs(jobs, false);
        Map<Integer, ArrayList<Integer>> expectedResult = new HashMap<>();
        expectedResult.put(1, new ArrayList<>(Arrays.asList(5, 5)));
        expectedResult.put(2, new ArrayList<>(Arrays.asList(10)));
        expectedResult.put(3, new ArrayList<>(Arrays.asList(12)));

        assertEquals(expectedResult, result);

    }

}