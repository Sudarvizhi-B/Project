package com.idols.service;

import java.util.List;

import bean.Idols;

public interface IIdolsService {
	Idols add(Idols idol);
	List<Idols> allidols();
	Idols updateIdol(Idols idol);
}
