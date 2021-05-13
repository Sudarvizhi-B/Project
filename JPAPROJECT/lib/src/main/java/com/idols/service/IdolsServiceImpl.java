package com.idols.service;

import java.util.List;

import com.idols.dao.IIdolsdao;
import com.idols.dao.IdolsdaoImpl;

import bean.Idols;

public class IdolsServiceImpl implements IIdolsService{
	
	IIdolsdao idoldao = new IdolsdaoImpl();

	@Override
	public Idols add(Idols idol) {
		return idoldao.add(idol);
	}

	@Override
	public List<Idols> allidols() {
		
		return idoldao.allidols();
	}
	
	@Override
	public Idols updateIdol(Idols idol) {
		
		return idoldao.updateIdol(idol);
	}
	

}
