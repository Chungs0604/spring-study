package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;

public class MemberApp {

    public static void main(String[] args) {
//        MemberService memberService = new MemberServiceImpl();
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        Member member = new Member(1L, "member1", Grade.BASIC);

        memberService.join(member);

        Member member1 = memberService.findMember(member.getId());
        System.out.println("member1 = " + member1);
        System.out.println("member = " + member);
    }
}
