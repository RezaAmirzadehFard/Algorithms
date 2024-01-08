package greedy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ActivitySelection {

    public static void main(String[] args){
        Activity a1 = new Activity("a1",1,4);
        Activity a2 = new Activity("a2",3,5);
        Activity a3 = new Activity("a3",0,6);
        Activity a4 = new Activity("a4",5,7);
        Activity a5 = new Activity("a5",3,9);
        Activity a6 = new Activity("a6",5,9);
        Activity a7 = new Activity("a7",6,10);
        Activity a8 = new Activity("a8",7,11);
        Activity a9 = new Activity("a9",8,12);
        Activity a10 = new Activity("a10",2,14);
        Activity a11 = new Activity("a11",12,16);

        List<Activity> activityList = new ArrayList<>();
        activityList.add(a1);
        activityList.add(a2);
        activityList.add(a3);
        activityList.add(a4);
        activityList.add(a5);
        activityList.add(a6);
        activityList.add(a7);
        activityList.add(a8);
        activityList.add(a9);
        activityList.add(a10);
        activityList.add(a11);

        System.out.println("\n############# List of activities #############\n");
        System.out.println("activity\t start \t finish\t");

        for(var activity: activityList) {
            System.out.println(activity.name +"\t\t\t "+ activity.start +"\t\t "+ activity.finish+"\t");
        }

        System.out.println("\n############# Result #############\n");

        List<Activity> ac = greedyActivitySelector(activityList);

        System.out.println("activity\t s\t f\t|=================");
        System.out.println("--------------------------------------");
        for(var activity: ac) {
            System.out.print(activity.name +"\t\t\t "+ activity.start +"\t "+ activity.finish+"\t|");
            int duration = activity.finish - activity.start;
            for (int j = 0; j < activity.start; j++){
                System.out.print(" ");
            }
            for (int i = 0; i < duration; i++ ){
                System.out.print("=");
            }
            System.out.println();
        }

    }

    public static List<Activity> greedyActivitySelector(List<Activity> activities){
        activities.sort(Comparator.comparingInt(i->i.finish));
        List<Activity> result = new ArrayList<>();
        result.add(activities.get(0));
        int k = 0;
        for (int m = 1; m < activities.size(); m++) {
            int sm = activities.get(m).start;
            int fk = activities.get(k).finish;
            if( sm >= fk ){
                result.add(activities.get(m));
                k = m;
            }
        }
        return result;
    }

    private static class Activity{
        private final String name;
        private final int start;
        private final int finish;

        private Activity(String name, int start, int finish) {
            this.name = name;
            this.start = start;
            this.finish = finish;
        }
    }
}
