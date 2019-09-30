package com.tennisGame.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.tennisGame.ServiceImpl.TennisMatchService;
import com.tennisGame.exception.TennisAppliException;
import com.tennisGame.exception.TennisExceptionMessage;
import com.tennisGame.model.PlayerMatch;

@RestController
@RequestMapping("/match")
public class TennisMatchController {

	@Autowired
	private TennisMatchService tennisMatchService;

	/**
	 * get the result of the match
	 * @param playersMatch
	 * @return
	 */
	@PostMapping
	public ResponseEntity<String> getScore(@RequestBody PlayerMatch playersMatch) {
		if (CollectionUtils.isEmpty(playersMatch.getPlayers())
				|| (playersMatch.getPlayers() != null && playersMatch.getPlayers().size() != 2)) {
			throw new TennisAppliException(TennisExceptionMessage.INVALID_PLAYERS_LIST.getDescription());
		}
		if (playersMatch.getScore()== null ||playersMatch.getScore().length == 0 ){
			throw new TennisAppliException(TennisExceptionMessage.SCORE_MISSED.getDescription());
		}
		String result = tennisMatchService.getScore(playersMatch.getPlayers().get(0), playersMatch.getPlayers().get(1),playersMatch.getScore());
		return new ResponseEntity<String>(result, new HttpHeaders(), HttpStatus.OK);
	}

}
