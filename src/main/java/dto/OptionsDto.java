package dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.org.apache.xpath.internal.operations.Bool;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OptionsDto {
    @JsonProperty("ntop")
    private String ntop;
    @JsonProperty("mandatory")
    private Boolean mandatory;
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("option_items")
    private OptionItemsDto optionItemsList;
    @JsonProperty("name")
    private String name;
}
