package Fenix.Attendance;

import java.time.LocalDate;
import java.util.List;

import Fenix.Meeting.Meeting;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AttendanceService {
    //List<Meeting> meetingList = meetingController.gettAll();

    public List<Meeting> getMeetingsByDate(LocalDate InitDate, LocalDate finalDate){
        return null;
    }
}

    /*


    private final MeetingController meetingController;
    private final MemberController memberController;
    private final LodgeController lodgeController;

    public long  attendedMeetingsOfMemberOnTimeBox(Integer memberId, YearMonth initYearMonth, YearMonth finalYearMonth) {
    	 List<Meeting> meetingList = meetingController.gettAll();
         
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

}*/
