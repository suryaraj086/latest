package virtualclass;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class VirtualClass {
	Map<Integer, Details> stuMap = new HashMap<Integer, Details>();
	Map<Integer, Map<String, Role>> login = new HashMap<>();
	List<String> ppt = new ArrayList<>();
	Map<String, String> doubt = new HashMap<String, String>();
	Map<Integer, Details> signup = new HashMap<Integer, Details>();

	public String signup(Details obj, int id) {
		signup.put(id, obj);
		return "Signup Successful";
	}

	public String signupRequests(int val) {
		int k = 0;
		for (int id : signup.keySet()) {
			if (k == val) {
				Details obj = signup.get(id);
				stuMap.put(id, obj);
				signup.remove(id);
			}
			k++;
		}
		return "Successful";
	}

	public String listRequests() {
		StringBuilder sb = new StringBuilder();
		for (int id : signup.keySet()) {
			sb.append(signup.get(id));
			sb.append("\n");
		}
		return sb.toString();
	}

	public String editProfile(Details obj, int id) throws Exception {
		nullChecker(obj);
		stuMap.put(id, obj);
		return "edit successful";
	}

	public void nullChecker(Object obj) throws Exception {
		if (Objects.isNull(obj)) {
			throw new Exception("Error");
		}
	}

	public Details getProfile(int id) {
		return stuMap.get(id);
	}

	public String askDoubt(String question) {
		doubt.put(question, null);
		return "Question added";
	}

	public String answerQuestion(String answer, int val) {
		String question = questions(val);
		doubt.put(question, answer);
		return "answer added";
	}

	public String listDoubt() {
		StringBuilder temp = new StringBuilder();
		for (String s : doubt.keySet()) {
			temp.append(s);
			temp.append("\n");
		}
		return temp.toString();
	}

	public String listAnswers() {
		StringBuilder temp = new StringBuilder();
		for (String s : doubt.values()) {
			temp.append(s);
			temp.append("\n");
		}
		return temp.toString();
	}

	public String questions(int val) {
		int k = 0;
		for (String s : doubt.keySet()) {
			if (k == val) {
				return s;
			}
			k++;
		}
		return "not found";
	}

	public String showStudyMaterials() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < ppt.size(); i++) {
			sb.append(ppt.get(i));
			sb.append("\n");
		}
		return sb.toString();
	}

	public Role loginAndRole(int id, String password) throws Exception {
		Map<String, Role> temp = login.get(id);
		if (temp == null) {
			throw new Exception("User not found");
		} else if (temp.get(password) == null) {
			throw new Exception("Password incorrect");
		}
		return temp.get(password);
	}

	public Details studentChecker(int id) throws Exception {
		Details obj = stuMap.get(id);
		if (obj == null) {
			throw new Exception("Student not found");
		}
		return obj;
	}

}
