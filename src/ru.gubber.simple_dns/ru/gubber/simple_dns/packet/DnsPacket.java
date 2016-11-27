package ru.gubber.simple_dns.packet;

/**
 * Created by a.vashchenkov on 06.11.2016.
 */
public class DnsPacket {
	private int id;
	private boolean req;
	private byte opCode;
	private boolean authAnsw;
	private boolean truncated;
	private boolean recurtionDesired;
	private boolean recurtionAvailable;
	private byte responseCode;
	private int questionCount;
	private int answersCount;
	private int nsCount;
	private int addRecordCount;
	private String representation;


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isReq() {
		return req;
	}

	public void setReq(boolean req) {
		this.req = req;
	}

	public byte getOpCode() {
		return opCode;
	}

	public void setOpCode(byte opCode) {
		this.opCode = opCode;
	}

	public boolean isAuthAnsw() {
		return authAnsw;
	}

	public void setAuthAnsw(boolean authAnsw) {
		this.authAnsw = authAnsw;
	}

	public boolean isTruncated() {
		return truncated;
	}

	public void setTruncated(boolean truncated) {
		this.truncated = truncated;
	}

	public boolean isRecurtionDesired() {
		return recurtionDesired;
	}

	public void setRecurtionDesired(boolean recurtionDesired) {
		this.recurtionDesired = recurtionDesired;
	}

	public boolean isRecurtionAvailable() {
		return recurtionAvailable;
	}

	public void setRecurtionAvailable(boolean recurtionAvailable) {
		this.recurtionAvailable = recurtionAvailable;
	}

	public byte getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(byte responseCode) {
		this.responseCode = responseCode;
	}

	public int getQuestionCount() {
		return questionCount;
	}

	public void setQuestionCount(int questionCount) {
		this.questionCount = questionCount;
	}

	public int getAnswersCount() {
		return answersCount;
	}

	public void setAnswersCount(int answersCount) {
		this.answersCount = answersCount;
	}

	public int getNsCount() {
		return nsCount;
	}

	public void setNsCount(int nsCount) {
		this.nsCount = nsCount;
	}

	public int getAddRecordCount() {
		return addRecordCount;
	}

	public void setAddRecordCount(int addRecordCount) {
		this.addRecordCount = addRecordCount;
	}

	@Override
	public String toString() {
		return "DnsPacket{" + "id=" + id +
				", req=" + req +
				", opCode=" + opCode +
				", authAnsw=" + authAnsw +
				", truncated=" + truncated +
				", recurtionDesired=" + recurtionDesired +
				", recurtionAvailable=" + recurtionAvailable +
				", responseCode=" + responseCode +
				", questionCount=" + questionCount +
				", answersCount=" + answersCount +
				", nsCount=" + nsCount +
				", addRecordCount=" + addRecordCount +
				", representation=" + representation +
				'}';
	}

	public void setRepresentation(String representation) {
		this.representation = representation;
	}
}