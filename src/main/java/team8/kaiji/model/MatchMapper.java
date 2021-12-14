package team8.kaiji.model;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface MatchMapper {
  @Insert("insert into match (user1id,user2id,user1hand,user2hand) values (#{user1id},#{user2id},#{user1hand},NULL);")
  @Options(useGeneratedKeys = true, keyColumn = "matchid", keyProperty = "matchid")
  void insertMatchPlayer1(Match match);

  @Select("select * from match; ")
  ArrayList<Match> selectAllMatch();

  @Select("select matchid from match where user2id = #{user2id};")
  ArrayList<Integer> selectMatchIdByUserid(int user2id);

  @Update("Update Match set user2hand=#{user2hand} where matchid = #{matchid} ")
  void updateUser2Hand(Match match);
}