package com.cts.spring.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
public class Comments {

	@Id
	@NotNull(message = "Cid is mandatory")
	private Integer cid;

	@NotEmpty(message = "Comment is mandatory")
	private String comment;

	@NotEmpty(message = "Commenter is mandatory")
	private String commenter;

	@NotNull(message = "Pid must be provided")
	@Max(value = 1001, message = "PostId must be >= 1001")
	private Integer pid;

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getCommenter() {
		return commenter;
	}

	public void setCommenter(String commenter) {
		this.commenter = commenter;
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public Comments(@NotNull(message = "Cid is mandatory") Integer cid,
			@NotEmpty(message = "Comment is mandatory") String comment,
			@NotEmpty(message = "Commenter is mandatory") String commenter,
			@NotNull(message = "Pid must be provided") @Min(value = 1001, message = "PostId must be >= 1001") Integer pid) {
		super();
		this.cid = cid;
		this.comment = comment;
		this.commenter = commenter;
		this.pid = pid;
	}

	public Comments() {
		super();
	}

	@Override
	public String toString() {
		return "Comments [cid=" + cid + ", comment=" + comment + ", commenter=" + commenter + ", pid=" + pid + "]";
	}

	

}
