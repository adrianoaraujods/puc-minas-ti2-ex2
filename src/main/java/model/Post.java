package model;

import java.util.Date;

public class Post {
	private int id;
	private String title;
	private long createdAt;
	private String content;
	
	public Post() {
		this.id = -1;
		this.title = "";
		this.createdAt = new Date().getTime();
		this.content = "";
	}

    public Post(int id, String title, long createdAt, String content) {
        this.id = id;
        this.title = title;
        this.createdAt = createdAt;
        this.content = content;
    }

    public Post(int id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public long getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(long createdAt) {
		this.createdAt = createdAt;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "Post [id=" + id + ", title=" + title + ", createdAt=" + createdAt + ", content=" + content + "]";
	}	
}
