package WebSitePractices.NeetCode.Queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * The school cafeteria offers circular and square sandwiches at lunch break,
 * referred to by numbers 0 and 1 respectively.
 * All students stand in a queue. Each student either prefers square or circular sandwiches.
 * The number of sandwiches in the cafeteria is equal to the number of students.
 * The sandwiches are placed in a stack.
 * At each step:
 * If the student at the front of the queue prefers the sandwich on the top of the stack,
 * they will take it and leave the queue.
 * Otherwise, they will leave it and go to the queue's end.
 * This continues until none of the queue students want to take the top sandwich
 * and are thus unable to eat.
 * You are given two integer arrays students and sandwiches where sandwiches[i]
 * is the type of the ith sandwich in the stack (i = 0 is the top of the stack)
 * and students[j] is the preference of the jth student in the initial queue
 * (j = 0 is the front of the queue). Return the number of students that are unable to eat.
 *
 * Input: students = [1,1,0,0], sandwiches = [0,1,0,1]
 * Output: 0
 * Explanation:
 * - Front student leaves the top sandwich and returns to the end of the line making students = [1,0,0,1].
 * - Front student leaves the top sandwich and returns to the end of the line making students = [0,0,1,1].
 * - Front student takes the top sandwich and leaves the line making students = [0,1,1] and sandwiches = [1,0,1].
 * - Front student leaves the top sandwich and returns to the end of the line making students = [1,1,0].
 * - Front student takes the top sandwich and leaves the line making students = [1,0] and sandwiches = [0,1].
 * - Front student leaves the top sandwich and returns to the end of the line making students = [0,1].
 * - Front student takes the top sandwich and leaves the line making students = [1] and sandwiches = [1].
 * - Front student takes the top sandwich and leaves the line making students = [] and sandwiches = [].
 * Hence all students are able to eat.
 *
 * Input: students = [1,1,1,0,0,1], sandwiches = [1,0,0,0,1,1]
 * Output: 3
 */
public class StudentUnableEatLunch {
    public static void main(String[] args){
        int[] students = {1,1,1,0,0,1};
        int[] sandwiches = {1,0,0,0,1,1};
        int count = getStudentsUnableToEat(students,sandwiches);
        System.out.println(count+" number of students were unable to eat");
    }
    private static int getStudentsUnableToEat(int[] students,int[] sandwiches){
        Queue<Integer> stdnts = new LinkedList<>();
        Stack<Integer> sndwchs = new Stack<>();
        for(int i=0;i<students.length;i++){
            stdnts.offer(students[i]);
            sndwchs.push(sandwiches[students.length - i - 1]);
        }
        System.out.println("Students :"+stdnts);
        System.out.println("Sandwiches :"+sndwchs);
        int lastServed = 0;
        while (stdnts.size()>0 && lastServed<stdnts.size()) {
            if (stdnts.peek() == sndwchs.peek()) {
                sndwchs.pop();
                stdnts.poll();
                lastServed = 0;
            } else {
                stdnts.offer(stdnts.poll());
                lastServed++;
            }
        }
        return stdnts.size();
    }
}
