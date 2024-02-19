package Greedy;
import java.util.*;

public class 전투게임 {

}

class Student implements Comparable<Student>{

    int no;
    char team;
    int attack;

    public Student(int no, char team, int attack) {
        this.no = no;
        this.team = team;
        this.attack = attack;
    }

    @Override
    public int compareTo(Student o) {
        Student s = (Student) o;
        return this.attack - s.attack;
    }
}
class Solution7 {
    public int[] solution(String[] students){
        int n = students.length;
        int[] answer = new int[n];
        Student[] studentsArray = new Student[students.length];

        for (int i = 0; i < students.length; i++) {
            char team = students[i].split(" ")[0].charAt(0);
            int attack = Integer.parseInt(students[i].split(" ")[1]);
            studentsArray[i] = new Student(i,team,attack);
        }

        Arrays.sort(studentsArray);
        int total = 0;
        HashMap<Character, Integer> teamPoint = new HashMap<>();
        int j = 0;
        for (int i = 1; i < students.length; i++){
            if(studentsArray[i-1].attack < studentsArray[i].attack){
                for (; j < i; j++) {
                    total += studentsArray[i-1].attack;
                    char team = studentsArray[i-1].team;
                    int attack = studentsArray[i-1].attack;
                    teamPoint.put(team,teamPoint.getOrDefault(team,0)+attack);
                }
            }
            answer[studentsArray[i].no] = total - teamPoint.getOrDefault(studentsArray[i].team,0);
        }

        return answer;
    }

    public static void main(String[] args){
        Solution7 T = new Solution7();
        System.out.println(Arrays.toString(T.solution(new String[]{"a 20", "b 12", "a 10", "c 11", "e 12"})));
        System.out.println(Arrays.toString(T.solution(new String[]{"a 17", "b 12", "a 10", "c 11", "b 24", "a 25", "b 12"})));
        System.out.println(
                Arrays.toString(T.solution(new String[]{"b 20", "c 15", "a 200", "b 11", "b 24", "a 25", "b 12"})));
        System.out.println(Arrays.toString(T.solution(new String[]{"a 30", "a 25", "a 25", "b 20", "b 25", "a 25", "b 30"})));
    }
}
