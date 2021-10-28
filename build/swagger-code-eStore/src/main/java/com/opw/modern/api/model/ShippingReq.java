package com.opw.modern.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.opw.modern.api.model.Address;
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
 * Contains information required for Shipping request
 */
@ApiModel(description = "Contains information required for Shipping request")
@JacksonXmlRootElement(localName = "ShippingReq")
@XmlRootElement(name = "ShippingReq")
@XmlAccessorType(XmlAccessType.FIELD)
public class ShippingReq extends RepresentationModel<ShippingReq>  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("orderId")
  @JacksonXmlProperty(localName = "orderId")
  private String orderId;

  @JsonProperty("address")
  @JacksonXmlProperty(localName = "address")
  private Address address;

  @JsonProperty("itemCount")
  @JacksonXmlProperty(localName = "itemCount")
  private Integer itemCount;

  public ShippingReq orderId(String orderId) {
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

  public ShippingReq address(Address address) {
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

  public ShippingReq itemCount(Integer itemCount) {
    this.itemCount = itemCount;
    return this;
  }

  /**
   * The number of items in the order
   * @return itemCount
  */
  @ApiModelProperty(value = "The number of items in the order")


  public Integer getItemCount() {
    return itemCount;
  }

  public void setItemCount(Integer itemCount) {
    this.itemCount = itemCount;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ShippingReq shippingReq = (ShippingReq) o;
    return Objects.equals(this.orderId, shippingReq.orderId) &&
        Objects.equals(this.address, shippingReq.address) &&
        Objects.equals(this.itemCount, shippingReq.itemCount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(orderId, address, itemCount);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ShippingReq {\n");
    
    sb.append("    orderId: ").append(toIndentedString(orderId)).append("\n");
    sb.append("    address: ").append(toIndentedString(address)).append("\n");
    sb.append("    itemCount: ").append(toIndentedString(itemCount)).append("\n");
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

