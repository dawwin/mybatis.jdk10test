package dwd.mybatisjdk10test.mapper;

import dwd.mybatisjdk10test.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

    void saveAll(@Param("list") final List<User> users);

    List<User> getAllUsers();

}
