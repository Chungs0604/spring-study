package hello.core.order;

import hello.core.AppConfig;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;

public class OrderApp {

    public static void main(String[] args) {
//        MemberService memberService = new MemberServiceImpl(null);
//        OrderService orderService = new OrderServiceImpl(null, null);

        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();

        Member newMember = new Member(1L, "member1", Grade.VIP);
        memberService.join(newMember);
        Order order = orderService.createOrder(newMember.getId(), "item1", 20000);

        System.out.println(order);
        System.out.println("calculatePrice = " + order.calculatePrice());
    }
}
