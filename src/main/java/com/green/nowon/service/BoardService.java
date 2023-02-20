package com.green.nowon.service;

import org.springframework.ui.Model;

import com.green.nowon.domain.entity.BoardDTO;
import com.green.nowon.domain.entity.BoardSearchDTO;

public interface BoardService {

	void createBoard(BoardDTO dto);

	void findAll(BoardSearchDTO dto, Model model);

}
