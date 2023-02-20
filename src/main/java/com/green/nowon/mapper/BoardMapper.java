package com.green.nowon.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.green.nowon.domain.entity.BoardDTO;
import com.green.nowon.domain.entity.BoardSearchDTO;

@Mapper //mapper.xml에 경로 넣어주기! 
//config에서 @MapperScan 사용해도 가능. 
public interface BoardMapper {

	void save(BoardDTO dto);

	List<BoardDTO> findAll(BoardSearchDTO dto);

}
