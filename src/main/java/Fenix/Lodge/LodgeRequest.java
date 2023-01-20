package Fenix.Lodge;

import Fenix.Member.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class LodgeRequest{
    private String name;
    private Integer register;
    private List<Member> members;
}
