package com.green.nowon.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.green.nowon.domain.entity.BoardDTO;
import com.green.nowon.domain.entity.BoardSearchDTO;
import com.green.nowon.mapper.BoardMapper;
import com.green.nowon.service.BoardService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BoardServiceProcess implements BoardService {
	
	@Autowired
	private BoardMapper mapper;

	@Override
	public void createBoard(BoardDTO dto) {
		System.out.println(">>>>>>>>>:"+mapper);
		log.info("메세지>>>>"+mapper);
		mapper.save(dto);
	}

	@Override
	public void findAll(BoardSearchDTO dto, Model model) {
		model.addAttribute("list", mapper.findAll(dto));
				
	}

}
