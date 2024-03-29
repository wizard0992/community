package lift.wizard.community.dao;

import lombok.Data;

@Data
public class Question {
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
}
