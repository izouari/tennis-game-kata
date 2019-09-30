package com.tennisGame.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tennisGame.ServiceImpl.TennisSetService;
import com.tennisGame.exception.TennisAppliException;
import com.tennisGame.exception.TennisExceptionMessage;
import com.tennisGame.model.Player;

@RestController
@RequestMapping("/set")
public class TennisSetController {

	@Autowired
	private TennisSetService tennisSetService;

	/**
	 * get the result of Set 
	 * @param players
	 * @return
	 */
	@PostMapping
	public ResponseEntity<String> getScore(@RequestBody List<Player> players) {

		if (CollectionUtils.isEmpty(players) || (players != null && players.size() != 2)) {
			throw new TennisAppliException(TennisExceptionMessage.INVALID_PLAYERS_LIST.getDescription());
		}
		String result = tennisSetService.getScore(players.get(0), players.get(1));
		return new ResponseEntity<String>(result, new HttpHeaders(), HttpStatus.OK);
	}

}
