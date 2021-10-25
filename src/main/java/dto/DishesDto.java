package dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.org.apache.xpath.internal.operations.Bool;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DishesDto {
    @JsonProperty("is_deleted")
    private Boolean isDelete;
    @JsonProperty("description")
    private String description;
    @JsonProperty("price")
    private PriceDto price;
    @JsonProperty("is_active")
    private Boolean isActive;
    @JsonProperty("display_order")
    private String displayOrder;
    @JsonProperty("total_like")
    private String totalLike;
    @JsonProperty("properties")
    private String[] properties;
    @JsonProperty("photos")
    private List<Photo> photoList;
    @JsonProperty("options")
    private ArrayList<OptionsDto> optionsArrayList;
    @JsonProperty("discount_price")
    private DiscountPrice discountPrice;
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("is_available")
    private Boolean is_available;
    @JsonProperty("is_group_discount_item")
    private Boolean is_group_discount_item;
    @JsonProperty("time")
    private TimeDto timeDto;
    @JsonProperty("quantity")
    private Integer quantity;
    @JsonProperty("limit_type")
    private Integer limit_type;
    @JsonProperty("discount_remaining_quantity")
    private Integer discount_remaining_quantity;
}
