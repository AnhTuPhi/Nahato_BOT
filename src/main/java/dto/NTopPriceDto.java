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
public class NTopPriceDto {
    @JsonProperty("text")
    private String text;
    @JsonProperty("unit")
    private String unit;
    @JsonProperty("value")
    private String value;
}
