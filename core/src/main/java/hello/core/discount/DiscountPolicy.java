package hello.core.discount;

import hello.core.member.Member;

public interface DiscountPolicy {

    /**
     *
     * @return 할인 대상 금액 //얼마 할인됐는지 1000원, 0원 이런식
     */
    int discount(Member member, int price);
}
