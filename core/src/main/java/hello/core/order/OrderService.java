package hello.core.order;

public interface OrderService {
    Order createOrder(Long memberId, String itemName, int itemPrice);
    //회원id 상품명 상품가격을 파라미터로 넘김!!!

}
