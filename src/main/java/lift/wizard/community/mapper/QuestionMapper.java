package lift.wizard.community.mapper;

import lift.wizard.community.dao.Question;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface QuestionMapper {

    @Insert("insert into QUESTION (PUBLISH_TITLE,DESCRIPTION,GMT_CREATE,GMT_MODIFIED,CREATOR,TAG)" +
            "values(#{publishTitle},#{description},#{gmtCreate},#{gmtModified},#{creator},#{tag})")
    public void creat(Question question);

    @Select("select * from question")
    List<Question> list();
}
