package com.idols;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import com.idols.service.IIdolsService;
import com.idols.service.IdolsServiceImpl;

import bean.Idols;

public class TestIdols {
	
	IIdolsService idolService = new IdolsServiceImpl();
	
	@Test
	
	void testAddIdols() {
		Idols idol = new Idols();
		idol.setId(7);
		idol.setName("Jeon Jungkook");
		idol.setStagename("JK");
		idol.setPopularsolo("Euphoria");
		
		Idols persistedIdol = idolService.add(idol);
		System.out.println(persistedIdol);
		
		assertEquals("Jeon Jungkook", idol.getName());
	}
	
	@Test
	@Disabled
	void testUpdateIdols() {
		Idols idol = new Idols();
		
		idol.setName("Park Jimin");
		idol.setPopularsolo("Filter");
		
		Idols updated = idolService.updateIdol(idol);
		System.out.println(updated);
		
		assertEquals("Filter",updated.getPopularsolo());
		
	}
	
	@Test
	@Disabled
	void testAllIdolsbyName() {
		List<Idols> idols = idolService.allidols();
		assertEquals(7,idols.size());
	}

}
