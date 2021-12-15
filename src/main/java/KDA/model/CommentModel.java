package KDA.model;

import java.sql.Date;

public class CommentModel {
	private int commentid;
	private int uid;
	private int pid;
	private String fname;
	private String lname;
	private String content;
	public CommentModel() {
		super();
	}
	public CommentModel(int commentid, int uid, int pid, String fname, String lname, String content) {
		super();
		this.commentid = commentid;
		this.uid = uid;
		this.pid = pid;
		this.fname = fname;
		this.lname = lname;
		this.content = content;
	}
	public int getCommentid() {
		return commentid;
	}
	public void setCommentid(int commentid) {
		this.commentid = commentid;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "CommentModel [commentid=" + commentid + ", uid=" + uid + ", pid=" + pid + ", fname=" + fname
				+ ", lname=" + lname + ", content=" + content + "]";
	}
	
}
