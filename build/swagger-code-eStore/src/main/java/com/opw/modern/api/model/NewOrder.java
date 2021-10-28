package com.opw.modern.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.opw.modern.api.model.Address;
import com.opw.modern.api.model.Card;
import com.opw.modern.api.model.Item;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.openapitools.jackson.nullable.JsonNullable;
import java.io.Serializable;
import javax.validation.Valid;
import javax.validation.constraints.*;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import javax.xml.bind.annotation.*;
import org.springframework.hateoas.RepresentationModel;

/**
 * Contains the new order request information
 */
@ApiModel(description = "Contains the new order request information")
@JacksonXmlRootElement(localName = "NewOrder")
@XmlRootElement(name = "NewOrder")
@XmlAccessorType(XmlAccessType.FIELD)
public class NewOrder extends RepresentationModel<NewOrder>  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("customerId")
  @JacksonXmlProperty(localName = "customerId")
  private String customerId;

  @JsonProperty("address")
  @JacksonXmlProperty(localName = "address")
  private Address address;

  @JsonProperty("card")
  @JacksonXmlProperty(localName = "card")
  private Card card;

  @JsonProperty("items")
  @JacksonXmlProperty(localName = "items")
  @Valid
  private List<Item> items = null;

  public NewOrder customerId(String customerId) {
    this.customerId = customerId;
    return this;
  }

  /**
   * Get customerId
   * @return customerId
  */
  @ApiModelProperty(value = "")


  public String getCustomerId() {
    return customerId;
  }

  public void setCustomerId(String customerId) {
    this.customerId = customerId;
  }

  public NewOrder address(Address address) {
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

  public NewOrder card(Card card) {
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

  public NewOrder items(List<Item> items) {
    this.items = items;
    return this;
  }

  public NewOrder addItemsItem(Item itemsItem) {
    if (this.items == null) {
      this.items = new ArrayList<>();
    }
    this.items.add(itemsItem);
    return this;
  }

  /**
   * Items in shopping cart
   * @return items
  */
  @ApiModelProperty(value = "Items in shopping cart")

  @Valid

  public List<Item> getItems() {
    return items;
  }

  public void setItems(List<Item> items) {
    this.items = items;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    NewOrder newOrder = (NewOrder) o;
    return Objects.equals(this.customerId, newOrder.customerId) &&
        Objects.equals(this.address, newOrder.address) &&
        Objects.equals(this.card, newOrder.card) &&
        Objects.equals(this.items, newOrder.items);
  }

  @Override
  public int hashCode() {
    return Objects.hash(customerId, address, card, items);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NewOrder {\n");
    
    sb.append("    customerId: ").append(toIndentedString(customerId)).append("\n");
    sb.append("    address: ").append(toIndentedString(address)).append("\n");
    sb.append("    card: ").append(toIndentedString(card)).append("\n");
    sb.append("    items: ").append(toIndentedString(items)).append("\n");
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

