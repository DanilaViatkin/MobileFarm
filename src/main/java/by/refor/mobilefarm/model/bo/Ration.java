package by.refor.mobilefarm.model.bo;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="rationId")
public class Ration {
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long rationId;
    private FeedGroup feedGroup;
    private List<Feed> feeds;
}
