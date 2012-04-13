package kr.pe.ldg.mybatis.example1.repository.mapper;

import java.util.List;
import java.util.Map;

import kr.pe.ldg.mybatis.example1.model.Comment;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;

public interface CommentMapper {
//	@Select("SELECT comment_no, user_id, comment_content, reg_date FROM COMMENT WHERE comment_no = #{commentNo}")
	Comment selectCommentByPrimaryKey(Long commentNo);

//	@SelectProvider(type=CommentSqlProvider.class, method="selectCommentByCondition")
	List<Comment> selectCommentByCondition(Map<String, Object> condition);

	@Insert("INSERT INTO COMMENT(comment_no, user_id, comment_content, reg_date) VALUES (#{commentNo}, #{userId}, #{commentContent}, #{regDate})")
	Integer insertComment(Comment comment);

	@Delete("DELETE FROM comment WHERE comment_no = #{commentNo}")
	Integer deleteComment(Long commentNo);
}