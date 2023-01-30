package Fenix.Attendance;

import Fenix.Member.Member;
import Fenix.Member.MemberRepository;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/attendance")
@AllArgsConstructor
public class AttendanceController {

    public final AttendanceService attendanceService;
    private final MemberRepository memberRepository;

    @PostMapping
    public AttendanceResponse getAttendanceRate(@RequestBody AttendanceRateRequest request){
        return attendanceService.calculateAttendanceRate(request);
    }

    @PostMapping("/completeReport")
    public void generateAttendanceReport(@RequestBody AttendanceRateRequest request) throws Exception{
        try{
            List<MemberAttendanceRecord> memberRates = new ArrayList<>();
            List<Member> memberList = memberRepository.findAll();
            for (Member member: memberList) {
                //double d = attendanceService.calculateAttendanceRate(request).getAttendanceRate();
                AttendanceResponse response = attendanceService.calculateAttendanceRate(request);
                memberRates.add(new MemberAttendanceRecord(member, attendanceService.calculateAttendanceRate(new AttendanceRateRequest(member.getId(),request.getInitDate(),request.getFinalDate(),AttendanceRule.GERAL)).getAttendanceRate()));
            }

            AttendanceXlsxPrinter.generateReport(request.getInitDate(),request.getFinalDate(), memberRates);
        } catch (Exception e){
            System.err.println("Erro generateAttendanceReport");
        }

    }

    @GetMapping("/memberReport/{memberId}")
    public AttendanceResponse getMemberReport(@PathVariable("memberId") Integer memberId){
        try{
        return attendanceService.memberAttendanceRate(memberId);
        } catch (Exception e){
            System.out.println(e);
            return null;
        }
    }
}