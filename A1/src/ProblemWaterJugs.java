/**
 * Created by hdford on 26/09/16.
 */

import java.util.HashSet;
import java.util.Set;

public class ProblemWaterJugs extends Problem {

    boolean goal_test(Object state) {
        StateWaterJugs jugs_state = (StateWaterJugs) state;
        if (jugs_state.jugsArray[0]==1 || jugs_state.jugsArray[1]==1 || jugs_state.jugsArray[2]==1) return true;
        else return false;
    }

    Set<Object> getSuccessors(Object state) {

        Set<Object> set = new HashSet<Object>();
        StateWaterJugs jugs_state = (StateWaterJugs) state;

        //Again, create without any constraint, then remove the illegal ones
        StateWaterJugs successor_state;

        //First Jug
        //Check if 12 gallon jug is empty, if so then can only fill
        successor_state = new StateWaterJugs(jugs_state);
        if (successor_state.jugsArray[0] == 0) {
            successor_state.jugsArray[0] += 12;
            set.add(successor_state);
        }
        //Check if can pour from 12 gallon jug to 8 gallon jug
        successor_state = new StateWaterJugs(jugs_state);
        if (successor_state.jugsArray[0] > 0 && successor_state.jugsArray[1] < 8) {
            int space_available = 8 - successor_state.jugsArray[1];
            if (space_available <= successor_state.jugsArray[0]) {
                successor_state.jugsArray[0] -= space_available;
                successor_state.jugsArray[1] += space_available;
            } else {
                successor_state.jugsArray[1] += successor_state.jugsArray[0];
                successor_state.jugsArray[0] = 0;
            }
            set.add(successor_state);
        }
        //Check if can pour from 12 gallon jug to 3 gallon jug
        successor_state = new StateWaterJugs(jugs_state);
        if (successor_state.jugsArray[0] > 0 && successor_state.jugsArray[2] < 3) {
            int space_available = 3 - successor_state.jugsArray[2];
            if (space_available <= successor_state.jugsArray[0]) {
                successor_state.jugsArray[0] -= space_available;
                successor_state.jugsArray[2] += space_available;
            } else {
                successor_state.jugsArray[2] += successor_state.jugsArray[0];
                successor_state.jugsArray[0] = 0;
            }
            set.add(successor_state);
        }
        //Pour 12 gallon jug out
        successor_state = new StateWaterJugs(jugs_state);
        if (successor_state.jugsArray[0] > 0) {
            successor_state.jugsArray[0] = 0;
            set.add(successor_state);
        }

        //Second Jug
        //Check if 8 gallon jug is empty, if so then can only fill
        successor_state = new StateWaterJugs(jugs_state);
        if (successor_state.jugsArray[1] == 0) {
            successor_state.jugsArray[1] += 8;
            set.add(successor_state);
        }
        //Check if can pour from 8 gallon jug to 12 gallon jug
        successor_state = new StateWaterJugs(jugs_state);
        if (successor_state.jugsArray[1] > 0 && successor_state.jugsArray[0] < 12) {
            int space_available = 12 - successor_state.jugsArray[0];
            if (space_available <= successor_state.jugsArray[1]) {
                successor_state.jugsArray[0] += space_available;
                successor_state.jugsArray[1] -= space_available;
            } else {
                successor_state.jugsArray[0] += successor_state.jugsArray[1];
                successor_state.jugsArray[1] = 0;
            }
            set.add(successor_state);
        }
        //Check if can pour from 8 gallon jug to 3 gallon jug
        successor_state = new StateWaterJugs(jugs_state);
        if (successor_state.jugsArray[1] > 0 && successor_state.jugsArray[2] < 3) {
            int space_available = 3 - successor_state.jugsArray[2];
            if (space_available <= successor_state.jugsArray[1]) {
                successor_state.jugsArray[2] += space_available;
                successor_state.jugsArray[1] -= space_available;
            } else {
                successor_state.jugsArray[2] += successor_state.jugsArray[1];
                successor_state.jugsArray[1] = 0;
            }
            set.add(successor_state);
        }
        //Pour 8 gallon jug out
        successor_state = new StateWaterJugs(jugs_state);
        if (successor_state.jugsArray[1] > 0) {
            successor_state.jugsArray[1] = 0;
            set.add(successor_state);
        }

        //Third Jug
        //Check if 3 gallon jug is empty, if so then can only fill
        successor_state = new StateWaterJugs(jugs_state);
        if (successor_state.jugsArray[2] == 0) {
            successor_state.jugsArray[2] += 3;
            set.add(successor_state);
        }
        //Check if can pour from 3 gallon jug to 12 gallon jug
        successor_state = new StateWaterJugs(jugs_state);
        if (successor_state.jugsArray[2] > 0 && successor_state.jugsArray[0] < 12) {
            int space_available = 12 - successor_state.jugsArray[0];
            if (space_available <= successor_state.jugsArray[2]) {
                successor_state.jugsArray[0] += space_available;
                successor_state.jugsArray[2] -= space_available;
            } else {
                successor_state.jugsArray[0] += successor_state.jugsArray[2];
                successor_state.jugsArray[2] = 0;
            }
            set.add(successor_state);
        }
        //Check if can pour from 3 gallon jug to 8 gallon jug
        successor_state = new StateWaterJugs(jugs_state);
        if (successor_state.jugsArray[2] > 0 && successor_state.jugsArray[1] < 8) {
            int space_available = 8 - successor_state.jugsArray[1];
            if (space_available <= successor_state.jugsArray[2]) {
                successor_state.jugsArray[1] += space_available;
                successor_state.jugsArray[2] -= space_available;
            } else {
                successor_state.jugsArray[1] += successor_state.jugsArray[2];
                successor_state.jugsArray[2] = 0;
            }
            set.add(successor_state);
        }
        //Pour 3 gallon jug out
        successor_state = new StateWaterJugs(jugs_state);
        if (successor_state.jugsArray[2] > 0) {
            successor_state.jugsArray[2] = 0;
            set.add(successor_state);
        }

        return set;
    }

    double step_cost(Object fromState, Object toState) {
        StateWaterJugs a = (StateWaterJugs) fromState;
        StateWaterJugs b = (StateWaterJugs) toState;
        int diff = 0;
        for(int i=0; i<3; i++) {
            if (Math.abs(a.jugsArray[i] - b.jugsArray[i]) > 0) {
                diff = Math.abs(a.jugsArray[i] - b.jugsArray[i]);
            }
        }
        return diff;
    }

    public double h(Object state) { return 0; }

    public static void main(String[] args) throws Exception {
        ProblemWaterJugs problem = new ProblemWaterJugs();
        int[] jugsArray = {0,0,0};
        problem.initialState = new StateWaterJugs(jugsArray);

        Search search  = new Search(problem);

        /*
		Hayden Ford V00794468
		James Davidson V00######
		 */
        System.out.println("\nAssignement #1\nCSC 421\nHayden Ford V00794468\nJames Davidson V00######\n");

        System.out.println("TreeSearch------------------------");
        System.out.println("BreadthFirstTreeSearch:\t\t" + search.BreadthFirstTreeSearch());
        System.out.println("UniformCostTreeSearch:\t\t" + search.UniformCostTreeSearch());

        System.out.println("\nGraphSearch------------------------");
        System.out.println("BreadthFirstGraphSearch:\t\t" + search.BreadthFirstGraphSearch());
        System.out.println("UniformCostGraphSearch:\t\t" + search.UniformCostGraphSearch());
        System.out.println("DepthFirstGraphSearch:\t\t" + search.DepthFirstGraphSearch());

        System.out.println("\nIterativeDeepening------------------------");
        System.out.println("IterativeDeepeningTreeSearch:\t\t" + search.IterativeDeepeningTreeSearch());
        System.out.println("IterativeDeepeningGraphSearch:\t\t" + search.IterativeDeepeningGraphSearch());
    }
}