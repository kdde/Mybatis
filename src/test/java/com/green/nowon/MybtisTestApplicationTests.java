package com.green.nowon;

import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.green.nowon.domain.entity.BoardDTO;
import com.green.nowon.mapper.BoardMapper;

@SpringBootTest
class MybtisTestApplicationTests {
	
	@Autowired
	BoardMapper mapper;
	
	//@Test
	void 더미() {
		IntStream.rangeClosed(1, 100000).forEach(i->{
			mapper.save(
						BoardDTO.builder()
						.title("테스트"+i).content("내용테스트"+i).writer("작성자"+(i%9+1))
						.build()
					);
					
		});
	}

}
