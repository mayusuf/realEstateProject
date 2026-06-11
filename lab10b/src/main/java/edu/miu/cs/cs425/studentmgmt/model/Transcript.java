package edu.miu.cs.cs425.studentmgmt.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "transcripts")
public class Transcript {
	@Id
	private Long transcriptId;

	@Column(nullable = false)
	private String degreeTitle;

	public Transcript() {
	}

	public Transcript(Long transcriptId, String degreeTitle) {
		this.transcriptId = transcriptId;
		this.degreeTitle = degreeTitle;
	}

	public Long getTranscriptId() {
		return transcriptId;
	}

	public void setTranscriptId(Long transcriptId) {
		this.transcriptId = transcriptId;
	}

	public String getDegreeTitle() {
		return degreeTitle;
	}

	public void setDegreeTitle(String degreeTitle) {
		this.degreeTitle = degreeTitle;
	}

}
