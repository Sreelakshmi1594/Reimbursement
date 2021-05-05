package com.revature.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


import com.revature.dao.ReimbDaoImplement;
import com.revature.dao.UserDaoImplement;

import com.revature.model.ReimbursementModel;
import com.revature.model.User;
import com.revature.service.ReimbService;
import com.revature.service.UserService;


public class ReimbTest {
	
@Mock
private ReimbDaoImplement Fakedao=mock(ReimbDaoImplement.class);
private UserDaoImplement userfakedao=mock(UserDaoImplement.class);
private UserService fakeuserobj=mock(UserService.class);
private ReimbService adser =mock(ReimbService.class);
private User usobj;
private User usobj1;
private ReimbursementModel ac;
private ReimbursementModel ac1;
List<ReimbursementModel> reimbDetails;
List<User> us;
int statusid=1;
int reimbid=456678;


@BeforeEach
public void setUp() {
	MockitoAnnotations.initMocks(this);
	fakeuserobj = new UserService(userfakedao);
	adser = new ReimbService(Fakedao);
	ac=new ReimbursementModel(45678,100,"travel",12345);
	usobj =new User(4567891,"Sree","password","Sree","Nishan","sree@gmail.com",2);
	usobj1 = new User(4567891,"Sree","password","Sree","Nishan","sree@gmail.com",2);
	reimbDetails = new ArrayList<>();
	us = new ArrayList<>();
	us.add(usobj);
	reimbDetails.add(ac);
	

	
}

@Test
public void getAllccount() {
	when(Fakedao.getAll()).thenReturn(reimbDetails);
	assertEquals(reimbDetails,Fakedao.getAll());
}

@Test
public void reimbtest() {
	when(Fakedao.getReimbDetails(4567891)).thenReturn(reimbDetails);
	assertEquals(reimbDetails,Fakedao.getReimbDetails(4567891));
	
}

@Test
public void usertest() {
	when(userfakedao.getAll()).thenReturn(us);
	assertEquals(us,userfakedao.getAll());
	
}

@Test
public void modelTest() {
	assertEquals("Sree",usobj.getFirstName());
}



}
