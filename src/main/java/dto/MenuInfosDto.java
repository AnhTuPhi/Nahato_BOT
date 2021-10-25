package dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.soap.Detail;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MenuInfosDto {
    @JsonProperty("dish_type_id")
    private Integer dishTypeId;
    @JsonProperty("dish_type_name")
    private String dishTypeName;
    @JsonProperty("dishes")
    private List<DishesDto> dishesDtoList;
}
