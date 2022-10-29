package onboarding.problem6;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class SimilarNicknameCrewSelector {
	private List<List<String>> crewInformations;
	private final int numberOfCrews;
	private List<Boolean> hasSimilarNickname;
	private List<String> similarNicknameCrewsEmail;

	public SimilarNicknameCrewSelector(List<List<String>> forms) {
		this.crewInformations = new ArrayList<>(forms);
		this.numberOfCrews = forms.size();
		this.hasSimilarNickname = new ArrayList<>();
		this.similarNicknameCrewsEmail = new ArrayList<>();

		for (int i = 0; i < this.numberOfCrews; i++) {
			this.hasSimilarNickname.add(false);
		}
	}

	private void compareCrewsNickname(int comparingCrewIndex) {
		TreeSet<String> dividedNickname = makeDividedNickname(comparingCrewIndex);

		if (dividedNickname.isEmpty() == false) {
			checkSimilarityWithOtherCrews(comparingCrewIndex, dividedNickname);
		}
	}

	private void checkSimilarityWithOtherCrews(int comparingCrewIndex, TreeSet<String> dividedNickname) {
		for(int comparedCrewIndex = comparingCrewIndex + 1; comparedCrewIndex < numberOfCrews; comparedCrewIndex++) {
			if ((hasSimilarNickname.get(comparedCrewIndex) == false) &&
				isSimilar(dividedNickname, comparedCrewIndex)) {
				hasSimilarNickname.set(comparingCrewIndex, true);
				hasSimilarNickname.set(comparedCrewIndex, true);
			}
		}
	}

	private TreeSet<String> makeDividedNickname(int comparingCrewIndex) {
		TreeSet<String> dividedNickname = new TreeSet<>();
		String nickname = crewInformations.get(comparingCrewIndex).get(1);

		if (nickname.length() > 1) {
			for (int i = 0; i < nickname.length() - 1; i++) {
				dividedNickname.add(nickname.substring(i, i + 2));
			}
		}

		return dividedNickname;
	}

	private boolean isSimilar(TreeSet<String> dividedNickname, int comparedCrewIndex) {
		for(String twoCharacters : dividedNickname) {
			if (crewInformations.get(comparedCrewIndex).get(1).contains(twoCharacters)) {
				return true;
			}
		}
		return false;
	}

}
