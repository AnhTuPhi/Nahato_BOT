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
public class WeekDayDto {
    @JsonProperty("start")
    private String start;
    @JsonProperty("week_day")
    private String week_day;
    @JsonProperty("end")
    private String end;
}
