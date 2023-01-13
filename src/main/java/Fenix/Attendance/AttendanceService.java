package Fenix.Attendance;

import java.time.Month;
import java.time.YearMonth;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import Fenix.Meeting.Meeting;
import Fenix.Meeting.MeetingController;
import Fenix.Meeting.MeetingType;
import Fenix.Member.MemberController;
import LocalDate.LocalDateHelper;

public class AttendanceService {
   /* private static MeetingController meetingController;

    static{
        meetingController = new MeetingController();
    }
    
    private static long  attendedMeetingsOfMemberOnTimeBox(Integer memberId, YearMonth initYearMonth, YearMonth finalYearMonth) {
    	 List<Meeting> meetingList = MeetingController.getMeetingList();
         
    	 Set<Meeting> attendedMeetings = new LinkedHashSet<Meeting>();
    	 
    	 Iterator<Meeting> iterator = meetingList.iterator();
    	 
         long attendedMeetingsCount = 0;
         
         while(iterator.hasNext()) {
        	 Meeting meeting = iterator.next();
        	 Integer meetingMonth = meeting.getDate().getMonth().getValue();
        	 Integer meetingYear = meeting.getDate().getYear();
        	 if(meeting.getPresentMemberIds().contains(MemberController.getMemberById(memberId).getId()) &&
        			 LocalDateHelper.isinBetweenDates(meeting.getDate(), initYearMonth, finalYearMonth)) {
        		 attendedMeetings.add(meeting);
        		 attendedMeetingsCount++;
        	 }
         }
         System.out.println(attendedMeetings.toString());
         return attendedMeetingsCount;
    }
    
    private static long totalMeetingsOnTimeBox(YearMonth initYearMonth, YearMonth finalYearMonth) {
    	 List<Meeting> meetingList = meetingController.getMeetingList();
         
         long totalMeetingsOnTimeBox = meetingList.stream()
             .filter( meeting -> {
                 //int monthValue = Month.from(meeting.getDate() ).getValue();
                 //return (initYearMonth.getMonthValue() <= monthValue && finalYearMonth.getMonthValue() >= monthValue);
                 return (LocalDateHelper.isinBetweenDates(meeting.getDate(), initYearMonth, finalYearMonth));
             }).count();
    	
         return totalMeetingsOnTimeBox;
    }
    
    public static Double calculateAttendanceRate(Integer memberId, YearMonth initYearMonth, YearMonth finalYearMonth) {
    	System.out.println("CalculateAttendanceRate: Member " + memberId);
    	//System.out.println("Teste: "+ ((double)attendedMeetingsOfMemberOnTimeBox(memberId, initMonth, finalMonth)/(double)totalMeetingsOnTimeBox(initMonth,finalMonth)*100)+"%");
        return ((double)attendedMeetingsOfMemberOnTimeBox(memberId, initYearMonth, finalYearMonth)/(double)totalMeetingsOnTimeBox(initYearMonth,finalYearMonth));
    }
*/
}
