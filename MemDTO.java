package PCroomOrderingSystem;

public class MemDTO {
   private String product_name;
   private int order_number;
   private int total_price;
   private int order_quantity;
   private int seat_number;

   public MemDTO(int total_price, int order_quantity, int seat_number, String product_name) {
      this.product_name = product_name;
      this.total_price = total_price;
      this.order_quantity = order_quantity;
      this.seat_number = seat_number;
   }

   public MemDTO() {

   }

   public int getOrder_number() {
      return order_number;
   }

   public void setOrder_number(int order_number) {
      this.order_number = order_number;
   }

   public int getTotal_price() {
      return total_price;
   }

   public void setTotal_price(int total_price) {
      this.total_price = total_price;
   }

   public int getOrder_quantity() {
      return order_quantity;
   }

   public void setOrder_quantity(int order_quantity) {
      this.order_quantity = order_quantity;
   }

   public int getSeat_number() {
      return seat_number;
   }

   public void setSeat_number(int seat_number) {
      this.seat_number = seat_number;
   }

   public String getProduct_name() {
      return product_name;
   }

   public void setProduct_name(String product_name) {
      this.product_name = product_name;
   }

}