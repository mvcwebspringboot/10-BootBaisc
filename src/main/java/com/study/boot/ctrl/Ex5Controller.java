package com.study.boot.ctrl;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.study.boot.model.MyBoardDTO;
import com.study.boot.model.MyBoardVO;
import com.study.boot.persistence.MyBoardMapper;
import com.study.boot.util.MapperUtil;

import jakarta.validation.Valid;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Controller
public class Ex5Controller {

	@Autowired
	private MyBoardMapper dao;
	private ModelMapper modelMapper = MapperUtil.INSTANCE.getModelMapper();
	
	@GetMapping("/myBoard/write")
	public String write() {
		return "myBoard/write";
	}
	
	//글작성
	@PostMapping("/myBoard/writeOk")
	public String writeOk(@Valid MyBoardDTO dto, BindingResult result) {
		
		MyBoardVO vo = modelMapper.map(dto, MyBoardVO.class);
		
		if(result.hasErrors()) {
			
			if(result.getFieldError("writer")!=null) {
				log.info(result.getFieldError("writer").getDefaultMessage());
			}
			
			if(result.getFieldError("title")!=null) {
				log.info(result.getFieldError("title").getDefaultMessage());
			}
			
			return "redirect:/myBoard/write";
		}
		
		dao.save(vo);
		
		return "redirect:/myBoard/list";
	}
	
	//목록보기
	@GetMapping("/myBoard/list")
	public String list(Model model) {
		
		List<MyBoardDTO> list = dao.findAll().stream()
				.map(vo->modelMapper.map(vo, MyBoardDTO.class))
				.collect(Collectors.toList());
		
		model.addAttribute("list",list);
		
		return "myBoard/list";
	}
	
	//상세글보기
	@GetMapping("/myBoard/{seq}")
	public String content(@PathVariable int seq, Model model) {
		
		MyBoardDTO dto = modelMapper.map(dao.getOne(seq), MyBoardDTO.class);
		model.addAttribute("dto",dto);
		
		return "myBoard/content";
	}
	
	
	//삭제하기
	@GetMapping("/myBoard/delete/{seq}")
	public String delete(@PathVariable int seq) {
		
		dao.delete(seq);
		
		return "redirect:/myBoard/list";
	}
}







































