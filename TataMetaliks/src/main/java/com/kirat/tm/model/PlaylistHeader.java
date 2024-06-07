package com.kirat.tm.model;


public class PlaylistHeader {
	private String playlisthdrid;
	
	private String listmode;
	
	private String playlistname;
	
	private String createdby;
	
	private String brifdescription;
	
	private int playedcount;

	

	public String getPlaylisthdrid() {
		return playlisthdrid;
	}

	public void setPlaylisthdrid(String playlisthdrid) {
		this.playlisthdrid = playlisthdrid;
	}

	public String getListmode() {
		return listmode;
	}

	public void setListmode(String listmode) {
		this.listmode = listmode;
	}

	public String getPlaylistname() {
		return playlistname;
	}

	public void setPlaylistname(String playlistname) {
		this.playlistname = playlistname;
	}

	public String getCreatedby() {
		return createdby;
	}

	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}

	public String getBrifdescription() {
		return brifdescription;
	}

	public void setBrifdescription(String brifdescription) {
		this.brifdescription = brifdescription;
	}
	
	public int getPlayedcount() {
		return playedcount;
	}

	public void setPlayedcount(int playedcount) {
		this.playedcount = playedcount;
	}
	
}
