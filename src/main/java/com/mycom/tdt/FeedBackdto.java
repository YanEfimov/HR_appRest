package com.mycom.tdt;

public class FeedBackdto {
	private String reason;
	private FeedBackStatedto state;
	private Userdto interviewer;
	private Interviewdto interview;

	public FeedBackdto(String reason, FeedBackStatedto state, Userdto interviewer, Interviewdto interview) {
		this.reason = reason;
		this.state = state;
		this.interviewer = interviewer;
		this.interview = interview;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public FeedBackStatedto getState() {
		return state;
	}

	public void setState(FeedBackStatedto state) {
		this.state = state;
	}

	public Userdto getInterviewer() {
		return interviewer;
	}

	public void setInterviewer(Userdto interviewer) {
		this.interviewer = interviewer;
	}

	public Interviewdto getInterview() {
		return interview;
	}

	public void setInterview(Interviewdto interview) {
		this.interview = interview;
	}

}
