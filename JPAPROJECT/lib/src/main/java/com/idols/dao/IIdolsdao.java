package com.idols.dao;

import java.util.List;

import bean.Idols;

public interface IIdolsdao {
	Idols add(Idols idol);
	List<Idols> allidols();
	Idols updateIdol(Idols idol);
}
