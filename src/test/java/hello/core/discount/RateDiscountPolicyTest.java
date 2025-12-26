package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {

    DiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10%할인 받는다")
    void vip_o() {
        //given
        Member member1 = new Member(1L, "member1", Grade.VIP);
        // when
        int discount = discountPolicy.discount(member1, 10000);
        //then
        assertThat(discount).isEqualTo(1000);
    }


    @Test
    @DisplayName("VIP는 10%할인 X")
    void vip_x() {
        //given
        Member member1 = new Member(1L, "member1", Grade.BASIC);
        // when
        int discount = discountPolicy.discount(member1, 10000);
        //then

        assertThat(discount).isEqualTo(0);
    }

}