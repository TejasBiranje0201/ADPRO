package com.adpro.service;

import java.util.List;

import com.adpro.entity.State;

public interface StateService {

	List<State>lists();
	State getByid(int id);
	
}
