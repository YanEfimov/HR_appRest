package com.mycom.tdt;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import com.mycom.entity.Candidate;
import com.mycom.entity.CandidateState;
import com.mycom.entity.FeedBack;
import com.mycom.entity.FeedBackState;
import com.mycom.entity.Interview;
import com.mycom.entity.Skill;
import com.mycom.entity.User;
import com.mycom.entity.Vacancy;

public class TemplateDto {
	public static List<Skilldto> parseSkill(Collection<Skill> skills) {
		List<Skilldto> list = new LinkedList<Skilldto>();
		for (Skill skill : skills) {
			list.add(new Skilldto(skill.getName()));
		}
		return list;
	}

	public static CandidateStatedto parseCandidateState(CandidateState state) {
		return new CandidateStatedto(state.getName());
	}

	public static FeedBackStatedto parseFeedBackState(FeedBackState state) {
		return new FeedBackStatedto(state.getName());
	}

	public static Userdto parseUser(User user) {
		return new Userdto(user.getId(), user.getName(), user.getSurname(), user.getEmail(), user.getPassword(),
				user.getRole());
	}

	public static List<Userdto> parseUserdto(Collection<User> users) {
		List<Userdto> list = new LinkedList<Userdto>();
		for (User user : users) {
			list.add(parseUser(user));
		}
		return list;
	}

	public static Candidatedto parseCandidate(Candidate candidate) {
		return new Candidatedto(candidate.getId(), candidate.getName(), candidate.getSurname(), candidate.getBirthday(),
				candidate.getSalary(), parseSkill(candidate.getSkills()),
				parseCandidateState(candidate.getCandidateState()));
	}

	public static List<Candidatedto> parseCandidatedto(Collection<Candidate> candidates) {
		List<Candidatedto> list = new LinkedList<Candidatedto>();
		for (Candidate candidate : candidates) {
			list.add(parseCandidate(candidate));
		}
		return list;
	}

	public static Vacancydto parseVacancy(Vacancy vacancy) {
		return new Vacancydto(vacancy.getSalaryto(), vacancy.getSalaryfrom(), vacancy.getExperienceYearRequire(),
				vacancy.getPosition(), parseUser(vacancy.getUser()), parseSkill(vacancy.getSkills()));
	}

	public static List<Vacancydto> parseVacancy(Collection<Vacancy> vacancys) {
		List<Vacancydto> list = new LinkedList<Vacancydto>();
		for (Vacancy vacancy : vacancys) {
			list.add(parseVacancy(vacancy));
		}
		return list;
	}

	public static Interviewdto parseInterview(Interview interview) {
		return new Interviewdto(interview.getFactDate(), interview.getPlanDate(), parseVacancy(interview.getVacancy()),
				parseCandidate(interview.getCandidate()), interview.getName());
	}

	public static List<Interviewdto> parseInterviewdto(Collection<Interview> interviews) {
		List<Interviewdto> list = new LinkedList<Interviewdto>();
		for (Interview interview : interviews) {
			list.add(parseInterview(interview));
		}
		return list;
	}

	public static FeedBackdto parseFeedBack(FeedBack feedback) {
		return new FeedBackdto(feedback.getReason(), parseFeedBackState(feedback.getFeedbackState()),
				parseUser(feedback.getInterviewer()), parseInterview(feedback.getInterview()));
	}

	public static List<FeedBackdto> parseFeedBackdto(Collection<FeedBack> feedbacks) {
		List<FeedBackdto> list = new LinkedList<FeedBackdto>();
		for (FeedBack feedback : feedbacks) {
			list.add(parseFeedBack(feedback));
		}
		return list;
	}
}
