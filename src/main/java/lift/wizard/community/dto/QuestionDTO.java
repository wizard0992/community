package lift.wizard.community.dto;

import lift.wizard.community.dao.User;
import lombok.Data;

@Data
public class QuestionDTO {
    private Integer id;
    private String publishTitle;
    private String description;
    private String tag;
    private Long gmtCreate;
    private Long gmtModified;
    private Integer creator;
    private Integer viewCount;
    private Integer commentCount;
    private Integer likeCount;
    private User user;
}
