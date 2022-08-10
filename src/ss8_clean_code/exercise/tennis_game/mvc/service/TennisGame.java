package ss8_clean_code.exercise.tennis_game.mvc.service;

public class TennisGame {
    public static String getScore(int scoreOfPlayer1, int scoreOfPlayer2) {
        String score = "";
        int tempScore = 0;

        boolean isDraw = scoreOfPlayer1 == scoreOfPlayer2;
        if (isDraw) return getDrawScore(scoreOfPlayer1);

        boolean isWin = scoreOfPlayer1 >= 4 || scoreOfPlayer2 >= 4;
        if (isWin) score = getWin(scoreOfPlayer1, scoreOfPlayer2);
        else getTempScore(scoreOfPlayer1, scoreOfPlayer2, score);
        return score;
    }

    private static void getTempScore(int scoreOfPlayer1, int scoreOfPlayer2, String score) {
        int tempScore;
        for (int i = 1; i < 3; i++) {
            if (i == 1) tempScore = scoreOfPlayer1;
            else {
                score += "-";
                tempScore = scoreOfPlayer2;
            }
            switch (tempScore) {
                case 0:
                    score += "Love";
                    break;
                case 1:
                    score += "Fifteen";
                    break;
                case 2:
                    score += "Thirty";
                    break;
                case 3:
                    score += "Forty";
                    break;
            }
        }
    }

    private static String getWin(int scoreOfPlayer1, int scoreOfPlayer2) {
        String score;
        int minusResult = scoreOfPlayer1 - scoreOfPlayer2;
        if (minusResult == 1) score = "Advantage player1";
        else if (minusResult == -1) score = "Advantage player2";
        else if (minusResult >= 2) score = "Win for player1";
        else score = "Win for player2";
        return score;
    }

    private static String getDrawScore(int scoreOfPlayer1) {
        String score;
        switch (scoreOfPlayer1) {
            case 0:
                score = "Love-All";
                break;
            case 1:
                score = "Fifteen-All";
                break;
            case 2:
                score = "Thirty-All";
                break;
            case 3:
                score = "Forty-All";
                break;
            default:
                score = "Deuce";
                break;
        }
        return score;
    }
}
