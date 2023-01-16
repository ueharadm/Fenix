package Fenix.Attendance;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/attendance")
@AllArgsConstructor
public class AttendanceController {

    public final AttendanceService attendanceService;
}
