package Fenix.Meeting;

import java.time.LocalDate;
import java.time.LocalDate;

import Fenix.Member.MemberController;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MeetingRepository extends JpaRepository<Meeting, Integer> {}