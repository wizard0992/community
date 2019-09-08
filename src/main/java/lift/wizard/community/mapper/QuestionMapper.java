package lift.wizard.community.mapper;

import lift.wizard.community.dao.Question;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface QuestionMapper {

    @Insert("insert into QUESTION (PUBLISH_TITLE,DESCRIPTION,GMT_CREATE,GMT_MODIFIED,CREATOR,TAG)" +
            "values(#{publish_title},#{description},#{gmtCreate},#{gmtModified},#{creator},#{tag})")
    public void creat(Question question);
}
