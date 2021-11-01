package com.opw.modern.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.opw.modern.api.model.Address;
import com.opw.modern.api.model.Card;
import com.opw.modern.api.model.CustomerInfoOnCard;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.openapitools.jackson.nullable.JsonNullable;
import java.io.Serializable;
import javax.validation.Valid;
import javax.validation.constraints.*;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import javax.xml.bind.annotation.*;
import org.springframework.hateoas.RepresentationModel;

/**
 * Contains the payment request information
 */
@ApiModel(description = "Contains the payment request information")
@JacksonXmlRootElement(localName = "PaymentReq")
@XmlRootElement(name = "PaymentReq")
@XmlAccessorType(XmlAccessType.FIELD)
public class PaymentReq extends RepresentationModel<PaymentReq>  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("orderId")
  @JacksonXmlProperty(localName = "orderId")
  private String orderId;

  @JsonProperty("customer")
  @JacksonXmlProperty(localName = "customer")
  private CustomerInfoOnCard customer;

  @JsonProperty("address")
  @JacksonXmlProperty(localName = "address")
  private Address address;

  @JsonProperty("card")
  @JacksonXmlProperty(localName = "card")
  private Card card;

  @JsonProperty("amount")
  @JacksonXmlProperty(localName = "amount")
  private Float amount;

  public PaymentReq orderId(String orderId) {
    this.orderId = orderId;
    return this;
  }

  /**
   * Order Identifier
   * @return orderId
  */
  @ApiModelProperty(value = "Order Identifier")


  public String getOrderId() {
    return orderId;
  }

  public void setOrderId(String orderId) {
    this.orderId = orderId;
  }

  public PaymentReq customer(CustomerInfoOnCard customer) {
    this.customer = customer;
    return this;
  }

  /**
   * Get customer
   * @return customer
  */
  @ApiModelProperty(value = "")

  @Valid

  public CustomerInfoOnCard getCustomer() {
    return customer;
  }

  public void setCustomer(CustomerInfoOnCard customer) {
    this.customer = customer;
  }

  public PaymentReq address(Address address) {
    this.address = address;
    return this;
  }

  /**
   * Get address
   * @return address
  */
  @ApiModelProperty(value = "")

  @Valid

  public Address getAddress() {
    return address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }

  public PaymentReq card(Card card) {
    this.card = card;
    return this;
  }

  /**
   * Get card
   * @return card
  */
  @ApiModelProperty(value = "")

  @Valid

  public Card getCard() {
    return card;
  }

  public void setCard(Card card) {
    this.card = card;
  }

  public PaymentReq amount(Float amount) {
    this.amount = amount;
    return this;
  }

  /**
   * Payment amount
   * @return amount
  */
  @ApiModelProperty(value = "Payment amount")


  public Float getAmount() {
    return amount;
  }

  public void setAmount(Float amount) {
    this.amount = amount;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PaymentReq paymentReq = (PaymentReq) o;
    return Objects.equals(this.orderId, paymentReq.orderId) &&
        Objects.equals(this.customer, paymentReq.customer) &&
        Objects.equals(this.address, paymentReq.address) &&
        Objects.equals(this.card, paymentReq.card) &&
        Objects.equals(this.amount, paymentReq.amount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(orderId, customer, address, card, amount);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PaymentReq {\n");
    
    sb.append("    orderId: ").append(toIndentedString(orderId)).append("\n");
    sb.append("    customer: ").append(toIndentedString(customer)).append("\n");
    sb.append("    address: ").append(toIndentedString(address)).append("\n");
    sb.append("    card: ").append(toIndentedString(card)).append("\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

