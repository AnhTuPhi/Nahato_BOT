package dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OptionItemsDto {
    @JsonProperty("max_select")
    private Integer max_select;
    @JsonProperty("min_select")
    private Integer min_select;
    @JsonProperty("items")
    private ArrayList<DetailItemsDto> detailItemsDtos;
}
