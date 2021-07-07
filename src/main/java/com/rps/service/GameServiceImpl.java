package com.rps.service;

import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class GameServiceImpl implements IGameService {

	private final String TIE = "It's Tie !!!";
	private String USER_WON = "You won the game !!! Hurray...";
	private final String COMP_WON = "Computer won the game !!! So sad...";

	private enum Actions {
		ROCK, PAPER, SCISSORS;
	}

	@Override
	public String perform(String action) throws Exception {

		StringBuilder output = new StringBuilder();

		validate(action);

		action = action.toUpperCase();

		int serverMove = randomMove();

		String serverAction = getAction(serverMove);

		output.append("Your action is :").append(action).append("\n");
		output.append("Computer action is :").append(serverAction).append("\n");

		String whoWin = whoWin(serverAction, action);
		output.append(whoWin);

		return output.toString();
	}

	private void validate(String action) throws Exception {
		if (null == action) {
			throw new Exception(String.format(
					"Action provided %s is not valid action. Input {'ROCK','PAPER','SCISSORS' as action} ", action));
		}

		if (!(Actions.ROCK.name().equalsIgnoreCase(action) || Actions.PAPER.name().equalsIgnoreCase(action)
				|| Actions.SCISSORS.name().equalsIgnoreCase(action))) {
			throw new Exception(String.format(
					"Action provided %s is not valid action. Input {'ROCK','PAPER','SCISSORS' as action} ", action));
		}
	}

	public String getAction(int index) {
		switch (index) {
		case 0:
			return Actions.ROCK.name();
		case 1:
			return Actions.PAPER.name();
		case 2:
			return Actions.SCISSORS.name();
		}
		return null;
	}

	private int randomMove() {
		Random random = new Random();
		return random.nextInt(3);
	}

	private String whoWin(String serverAction, String userAction) {
		boolean isUserWon = true;
		if (userAction.equalsIgnoreCase(serverAction)) {
			return TIE;
		} else if (Actions.ROCK.name().equalsIgnoreCase(userAction)
				&& Actions.PAPER.name().equalsIgnoreCase(serverAction)) {
			isUserWon = false;
		} else if (Actions.SCISSORS.name().equalsIgnoreCase(userAction)
				&& Actions.ROCK.name().equalsIgnoreCase(serverAction)) {
			isUserWon = false;
		} else if (Actions.PAPER.name().equalsIgnoreCase(userAction)
				&& Actions.SCISSORS.name().equalsIgnoreCase(serverAction)) {
			isUserWon = false;
		}

		return isUserWon ? USER_WON : COMP_WON;
	}
}
