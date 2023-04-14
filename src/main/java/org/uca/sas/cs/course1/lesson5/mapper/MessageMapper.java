package org.uca.sas.cs.course1.lesson5.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.uca.sas.cs.course1.lesson5.model.Message;

import java.util.List;

@Mapper
public interface MessageMapper {
    @Select("SELECT * FROM MESSAGES WHERE username = #{username}")
    List<Message> getMessages(String username);

    @Insert("INSERT INTO MESSAGES (username, messagetext) VALUES(#{username}, #{messagetext})")
    @Options(useGeneratedKeys = true, keyProperty = "messageId")
    int insert(Message message);
}
