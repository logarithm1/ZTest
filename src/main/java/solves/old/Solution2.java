package solves.old;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution2 {

    public static class Meeting implements Comparable<Meeting> {

        public int compareTo(Meeting m2) {
            if(this.startTime !=m2.startTime) {
                return this.startTime -m2.startTime;
            } else return this.endTime -m2.endTime;
        }
        private int startTime;
        private int endTime;

        public Meeting(int startTime, int endTime) {
            // number of 30 min blocks past 9:00 am
            this.startTime = startTime;
            this.endTime   = endTime;
        }

        public int getStartTime() {
            return startTime;
        }

        public void setStartTime(int startTime) {
            this.startTime = startTime;
        }

        public int getEndTime() {
            return endTime;
        }

        public void setEndTime(int endTime) {
            this.endTime = endTime;
        }
    }

    public static List<Meeting> mergeRanges(List<Meeting> meetings) {

        // merge meeting ranges
        List<Meeting> mergedMeetings = new ArrayList<Meeting>();
        
        java.util.Collections.sort(meetings);
        Meeting firstMeeting = meetings.get(0);
        int start=firstMeeting.getStartTime();
        int end = firstMeeting.getEndTime();
        
        Meeting mergedMeeting = new Meeting(start,end);
        mergedMeetings.add(mergedMeeting);
        for(Meeting nextMeeting:meetings) {
            int nextStart=nextMeeting.getStartTime();
            int nextEnd = nextMeeting.getEndTime();
            
            if(nextStart<=end) {
                if(nextEnd>end) {
                    mergedMeeting.setEndTime(nextEnd);
                    end=nextEnd;

                }
            } else {
                mergedMeeting=new Meeting(nextStart,nextEnd); 
                mergedMeetings.add(mergedMeeting);
                start=nextStart;
                end=nextEnd;
            }
            
        }

        return mergedMeetings;
    }

    public static void main(String[] args) {
        Meeting[] meetings = {
            new Meeting(0, 1),
            new Meeting(3, 5),
            new Meeting(4, 8),
            new Meeting(10, 12),
            new Meeting(9, 10)
        };

        List<Meeting> result = mergeRanges(Arrays.asList(meetings));
        for (Meeting meeting: result) {
            System.out.printf("(%d, %d) ", meeting.getStartTime(),
                                meeting.getEndTime());
        }
        System.out.println();
    }
}