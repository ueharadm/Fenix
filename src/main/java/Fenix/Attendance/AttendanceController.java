package Fenix.Attendance;

import lombok.AllArgsConstructor;
import java.time.LocalDate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/attendance")
@AllArgsConstructor
public class AttendanceController {

    public final AttendanceService attendanceService;

    @PostMapping
    public AttendanceResponse getAttendanceRate(@RequestBody AttendanceRateRequest request){
        return attendanceService.calculateAttendanceRate(request);
    }
}