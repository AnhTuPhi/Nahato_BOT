package dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DetailItemsDto {
    @JsonProperty("name")
    private String name;
    @JsonProperty("weight")
    private Integer weight;
    @JsonProperty("max_quantity")
    private Integer max_quantity;
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("is_default")
    private Boolean is_default;
    @JsonProperty("top_order")
    private Integer top_order;
    @JsonProperty("ntop_price")
    private PriceDto nTopPriceDto;
    @JsonProperty("price")
    private PriceDto priceDto;
}
