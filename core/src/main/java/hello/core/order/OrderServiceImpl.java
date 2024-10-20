package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{
//주문 생성 요청이 오면 하는 로직
    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);//grade만 넘길지 member전체를 넘길지는 선택
        //할인에 관해선 discountPolicy에서 하는 로직으로 함. 우리는 결과값만 받아옴

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

}
