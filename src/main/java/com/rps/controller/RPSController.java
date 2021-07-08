package com.rps.controller;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rps.service.IGameService;

@RestController
public class RPSController {

	@Autowired
	private IGameService iGameService;

	@RequestMapping(method = RequestMethod.POST, value = "/api/v1/rps/{action}")
	public ResponseEntity<?> execute(@PathVariable("action") String action) {
		try {
			String whoWin = iGameService.perform(action);
			return new ResponseEntity<String>(whoWin, HttpStatus.OK);

		} catch (Exception ex) {
			return new ResponseEntity<String>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(method = RequestMethod.POST, value = "/api/v1/rps/start.do")
	public ResponseEntity<?> start(@RequestParam("action") String action) {
		return execute(action);
	}

}
