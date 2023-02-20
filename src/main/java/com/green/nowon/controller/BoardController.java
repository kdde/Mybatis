package com.green.nowon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.green.nowon.domain.entity.BoardDTO;
import com.green.nowon.domain.entity.BoardSearchDTO;
import com.green.nowon.service.BoardService;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService service;
	
	@PostMapping("/board/new")
	public String board(BoardDTO dto) {
		service.createBoard(dto);
		return "board/list";
	}
	
	@GetMapping("/boards")
	public String boards(BoardSearchDTO dto, Model model) {
		service.findAll(dto, model);
		return "board/list";
	}
	
}
