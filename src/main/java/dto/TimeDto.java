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
public class TimeDto {
    @JsonProperty("available")
    private String[] available;
    @JsonProperty("week_days")
    private ArrayList<WeekDayDto> weekdayDtos;
    @JsonProperty("not_available")
    private String[] not_available;
}