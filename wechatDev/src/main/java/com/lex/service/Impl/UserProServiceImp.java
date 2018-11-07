package com.lex.service.Impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.lex.dao.BaseServiceSupport;
import com.lex.service.UserProService;

@Service(value = "userProservice")
public class UserProServiceImp extends BaseServiceSupport implements
		UserProService {
	@Autowired
	JdbcTemplate jdbcTemplate;
	@Autowired
	SessionFactory sessionFactory;

}
