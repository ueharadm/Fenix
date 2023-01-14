package Fenix.Member;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Integer> {}